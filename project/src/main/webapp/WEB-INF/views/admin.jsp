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
	<div class="background-image"></div>
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
						Домой
					</a>
					<a class="navbar-item" href="/">
						Еще куданить
					</a>
					<a class="navbar-item" href="/">
						Сюда
					</a>
				</div>
				<div class="navbar-end">
					<span class="navbar__name">Hello, ${pageContext.request.userPrincipal.name}</span>
					<a class="navbar-item navbar--exit" href="/">
						Выйти
					</a>
				</div>
			</div>
		</nav>
	</header>
	<main class="conatiner main">
		<ul class="main__button-list">
			<li class="main__button-list-item">
				<button id="register" class="button">Зарегистрировать работника</button>
			</li>
			<li class="main__button-list-item">
				<button id="list" class="button">Список работников</button>
			</li>
			<li class="main__button-list-item">
				<button id="request" class="button">Заявки на регистрацию</button>
			</li>
		</ul>
		<div class="content">
			<form class="worker-registration disp-none">
				<label class="worker-registration__label">
					<span class="worker-registration__title">Логин</span>
					<input class="worker-registration__input" type="text" required>
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title">Пароль</span>
					<input class="worker-registration__input" type="password" required>
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title">Имя</span>
					<input class="worker-registration__input" type="text" required>
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title">Фамилия</span>
					<input class="worker-registration__input" type="text" required>
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title">Почта</span>
					<input class="worker-registration__input" type="email" required>
				</label>
				<label class="worker-registration__label">
					<span class="worker-registration__title">Телефон</span>
					<input class="worker-registration__input" type="tel" required>
				</label>
				<button class="worker-registration__submit-button" type="submit">Создать</button>
			</form>
			<ul class="worker-list disp-none">
				<li class="worker-list__item">
					<form class="worker-edit">
						<label class="worker-registration__label">
							<span  class="worker-registration__title w-name">Имя</span>
							<input class="worker-registration__input disp-none" type="text">
						</label>
						<label class="worker-registration__label">
							<span  class="worker-registration__title w-surname">Фамилия</span>
							<input class="worker-registration__input disp-none" type="text">
						</label>
						<label class="worker-registration__label">
							<span  class="worker-registration__title w-address">Почта</span>
							<input class="worker-registration__input disp-none" type="email">
						</label>
						<label class="worker-registration__label">
							<span class="worker-registration__title w-tel">Телефон</span>
							<input class="worker-registration__input disp-none" type="tel">
						</label>
						<label class="worker-registration__label">
							<span  class="worker-registration__title w-login">Логин</span>
							<input class="worker-registration__input disp-none" type="text">
						</label>
						<label class="worker-registration__label">
							<span class="worker-registration__title w-pass">Пароль</span>
							<input class="worker-registration__input disp-none" type="password">
						</label>
						<button type="button" class="worker-edit__save worker-registration__submit-button disp-none">Сохранить</button>
					</form>
				</li>
			</ul>
			<ul class="requests disp-none">
				<li class="request__item">
					<div class="request__person">
						<span class="request_person-init">Дима</span>
						<span class="request_person-init">Рудяк</span>
						<span class="request_person-init">dima@pross.com</span>
						<span class="request_person-init">0768449324</span>
					</div>
					<button class="worker-registration__submit-button but-accept">Принять</button>
					<button class="worker-registration__submit-button but-decline">Отклонить</button>
				</li>
			</ul>
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
	<script src="<c:url value="/resources/js/bundle.js" />"></script>
</body>
</html>