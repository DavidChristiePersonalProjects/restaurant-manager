/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.restaurantmanager.menu.menucategory;

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
public class MenuCategoryService {
    
    @Autowired
    private MenuCategoryRepository menuCategoryRepository;
    
    public List<MenuCategory> getAllMenuCategories(int menuId) {
        List<MenuCategory> menuCategories = new ArrayList<>();
        
        menuCategoryRepository.findByMenuId(menuId)
                .forEach(menuCategories::add);
        
        return menuCategories;
    }

    public Optional<MenuCategory> getMenuCategory(int id) {
       return menuCategoryRepository.findById(id);
    }

    public void addMenuCategory(MenuCategory menuCategory) {
        menuCategoryRepository.save(menuCategory);
    }

    public void updateMenuCategory(MenuCategory menuCategory) {
        menuCategoryRepository.save(menuCategory);
    }

    public void deleteMenuCategory(int id) {
        menuCategoryRepository.deleteById(id);
    }
    
    
    
}
