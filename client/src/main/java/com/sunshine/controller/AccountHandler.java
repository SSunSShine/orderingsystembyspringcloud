package com.sunshine.controller;

import com.sunshine.entity.Account;
import com.sunshine.entity.Admin;
import com.sunshine.entity.User;
import com.sunshine.feign.AccountFeign;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/account")
public class AccountHandler {
    @Autowired
    private AccountFeign accountFeign;


    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Account account = accountFeign.login(username,password,type);
        String target = null;
        if(account == null){
            target = "login";
        }else{
            switch (type){
                case "user":
                    User user = new User();
                    BeanUtils.copyProperties(account,user);
                    session.setAttribute("user",user);
                    target = "redirect:/account/redirect/index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    BeanUtils.copyProperties(account,admin);
                    session.setAttribute("admin",admin);
                    target = "main";
                    break;
            }
        }
        return target;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

}
