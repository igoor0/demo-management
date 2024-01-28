package dev.cafemanagement.server.repository;


import dev.cafemanagement.server.model.Product;
import dev.cafemanagement.server.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT DISTINCT p.productCategory FROM Product p")
    List<ProductCategory> findAllProductCategories();
}
