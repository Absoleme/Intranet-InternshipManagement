<%--
    Table of interns
--%>
<div class="table-responsive text-nowrap pb-2">

    <table class="table table-hover" id="interns-table" aria-describedby="Internship table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Group</th>
            <th scope="col" class="th-lg">Firstname</th>
            <th scope="col" class="th-lg">Lastname</th>
            <th scope="col">Requirements</th>
            <th scope="col">Visit file</th>
            <th scope="col">Eval. Company file</th>
            <th scope="col">Web poll</th>
            <th scope="col">Report delivered</th>
            <th scope="col">Defense</th>
            <th scope="col" data-toggle="tooltip" data-placement="top"
                title="Defense planned">Planned
            </th>
            <th scope="col" data-toggle="tooltip" data-placement="top"
                title="Defense done">Done
            </th>
            <th scope="col">Start date</th>
            <th scope="col">End date</th>
            <th scope="col">Extra Info</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.internships}" var="internship">
            <c:set scope="request" value="${internship}" var="internship"/>
            <c:set scope="request" value="${internship.intern}" var="intern"/>
            <c:set scope="request" value="${internship.company}" var="company"/>
            <c:set scope="request" value="${internship.supervisor}" var="supervisor"/>
            <c:import url="/WEB-INF/views/components/home/table-row.jsp"/>
        </c:forEach>
        </tbody>
    </table>

</div>
