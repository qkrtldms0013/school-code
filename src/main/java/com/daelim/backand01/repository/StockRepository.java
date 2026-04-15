package com.daelim.backand01.repository;

import com.daelim.backand01.domain.entity.Stock;
import com.daelim.backand01.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
