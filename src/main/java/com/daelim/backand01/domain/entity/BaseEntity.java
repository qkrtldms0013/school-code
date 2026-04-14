package com.daelim.backand01.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    LocalDateTime createdAt;


    @LastModifiedDate
    LocalDateTime updatedAt;

    LocalDateTime deletedAt;

    boolean deleted = false;

    public void delete() {
        deleted = true;
        deletedAt = LocalDateTime.now();
    }

    public void revive() {
        deleted = false;

    }


}
