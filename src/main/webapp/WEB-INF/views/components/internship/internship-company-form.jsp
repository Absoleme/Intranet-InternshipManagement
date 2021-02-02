<!-- Company information -->
<div class="tab d-none" id="tab-2">
    <h4 class="text-center">Add a company</h4>
    <div class="form-row">
        <div class="form-group col-md-12">
            <div class="md-form">
                <input required type="text" class="form-control" name="companyName" id="companyName"
                       value="<c:out value="${requestScope.internship.company.name}"/>">
                <label for="companyName">Name</label>
            </div>
        </div>
    </div>

    <div class="form-row">
        <div class="form-group col-md-4">
            <div class="md-form">
                <input required type="number" class="form-control" id="companyStreetNumber" name="companyStreetNumber"
                       value="<c:out value="${requestScope.internship.company.streetNumber}"/>">
                <label for="companyStreetNumber">Street Number</label>
            </div>
        </div>
        <div class="form-group col-md-8">
            <div class="md-form">
                <input required type="text" class="form-control" id="companyStreetName" name="companyStreetName"
                       value="<c:out value="${requestScope.internship.company.streetName}"/>">
                <label for="companyStreetName">Street Name</label>
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-10">
            <div class="md-form">
                <input required type="text" class="form-control" id="companyCity" name="companyCity"
                       value="<c:out value="${requestScope.internship.company.city}"/>">
                <label for="companyCity">City</label>
            </div>
        </div>
        <div class="form-group col-md-2">
            <div class="md-form">
                <input required type="text" class="form-control" id="companyZipCode" name="companyZipCode"
                       value="<c:out value="${requestScope.internship.company.zipcode}"/>">
                <label for="companyZipCode">Zip</label>
            </div>
        </div>
    </div>
</div>
<!-- Company information -->
