<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"  %>
<%@page session="true"%>
<html>
<head>
<%@ page isELIgnored="false" %>
<title>Login Page</title>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bundle.css" />" rel="stylesheet">
</head>
<body onload='document.loginForm.username.focus();'>
<div class="background-image"><img src="<c:url value="/resources/images/city.jpg" />"></div>
	<header class="header">
		<nav class="navbar" role="navigation" aria-label="main navigation">
			<div class="navbar-brand">
				<a href="/">
					<img src="<c:url value="/resources/images/logo.png" />" width="60" height="60">
				</a>
			</div>
			<div class="navbar-menu">
				<div class="navbar-start">
					<a class="navbar-item" href="/">
						Додому
					</a>
				</div>
				<div class="navbar-end">
					<a class="navbar-item" href="/project_war/login">
						Залогінитись
					</a>
				</div>
			</div>
		</nav>
	</header>
	<main class="conatiner main">
		<div class="login-container">
			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
			<form class="login-form" name='loginForm' action="<c:url value='/login' />" method='POST'>
				<label class="login-form__row">
					<span class="login-form__input-name">Логін</span>
					<input class="login-form__input" type='text' name='login'>
				</label>
				<label class="login-form__row">
					<span class="login-form__input-name">Пароль</span>
					<input class="login-form__input" type='password' name='password' />
				</label>
				<input class="button"  name="submit" type="submit" value="submit" />
				<input type="hidden" name="${_csrf.parameterName}"
					   value="${_csrf.token}" />
			</form>
		</div>
	</main>
	<footer class="footer">
    <span class="footer__copyright">
        &copy; 2019 Lorem Ipsum - это текст-"рыба", часто используемый в печати и вэб-дизайне. Lorem Ipsum является стандартной "рыбой" для текстов на латинице с начала XVI века.
    </span>
		<div class="navbar-brand">
			<a href="/">
				<img src="<c:url value="/resources/images/logo.png" />" width="60" height="60">
			</a>
		</div>
	</footer>

</body>
</html>