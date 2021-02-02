<%--
   Detail page
--%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--<link rel="stylesheet" href="<c:url value="/css/detail.css"/>">--%>
<t:main-template titlePage="Detail">
    <jsp:attribute name="customScripts">
		<script type="text/javascript" src="<c:url value="/js/details/script.js"/>"></script>
	</jsp:attribute>
    <jsp:attribute name="customStyles">
		<%--<link href="<c:url value="/css/detail.css" />" rel="stylesheet">--%>
        <link rel="stylesheet" href="<c:url value="/css/detail-mission.css"/>">
	</jsp:attribute>
    <jsp:body>
        <c:choose>
            <c:when test="${empty requestScope.detail_form.errors and pageContext.request.method == 'POST'}">
                <div class="alert alert-success" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                        ${requestScope.detail_form.message}
                </div>
            </c:when>
            <c:when test="${not empty requestScope.detail_form.errors and pageContext.request.method == 'POST'}">
                <div class="alert alert-danger" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                        ${requestScope.detail_form.message}
                    <ul>
                        <c:forEach items="${requestScope.detail_form.errors}" var="error">
                            <li>${error.value}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:when>
        </c:choose>

        <div class="detail-panel rounded card">
            <div class="card-body">
                <c:import url="/WEB-INF/views/components/header-card.jsp">
                    <c:param name="title"
                             value="Detail of ${requestScope.internship.intern.student.firstname} ${requestScope.internship.intern.student.lastname}"/>
                </c:import>
                <a class="btn btn-link btn-sm" href="<c:url value="/"/>"><em class="fas fa-arrow-left"></em> Home</a>
                <div class="dropdown-divider"></div>
                <form id="detail-form" action="<c:url value="/detail?id=${requestScope.internship.internshipId}"/>"
                      method="post">

                    <!-- Detail info -->
                    <div class="row p-3">
                        <!-- Intern detail -->
                        <div class="col-lg-6">
                            <c:import url="/WEB-INF/views/components/detail/detail-intern.jsp"/>
                        </div>
                        <!-- Company & Supervisor detail -->
                        <div class="col-lg-6">
                            <div class="row mb-lg-4">
                                <div class="col">
                                    <c:import url="/WEB-INF/views/components/detail/detail-supervisor.jsp"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <c:import url="/WEB-INF/views/components/detail/detail-company.jsp"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row p-3">
                        <div class="col">
                            <c:import url="/WEB-INF/views/components/detail/detail-internship.jsp"/>
                        </div>
                    </div>
                    <div class="row p-3">
                        <div class="col">
                            <c:import url="/WEB-INF/views/components/detail/detail-mission.jsp"/>
                        </div>
                    </div>
                    <div class="row p-3">
                        <div class="col">
                            <c:import url="/WEB-INF/views/components/detail/detail-commentary.jsp"/>
                        </div>
                    </div>
                    <!-- Return button -->
                    <div class="row p-lg-3 p-1">
                        <div class="col">
                            <button class="btn btn-primary btn-sm" type="submit">Update</button>
                            <a class="btn btn-danger btn-sm" href="<c:url value="/"/>">Close</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </jsp:body>
</t:main-template>