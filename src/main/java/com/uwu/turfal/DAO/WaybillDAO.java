package com.uwu.turfal.DAO;

import com.uwu.turfal.modules.Waybill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaybillDAO extends JpaRepository<Waybill, Long> {
}
