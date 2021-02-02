<div class="company card my-4 m-lg-0">
    <div class="card-body">
        <div class="company-information">
            <h4 class="card-title">Supervisor</h4>
            <!-- Firstname -->
            <div class="md-form">
                <input type="text" id="supervisorFirstname" class="form-control" name="supervisorFirstname"
                       value="<c:out value="${requestScope.internship.supervisor.firstname}"/>">
                <label for="supervisorFirstname">Firstname</label>
            </div>
            <!-- Firstname -->

            <!-- Lastname -->
            <div class="md-form">
                <input type="text" id="supervisorLastname" class="form-control" name="supervisorLastname"
                       value="<c:out value="${requestScope.internship.supervisor.lastname}"/>">
                <label for="supervisorLastname">Lastname</label>
            </div>
            <!-- Lastname -->
        </div>
    </div>
</div>