package com.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manag")
public class ManagerController {

    @RequestMapping("/login.action")
    public String login(){
        return "backendlogin";
    }
}
