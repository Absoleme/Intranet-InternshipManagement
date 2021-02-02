<%--
  Table row
--%>
<tr class="text-center" name="internship-row-${requestScope.internship.intern.internId}"
    data-student-id="${requestScope.internship.intern.student.studentId}"
    data-intern-id="${requestScope.internship.intern.internId}">
    <td class="align-middle">
        <div class="custom-control custom-radio">
            <input class="custom-control-input" type="radio" name="radio-id-intern"
                   id="radio-id-intern-${requestScope.internship.internshipId}"
                   data-internship-id="${requestScope.internship.internshipId}">
            <label class="custom-control-label" for="radio-id-intern-${requestScope.internship.internshipId}"></label>
        </div>
    </td>
    <td class="align-middle">${requestScope.internship.intern.student.studentGroup}</td>
    <td class="align-middle">${requestScope.internship.intern.student.firstname}</td>
    <td class="align-middle">${requestScope.internship.intern.student.lastname}</td>
    <td class="align-middle"><input type="checkbox" name="requirement"
                                    <c:if test="${requestScope.intern.requirement}">checked</c:if>></td>
    <td class="align-middle"><input type="checkbox" name="visitFile"
                                    <c:if test="${requestScope.intern.visitFile}">checked</c:if>></td>
    <td class="align-middle"><input type="checkbox" name="evalCompFile"
                                    <c:if test="${requestScope.intern.evalCompFile}">checked</c:if>></td>
    <td class="align-middle"><input type="checkbox" name="webPoll"
                                    <c:if test="${requestScope.intern.webPoll}">checked</c:if>></td>
    <td class="align-middle"><input type="checkbox" name="reportDelivered"
                                    <c:if test="${requestScope.intern.reportDelivered}">checked</c:if>></td>
    <td class="align-middle"><input type="checkbox" name="defense"
                                    <c:if test="${requestScope.intern.defense}">checked</c:if>></td>
    <td class="align-middle"><input type="checkbox" name="defensePlanned"
                                    <c:if test="${requestScope.intern.defensePlanned}">checked</c:if>></td>
    <td class="align-middle"><input type="checkbox" name="defenseDone"
                                    <c:if test="${requestScope.intern.defenseDone}">checked</c:if>></td>
    <td class="align-middle">
            <span name="endDate">
            <fmt:formatDate type="date" value="${requestScope.internship.startDate}"/>
        </span>
    </td>
    <td class="align-middle">
        <span name="endDate">
            <fmt:formatDate type="date" value="${requestScope.internship.endDate}"/>
        </span>
    </td>
    <td class="align-middle">
        <button type="button" class="btn btn-info px-3" data-toggle="modal"
                data-target="#modal-internship-${requestScope.internship.internshipId}">
            <em class="fas fa-info" aria-hidden="true"></em>
        </button>
        <button type="button" class="btn btn-danger px-3 btn-delete-internship"
                data-internship-id="${requestScope.internship.internshipId}">
            <em class="fas fa-trash" aria-hidden="true"></em>
        </button>
        <!-- Modal -->
        <div class="modal fade" id="modal-internship-${requestScope.internship.internshipId}" tabindex="-1"
             role="dialog"
             aria-labelledby="modal-internship-${requestScope.internship.internshipId}-title"
             aria-hidden="true">
            <!-- Add .modal-dialog-centered to .modal-dialog to vertically center the modal -->
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title"
                            id="exampleModalLongTitle">${requestScope.intern.student.firstname} ${requestScope.intern.student.lastname}</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container">
                            <div class="row mt-2">
                                <div><span class="font-weight-bold">Supervisor</span> :
                                    <span>${requestScope.supervisor.firstname} ${requestScope.supervisor.lastname}</span>
                                </div>
                            </div>
                            <div class="row mt-2">
                                <div class="col">
                                    <div class="row my-2"><span class="font-weight-bold">Company</span></div>
                                    <div class="row my-2 flex-column d-flex text-left">
                                        <p><em class="fas fa-building"></em> ${company.name}</p>
                                        <p>
                                            <em class="fas fa-map-marker-alt"></em> ${company.streetNumber} ${company.streetName}, ${company.city} ${company.zipcode}
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-efrei" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </td>
</tr>
