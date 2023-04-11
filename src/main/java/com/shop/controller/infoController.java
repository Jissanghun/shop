package com.shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class infoController {

    @RequestMapping("/infomation")
    public String register(Model model){
        model.addAttribute("center","register");
        return "main";
    }

}
