package com.uwu.turfal.service;

import com.uwu.turfal.DAO.PaymentDAO;
import com.uwu.turfal.modules.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentDAO paymentDAO;

    public void savePayment(Payment payment) {
        payment.setCreatedAt(LocalDate.now());
        paymentDAO.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentDAO.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentDAO.findById(id).orElse(null);
    }

}
