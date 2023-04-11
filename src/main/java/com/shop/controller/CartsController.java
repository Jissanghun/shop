package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.dto.CartsDTO;
import com.shop.dto.CustDTO;
import com.shop.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartsController {
    @Autowired
    CartsService cartsService;
    String dir = "/cart/";

    @GetMapping("")
    public String getpage(@RequestParam(required = false, defaultValue = "1") int pageNum,
                          Model model, String id) throws Exception {
        List<CartsDTO> mycarts = null;
        mycarts = cartsService.cartsall(id);
        PageInfo<CartsDTO> p =
                new PageInfo<>(cartsService.cartsallpage(pageNum,id), 3);
        model.addAttribute("items", p);
        model.addAttribute("mycarts", mycarts);
        model.addAttribute("center", dir+"getpage");

        return "/main";
    }


    @PostMapping("/addcartimpl")
    public String addcartimpl(Model model, CartsDTO carts) throws Exception {
        cartsService.register(carts);
        return "redirect:/cart?id="+carts.getCust_id();
    }
    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, int id, String cid) throws Exception {
        System.out.println(id+" "+cid);
        cartsService.remove(id);
        return "redirect:/cart?id="+cid;
    }
}
