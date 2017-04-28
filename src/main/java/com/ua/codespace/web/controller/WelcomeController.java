package com.ua.codespace.web.controller;

import com.ua.codespace.entity.User;
import com.ua.codespace.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping({"/", "/welcome"})
public class WelcomeController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = GET)
    public String welcome(Model model) {
        model.addAttribute("user", new User("Johnny"));
        return "welcome";
    }

    @RequestMapping(value = "/message", method = GET)
    @ResponseBody
    public String message() {
        return messageService.printMessage();
    }

}

