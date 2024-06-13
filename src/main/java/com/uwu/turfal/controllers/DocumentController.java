package com.uwu.turfal.controllers;

import com.uwu.turfal.modules.Document;
import com.uwu.turfal.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    public String home(Model model) {
        List<Document> documents = documentService.getAllDocuments();
        model.addAttribute("documents", documents);
        model.addAttribute("document", new Document());
        return "home";
    }

    @GetMapping("/document/{id}")
    public String viewDocument(@PathVariable Long id, Model model) {
        Document document = documentService.getDocumentById(id);
        model.addAttribute("document", document);
        return "document";
    }

    @PostMapping("/create")
    public String createDocument(@ModelAttribute("document") Document document) {
        documentService.saveDocument(document);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<Document> editDocument(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        return ResponseEntity.ok().body(document);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateDocument(@RequestBody Document document) {
        documentService.saveDocument(document);
        return ResponseEntity.ok().body("Document updated successfully");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteDocument(@RequestParam Long id) {
        documentService.deleteDocumentById(id);
        return ResponseEntity.ok().body("Document deleted successfully");
    }

}

