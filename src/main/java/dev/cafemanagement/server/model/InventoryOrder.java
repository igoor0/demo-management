package dev.cafemanagement.server.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "inventory_order")
public class InventoryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    @Column(nullable = false)
    private Date orderDate;

    @Column(nullable = false)
    private int quantity;
}

