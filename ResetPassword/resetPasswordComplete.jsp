<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="3;URL='home.jsp'"/>
<link rel="stylesheet" href="./css/style.css">

<title>パスワード再設定確認画面</title>
</head>
<body>
	<s:include value="header.jsp" />

	<div id="title3">
		<h1>パスワード再設定確認画面</h1>
	</div>
	<div class="message message_success">
	パスワード再設定が完了しました。
	</div>
	<s:include value="footer.jsp" />
</body>
</html>