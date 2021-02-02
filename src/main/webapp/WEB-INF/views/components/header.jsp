<%--
  Header JSP
--%>
<header>
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-efrei scrolling-navbar">
        <div class="navbar-header">
            <a class="navbar-brand mx-auto" href="<c:url value="/"/>"><img class="logo"
                                                                           src="<c:url value="/assets/logo/myefrei-logo.png"/>"
                                                                           alt="logo-efrei"></a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto nav-flex-icons">
                <span class="navbar-text white-text mr-2">${sessionScope.SESSION_USER.firstname} ${sessionScope.SESSION_USER.lastname}</span>
                <li class="nav-item">
                    <a class="navbar-text text-white p-2" href="<c:url value="/logout"/>"><em
                            class="fas fa-power-off shadow-overlay zoom-overlay"></em></a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="alerts-box">
        <div class="messages"></div>
    </div>
</header>
