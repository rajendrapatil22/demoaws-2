package com.in28minutes.rest.webservices.restfulwebservices;

import com.in28minutes.rest.webservices.restfulwebservices.helloworld.Item;

public class ItemBuilder {
  private Item item = new Item();
  
  public ItemBuilder id(int id) {
    item.setId(id);
    return this;
  }
  
  public ItemBuilder description(String description) {
    item.setDescription(description);
    return this;
  }
  
  public ItemBuilder checked() {
    item.setStatus(true);
    return this;
  }
  
  public Item build() {
    return item;
  }
}
