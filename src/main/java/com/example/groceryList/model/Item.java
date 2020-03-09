package com.example.groceryList.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

    private long listItemId;
    private String itemName;
    private String itemDescription;
    private String quantity;
 
    public Item() {
  
    }
 
    public Item(String itemName, String itemDescription, String quantity) {
         this.itemName = itemName;
         this.itemDescription = itemDescription;
         this.quantity = quantity;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return listItemId;
    }
    public void setId(long id) {
        this.listItemId = id;
    }
 
    @Column(name = "itemName", nullable = false)
    public String getitemName() {
        return itemName;
    }
    public void setitemName(String itemName) {
        this.itemName = itemName;
    }
 
    @Column(name = "itemDescription", nullable = false)
    public String getitemDescription() {
        return itemDescription;
    }
    public void setitemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
 
    @Column(name = "quantity", nullable = false)
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item [itemIid=" + listItemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription + ", quantity=" + quantity
       + "]";
    }
 
}