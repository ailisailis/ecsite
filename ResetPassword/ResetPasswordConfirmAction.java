package com.internousdev.anemone.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.anemone.dao.UserInfoDAO;
import com.internousdev.anemone.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware {

	private String loginId;
	// ログイン時に使用するID

	private String password;
	// ログイン時に使用するパスワード

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	// ログインIdを入力した際に入力ミスがあったとき出るメッセージ

	private List<String> passwordErrorMessageList = new ArrayList<String>();
	// パスワードを入力した際に入力ミスがあったとき出るメッセージ

	private List<String> passwordIncorrectErrorMessageList = new ArrayList<String>();
	// パスワードが間違っているときに出るエラーメッセージ

	private List<String> newPasswordErrorMessageList = new ArrayList<String>();
	// 新しいパスワードを入力した際に入力ミスがあったとき出るメッセージ

	private List<String> reConfirmationNewPasswordErrorMessageList = new ArrayList<String>();
	// 再確認用パスワードを入力した際に入力ミスがあったとき出るメッセージ

	private List<String> newPasswordIncorrectErrorMessageList = new ArrayList<String>();
	// 新しいパスワードと再確認用パスワードが違うときに出るエラーメッセージ
	private List<String> dateBaseErrorMessageList = new ArrayList<String>();
	// データベースにIDとパスワードが無いときメッセージ（勝手に追加しました）


	public Map<String, Object> session;
	private String newPassword;
	private String reConfirmationPassword;

	public String execute() {
		if (!session.containsKey("mCategoryList")) {
			return "sessionError";
		}
		session.put("resetId", loginId);

		// 文字種の判別、数を調べている
		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ユーザーID", loginId, 1, 8, true, false, false, true, false, false,
				false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("現在のパスワード", password, 1, 16, true, false, false, true, false,
				false, false, false, false);
		newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード", newPassword, 1, 16, true, false, false, true,
				false, false, false, false, false);
		reConfirmationNewPasswordErrorMessageList = inputChecker.doCheck("(再確認)", reConfirmationPassword, 1, 16, true,
				false, false, true, false, false, false, false, false);


		UserInfoDAO userInfoDAO = new UserInfoDAO();

		session.put("reConfirmationPassword",reConfirmationPassword);
		session.put("newPassword",newPassword);
		session.put("loginId",loginId);
		session.put("password",password);

		//エラーが一つでもあればエラーメッセージが表記
		if (loginIdErrorMessageList.size()> 0
				|| passwordErrorMessageList.size()> 0
				|| newPasswordErrorMessageList.size() > 0
				|| reConfirmationNewPasswordErrorMessageList.size() > 0
				||passwordIncorrectErrorMessageList.size() > 0){
				return ERROR;
			}

		if (userInfoDAO.isExistsUserInfo(loginId, password)) {
			String concealedPassword = concealPassword(newPassword);
			session.put("newPassword", newPassword);
			session.put("concealedPassword", concealedPassword);
			// IdとパスワードをDBに確認中
		} else {
			dateBaseErrorMessageList.add("ユーザーIDまたは現在のパスワードが異なります");
			return ERROR;
			// IDとパスワードがDBに無いとき
		}
		newPasswordIncorrectErrorMessageList = inputChecker.doPasswordCheck(newPassword, reConfirmationPassword);
		if(newPasswordIncorrectErrorMessageList.size() > 0){
			return ERROR;
		}

		return SUCCESS;
	}

	public String concealPassword(String password) {
		int beginIndex = 0;
		int endIndex = 1;

		StringBuilder stringBuilder = new StringBuilder("****************");

		String concealPassword = stringBuilder.replace(beginIndex, endIndex, password.substring(beginIndex,endIndex)).toString();
		return concealPassword;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConcealPassword() {
		return password;
	}



	public String getReConfirmationPassword() {
		return reConfirmationPassword;
	}

	public void setReConfirmationPassword(String reConfirmationPassword) {
		this.reConfirmationPassword = reConfirmationPassword;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public List<String> getPasswordIncorrectErrorMessageList() {
		return passwordIncorrectErrorMessageList;
	}

	public void setPasswordIncorrectErrorMessageList(List<String> passwordIncorrectErrorMessageList) {
		this.passwordIncorrectErrorMessageList = passwordIncorrectErrorMessageList;

	}

	public List<String> getDateBaseErrorMessageList() {
		return dateBaseErrorMessageList;
	}

	public void setDateBaseErrorMessageList(List<String> dateBaseErrorMessageList) {
		this.dateBaseErrorMessageList = dateBaseErrorMessageList;

	}

	public List<String> getNewPasswordErrorMessageList() {
		return newPasswordErrorMessageList;
	}

	public void setNewPasswordErrorMessageList(List<String> newPasswordErrorMessageList) {
		this.newPasswordErrorMessageList = newPasswordErrorMessageList;
	}

	public List<String> getReConfirmationNewPasswordErrorMessageList() {
		return reConfirmationNewPasswordErrorMessageList;
	}

	public void setReConfirmationNewPasswordErrorMessageList(List<String> reConfirmationNewPasswordErrorMessageList) {
		this.reConfirmationNewPasswordErrorMessageList = reConfirmationNewPasswordErrorMessageList;
	}

	public List<String> getNewPasswordIncorrectErrorMessageList() {
		return newPasswordIncorrectErrorMessageList;
	}

	public void setNewPasswordIncorrectErrorMessageList(List<String> newPasswordIncorrectErrorMessageList) {
		this.newPasswordIncorrectErrorMessageList = newPasswordIncorrectErrorMessageList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
