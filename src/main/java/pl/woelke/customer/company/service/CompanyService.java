package pl.woelke.customer.company.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.woelke.customer.company.model.Company;
import pl.woelke.customer.company.repository.CompanyEntity;
import pl.woelke.customer.company.repository.CompanyRepository;
import pl.woelke.customer.exception.CompanyNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public CompanyService(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    public List<Company> getAllCompanies() {
        log.debug("getAllCompanies()");
        List<CompanyEntity> companyEntities = companyRepository.findAll();
        List<Company> companies = companyEntities.stream()
                .map(companyEntity -> modelMapper.map(companyEntity, Company.class))
                .collect(Collectors.toList());
        log.debug("getAllCompanies(...)");
        return companies;
    }

    public Company addCompany(Company company) {
        log.debug("addCompany()");
        CompanyEntity companyEntity = modelMapper.map(company, CompanyEntity.class);
        CompanyEntity savedCompanyEntity = companyRepository.save(companyEntity);
        Company savedCompany = modelMapper.map(savedCompanyEntity, Company.class);
        log.debug("addCompany(...)");
        return savedCompany;
    }

    public Company updateCompany(Long id, Company company) throws CompanyNotFoundException {
        log.debug("updateCompany({}, {})", id, company);
        CompanyEntity companyEntity = companyRepository.findById(id).orElseThrow(
                () -> new CompanyNotFoundException("Company not found with id: " + id)
        );
        CompanyEntity editedCompanyEntity = modelMapper.map(company, CompanyEntity.class);
        editedCompanyEntity.setId(companyEntity.getId());
        Company updatedCompany = modelMapper.map(companyRepository.save(editedCompanyEntity), Company.class);
        log.debug("updateCompany({}, {})", id, updatedCompany);
        return updatedCompany;
    }

    public Company getCompanyById(Long id) throws CompanyNotFoundException {
        log.debug("getCompanyById({})", id);
        CompanyEntity companyEntity = companyRepository.findById(id).orElseThrow(
                () -> new CompanyNotFoundException("Company not found with id:" + id)
        );
        log.debug("getCompanyById(...)");
        return modelMapper.map(companyEntity, Company.class);
    }

    public void deleteCompany(Long id) {
        log.debug("deleteCompany({})", id);
        companyRepository.deleteById(id);
        log.debug("deleteCompany(...)");
    }
}
