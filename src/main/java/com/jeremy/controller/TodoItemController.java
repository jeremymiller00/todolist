package com.jeremy.controller;

import com.jeremy.model.TodoData;
import com.jeremy.model.TodoItem;
import com.jeremy.service.TodoItemService;
import com.jeremy.util.AttributeNames;
import com.jeremy.util.Mappings;
import com.jeremy.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoItemController {

  private final TodoItemService todoItemService;

  @Autowired
  public TodoItemController(TodoItemService todoItemService) {
    this.todoItemService = todoItemService;
  }

  // == attributes ==
  @ModelAttribute
  public TodoData todoData() {
    return todoItemService.getData();
  }

  // http://localhost:8080/todolist/items
  @GetMapping(Mappings.ITEMS)
  public String items() {
    return ViewNames.ITEMS_LIST;
  }

  @PostMapping(Mappings.ADD_ITEM)
  public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM)  TodoItem todoItem) {
    return "redirect:/+" + Mappings.ITEMS;
  }



}
