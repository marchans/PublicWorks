<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<%@ page contentType="text/html; charset=UTF-8"%>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bundle.css" />" rel="stylesheet">
<%@ page isELIgnored="false"%>
</head>
<body data-page="worker">
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
						Вийти
					</a>
            </div>
        </div>
    </nav>
</header>
<main class="conatiner main">
    <ul class="main__button-list">
        <li class="main__button-list-item">
            <button class="button requests-but">Заявки пользователей</button>
        </li>
    </ul>
    <div class="content">
        <ul class="requests requests--worker disp-none">
            <li class="request__item">
                <div class="request__person">
                    <h2>Заявка</h2>
                    <div class="request_person-init"><h3>Имя:</h3> <span>Дима</span></div>
                    <div class="request_person-init"><h3>Фамилия:</h3> <span>Рудяк</span></div>
                    <div class="request_person-init"><h3>Мейл:</h3> <span>dima@pross.com</span></div>
                    <div class="request_person-init"><h3>Телефон:</h3> <span>0768449324</span></div>
                    <div class="request_person-init request--reason"><h3>Причина:</h3> <span>Lorem Ipsum - это текст-"рыба", часто используемый в печати и вэб-дизайне. Lorem Ipsum являеLorem Ipsum - это текст-"рыба", часто используемый в печати и вэб-дизайне. Lorem Ipsum являе</span></div>
                </div>
                <button class="worker-registration__submit-button button--done disp-none">Сделано</button>
                <button class="worker-registration__submit-button button--accept ">Принять</button>
                <button class="worker-registration__submit-button button--decline disp-none">Отклонить</button>
            </li>
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
<script src="<c:url value="/resources/js/bundle.js" />"></script>
</body>
</html>