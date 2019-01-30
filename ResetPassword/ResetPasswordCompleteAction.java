package com.internousdev.anemone.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.anemone.dao.UserInfoDAO;
import com.internousdev.anemone.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;
public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware {
	private Map<String,Object> session;

	public String execute(){
		 List<String> loginIdErrorMessageList = new ArrayList<String>();
		// ログインIdを入力した際に入力ミスがあったとき出るメッセージ

		 List<String> passwordErrorMessageList = new ArrayList<String>();
		// パスワードを入力した際に入力ミスがあったとき出るメッセージ

		 List<String> passwordIncorrectErrorMessageList = new ArrayList<String>();
		// パスワードが間違っているときに出るエラーメッセージ

		 List<String> newPasswordErrorMessageList = new ArrayList<String>();
		// 新しいパスワードを入力した際に入力ミスがあったとき出るメッセージ

		 List<String> reConfirmationNewPasswordErrorMessageList = new ArrayList<String>();
		// 再確認用パスワードを入力した際に入力ミスがあったとき出るメッセージ


		if(!session.containsKey("mCategoryList")) {
			return "sessionError";
		}
		// 文字種の判別、数を調べている
				InputChecker inputChecker = new InputChecker();

				loginIdErrorMessageList = inputChecker.doCheck("ユーザーID", (session.get("loginId").toString()), 1, 8, true, false, false, true, false, false,
						false, false, false);
				passwordErrorMessageList = inputChecker.doCheck("現在のパスワード", (session.get("password").toString()), 1, 16, true, false, false, true, false,
						false, false, false, false);
				newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード", (session.get("newPassword").toString()), 1, 16, true, false, false, true,
						false, false, false, false, false);
				reConfirmationNewPasswordErrorMessageList = inputChecker.doCheck("(再確認)", (session.get("reConfirmationPassword").toString()), 1, 16, true,
						false, false, true, false, false, false, false, false);


				//エラーが一つでもあればエラーメッセージが表記
				if (loginIdErrorMessageList.size()> 0
						|| passwordErrorMessageList.size()> 0
						|| newPasswordErrorMessageList.size() > 0
						|| reConfirmationNewPasswordErrorMessageList.size() > 0
						||passwordIncorrectErrorMessageList.size() > 0){
						return ERROR;
					}
		String result =ERROR;
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		//カウントにvalueOfで取得した文字を数えている
		//valueOfはString型文字列に変える
		//userInfoDAOで新しいパスワードをDBに入れている模様。
		int count = userInfoDAO.resetPassword(String.valueOf(session.get("resetId")),String.valueOf(session.get("newPassword")));
		if(count >0){
			result =SUCCESS;
		}else{
			result = ERROR;
		}

		return result;
	}

	public Map<String,Object>getSession(){
		return session;

	}
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}
