package com.daelim.backand01.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"snack_id", "store_id"})
        }
)
public class Stock extends BaseEntity{

    public Stock(Snack snack, Store store, Long quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }

        this.snack = snack;
        this.store = store;
        this.quantity = quantity;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "snack_id", nullable = false)
    private Snack snack;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(nullable = false)
    private Long quantity;

    public void increase(Long amount) {
        this.quantity += amount;
    }
    public void decree(Long amount) {
        if (this.quantity < amount) {
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }
        this.quantity -= amount;
    }
}
