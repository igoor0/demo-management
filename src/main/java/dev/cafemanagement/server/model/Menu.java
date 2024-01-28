package dev.cafemanagement.server.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Entity
@Data
@Table(name = "menu")
public class Menu {
    @Id
    @Getter
    @Setter
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "name", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> items;
}