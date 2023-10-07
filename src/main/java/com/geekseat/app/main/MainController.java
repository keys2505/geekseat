package com.geekseat.app.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
    
  @GetMapping("/")
	String getIndex(Model model, HttpSession session) {
        return "redirect:/swagger-ui/index.html";
	}
}
