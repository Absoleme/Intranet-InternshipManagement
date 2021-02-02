<div class="profile card h-100">
    <div class="card-body">
        <h4 class="card-title">Intern info</h4>
        <div class="profile-picture">
            <div class="row justify-content-center">
                <img class="profile" src="<c:url value="/assets/logo/profile.png"/>" alt="">
            </div>
        </div>
        <div class="profile-information">
            <!-- Firstname -->
            <div class="md-form">
                <input type="text" id="formFirstname" class="form-control" name="studentLastname"
                       value="<c:out value="${requestScope.internship.intern.student.lastname}"/>">
                <label for="formFirstname">Lastname</label>
            </div>
            <!-- Firstname -->

            <!-- Lastname -->
            <div class="md-form">
                <input type="text" id="formLastname" class="form-control" name="studentFirstname"
                       value="<c:out value="${requestScope.internship.intern.student.firstname}"/>">
                <label for="formLastname" class="disabled">Firstname</label>
            </div>

            <!-- Student Group -->
            <div class="row align-items-center">
                <div class="col-lg-4 col-6">
                    <h6>Student Group</h6>
                </div>
                <div class="col-lg-4 col-6">
                    <select class="browser-default custom-select" name="studentGroup" id="studentGroup">
                        <option value="L1"
                                <c:if test="${requestScope.internship.intern.student.studentGroup == 'L1'}">selected</c:if>>
                            L1
                        </option>
                        <option value="L2"
                                <c:if test="${requestScope.internship.intern.student.studentGroup == 'L2'}">selected</c:if>>
                            L2
                        </option>
                        <option value="L3"
                                <c:if test="${requestScope.internship.intern.student.studentGroup == 'L3'}">selected</c:if>>
                            L3
                        </option>
                        <option value="M1"
                                <c:if test="${requestScope.internship.intern.student.studentGroup == 'M1'}">selected</c:if>>
                            M1
                        </option>
                        <option value="M2"
                                <c:if test="${requestScope.internship.intern.student.studentGroup == 'M2'}">selected</c:if>>
                            M2
                        </option>
                    </select>
                </div>
            </div>

            <!-- LinkedIn profile -->
            <div class="md-form">
                <input type="text" id="linkedinUrl" class="form-control" name="linkedinUrl"
                       value="<c:out value="${requestScope.internship.intern.linkedinUrl}"/>">
                <label for="linkedinUrl" class="disabled">LinkedIn Url</label>
            </div>
            <!-- LinkedIn profile -->
        </div>
    </div>
</div>
