/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.restaurantmanager.menu.menuitem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class MenuItemService {
    
    @Autowired
    private MenuItemRepository menuItemRepository;
    
    public List<MenuItem> getAllMenuItems(int menuCategoryId) {
        List<MenuItem> menuItems = new ArrayList<>();
        
        menuItemRepository.findByMenuCategoryId(menuCategoryId)
                .forEach(menuItems::add);
        
        return menuItems;
    }

    public Optional<MenuItem> getMenuItem(int id) {
       return menuItemRepository.findById(id);
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }

    public void updateMenuItem(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(int id) {
        menuItemRepository.deleteById(id);
    }
    
    
    
}
