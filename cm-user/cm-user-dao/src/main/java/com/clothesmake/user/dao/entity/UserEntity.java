package com.clothesmake.user.dao.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 *  user
 * @author coco 2019-06-21
 */
@Entity
@Data
@Table(name="user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * id
     */
    private Integer id;

    /**
     * nickname
     */
    private String nickname;

    /**
     * 手机
     */
    private String mobile;

    /**
     * email
     */
    private String email;

    /**
     * password
     */
    @JsonIgnore
    private String password;

    /**
     * customeruser
     */
    private String roles;

    /**
     * 最后登录时间
     */
    private Integer logintime;

    /**
     * 最后登录ip
     */
    private String loginip;

    /**
     * 创建时间
     */
    private Integer createtime;

    /**
     * 注册ip
     */
    private String createip;

    /**
     * 小头像
     */
    private String smallavatar;

    /**
     * 中头像
     */
    private String mediumavatar;

    /**
     * 大头像
     */
    private String bigavatar;

    /**
     * 是否完善基础身形数据
     */
    private Integer basebodydata;

    /**
     * 是否完善详细身形数据
     */
    private Integer bodydata;

    /**
     * isperfectinfo
     */
    private Integer isperfectinfo;

    /**
     * 邀请人id
     */
    private Integer inviter;

    /**
     * 邀请码
     */
    private String invitecode;

    /**
     * 来源网址
     */
    private String sourcefrom;

    /**
     * sourcefromhost
     */
    private String sourcefromhost;

    /**
     * 设备
     */
    private String sourcefromdevice;

    public UserEntity() {
    }

}