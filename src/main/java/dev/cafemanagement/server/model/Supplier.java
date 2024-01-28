package dev.cafemanagement.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "supplier")
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contactPerson;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private String email;
}