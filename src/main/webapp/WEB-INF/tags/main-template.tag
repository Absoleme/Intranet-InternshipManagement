<%--
    Main template
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Base template" pageEncoding="UTF-8" %>
<%--
    Fragment attribute
--%>
<%@attribute name="customScripts" fragment="true" %>
<%@attribute name="customStyles" fragment="true" %>
<%--
    Template attributes
--%>
<%@attribute name="titlePage" required="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link id="contextPathHolder" data-context-path="${pageContext.request.contextPath}"/>
    <title>${titlePage}</title>
    <c:import url="/WEB-INF/vendors/styles.jsp"/>
    <link rel="stylesheet" href="<c:url value="/css/style.css?&version=2"/>">
    <link rel="stylesheet" href="<c:url value="/css/header.css"/>">
    <link rel="icon" type="image/png" href="<c:url value="/assets/logo/favicon.png"/>">
    <jsp:invoke fragment="customStyles"/>
</head>
<body>
<!-- Import Header -->
<c:import url="/WEB-INF/views/components/header.jsp"/>
<div class="page-content">
    <div class="background">
        <div class="blur"></div>
    </div>
    <div class="container-lg container-fluid py-5">
        <div class="row mt-5 pt-5">
            <div class="col-lg-12">
                <div class="box">
                    <jsp:doBody/>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Import footer -->
<c:import url="/WEB-INF/views/components/footer.jsp"/>

<div class="scripts">

    <c:import url="/WEB-INF/vendors/scripts.jsp"/>
    <script>
        // Tooltips Initialization
        $(function () {
            $('[data-toggle="tooltip"]').tooltip();
            $(".box").animsition({
                inClass: 'fade-in-right',
                outClass: 'fade-out-right',
                inDuration: 500,
                outDuration: 500,
                linkElement: '.animsition-link',
                // e.g. linkElement: 'a:not([target="_blank"]):not([href^="#"])'
                loading: true,
                loadingParentElement: '.box', //animsition wrapper element
                loadingClass: 'animsition-loading',
                loadingInner: '', // e.g '<img src="loading.svg" />'
                timeout: false,
                timeoutCountdown: 5000,
                onLoadEvent: true,
                browser: ['animation-duration', '-webkit-animation-duration'],
                // "browser" option allows you to disable the "animsition" in case the css property in the array is not supported by your browser.
                // The default setting is to disable the "animsition" in a browser that does not support "animation-duration".
                overlay: false,
                overlayClass: 'animsition-overlay-slide',
                overlayParentElement: '.box',
                transition: function (url) {
                    window.location.href = url;
                }
            });
        });
    </script>
    <jsp:invoke fragment="customScripts"/>
</div>
</body>
</html>