package com.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev")
public class DevController {

    @RequestMapping("/login.action")
    public String login(){
        return "devlogin";
    }
}
