package com.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.CRM.entity.Task;
import com.CRM.serviceImpl.TaskService;

@Controller
public class LandingPageController {
	@Autowired
	private TaskService service;
  
  @GetMapping("/")
  public String landingPage(Model model) {
    List<Task> recentActivities = service.getAllTasks();// retrieve recent activities from database
    model.addAttribute("recentActivities", recentActivities);
    return "CRM";
  }
}
