package com.clothesmake.user.web.controller;

import com.clothesmake.common.Result;
import com.clothesmake.user.api.UserProfileService;
import com.clothesmake.user.api.UserService;
import com.clothesmake.user.dto.UserDto;
import com.clothesmake.user.dto.UserProfileDto;
import com.clothesmake.util.MapBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class ProfileController {
    @Autowired
    protected UserService userService;

    @Autowired
    protected UserProfileService userProfileService;

    @GetMapping(value = "/profile")
    public Result<Map> userinfo(HttpServletRequest request) {
        //int id = (int) request.getAttribute("uid");
        int id = 25;
        if (id <= 0) {
            return Result.error(1001, "not login");
        }

        UserDto userDto =  userService.getUser(id);
        UserProfileDto userProfileDto = userProfileService.getUserProfile(id);

        Map ret = new HashMap();
        ret.putAll(MapBeanUtil.object2Map(userDto));
        ret.putAll(MapBeanUtil.object2Map(userProfileDto));

        return Result.success(ret);
    }
}   
