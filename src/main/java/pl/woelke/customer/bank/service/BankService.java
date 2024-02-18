package pl.woelke.customer.bank.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.woelke.customer.bank.model.BankDetail;
import pl.woelke.customer.bank.repository.BankDetailEntity;
import pl.woelke.customer.bank.repository.BankRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BankService {

    private final BankRepository bankRepository;
    private final ModelMapper modelMapper;

    public BankService(BankRepository bankRepository, ModelMapper modelMapper) {
        this.bankRepository = bankRepository;
        this.modelMapper = modelMapper;
    }

    public List<BankDetail> getAllBanks() {
        log.debug("getAllBanks()");
        return bankRepository.findAll().stream()
                .map(bankDetailEntity -> modelMapper.map(bankDetailEntity, BankDetail.class))
                .collect(Collectors.toList());
    }

    public BankDetail createBank(BankDetail bankDetail) {
        log.debug("createBank({})", bankDetail);
        BankDetailEntity bankDetailEntity = modelMapper.map(bankDetail, BankDetailEntity.class);
        BankDetailEntity savedBankDetailEntity = bankRepository.save(bankDetailEntity);
        return modelMapper.map(savedBankDetailEntity, BankDetail.class);
    }

    public BankDetail getBankById(Long id) {
        log.debug("getBankById({})", id);
        Optional<BankDetailEntity> bankDetailEntityOptional = bankRepository.findById(id);
        return bankDetailEntityOptional.map(bankDetailEntity -> modelMapper.map(bankDetailEntity, BankDetail.class))
                .orElse(null);
    }

    public BankDetail updateBank(Long id, BankDetail bankDetail) {
        log.debug("updateBank({}, {})", id, bankDetail);
        BankDetailEntity bankDetailEntity = bankRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BankDetail not found with id " + id));
        BankDetailEntity updatedBankDetailEntity = bankRepository.save(bankDetailEntity);
        return modelMapper.map(updatedBankDetailEntity, BankDetail.class);
    }

    public void deleteBank(Long id) {
        log.debug("deleteBank({})", id);
        bankRepository.deleteById(id);
    }

}
