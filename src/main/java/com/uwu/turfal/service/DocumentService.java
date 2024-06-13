
package com.uwu.turfal.service;

import com.uwu.turfal.DAO.DocumentRepository;
import com.uwu.turfal.modules.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public void saveDocument(Document document) {
        document.setCreatedAt(LocalDate.now());
        documentRepository.save(document);
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    public void deleteDocumentById(Long id) {
        documentRepository.deleteById(id);
    }
}
