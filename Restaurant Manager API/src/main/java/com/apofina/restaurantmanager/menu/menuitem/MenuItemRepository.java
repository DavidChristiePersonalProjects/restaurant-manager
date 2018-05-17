/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.restaurantmanager.menu.menuitem;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author David
 */
public interface MenuItemRepository extends CrudRepository<MenuItem, Integer> {
    
    public Iterable<MenuItem> findByMenuCategoryId(int id);
    
}
