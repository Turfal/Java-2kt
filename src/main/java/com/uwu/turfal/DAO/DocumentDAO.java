package com.uwu.turfal.DAO;

import com.uwu.turfal.modules.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDAO extends JpaRepository<Document, Long> {
}
