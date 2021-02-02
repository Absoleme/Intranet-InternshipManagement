<%--
  Home page
--%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main-template titlePage="Extranet Efrei">
    <jsp:attribute name="customScripts">
        <script type="text/javascript" src="<c:url value="/js/home/table-home.js"/>"></script>
    </jsp:attribute>
    <jsp:body>
        <!-- Home panel -->
        <c:if test="${not empty requestScope.internship_form.message}">
            <div class="alert alert-success" role="alert">
                    ${requestScope.internship_form.message}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <div class="home-panel rounded card">
            <div class="card-body">
                <c:import url="/WEB-INF/views/components/header-card.jsp"/>
                <div class="dropdown-divider"></div>
                <!-- Explication text -->
                <div class="row p-3">
                    <div class="col-lg-4 d-none d-lg-block">
                        <img class="large-logo px-5 py-3"
                             src="<c:url value="/assets/logo/myefrei-color-2.png"/>" alt="MyEfrei Logo">
                    </div>

                    <div class="col-lg-8 pt-4">
                        <h4>Welcome on your <span class="font-weight-bold text-efrei-light">tutor portal</span></h4>
                        <p>You can show your interns and manage them interships</p>
                    </div>
                </div>
                <!-- Explication text -->
                <!-- Table of interns -->
                <div class="row p-3">
                    <div class="col">
                        <div class="row">
                            <div class="col-lg-6">
                                <h3>List of interns</h3>
                            </div>

                        </div>
                        <div class="row justify-content-end my-2">
                            <div class="col-lg-3 text-right">
                                <!-- Academic button group -->
                                <div class="btn-group">
                                    <button name="internshipYear" id="internshipYear"
                                            class="btn btn-info btn-sm dropdown-toggle" type="button"
                                            data-toggle="dropdown"
                                            aria-haspopup="true" aria-expanded="false">
                                        Academic year ${requestScope.year}
                                    </button>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="<c:url value="/"/>">All years</a>
                                        <a class="dropdown-item" href="<c:url value="/?year=2021"/>">2021</a>
                                        <a class="dropdown-item" href="<c:url value="/?year=2020"/>">2020</a>
                                        <a class="dropdown-item" href="<c:url value="/?year=2019"/>">2019</a>
                                        <a class="dropdown-item" href="<c:url value="/?year=2018"/>">2018</a>
                                        <a class="dropdown-item" href="<c:url value="/?year=2017"/>">2017</a>
                                    </div>
                                </div>
                                <!-- Academic button group -->
                            </div>
                        </div>
                        <form action="" method="post" id="interns-form">
                            <c:choose>
                                <c:when test="${empty requestScope.internships}">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <h3>No interns</h3>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <c:import url="/WEB-INF/views/components/home/table-interns.jsp"/>
                                </c:otherwise>
                            </c:choose>

                            <div class="mt-2">
                                <c:if test="${not empty requestScope.internships}">
                                    <button type="submit" class="btn btn-info">
                                        Update
                                    </button>
                                    <a href="<c:url value="/detail"/>"
                                       class="btn btn-efrei" id="detail-btn">
                                        See details
                                    </a>
                                </c:if>
                                <a href="<c:url value="/internship"/>" class="btn btn-efrei">
                                    Add
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- Table of interns -->
            </div>
        </div>
        <!-- Home panel -->
    </jsp:body>
</t:main-template>
