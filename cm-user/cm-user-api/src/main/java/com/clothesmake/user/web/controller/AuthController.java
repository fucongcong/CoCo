package com.clothesmake.user.web.controller;

import com.clothesmake.common.Result;
import com.clothesmake.user.api.UserService;
import com.clothesmake.user.dto.UserDto;
import com.clothesmake.user.web.vm.UserVm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    protected UserService userService;

    @PostMapping(value = "/join")
    public Result<Map> join(@Valid @ModelAttribute UserVm userVm, HttpServletRequest request) {
        if (!checkPasswordLength(userVm.getPassword())) {
            return Result.error(1003, "密码格式错误");
        }

        Cookie[] cookies = request.getCookies();
        String sourceFrom = "";
        if (cookies != null) {
            for (Cookie cookie :cookies) {
                if (cookie.getName().equals("sourceFrom")) {
                    sourceFrom = cookie.getValue();
                }
            }
        }

        userVm.setSourceFrom(StringUtils.trim(sourceFrom));

        UserDto userDto = userService.registerUser(userVm, userVm.getPassword());

        Map ret = new HashMap();
        ret.put("user", userDto);

        return Result.success(ret);
    }

    private static boolean checkPasswordLength(String password) {
        return !StringUtils.isEmpty(password) &&
                password.length() >= UserVm.PASSWORD_MIN_LENGTH &&
                password.length() <= UserVm.PASSWORD_MAX_LENGTH;
    }
}
