<!-- Internship mission information -->
<div class="tab d-none" id="tab-4">
    <h4 class="text-center">Add internship information</h4>

    <div class="form-row">
        <div class="form-group col-md-6">
            <%--            <div class="md-form">
                            <input required type="text" class="form-control" name="missionDescription" id="missionDescription"
                                   value="<c:out value="${requestScope.internship.supervisor.firstname}"/>">
                            <label for="missionDescription">Mission Description</label>
                        </div>--%>
            <div class="md-form mb-4 pink-textarea active-pink-textarea">
                <textarea required id="missionDescription" name="missionDescription" class="md-textarea form-control"
                          rows="3"><c:out value="${requestScope.internship.mission.description}"/></textarea>
                <label for="missionDescription">Mission Description</label>
            </div>
        </div>
        <div class="form-group col-md-6">
            <div class="md-form">
                <input type="text" class="form-control" name="missionKeywords" id="missionKeywords"
                       value="<c:out value="${requestScope.internship.mission.keywords}"/>">
                <label for="missionKeywords">Mission keyword</label>
            </div>
        </div>
    </div>

    <!-- Date pickers for start and end date -->
    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="md-form">
                <input required type="date" class="form-control" name="startDate" id="startDate"
                       value="<c:out value="${requestScope.internship.startDate}"/>">
                <label for="startDate">Start Date</label>
            </div>
        </div>
        <div class="form-group col-md-6">
            <div class="md-form">
                <input required type="date" class="form-control" name="endDate" id="endDate"
                       value="<c:out value="${requestScope.internship.endDate}"/>">
                <label for="endDate">End Date</label>
            </div>
        </div>
        <div class="col-12 text-center">
            <c:if test="${not empty requestScope.internship_form.errors['startDate']}">
                <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-danger text-center mb-4">
                        ${requestScope.internship_form.errors['startDate']}
                </small>
            </c:if>
        </div>
    </div>
    <!-- Date pickers for start and end date -->

    <!-- Optional information -->
    <div class="row p-3">
        <div class="form-check mb-4 col-3">
            <input type="checkbox" class="form-check-input" id="requirement" name="requirement"
                   <c:if test="${requestScope.internship.intern.requirement}">checked</c:if>>
            <label class="form-check-label" for="requirement">Requirement</label>
        </div>
        <div class="form-check mb-4 col-3">
            <input type="checkbox" class="form-check-input" id="visitFile" name="visitFile"
                   <c:if test="${requestScope.internship.intern.visitFile}">checked</c:if>>
            <label class="form-check-label" for="visitFile">Visit File</label>
        </div>
        <div class="form-check mb-4 col-3">
            <input type="checkbox" class="form-check-input" id="evalCompFile" name="evalCompFile"
                   <c:if test="${requestScope.internship.intern.evalCompFile}">checked</c:if>>
            <label class="form-check-label" for="evalCompFile">Eval. Company file</label>
        </div>
        <div class="form-check mb-4 col-3">
            <input type="checkbox" class="form-check-input" id="webPoll" name="webPoll"
                   <c:if test="${requestScope.internship.intern.webPoll}">checked</c:if>>
            <label class="form-check-label" for="webPoll">Web poll</label>
        </div>
        <div class="form-check mb-4 col-3">
            <input type="checkbox" class="form-check-input" id="reportDelivered" name="reportDelivered"
                   <c:if test="${requestScope.internship.intern.reportDelivered}">checked</c:if>>
            <label class="form-check-label" for="reportDelivered">Report delivered</label>
        </div>
        <div class="form-check mb-4 col-3">
            <input type="checkbox" class="form-check-input" id="defense" name="defense"
                   <c:if test="${requestScope.internship.intern.defense}">checked</c:if>>
            <label class="form-check-label" for="defense">Defense</label>
        </div>
        <div class="form-check mb-4 col-3">
            <input type="checkbox" class="form-check-input" id="defensePlanned" name="defensePlanned"
                   <c:if test="${requestScope.internship.intern.defensePlanned}">checked</c:if>>
            <label class="form-check-label" for="defensePlanned">Defense Planned</label>
        </div>
        <div class="form-check mb-4 col-3">
            <input type="checkbox" class="form-check-input" id="defenseDone" name="defenseDone"
                   <c:if test="${requestScope.internship.intern.defenseDone}">checked</c:if>>
            <label class="form-check-label" for="defenseDone">Defense Done</label>
        </div>
    </div>
    <!-- Optionnal informations -->
</div>

<!-- Internship information -->
