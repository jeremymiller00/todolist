package com.jeremy.service;

import com.jeremy.model.TodoData;
import com.jeremy.model.TodoItem;

import java.util.List;

public interface TodoItemService {

  void addItem(TodoItem toAdd);

  void removeItem(int id);

  TodoItem getItem(int id);

  void updateItem(TodoItem toUpdate);

  TodoData getData();

}
