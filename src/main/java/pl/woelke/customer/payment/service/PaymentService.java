package pl.woelke.customer.payment.service;

import org.springframework.stereotype.Service;
import pl.woelke.customer.payment.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
}
