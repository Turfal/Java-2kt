package com.uwu.turfal.DAO;

import com.uwu.turfal.modules.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDAO extends JpaRepository<Payment, Long> {
}
