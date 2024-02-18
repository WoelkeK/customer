package pl.woelke.customer.service;

import org.springframework.stereotype.Service;
import pl.woelke.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
