package com.bdqn.controller;

import com.bdqn.pojo.DevUser;
import com.bdqn.service.devuser.DevUserService;
import com.bdqn.utils.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dev")
public class DevController {

    private final Logger LOG = Logger.getLogger(getClass());

    @Resource
    DevUserService devUserService;

    @RequestMapping(value = "/doLogin.action",method = RequestMethod.POST)
    public String doLogin(String devCode, String devPassword, HttpSession session){
        LOG.info("APP信息管理系统,DevController:doLogin()接收到请求,参数:devCode:" + devCode + ", devPassword:" + devPassword);
        Map<String, Object> param = new HashMap<>();
        param.put("devCode", devCode);
        param.put("devPassword", devPassword);
        DevUser user = devUserService.doLogin(param);
        if(null != user){
            session.setAttribute(Constants.USER_SESSION, user);
            return "redirect:/devPage/main.action";
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
