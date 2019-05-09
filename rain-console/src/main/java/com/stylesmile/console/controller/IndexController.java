package com.stylesmile.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "Hello World!";
    }
}
