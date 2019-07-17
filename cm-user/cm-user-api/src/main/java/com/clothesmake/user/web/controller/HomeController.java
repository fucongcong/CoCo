package com.clothesmake.user.web.controller;

import com.clothesmake.common.Result;
import com.clothesmake.user.api.UserService;
import com.clothesmake.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class HomeController {

    @Autowired
    protected UserService userService;

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public String index(@PathVariable Integer id) {
        return "hello world!";
    }

    @GetMapping(value = "/profile")
    public Result<Map> userinfo(HttpServletRequest request) {
        int id = (int) request.getAttribute("uid");
        if (id <= 0) {
            return Result.error(1001, "not login");
        }

        UserDto userDto =  userService.getUser(id);

        Map ret = new HashMap();
        ret.put("user", userDto);

        return Result.success(ret);
    }
}
