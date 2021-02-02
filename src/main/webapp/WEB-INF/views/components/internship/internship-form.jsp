<!-- Internship Form -->
<form class="border border-light p-lg-5 p-md-4 p-3" id="internship-form" method="post">

    <c:import url="/WEB-INF/views/components/internship/internship-student-form.jsp"/>

    <c:import url="/WEB-INF/views/components/internship/internship-company-form.jsp"/>

    <c:import url="/WEB-INF/views/components/internship/internship-supervisor-form.jsp"/>

    <c:import url="/WEB-INF/views/components/internship/internship-mission-form.jsp"/>

    <div class="row">
        <div class="col text-right">
            <button class="btn btn-light" type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
            <button class="btn btn-efrei" type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
        </div>
    </div>

    <!-- Circles which indicates the steps of the form: -->
    <div class="row pt-2">
        <div class="col text-center">
            <span class="step"></span>
            <span class="step"></span>
            <span class="step"></span>
            <span class="step"></span>
        </div>
    </div>


</form>
<!-- Internship Form -->