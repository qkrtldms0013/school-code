package com.daelim.backand01.repository;

import com.daelim.backand01.domain.entity.Store;
import com.daelim.backand01.domain.entity.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
