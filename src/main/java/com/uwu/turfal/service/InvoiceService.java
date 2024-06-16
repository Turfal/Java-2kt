package com.uwu.turfal.service;

import com.uwu.turfal.DAO.InvoiceDAO;
import com.uwu.turfal.modules.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceDAO invoiceDAO;

    public void saveInvoice(Invoice invoice) {
        invoice.setCreatedAt(LocalDate.now());
        invoiceDAO.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceDAO.findAll();
    }

}
