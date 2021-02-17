package com.jeremy.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/*
 Simulate an in-memory database
 */
public class TodoData {

  // == fields ==
  private static int idValue = 1;

  private final List<TodoItem> items = new ArrayList<>();

  // == constructor ==
  public TodoData() {

    // == dummy data ==
    addItem(new TodoItem("first", "first details", LocalDate.now()));
    addItem(new TodoItem("second", "second details", LocalDate.now()));
    addItem(new TodoItem("third", "third details", LocalDate.now()));
    addItem(new TodoItem("fourth", "fourth details", LocalDate.now()));

  }

  // == crud operations ==
  public List<TodoItem> getItems() {
    return Collections.unmodifiableList(items);
  }

  public void addItem(TodoItem toAdd) {
    if (toAdd == null) {
      throw new NullPointerException("toAdd is a required parameter");
    }
    toAdd.setId(idValue);
    items.add(toAdd);
    idValue++;
  }

  public void removeItem(int id) {
    ListIterator<TodoItem> itemIterator = items.listIterator();
    while (itemIterator.hasNext()) {
      TodoItem item = itemIterator.next();
      if (item.getId() == id) {
        itemIterator.remove();
        break;
      }
    }
  }

  public TodoItem getItem(int id) {
    for (TodoItem item : items) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  public void updateItem(TodoItem toUpdate) {
    if (toUpdate == null) {
      throw new NullPointerException("toUpdate parameter is required");
    }

    ListIterator<TodoItem> itemIterator = items.listIterator();
    while (itemIterator.hasNext()) {
      TodoItem item = itemIterator.next();
      if (item.equals(toUpdate)) {
        itemIterator.set(toUpdate);
        break;
      }
    }
  }
}
