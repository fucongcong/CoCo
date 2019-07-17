package com.clothesmake.user.web.controller;

import com.clothesmake.user.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class HomeController {

    @Autowired
    protected UserService userService;

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public String index(@PathVariable Integer id) {
        return "hello world!";
    }

//    @GetMapping(value = "/profile")
//    public Result<Map> userinfo(HttpServletRequest request) {
//        int id = (int) request.getAttribute("uid");
//        if (id <= 0) {
//            return Result.error(1001, "not login");
//        }
//
//        UserDto userDto =  userService.getUser(id);
//
//        Map ret = new HashMap();
//        ret.put("user", userDto);
//
//        return Result.success(ret);
//    }
}
