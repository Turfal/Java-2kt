
package com.uwu.turfal.modules;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentName;
    private String documentDescription;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @Lob
    private String documentContent;

    private LocalDateTime createdAt;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public LocalDate getCreatedAt() {
        return createdAt.toLocalDate();
    }

    public void setCreatedAt(LocalDate createdAtDate) {
        this.createdAt = createdAtDate.atStartOfDay();
    }

    public Long getCustomerId() {
        return id;
    }
}
