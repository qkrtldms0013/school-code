package com.daelim.backand01.repository;

import com.daelim.backand01.domain.entity.Snack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SnackRepository extends JpaRepository<Snack, Long> {
    List<Snack> findByDeletedFalse();
    Optional<Snack> findByIdAndDeletedFalse(Long id);
}
