package com.example.companyms.company;


import com.example.companyms.company.dto.ReviewMessage;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> findAllCompanies();
    void createCompany(Company company);
    Optional<Company> getCompanyById(Long id);
    boolean deleteCompany(Long id);
    boolean updateCompany(Long id, Company companyUpdate);

    void updateCompanyRating(ReviewMessage reviewMessage);
}
