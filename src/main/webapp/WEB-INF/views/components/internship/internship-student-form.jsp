<!-- Student information -->
<div class="tab d-block" id="tab-1">
    <h4 class="text-center">Add an intern</h4>
    <div class="md-form">
        <input required type="text" id="studentFirstname" name="studentFirstname" class="form-control"
               value="<c:out value="${requestScope.internship.intern.student.firstname}"/>">
        <label for="studentFirstname">First Name *</label>
    </div>

    <div class="md-form">
        <input required type="text" id="studentLastname" name="studentLastname" class="form-control"
               value="<c:out value="${requestScope.internship.intern.student.lastname}"/>">
        <label for="studentLastname">Last Name *</label>
    </div>

    <div class="row align-items-center select-group">
        <div class="col-lg-3 col-3">
            <label for="studentGroup" class="align-middle m-0">Student Group * </label>
        </div>
        <div class="col-lg-4">
            <select required class="browser-default custom-select" name="studentGroup" id="studentGroup">
                <option value="">Please select a group</option>
                <option value="L1"
                        <c:if test="${requestScope.internship.intern.student.studentGroup == 'L1'}">selected</c:if>>L1
                </option>
                <option value="L2"
                        <c:if test="${requestScope.internship.intern.student.studentGroup == 'L2'}">selected</c:if>>L2
                </option>
                <option value="L3"
                        <c:if test="${requestScope.internship.intern.student.studentGroup == 'L3'}">selected</c:if>>L3
                </option>
                <option value="L3"
                        <c:if test="${requestScope.internship.intern.student.studentGroup == 'M1'}">selected</c:if>>M1
                </option>
                <option value="L3"
                        <c:if test="${requestScope.internship.intern.student.studentGroup == 'M2'}">selected</c:if>>M2
                </option>
            </select>
        </div>
    </div>

    <div class="md-form">
        <input type="text" id="linkedinUrl" name="linkedinUrl" class="form-control"
               value="<c:out value="${requestScope.internship.intern.linkedinUrl}"/>">
        <label for="linkedinUrl">Linkedin url</label>
    </div>

</div>
<!-- Student information -->