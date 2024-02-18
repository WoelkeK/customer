package pl.woelke.customer.company.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CompanyRepositoryTest {

    private static final Long COMPANY_ID = 1l;
    private  static  final String COMPANY_NAME = "TEST COMPANY 1";
    public static final Boolean  COMPANY_VAT_REGISTERED = true;
    public static final String  COMPANY_COUNTRY = "COUNTRY";
    public static final String  COMPANY_POSTCODE = "XX-XXX";
    public static final String  COMPANY_STREET = "STREET";
    public static final String  COMPANY_REGISTER_ID = "1234567890";
    public static final String  COMPANY_TAX_ID = "PL1234567890";

    @Autowired
    private  CompanyRepository companyRepository;

    @Test
    @Order(1)
    void addCompany(){
        // given
        CompanyEntity company = new CompanyEntity();
        company.setId(COMPANY_ID);
        company.setName(COMPANY_NAME);
        company.setVatRegistered(COMPANY_VAT_REGISTERED);
        company.setCountry(COMPANY_COUNTRY);
        company.setPostCode(COMPANY_POSTCODE);
        company.setTaxID(COMPANY_TAX_ID);
        company.setStreet(COMPANY_STREET);
        company.setRegisterID(COMPANY_REGISTER_ID);

        // when
        CompanyEntity savedCompanyEntity = companyRepository.save(company);
        // then
        assertAll(
                ()->assertNotNull(savedCompanyEntity, "savedCompanyEntity is NULL"),
                ()->assertNotNull(savedCompanyEntity.getId(), "savedCompanyEntity ID is NULL"),
                ()->assertTrue(savedCompanyEntity.getVatRegistered(), "savedCompanyEntity VAT_REGISTERED is false")
        );
    }
}