package com.pie.kart.order.Model;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Orders")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String title;
    private double price;
    private List<String> productMap;
    private LocalDateTime initDate;
    @PrePersist
    protected void onCreate() {
        initDate = LocalDateTime.now();
    }
}