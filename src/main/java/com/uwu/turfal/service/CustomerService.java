package com.uwu.turfal.service;

import com.uwu.turfal.DAO.CustomerDAO;
import com.uwu.turfal.modules.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public void saveCustomer(Customer customer) {
        customer.setCreatedAt(LocalDate.now());
        customerDAO.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerDAO.findById(id).orElse(null);
    }

    public void deleteCustomerById(Long id) {
        customerDAO.deleteById(id);
    }

    public void updateCustomer(Customer customer) {
        customer.setCreatedAt(LocalDate.now());
        customerDAO.save(customer);
    }
}
