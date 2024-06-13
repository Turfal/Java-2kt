package com.uwu.turfal.DAO;

import com.uwu.turfal.modules.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDAO extends JpaRepository<Invoice, Long> {
}
