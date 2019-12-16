package com.clothesmake.user.web.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.clothesmake.auth.Jwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(ApiInterceptor.class);

    private Environment env;

    public ApiInterceptor(Environment env) {
        this.env = env;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        String token = "";
        if (cookies != null) {
            for (Cookie cookie :cookies) {
                if (cookie.getName().toLowerCase().equals("jwt")) {
                    token = cookie.getValue();
                }
            }
        }

        if (token.isEmpty()) {
            token = request.getHeader("jwt");
        }

        log.debug("get the Jwt token : "+token);

        String secret = env.getProperty("jwt.secret");
        DecodedJWT jwt = Jwt.parseToken(token, secret);
        if (jwt != null) {
            Claim claim = Jwt.getClaim(jwt, "uid");
            request.setAttribute("uid", Integer.valueOf(claim.asString()));
        } else {
            request.setAttribute("uid", 0);
        }

        return true;
    }
}
