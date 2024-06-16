package com.uwu.turfal.controllers;

import com.uwu.turfal.modules.Customer;
import com.uwu.turfal.modules.Document;
import com.uwu.turfal.service.CustomerService;
import com.uwu.turfal.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    public String home(Model model) {
        List<Document> documents = documentService.getAllDocuments();
        model.addAttribute("documents", documents);
        model.addAttribute("customer", new Customer());
        model.addAttribute("document", new Document());
        return "home";
    }

    @GetMapping("/document/{id}")
    public String viewDocument(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        Document document = documentService.getDocumentById(id);
        model.addAttribute("document", document);
        return "document";
    }

    @PostMapping("/createDocumentAndCustomer")
    public String createDocumentAndCustomer(
            @ModelAttribute("customer") Customer customer,
            @ModelAttribute("document") Document document) {
        customerService.saveCustomer(customer);
        customer.setId(document.getCustomerId());
        documentService.saveDocument(document);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> editDocument(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        Customer customer = customerService.getCustomerById(document.getCustomerId());

        Map<String, Object> response = new HashMap<>();
        response.put("document", document);
        response.put("customer", customer);

        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/editDocument")
    public String updateDocument(
            @ModelAttribute("customer") Customer customer,
            @ModelAttribute("document") Document document) {
            customerService.updateCustomer(customer);
            customer.setId(document.getCustomerId());
            documentService.updateDocument(document);
        return "redirect:/";
    }

    @PostMapping("/deleteDocument")
    public ResponseEntity<String> deleteDocument(@RequestParam Long id) {
        Document document = documentService.getDocumentById(id);
        if (document != null) {
            customerService.deleteCustomerById(document.getCustomerId());
            documentService.deleteDocumentById(id);
            return ResponseEntity.ok().body("Document and customer deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid document ID");
        }
    }
}
