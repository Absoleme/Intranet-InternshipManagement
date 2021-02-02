<%--
   Login page
--%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:login-template titlePage="Connexion">
    <jsp:body>
        <div id="login-page" class="container-fluid">
            <!-- Screen version -->
            <div class="d-none d-lg-block">
                <div class="row">
                    <!-- Logo -->
                    <div class="col-lg-8 text-center">
                        <img class="logo" src="<c:url value="/assets/logo/logo-efrei.png"/>" alt="logo-efrei"/>
                    </div>
                    <!-- Logo -->
                    <div class="col-lg-4 bg-efrei-white z-depth-2">
                        <!-- Login Panel -->
                        <div class="login-panel">
                            <div class="row justify-content-center my-4">
                                <div class="col-lg-8 text-center">
                                    <img class="img-fluid" src="<c:url value="/assets/logo/myefrei-color.png"/>"
                                         alt="myefrei-color">
                                </div>
                            </div>
                            <div class="row justify-content-center my-4">
                                <div class="col-10">
                                    <h5 class="pt-5">Welcome on <span
                                            class="font-italic font-weight-bold text-efrei-dark">myEfrei</span>
                                        : the web platform that centralizes all of your <span
                                                class="font-italic font-weight-bold text-efrei-dark">Efrei Paris</span>
                                        com.project.services.</h5>
                                </div>
                            </div>
                            <!-- Login form -->
                            <c:import url="/WEB-INF/views/components/login/login-form.jsp"/>
                            <!-- Login form -->
                            <div class="row justify-content-center sticky-bottom mb-2">
                                <div class="col-lg-8 text-center">
                                    <h6>© Copyright 2019 - Efrei Paris
                                        Établissement d'enseignement supérieur technique privé</h6>
                                </div>
                            </div>
                        </div>
                        <!-- Login Panel -->
                    </div>
                </div>
            </div>

            <!-- Mobile version -->
            <div class="d-block d-lg-none">
                <!-- Logo -->
                <div class="row">
                    <div class="col-12 text-center">
                        <img class="logo img-fluid" src="<c:url value="/assets/logo/logo-efrei.png"/>"
                             alt="logo-efrei"/>
                    </div>
                </div>
                <!-- Logo -->
                <div class="row justify-content-center mt-4">
                    <div class="col-sm-12 col-md-6">
                        <!-- Login form -->
                        <c:import url="/WEB-INF/views/components/login/login-form.jsp"/>
                        <!-- Login form -->
                    </div>
                </div>
                <div class="row justify-content-center sticky-bottom mb-2">
                    <div class="col-lg-8 text-center text-white">
                        <h6>© Copyright 2019 - Efrei Paris
                            Établissement d'enseignement supérieur technique privé</h6>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:login-template>
