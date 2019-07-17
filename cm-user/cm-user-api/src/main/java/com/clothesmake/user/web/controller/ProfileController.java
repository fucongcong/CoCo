package com.clothesmake.user.web.controller;

import com.clothesmake.common.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class ProfileController {
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public Result<String> index() {
        return Result.success("hello world");
    }
}   
