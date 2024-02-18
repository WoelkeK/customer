package pl.woelke.customer.company.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import pl.woelke.customer.company.model.Company;
import pl.woelke.customer.company.repository.CompanyEntity;
import pl.woelke.customer.company.repository.CompanyRepository;
import pl.woelke.customer.exception.CompanyNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private ModelMapper modelMapper;

    private CompanyService companyService;

    @BeforeEach
    public void setup() {
        companyService = new CompanyService(companyRepository, modelMapper);
    }

    @Test
    void addCompany() {

        // given
        Company company = new Company();
        company.setName("Test Company");

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName(company.getName());

        CompanyEntity savedcompanyEntity = new CompanyEntity();
        savedcompanyEntity.setId(1L);
        savedcompanyEntity.setName(company.getName());

        Company expectedCompany = new Company();
        expectedCompany.setName(savedcompanyEntity.getName());

        when(modelMapper.map(company, CompanyEntity.class)).thenReturn(companyEntity);
        Mockito.when(companyRepository.save(companyEntity)).thenReturn(savedcompanyEntity);
        when(modelMapper.map(savedcompanyEntity, Company.class)).thenReturn(expectedCompany);

        // when
        Company addedCompany = companyService.addCompany(company);

        // then
        assertEquals(expectedCompany, addedCompany);
        Mockito.verify(modelMapper).map(company, CompanyEntity.class);
        Mockito.verify(companyRepository).save(companyEntity);
        Mockito.verify(modelMapper).map(savedcompanyEntity, Company.class);
    }

    @Test
    void getAllCompanies() {

        // given
        CompanyEntity companyEntity1 = new CompanyEntity();
        companyEntity1.setId(1L);
        companyEntity1.setName("Company 1");

        CompanyEntity companyEntity2 = new CompanyEntity();
        companyEntity2.setId(2L);
        companyEntity2.setName("Company 2");

        List<CompanyEntity> companyEntities = Arrays.asList(companyEntity1, companyEntity2);

        Company company1 = new Company();
        company1.setName(companyEntity1.getName());

        Company company2 = new Company();
        company2.setName(companyEntity2.getName());

        List<Company> expectedCompanies = Arrays.asList(company1, company2);

        Mockito.when(companyRepository.findAll()).thenReturn(companyEntities);
        Mockito.when(modelMapper.map(companyEntity1, Company.class)).thenReturn(company1);
        Mockito.when(modelMapper.map(companyEntity2, Company.class)).thenReturn(company2);

        // when
        List<Company> actualCompanies = companyService.getAllCompanies();

        // then
        assertThat(actualCompanies, containsInAnyOrder(expectedCompanies.toArray()));
        Mockito.verify(companyRepository).findAll();
        Mockito.verify(modelMapper).map(companyEntity1, Company.class);
        Mockito.verify(modelMapper).map(companyEntity2, Company.class);
    }

    @Test
    void getCompanyById() throws CompanyNotFoundException {
// given

        Long companyId = 1L;

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(companyId);
        companyEntity.setName("Test Company");

        Company expectedCompany = new Company();
        expectedCompany.setName(companyEntity.getName());

        Mockito.when(companyRepository.findById(companyId)).thenReturn(Optional.of(companyEntity));
        Mockito.when(modelMapper.map(companyEntity, Company.class)).thenReturn(expectedCompany);
// when
        Company actualCompany = companyService.getCompanyById(companyId);

// then
        assertEquals(expectedCompany, actualCompany);
        Mockito.verify(companyRepository).findById(companyId);
        Mockito.verify(modelMapper).map(companyEntity, Company.class);
    }

    @Test
    void updateCompany() throws CompanyNotFoundException {

        // given
        Long companyId = 1L;

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(companyId);
        companyEntity.setName("Test Company");

        Company updatedCompany = new Company();
        updatedCompany.setName("Updated Company");

        CompanyEntity updatedCompanyEntity = new CompanyEntity();
        updatedCompanyEntity.setId(companyId);
        updatedCompanyEntity.setName(updatedCompany.getName());

        Company expectedCompany = new Company();
        expectedCompany.setName(updatedCompanyEntity.getName());

        Mockito.when(companyRepository.findById(companyId)).thenReturn(Optional.of(companyEntity));
        Mockito.when(modelMapper.map(updatedCompany, CompanyEntity.class)).thenReturn(updatedCompanyEntity);
        Mockito.when(companyRepository.save(updatedCompanyEntity)).thenReturn(updatedCompanyEntity);
        Mockito.when(modelMapper.map(updatedCompanyEntity, Company.class)).thenReturn(expectedCompany);

        // when
        Company actualCompany = companyService.updateCompany(companyId, updatedCompany);

        // then
        assertEquals(expectedCompany, actualCompany);
        Mockito.verify(companyRepository).findById(companyId);
        Mockito.verify(modelMapper).map(updatedCompany, CompanyEntity.class);
        Mockito.verify(companyRepository).save(updatedCompanyEntity);
        Mockito.verify(modelMapper).map(updatedCompanyEntity, Company.class);
    }

    @Test
    void deleteCompany() {
        // given
        Long companyId = 1L;

        // when
        companyService.deleteCompany(companyId);

        // then
        Mockito.verify(companyRepository).deleteById(companyId);
    }
}