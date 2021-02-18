package com.jeremy.controller;

import com.jeremy.model.TodoData;
import com.jeremy.model.TodoItem;
import com.jeremy.service.TodoItemService;
import com.jeremy.util.AttributeNames;
import com.jeremy.util.Mappings;
import com.jeremy.util.ViewNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class TodoItemController {

  public static final Logger log = LoggerFactory.getLogger(TodoItemController.class);
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

  @GetMapping(Mappings.ADD_ITEM)
  public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                            Model model) {
    log.info("editing id = {}", id);
    TodoItem todoItem = todoItemService.getItem(id);
    if (todoItem == null) {
      todoItem = new TodoItem("", "", LocalDate.now());
    }
    model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
    return ViewNames.ADD_ITEM;
  }

  @PostMapping(Mappings.ADD_ITEM)
  public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM)  TodoItem todoItem) {
    log.info("todoItem from form = {}", todoItem);
    if (todoItem.getId() == 0) {
      todoItemService.addItem(todoItem);
    } else {
      todoItemService.updateItem(todoItem);
    }
    return "redirect:/" + Mappings.ITEMS;
  }

  @GetMapping(Mappings.DELETE_ITEM)
  public String deleteItem(@RequestParam int id) {
    log.info("deleting item with id = {}", id);
    todoItemService.removeItem(id);
    return "redirect:/" + Mappings.ITEMS;
  }

  @GetMapping(Mappings.VIEW_ITEM)
  public String viewItem(@RequestParam int id, Model model) {
    TodoItem todoItem = todoItemService.getItem(id);
    model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
    return ViewNames.VIEW_ITEM;
  }


}
