package com.bdqn.controller;

import com.bdqn.pojo.DevUser;
import com.bdqn.service.devuser.DevUserService;
import com.bdqn.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dev")
public class DevController {

    @Resource
    DevUserService devUserService;

    @RequestMapping("/login.action")
    public String login(){
        return "devlogin";
    }

    @RequestMapping(value = "/doLogin.action",method = RequestMethod.POST)
    public String doLogin(String devCode, String devPassword, HttpSession session){
        Map<String, Object> param = new HashMap<>();
        param.put("devCode", devCode);
        param.put("devPassword", devPassword);
        List<DevUser> users = devUserService.getDevUserListByMap(param);

        if(null != users.get(0)){
            session.setAttribute(Constants.USER_SESSION, users.get(0));
            return "redirect:/developer/main";
        }else {
            throw new RuntimeException("账号或者密码不正确！");
        }

    }
    @ExceptionHandler(value={RuntimeException.class})
    public String handlerException(RuntimeException e, HttpServletRequest req){
        req.setAttribute("e", e);
        return "devlogin";
    }
}
