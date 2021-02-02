<div class="commentary card ">
    <div class="card-body">
        <h4 class="card-title">Commentaries</h4>
        <div class="dropdown-divider mb-4"></div>
        <div class="comments">
            <div class="form-group">
                <h5 class="card-title">
                    <label for="commentarySupervisor">Supervisor Commentary</label>
                </h5>
                <textarea class="form-control rounded-0" id="commentarySupervisor" name="commentarySupervisor"
                          rows="3"><c:out value="${requestScope.internship.commentarySupervisor}"/></textarea>
            </div>
            <div class="form-group">
                <h5 class="card-title">
                    <label for="commentaryIntern">Intern Commentary</label>
                </h5>
                <textarea class="form-control rounded-0" id="commentaryIntern" name="commentaryIntern"
                          rows="3"><c:out value="${requestScope.internship.commentaryIntern}"/></textarea>
            </div>
        </div>
    </div>
</div>