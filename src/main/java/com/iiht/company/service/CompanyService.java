package com.iiht.company.service;

import com.iiht.company.pojo.Company;
import com.iiht.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> findByCompanyCode(String companyCode) {
       Optional<Company> companyOptional = companyRepository.findByCompanyCode(companyCode);
       return companyOptional;
    }

    public String deleteCompany(String id) {
        String msg = "";
        Optional<Company> companyOptional =  companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            companyRepository.delete(companyOptional.get());
            msg = "Company deleted successfully!";
        } else {
            msg = "Company not found!";
        }
        return msg;
    }

    public Boolean isCompanyAlreadyPresent(String companyCode) {
        Optional<Company> cmp = companyRepository.findByCompanyCode(companyCode);
        if(cmp.isPresent()){
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
