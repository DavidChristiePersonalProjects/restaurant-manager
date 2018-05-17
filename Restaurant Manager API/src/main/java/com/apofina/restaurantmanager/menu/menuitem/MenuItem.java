/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apofina.restaurantmanager.menu.menuitem;

import com.apofina.restaurantmanager.menu.menucategory.MenuCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author David
 */
@Entity
public class MenuItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String description;
    int cost;
    String imageURL;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    MenuCategory menuCategory;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
    }

    public MenuItem() {
    }

    public MenuItem(int id, String name, String description, int cost, String imageURL, int menuCategoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.imageURL = imageURL;
        this.menuCategory = new MenuCategory(menuCategoryId, "", "", -1);
    }
    
    
}
