package dev.cafemanagement.server.controller;

import dev.cafemanagement.server.model.Manager;
import dev.cafemanagement.server.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> managers = managerService.getAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @GetMapping("/{managerId}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Long managerId) {
        Manager manager = managerService.getManagerById(managerId);
        if (manager != null)

        {
            return new ResponseEntity<>(manager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Manager> addManager(@RequestBody Manager manager) {
        Manager newManager = managerService.addManager(manager);
        return new ResponseEntity<>(newManager, HttpStatus.CREATED);
    }

    @PutMapping("/{managerId}")
    public ResponseEntity<Manager> updateManager(@PathVariable Long managerId, @RequestBody Manager manager) {
        Manager updatedManager = managerService.updateManager(managerId, manager);
        if (updatedManager != null) {
            return new ResponseEntity<>(updatedManager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{managerId}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long managerId) {
        managerService.deleteManager(managerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}