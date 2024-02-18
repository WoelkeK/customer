package pl.woelke.customer.company.service;

import org.springframework.stereotype.Service;
import pl.woelke.customer.company.repository.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
