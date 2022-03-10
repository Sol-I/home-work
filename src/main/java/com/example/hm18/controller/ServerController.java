package com.example.hm18.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ServerController {

    @GetMapping("/user")
    @ResponseBody
    public ModelAndView getName(@RequestParam String name) {
        ModelAndView model = new ModelAndView();
        model.addObject("name", name);
        model.setViewName("welcome");
        return model;
    }
}
