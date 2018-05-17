/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.restaurantmanager.menu.menuitem;

import com.apofina.restaurantmanager.menu.menucategory.MenuCategory;
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
public class MenuItemController {
    
    @Autowired
    private MenuItemService menuItemService;
    
    @RequestMapping("/menus/{menu.id}/categories/{menu_category.id}/items")
    public List<MenuItem> getAllMenuItems(@PathVariable("menu_category.id") int menuCategoryId) {
        return menuItemService.getAllMenuItems(menuCategoryId);
    }
    
    @RequestMapping("/menus/{menu.id}/categories/{menu_category.id}/items/{menu_item.id}")
    public MenuItem getMenuItem(@PathVariable("menu_category.id") int menuItemId) {
        return menuItemService.getMenuItem(menuItemId).orElseThrow(IllegalArgumentException::new);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/menus/{menu.id}/categories/{menu_category.id}/items")
    public void addMenuItemCategory(@RequestBody MenuItem menuItem, @PathVariable("menu_category.id") int menuCategoryId, @PathVariable("menu.id") int menuId) {
        menuItem.setMenuCategory(new MenuCategory(menuCategoryId, "", "", menuId));
        menuItemService.addMenuItem(menuItem);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/menus/{menu.id}/categories/{menu_category.id}/items/{menu_item.id}")
    public void updateMenuItem(@RequestBody MenuItem menuItem, @PathVariable("menu_category.id") int menuCategoryId, @PathVariable("menu.id") int menuId) {
        menuItem.setMenuCategory(new MenuCategory(menuCategoryId, "", "", menuId));
        menuItemService.updateMenuItem(menuItem);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/menus/{menu.id}/categories/{menu_category.id}/items/{menu_item.id}")
    public void deleteMenuItem(@PathVariable("menu_item.id") int menuItemId) {
        menuItemService.deleteMenuItem(menuItemId);
    }

}
