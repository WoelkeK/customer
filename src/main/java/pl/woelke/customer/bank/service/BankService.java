package pl.woelke.customer.bank.service;

import org.springframework.stereotype.Service;
import pl.woelke.customer.bank.repository.BankRepository;

@Service
public class BankService {

    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
}
