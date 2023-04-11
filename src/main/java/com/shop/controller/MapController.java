package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
public class MapController {
    @RequestMapping("/map1")
    public String map1(Model model) {
        model.addAttribute("center", "map1");
        return "main";
    }
    @RequestMapping("/map2")
    public String map2(Model model) {
        model.addAttribute("center", "map2");
        return "main";
    }

    @RequestMapping("/shopdetail")
    public String map2(Model model, String id) {
        model.addAttribute("shopid", id);
        model.addAttribute("center", "shopdetail");
        return "main";
    }
}

