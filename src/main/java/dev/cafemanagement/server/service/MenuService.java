package dev.cafemanagement.server.service;

import dev.cafemanagement.server.model.Menu;
import dev.cafemanagement.server.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public Menu getMenuById(Long menuId) {
        return menuRepository.findById(menuId).orElse(null);
    }
    public void deleteMenu(Long menuId) {
        menuRepository.deleteById(menuId);
    }
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }
    public Menu updateMenu(Long menuId, Menu updatedMenu) {
        Menu existingMenu = getMenuById(menuId);
        if(existingMenu != null) {
            existingMenu.setId(updatedMenu.getId());
            existingMenu.setName(updatedMenu.getName());
            existingMenu.setDescription(updatedMenu.getDescription());
            existingMenu.setItems(updatedMenu.getItems());
            return menuRepository.save(existingMenu);
        } else {
            return null;
        }
    }
    public List<Menu> getAllMenus() { return menuRepository.findAll();
    }
}