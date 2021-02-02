<div class="internship card ">
    <div class="card-body">
        <div class="row">
            <div class="col">
                <h4 class="card-title">Date details</h4>
            </div>
        </div>
        <div class="dropdown-divider mb-4"></div>
        <div class="row">
            <div class="col-lg-6">
                <h5 class="card-title">Internship dates</h5>
                <!-- Start Date -->
                <div class="row align-items-center py-2">
                    <div class="col-lg-6">
                        <label for="startDate">Start Date</label>
                    </div>
                    <div class="col-lg-6">
                        <input type="date" id="startDate" name="startDate" class="form-control"
                               value="<c:out value="${requestScope.internship.startDate}"/>">
                    </div>
                </div>
                <!-- Start Date -->
                <!-- End Date -->
                <div class="row align-items-center py-2">
                    <div class="col-lg-6">
                        <label for="endDate">End Date</label>
                    </div>
                    <div class="col-lg-6">
                        <input type="date" id="endDate" name="endDate" class="form-control"
                               value="<c:out value="${requestScope.internship.endDate}"/>">
                    </div>
                </div>
                <!-- End Date -->
            </div>
            <div class="col-lg-6 mt-lg-0 mt-4">
                <h5 class="card-title">Mid Internship Meeting</h5>
                <!-- Mid internship meeting Date -->
                <div class="row align-items-center py-2">
                    <div class="col-lg-4">
                        <label for="midInternshipMeetingDate">Date</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="datetime-local" id="midInternshipMeetingDate" class="form-control"
                               name="midInternshipMeetingDate"
                               value="<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm" value = "${requestScope.internship.midInternshipMeetingDate}"/>">
                    </div>
                </div>
                <!-- Mid internship meeting Date -->
            </div>
        </div>

        <div class="dropdown-divider mb-4"></div>
        <div class="row">
            <div class="col">
                <h4 class="card-title">Internship information</h4>
            </div>
        </div>
        <!-- Report title -->
        <div class="md-form">
            <input type="text" id="titleReport" class="form-control" name="titleReport"
                   value="<c:out value="${requestScope.internship.titleReport}"/>">
            <label for="titleReport" class="disabled">Title Report</label>
        </div>
        <!-- Report title -->
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
        <div class="row">
            <div class="col-lg-3">
                <!-- Notations -->
                <h6 class="card-title">Notations</h6>
                <div class="md-form">
                    <input type="number" id="noteTech" class="form-control" name="noteTech"
                           value="<c:out value="${requestScope.internship.noteTech}"/>">
                    <label for="noteTech" class="disabled">Note tech</label>
                </div>
                <div class="md-form">
                    <input type="number" id="noteCom" class="form-control" name="noteCom"
                           value="<c:out value="${requestScope.internship.noteCom}"/>">
                    <label for="noteCom" class="disabled">Note com</label>
                </div>
                <!-- Notations -->
            </div>
        </div>
        <!-- Optional information -->
    </div>
</div>
