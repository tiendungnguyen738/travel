package com.khang.controller;

import com.khang.entity.Register;
import com.khang.entity.Role;
import com.khang.model.request.UserRequest;
import com.khang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController{
    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping(value="/home/{id}")
    public ModelAndView home(@PathVariable long id){
        ModelAndView md = new ModelAndView();
        List<Role> names = new ArrayList<Role>();

        Role role = new Role(1,"dung","admin");
        Role role1 = new Role(2,"tien","user");

        names.add(role);
        names.add(role1);

        md.addObject("model",names);

        return md;

    }
    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String homePost(@ModelAttribute(name="register")Register register){
        String targetUrl = "";
       /* User user = userService.findUserByUserNameAndPassword(register.getUsername(),register.getPassword());
        for(Role role : user.getRoles()){
            if("ADMIN".equals(role.getName())){
                targetUrl = "redirect:/admin/home";
                break;
            }else if("USER".equals(role.getName())){
                targetUrl="redirect:/home";
                break;
            }
        }*/
        return targetUrl;
    }


   /* @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage(){
        ModelAndView mav = new ModelAndView("home");

        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("sondx");
        userRequest.setPassword("123456");
        List<Long> roles = new ArrayList<>();
        roles.add(1L);
        roles.add(2L);

        userRequest.setIds(roles);

        userService.insert(userRequest);

        return mav;
    }*/

}