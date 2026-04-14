package com.daelim.backand01.repository;

import com.daelim.backand01.domain.entity.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestTableRepository extends JpaRepository<TestTable, Long> {

    Optional<TestTable> findByIdAndDeletedFalse(Long id);

    List<TestTable> findByDeletedFalse();

    List<TestTable> findByTitleAndDeletedFalse(String title);
    //select *  from test_table where title = ':title';

    List<TestTable> findByTitleContainingOrContentContainingAndDeletedFalse(String keyword, String content);

    List<TestTable> findByTitleLike(String title);
}
