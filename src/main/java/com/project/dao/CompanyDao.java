package com.project.dao;

import com.project.database.Database;
import com.project.models.Company;

import javax.persistence.Query;

public class CompanyDao extends DaoResource<Company> {

    public CompanyDao(Database database) {
        super(database, Company.class);
    }

    public Company mapping(Query query) {
        Company company = new Company();
        company.setCompanyId((Integer) query.getParameterValue("COMPANY_ID"));
        company.setName(String.valueOf(query.getParameterValue("NAME")));
        company.setStreetName(String.valueOf(query.getParameterValue("STREET_NAME")));
        company.setStreetNumber((Integer) query.getParameterValue("STREET_NUMBER"));
        company.setCity(String.valueOf(query.getParameterValue("CITY")));
        company.setZipcode(String.valueOf(query.getParameterValue("ZIPCODE")));
        return company;
    }
}
