<%--
  Home page
--%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main-template titlePage="Extranet Efrei">
    <jsp:attribute name="customStyles">
        <link rel="stylesheet" href="<c:url value="/css/error.css"/>">
    </jsp:attribute>
    <jsp:body>
        <div class="panel rounded card">
            <div class="card-body">
                <div class="row justify-content-center my-4 py-4">
                    <div class="col-lg-6">
                        <div class="notfound">
                            <div class="notfound-404 m-4">
                                <img src="<c:url value="/assets/emoji.png"/>" alt="emoji-sad">
                            </div>
                            <h1>500</h1>
                            <h2>Oops! ${requestScope.server_error}</h2>
                            <p>Sorry but the page you are looking for does not exist, have been removed. name
                                changed or is temporarily unavailable</p>
                            <a href="<c:url value="/"/>">Back to homepage</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Home panel -->
    </jsp:body>
</t:main-template>
