package com.example.groceryList.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.groceryList.exception.ResourceNotFoundException;
import com.example.groceryList.model.Item;
import com.example.groceryList.repository.ItemRepository;


@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ItemController 
{
	 private ItemRepository itemRepository;
	 
	 @GetMapping("/items")
	 public List<Item> getAllItems(){
		 return itemRepository.findAll();
	 }
	 
	 @GetMapping("/items/{id}")
	    public ResponseEntity<Item> getEmployeeById(@PathVariable(value = "id") Long listItemId)
	        throws ResourceNotFoundException {
	        Item item = itemRepository.findById(listItemId)
	          .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + listItemId));
	        return ResponseEntity.ok().body(item);
	    }
	    
	    @PostMapping("/items")
	    public Item createEmployee(@Valid @RequestBody Item item) {
	        return itemRepository.save(item);
	    }

	    @PutMapping("/items/{id}")
	    public ResponseEntity<Item> updateEmployee(@PathVariable(value = "id") Long listItemId,
	         @Valid @RequestBody Item itemDetails) throws ResourceNotFoundException {
	        Item item = itemRepository.findById(listItemId)
	        .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + listItemId));

	        item.setQuantity(itemDetails.getQuantity());
	        item.setitemDescription(itemDetails.getitemDescription());
	        item.setitemName(itemDetails.getitemName());
	        final Item updatedItem = itemRepository.save(item);
	        return ResponseEntity.ok(updatedItem);
	    }

	    @DeleteMapping("/items/{id}")
	    public Map<String, Boolean> deleteItem(@PathVariable(value = "id") Long listItemId)
	         throws ResourceNotFoundException {
	        Item item = itemRepository.findById(listItemId)
	       .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + listItemId));

	        itemRepository.delete(item);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
	 

