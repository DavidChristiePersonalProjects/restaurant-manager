/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.restaurantmanager.menu.menucategory;

import com.apofina.restaurantmanager.menu.Menu;
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
public class MenuCategoryController {
    
    @Autowired
    private MenuCategoryService menuCategoryService;
    
    @RequestMapping("/menus/{menu.id}/categories")
    public List<MenuCategory> getAllMenuCategories(@PathVariable("menu.id") int menuId) {
        return menuCategoryService.getAllMenuCategories(menuId);
    }
    
    @RequestMapping("/menus/{menu.id}/categories/{menu_category.id}")
    public MenuCategory getMenuCategory(@PathVariable("menu_category.id") int id) {
        return menuCategoryService.getMenuCategory(id).orElseThrow(IllegalArgumentException::new);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/menus/{menu.id}/categories")
    public void addMenuCategory(@RequestBody MenuCategory menuCategory, @PathVariable("menu.id") int menuId) {
        menuCategory.setMenu(new Menu(menuId, "", ""));
        menuCategoryService.addMenuCategory(menuCategory);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/menus/{menu.id}/categories/{menu_category.id}")
    public void updateMenuCatgory(@RequestBody MenuCategory menuCategory, @PathVariable("menu.id") int menuId) {
        menuCategory.setMenu(new Menu(menuId, "", ""));
        menuCategoryService.updateMenuCategory(menuCategory);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/menus/{menu.id}/categories/{menu_category.id}")
    public void deleteMenuItemCategory(@PathVariable("menu_category.id") int id) {
        menuCategoryService.deleteMenuCategory(id);
    }

}
