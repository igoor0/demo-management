package dev.cafemanagement.server.service;

import dev.cafemanagement.server.model.Supplier;
import dev.cafemanagement.server.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier getSupplierById(Long supplierId) {
        return supplierRepository.findById(supplierId).orElse(null);
    }
    public void deleteSupplier(Long supplierId) {
        supplierRepository.deleteById(supplierId);
    }
    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    public Supplier updateSupplier(Long supplierId, Supplier updatedSupplier) {
        Supplier existingSupplier = getSupplierById(supplierId);
        if(existingSupplier != null) {
            existingSupplier.setId(updatedSupplier.getId());
            existingSupplier.setEmail(updatedSupplier.getEmail());
            existingSupplier.setName(updatedSupplier.getName());
            existingSupplier.setContactNumber(updatedSupplier.getContactNumber());
            existingSupplier.setContactPerson(updatedSupplier.getContactPerson());
            return supplierRepository.save(existingSupplier);
        } else {
            return null;
        }
    }
    public List<Supplier> getAllSuppliers() { return supplierRepository.findAll();
    }
}
