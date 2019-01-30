<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>パスワード再設定確認画面</title>
</head>
<body>
	<s:include value="header.jsp" />
	<div id="contents">
	<h1>パスワード再設定確認画面</h1>
	<s:form action="ResetPasswordCompleteAction">
	<table class="vertical-list-table">

		<tr>
			<th>ユーザーID</th>
			<td><s:property value="loginId" /></td>
		</tr>
		<tr>
			<th>パスワード</th>
			<td><s:property value="#session.concealedPassword" /></td>
		</tr>
		</table>
			<div class="submit_btn_box">
			<div id=".contents-btn-set">
			<s:submit value="パスワード再設定" class="submit_btn" />
			</div>
			</div>
		</s:form>
	<form action="resetPassword.jsp">
		<div class="submit_btn_box">
		<div id=".contents-btn-set">
		<s:submit value="戻る" class="submit_btn"/>
		</div>
		</div>
		</form>
	</div>
	<s:include value="footer.jsp" />
</body>
</html>