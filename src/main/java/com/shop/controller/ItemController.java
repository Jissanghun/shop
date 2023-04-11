package com.shop.controller;

import com.github.pagehelper.PageInfo;
import com.shop.dto.CustDTO;
import com.shop.dto.ItemDTO;
import com.shop.service.ItemService;
import com.shop.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    String dir = "/item/";

    @Value("${imglocation}")
    String custdir;

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
    @RequestMapping("/get")
    public String get(Model model){
        List<ItemDTO> list = null;

        try {
            list = itemService.get();
            model.addAttribute("ilist",list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        return "main";
    }

    @GetMapping("/getpage")
    public String getpage(@RequestParam(required = false, defaultValue = "1") int pageNum, Model model) throws Exception {
        PageInfo<ItemDTO> p = new PageInfo<>(itemService.getPage(pageNum), 3);
        model.addAttribute("items", p);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"getpage");

        return "/main";
    }


    @RequestMapping("/addimpl")
    public String addimpl(Model model, ItemDTO obj) {

        String imgname = obj.getImg().getOriginalFilename();
        obj.setImgname(imgname);

        try {
            FileUploadUtil.saveFile(obj.getImg(), custdir);
            itemService.register(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:getpage";
    }
    @RequestMapping("/updateimpl")
    public String updateimpl(Model model, ItemDTO obj) throws Exception{
        if(obj.getImg().getOriginalFilename().equals("")){
            itemService.modify(obj);
        }else{
            String newimgname = obj.getImg().getOriginalFilename();
            FileUploadUtil.saveFile(obj.getImg(),custdir);
            obj.setImgname(newimgname);
            itemService.modify(obj);
        }
        return "redirect:detail?id="+obj.getId();
    }
    @RequestMapping("/detail")
    public String detail(Model model, int id){
        ItemDTO obj = null;

        try {
            obj = itemService.get(id);
            model.addAttribute("ditem",obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"detail");
        return "main";
    }


    @RequestMapping("/addcart")
    public String addcart(Model model, int id){
        ItemDTO obj = null;

        try {
            obj = itemService.get(id);
            model.addAttribute("ditem",obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"addcart");
        return "main";
    }

    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, int id){
         try {
            itemService.remove(id);
         } catch (Exception e) {
            throw new RuntimeException(e);
         }
         return "redirect:getpage";
    }

}
