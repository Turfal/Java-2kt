
package com.uwu.turfal.service;

import com.uwu.turfal.DAO.DocumentDAO;
import com.uwu.turfal.modules.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentDAO documentDAO;

    public void saveDocument(Document document) {
        document.setCreatedAt(LocalDate.now());
        documentDAO.save(document);
    }

    public void updateDocument(Document document) {
        document.setCreatedAt(LocalDate.now());
        documentDAO.save(document);
    }

    public List<Document> getAllDocuments() {
        return documentDAO.findAll();
    }

    public Document getDocumentById(Long id) {
        return documentDAO.findById(id).orElse(null);
    }

    public void deleteDocumentById(Long id) {
        documentDAO.deleteById(id);
    }
}
