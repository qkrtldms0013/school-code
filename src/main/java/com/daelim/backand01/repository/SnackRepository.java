package com.daelim.backand01.repository;

import com.daelim.backand01.domain.entity.SnackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SnackRepository extends JpaRepository<SnackEntity, Long> {
    List<SnackEntity> findByDeletedFalse();
    Optional<SnackEntity> findByIdAndDeletedFalse(Long id);
}
