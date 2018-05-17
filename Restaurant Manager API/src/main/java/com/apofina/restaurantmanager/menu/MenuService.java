/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.restaurantmanager.menu;

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
public class MenuService {
    
    @Autowired
    private MenuRepository menuRepository;
    
    public List<Menu> getAllMenus() {
        List<Menu> menus = new ArrayList<>();
        
        menuRepository.findAll()
                .forEach(menus::add);
        
        return menus;
    }
    
    public Optional<Menu> getMenu(int id) {
        return menuRepository.findById(id);
    }
    
    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }
    
    public void updateMenu(Menu menu) {
        System.out.println("updateMenu called");
        Menu mResult = menuRepository.save(menu);
        System.out.println(mResult);
    }
    
    public void deleteMenu(int id) {
        menuRepository.deleteById(id);
    }
    
}
