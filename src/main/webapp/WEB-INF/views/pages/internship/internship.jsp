<%-- 
    Add an internship 
--%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main-template titlePage="Extranet Efrei">

    <jsp:attribute name="customScripts">
        <script type="text/javascript" src="<c:url value="/js/internship/internship-form.js"/>"></script>
    </jsp:attribute>
    <jsp:attribute name="customStyles">
        <link href="<c:url value="/css/multipleForm.css" />" rel="stylesheet">
    </jsp:attribute>
    <jsp:body>
        <div class="internship-panel rounded card">

            <div class="card-body">

                <c:import url="/WEB-INF/views/components/header-card.jsp"/>

                <div class="row p-3">
                    <div class="col">
                        <c:import url="/WEB-INF/views/components/internship/internship-form.jsp"/>
                    </div>
                </div>
                <div class="row p-3">
                    <div class="col">
                        <a class="btn btn-danger btn-sm" href="<c:url value="/"/>">Close</a>
                    </div>
                </div>
            </div>

        </div>
    </jsp:body>
</t:main-template>





