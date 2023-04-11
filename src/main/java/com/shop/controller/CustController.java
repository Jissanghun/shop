package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.dto.CustDTO;
import com.shop.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cust")
public class CustController {
    @Autowired
    CustService custService;

    String dir = "/cust/";

    @RequestMapping("")
    public String cust(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "main";
    }
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"add");
        return "main";
    }

    @RequestMapping("/addimpl")
    public String addimpl(Model model, CustDTO cust){
        try {
            custService.register(cust);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/cust/getpage";
    }

    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, CustDTO cust){
        try {
            custService.modify(cust);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/cust/detail?id="+cust.getId();
    }
    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, String id){
        try {
            custService.remove(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/cust/getpage";
    }
    @RequestMapping("/get")
    public String get(Model model){
        List<CustDTO> list = null;
        try {
            list = custService.get();
            model.addAttribute("clist",list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        return "main";
    }

    @RequestMapping("/detail")
    public String detail(Model model, String id){
        CustDTO obj = null;
        try {
            obj = custService.get(id);
            model.addAttribute("dcust",obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"detail");
        return "main";
    }

    @GetMapping("/getpage")
    public String getpage(@RequestParam(required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
        PageInfo<CustDTO> p = new PageInfo<>(custService.getPage(pageNum), 8);
        model.addAttribute("users", p);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"getpage");

        return "/main";
    }

}
