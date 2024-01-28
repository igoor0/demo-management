package dev.cafemanagement.server.controller;

import dev.cafemanagement.server.model.Inventory;
import dev.cafemanagement.server.model.Product;
import dev.cafemanagement.server.model.ProductCategory;
import dev.cafemanagement.server.service.InventoryService;
import dev.cafemanagement.server.service.ProductCategoryService;
import dev.cafemanagement.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping
    public ResponseEntity<Inventory> getInventory(Long inventoryId) {
        Inventory inventory = inventoryService.getInventory(inventoryId);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<ProductCategory>> getAllProductCategories() {
        List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
        return new ResponseEntity<>(productCategories, HttpStatus.OK);
    }
}
