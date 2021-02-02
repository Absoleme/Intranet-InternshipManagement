<!-- Supervisor information -->
<div class="tab d-none" id="tab-3">
    <h4 class="text-center">Add a supervisor</h4>
    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="md-form">
                <input required type="text" id="supervisorFirstname" name="supervisorFirstname" class="form-control"
                       value="<c:out value="${requestScope.internship.supervisor.firstname}"/>">
                <label for="supervisorFirstname">First Name</label>
            </div>
        </div>
        <div class="form-group col-md-6">
            <div class="md-form">
                <input required type="text" id="supervisorLastname" name="supervisorLastname" class="form-control"
                       value="<c:out value="${requestScope.internship.supervisor.lastname}"/>">
                <label for="supervisorLastname">Lastname Name</label>
            </div>
        </div>
    </div>
</div>

