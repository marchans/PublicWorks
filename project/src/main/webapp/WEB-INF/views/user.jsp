<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8"%>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bundle.css" />" rel="stylesheet">
<%@ page isELIgnored="false"%>
</head>
<body data-page="user" >
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
					<a class="navbar-item" href="/"> Домой </a> <a class="navbar-item"
						href="/"> Еще куданить </a> <a class="navbar-item" href="/">
						Сюдаааа </a>

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
			<button class="button make-payment-js">Зробити платіж</button>
		</li>
		<li class="main__button-list-item">
			<button class="button payment-list-js">Список платежів</button>
		</li>
		<li class="main__button-list-item">
			<button class="button make-declaration-js">Подати заявку</button>
		</li>
		<li class="main__button-list-item">
			<button class="button declaration-list-js">Список заяв</button>
		</li>
	</ul>
	<div class="content">
		<form class="payment-form disp-none">
			<h3 class="payment-form__title">Форма Оплати</h3>
			<label class="payment-form__row"> <span
				class="payment-form__input-title">Послуга</span> <select
				class="dropdown">
					<option class="dropdown__item" value="volvo">Вода</option>
					<option class="dropdown__item" value="saab">Мусор</option>
					<option class="dropdown__item" value="mercedes">Квартплата</option>
					<option class="dropdown__item" value="audi">Газ</option>
			</select>
			</label>
			<div class="payment-form__row">
				Цена за 1 <span class="payment-form-unit-js">М^3</span>: <span
					class="payment-form-unit-price-js">17</span> грн
			</div>
			<div class="payment-form__row">
				Сумма:<span class="payment-form-total-price-js">540</span>грн
			</div>
			<button class="payment-form__submit" type="submit">Опатить</button>
		</form>

		<ul class="payment-list disp-none">
			<li class="payment-list__item"><span
				class="payment-list__column">Номер платежа</span> <span
				class="payment-list__column">Тип</span> <span
				class="payment-list__column">Дата</span> <span
				class="payment-list__column">Сумма</span></li>
			<li class="payment-list__item payment-list-item-template"><span
				class="payment-list__column">438473</span> <span
				class="payment-list__column">Мусор</span> <span
				class="payment-list__column">17/06/2020</span> <span
				class="payment-list__column">50</span></li>
		</ul>
		<form class="declaration-form disp-none">
			<h3 class="declaration-form__title">Форма Заявки</h3>
			<label class="declaration-form__row"> <span
				class="declaration-form__input-title">Услуга</span> <select
				class="dropdown">
					<option class="dropdown__item" value="volvo">Вода</option>
					<option class="dropdown__item" value="saab">Мусор</option>
					<option class="dropdown__item" value="mercedes">Квартплата</option>
					<option class="dropdown__item" value="audi">Газ</option>
			</select>
			</label>
			<textarea class="declaration-form__textarea">

            </textarea>
			<button class="declaration-form__submit" type="submit">Подать
				Заявку</button>
		</form>
		<ul class="declaration-list disp-none">
			<li class="declaration-list__item"><span
				class="declaration-list__column">Номер заявки</span> <span
				class="declaration-list__column">Статус</span></li>
			<li class="declaration-list__item"><span
				class="declaration-list__column">4343545</span> <span
				class="declaration-list__column">Выполняеться</span></li>
		</ul>
	</div>
	</main>
	<footer class="footer">
		<span class="footer__copyright"> &copy;2019 JavaEE project. </span>
		<div class="navbar-brand">
			<img src="<c:url value="/resources/images/logo.png" />" width="60" height="60">
			</a>
		</div>
	</footer>
	<script src="<c:url value="/resources/js/bundle.js" />"></script>
</body>
</html>