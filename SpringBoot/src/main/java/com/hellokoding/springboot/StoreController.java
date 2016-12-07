package com.hellokoding.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hellokoding.springboot.service.StoreService;

@Controller
public class StoreController {

	  @Autowired
	  private StoreService storeService;

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/addStore")
    public String addStore() {
    	storeService.addStore();
       return "addStore";
    }
    @RequestMapping("/findAllStore")
    public String findAllStore() {
    	storeService.findAllStore();
       return "findAllStore";
    }
    @RequestMapping("/JPAFindAllStore")
    public String JPAFindAllStore() {
    	storeService.JPAFindStore();
       return "addStore";
    }
}