package com.clothesmake.user.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class UserDto {

    private Integer id;

    /**
     * nickname
     */
    @Size(min = 2, max = 18)
    private String nickname;

    /**
     * 手机
     */
    @NotEmpty
    @Pattern(regexp="^1\\d{10}$", message="手机格式错误")
    private String mobile;

    /**
     * email
     */
    @Email
    private String email;

    /**
     * customeruser
     */
    private List<String> roles;

    /**
     * 最后登录时间
     */
    private Integer loginTime;

    /**
     * 最后登录ip
     */
    private String loginIp;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 注册ip
     */
    private String createIp;

    /**
     * 小头像
     */
    private String smallAvatar;

    /**
     * 中头像
     */
    private String mediumAvatar;

    /**
     * 大头像
     */
    private String bigAvatar;

    /**
     * isPerfectInfo
     */
    private Integer isPerfectInfo;

    /**
     * 邀请人id
     */
    private Integer inviter = 0;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 来源网址
     */
    private String sourceFrom ;

    /**
     * sourceFromHost
     */
    private String sourceFromHost;

    /**
     * 设备
     */
    private String sourceFromDevice;
}
