package com.jeremy.service;

import com.jeremy.model.TodoData;
import com.jeremy.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

  public final TodoData data = new TodoData();

  @Override
  public void addItem(TodoItem toAdd) {
    data.addItem(toAdd);
  }

  @Override
  public void removeItem(int id) {
    data.removeItem(id);
  }

  @Override
  public TodoItem getItem(int id) {
    return data.getItem(id);
  }

  @Override
  public void updateItem(TodoItem todoItem) {
    data.updateItem(todoItem);
  }

  @Override
  public TodoData getData() {
    return data;
  }
}
