/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.restaurantmanager.menu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David
 */
@RestController
public class MenuController {
    
    @Autowired
    private MenuService menuService;
    
    @RequestMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }
    
    @RequestMapping("/menus/{menu.id}")
    public Menu getMenu(@PathVariable("menu.id") int id) {
        return menuService.getMenu(id)
                .orElseThrow(IllegalArgumentException::new);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/menus")
    public void addMenu(@RequestBody Menu menu) {
        menuService.addMenu(menu);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/menus/{menu.id}")
    public void updateMenu(@RequestBody Menu menu) {
        menuService.updateMenu(menu);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/menus/{menu.id}")
    public void deleteMenu(@PathVariable("menu.id") int id) {
        menuService.deleteMenu(id);
    }
    
}
