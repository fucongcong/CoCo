package com.clothesmake.user.qualifier;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Named("UserTrans")
public class UserTrans {

    @Named("rolesToList")
    public List<String> rolesToList(String roles) {
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, String.class);
        try {
            List<String> configList =  mapper.readValue(roles, javaType);
            return configList;
        } catch (IOException e) {
            return null;
        }
    }

    @Named("avatarUrl")
    public String avatarUrl(String avatar) {
        return "http://xxxxx:"+avatar;
    }
}
