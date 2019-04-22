<%@ page contentType="text/html" pageEncoding="UTF-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<%@ page isELIgnored="false" %>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bundle.css" />" rel="stylesheet">
</head>
<body data-page="admin">

	<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

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
					<span class="navbar__name">Hello, ${pageContext.request.userPrincipal.name}</span>
					<a class="navbar-item navbar--exit" href="/">
						Вийти
					</a>
				</div>
			</div>
		</nav>
	</header>
	<main class="conatiner main">
		<ul class="main__button-list">
			<li class="main__button-list-item">
				<button id="register" class="button">Зареєструвати робітника</button>
			</li>
			<li class="main__button-list-item">
				<button id="list" class="button">Список робітників</button>
			</li>
			<li class="main__button-list-item">
				<button id="request" class="button">Заявки на реєстрацію</button>
			</li>
		</ul>
		<div class="content">
			<form class="worker-registration disp-none">
				<label class="worker-registration__label">
					<span class="worker-registration__title">Логін</span>
					<input class="worker-registration__input" type="text" name="login" required>
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title">Пароль</span>
					<input class="worker-registration__input" type="password" name="password" required>
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title">Ім'я</span>
					<input class="worker-registration__input" type="text" name="firstName" required>
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title">Прізвище</span>
					<input class="worker-registration__input" type="text" name="lastName" required>
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title">Пошта</span>
					<input class="worker-registration__input" type="email" name="email" required>
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title">Телефон</span>
					<input class="worker-registration__input" type="tel" name="phone" required>
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title">Посада</span>
					<input class="worker-registration__input" type="text" name="positionId" required>
				</label>
				<button class="worker-registration__submit-button" type="submit">Создать</button>
			</form>
			<ul class="worker-list disp-none">

			</ul>
			<ul class="requests disp-none">

			</ul>
		</div>
	</main>
	<footer class="footer">
    <span class="footer__copyright">
        &copy; 2019 JavaEE project.  
    </span>
		<div class="navbar-brand">
			<a href="/">
				<img src="<c:url value="/resources/images/logo.png" />" width="60" height="60">
			</a>
		</div>
	</footer>
	<template id="worker-template">
		<li class="worker-list__item">
			<form class="worker-edit">
				<label class="worker-registration__label">
					<span  class="worker-registration__title w-name">Ім'я</span>
					<input class="worker-registration__input disp-none" type="text">
				</label>
				<label class="worker-registration__label">
					<span  class="worker-registration__title w-surname">Прізвище</span>
					<input class="worker-registration__input disp-none" type="text">
				</label>
				<label class="worker-registration__label">
					<span  class="worker-registration__title w-address">Пошта</span>
					<input class="worker-registration__input disp-none" type="email">
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title w-tel">Телефон</span>
					<input class="worker-registration__input disp-none" type="tel">
				</label>
				<button type="button" class="worker-edit__save worker-registration__submit-button">Видалити</button>
			</form>
		</li>
	</template>

	<template id="request-template">
		<li class="request__item">
			<div class="request__person">
				<span class="request_person-init w-name">Діма</span>
				<span class="request_person-init w-surname">Рудяк</span>
				<span class="request_person-init w-passport">dima@pross.com</span>
				<span class="request_person-init w-town">0768449324</span>
			</div>
			<button class="worker-registration__submit-button but-accept">Прийняти</button>
			<button class="worker-registration__submit-button but-decline">Відмовити</button>
		</li>
	</template>
	<script src="<c:url value="/resources/js/bundle.js" />"></script>
</body>
</html>