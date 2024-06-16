package com.uwu.turfal.DAO;

import com.uwu.turfal.modules.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Orders, Long> {
}
