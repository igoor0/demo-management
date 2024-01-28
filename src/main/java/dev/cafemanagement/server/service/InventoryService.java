package dev.cafemanagement.server.service;

import dev.cafemanagement.server.model.Inventory;
import dev.cafemanagement.server.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory getInventory(Long inventoryId) { return inventoryRepository.findById(inventoryId).orElse(null);
    }
}