package dev.cafemanagement.server.service;

import dev.cafemanagement.server.model.Manager;
import dev.cafemanagement.server.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public Manager getManagerById(Long managerId) {return managerRepository.findById(managerId).orElse(null);}
    public Optional<Manager> getManagerByUsername(String username) {return managerRepository.findByUsername(username);}
    public void deleteManager(Long managerId) { managerRepository.deleteById(managerId);}
    public Manager addManager(Manager manager) { return managerRepository.save(manager);}
    public Manager updateManager(Long managerId, Manager updatedManager) {
        Manager existingManager = getManagerById(managerId);
        if(existingManager != null) {
            existingManager.setId(updatedManager.getId());
            existingManager.setRoles(updatedManager.getRoles());
            existingManager.setUsername(updatedManager.getUsername());
            existingManager.setPassword(updatedManager.getPassword());
            return managerRepository.save(existingManager);
        } else {
            return null;
        }
    }
    public List<Manager> getAllManagers() { return managerRepository.findAll();}
}

