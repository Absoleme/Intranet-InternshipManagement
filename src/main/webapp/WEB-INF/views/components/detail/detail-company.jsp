<div class="company card my-4 m-lg-0">
    <div class="card-body">
        <div class="company-information">
            <h4 class="card-title">Company</h4>
            <!-- Company Name -->
            <div class="row align-items-center">
                <div class="col-1">
                    <em class="fas fa-building"></em>
                </div>
                <div class="col-11">
                    <div class="md-form">
                        <input type="text" id="companyName" class="form-control" name="companyName"
                               value="<c:out value="${requestScope.internship.company.name}"/>">
                        <label for="companyName">Company Name</label>
                    </div>
                </div>
            </div>
            <!-- Company Name -->

            <!-- Company Address -->
            <div class="row align-items-center">
                <div class="col-1">
                    <em class="fas fa-map-marker-alt"></em>
                </div>
                <div class="col-11">
                    <div class="md-form">
                        <input type="text" id="companyAddress" class="form-control"
                               value="${requestScope.internship.company.streetNumber} ${requestScope.internship.company.streetName}, ${requestScope.internship.company.city} ${requestScope.internship.company.zipcode}"
                               readonly>
                        <label for="companyAddress" class="disabled">Address</label>
                    </div>
                </div>
            </div>
            <!-- Company Address -->
        </div>
    </div>
</div>