package com.example.demo.controllers;

import com.example.demo.services.CatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class CatController {
    CatService catService = new CatService();

    @GetMapping("/")
    @ResponseBody
    public String frontPage(){
        return "Welcome to cat facts. Cat facts Cat facts Cat facts Cat facts Cat facts Cat facts";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String singleFact() throws IOException {
        return catService.getSingleCatFact().getText();
    }

    @GetMapping("getTen")
    @ResponseBody
    public String getTen() throws IOException {
        return catService.getTen();
    }

    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public String getTenSortByDate() throws IOException {
        return catService.getTenSortByDate();
    }

    @GetMapping("/contains")
    @ResponseBody
    public String contains(@RequestParam char c, int amount) throws IOException {
        return catService.contains(c,amount);
    }

}
