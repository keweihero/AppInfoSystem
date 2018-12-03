package com.bdqn.controller;

import com.bdqn.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/devPage")
public class DevPageController {
    @RequestMapping("/login.action")
    public String login(){
        return "devlogin";
    }

    @RequestMapping("/main.action")
    public String doMain(){
        return "/developer/main";
    }

    @RequestMapping("logout.action")
    public String doLogout(HttpSession session){
        session.removeAttribute(Constants.USER_SESSION);
        return "devlogin";
    }

    @RequestMapping("/list.action")
    public String doList(){
        return "/developer/appinfolist";
    }

    @RequestMapping("/appinfoadd.action")
    public String appinfoadd(){
        return "/developer/appinfoadd";
    }

    @RequestMapping("/modify.action")
    public String modify(){
        return "/developer/appinfomodify";
    }
}
