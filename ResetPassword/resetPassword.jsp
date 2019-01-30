<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">


<title>パスワード再設定画面</title>
</head>

<body>
<s:include value="header.jsp" />
	<div id="contents">
		<h1>パスワード再設定画面</h1>

		<s:if test="!loginIdErrorMessageList.isEmpty()">
			<div class="error">
				<div class="message message_error">
					<s:iterator value="loginIdErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>

		<s:if test="!passwordErrorMessageList.isEmpty()">
			<div class="error">
				<div class="message message_error">
					<s:iterator value="passwordErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!passwordIncorrectErrorMessageList.isEmpty()">
			<div class="error">
				<div class="message message_error">
					<s:iterator value="passwordIncorrectErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>

		<s:if test="!newPasswordErrorMessageList.isEmpty()">
			<div class="error">
				<div class="message message_error">
					<s:iterator value="newPasswordErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>

		<s:if
			test="!reConfirmationNewPasswordErrorMessageList.isEmpty()">
			<div class="error">
				<div class="message message_error">
					<s:iterator
						value="reConfirmationNewPasswordErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
				<s:if test="!dateBaseErrorMessageList.isEmpty()">
			<div class="error">
				<div class="message message_error">
					<s:iterator value="dateBaseErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!newPasswordIncorrectErrorMessageList.isEmpty()">
			<div class="error">
				<div class="message message_error">
					<s:iterator value="newPasswordIncorrectErrorMessageList">
						<s:property />
						<br>
					</s:iterator>
				</div>
			</div>
		</s:if>


	<s:form action="ResetPasswordConfirmAction">
	<table class="vertical-list-table">
					<tr>
			<th scope="row"><s:label value="ユーザーID"/></th>
			<td><s:textfield name="loginId" class="txt"
			value="%{#session.resetId}" /></td>
		</tr>
		<tr>
			<th scope="row"><s:label value="現在のパスワード"/></th>
			<td><s:password name="password"  class="txt" /></td>
		</tr>

		<tr>
			<th scope="row"><s:label value="新しいパスワード"/></th>
			<td><s:password name="newPassword" class="txt" /></td>
		<tr>
			<th scope="row"><s:label value="(再確認)"/></th>
			<td><s:password name="reConfirmationPassword"  class="txt" /></td>
		</tr>
				</table>

	<div class="submit_btn_box">
			<s:submit value="確認" class="submit_btn" />
	</div>
			</s:form>


		</div>
		<br><br><br><br><br><br><br>

	<s:include value="footer.jsp"/>
</body>
</html>