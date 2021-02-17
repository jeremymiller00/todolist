package com.jeremy.controller;

import com.jeremy.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 Annotation indicates web controller
 */
@Controller
public class DemoController {

  // == attributes ==
  public static final Logger log = LoggerFactory.getLogger(DemoController.class);
  private final DemoService demoService;

  // == constructor ==
  @Autowired
  public DemoController(DemoService demoService) {
    this.demoService = demoService;
  }

  // == request methods ==
  // http://localhost:8080/todolist/hello
  @ResponseBody
  @GetMapping("/hello")
  public String hello() {
    return "Hello !";
  }

  // http://localhost:8080/todolist/welcome
  @GetMapping("welcome")
  public String welcome(@RequestParam String user,
                        @RequestParam int age,
                        Model model) {
    model.addAttribute("helloMessage", demoService.getHelloMessage(user));
    model.addAttribute("age", age);
    log.info("model = {}", model);
    return "welcome"; // uses prefix and suffix from view resolver WebConfig
  }

  // == model attributes ==
  @ModelAttribute("welcomeMessage")
  public String welcomeMessage() {
    log.info("welcomeMessage called");
    return demoService.getWelcomeMessage();
  }

}
