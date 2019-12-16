package com.clothesmake.user.dao.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *  user
 * @author coco 2019-06-21
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name="user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * roles
     */
    private String roles;

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
     * 是否完善基础身形数据
     */
    private Integer baseBodyData;

    /**
     * 是否完善详细身形数据
     */
    private Integer bodyData;

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

    public UserEntity() {
    }

}