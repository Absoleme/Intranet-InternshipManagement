<%--
    Login template
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Login template" pageEncoding="UTF-8" %>
<%--
    Fragment attribute
--%>
<%@attribute name="customScripts" fragment="true" %>

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
    <title>${titlePage}</title>
    <c:import url="/WEB-INF/vendors/styles.jsp"/>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <link rel="stylesheet" href="<c:url value="/css/login.css"/>">
    <link rel="icon" type="image/png" href="<c:url value="/assets/logo/favicon.png"/>">
</head>
<body>
<div class="page-content">
    <div class="background-login"></div>
    <jsp:doBody/>
</div>
<!-- Import footer -->
<c:import url="/WEB-INF/views/components/footer.jsp"/>

<div class="scripts">
    <c:import url="/WEB-INF/vendors/scripts.jsp"/>
    <jsp:invoke fragment="customScripts"/>
</div>
</body>
</html>