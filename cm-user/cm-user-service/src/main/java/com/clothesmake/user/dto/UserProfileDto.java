package com.clothesmake.user.dto;

import lombok.Data;

@Data
public class UserProfileDto {

    private Integer id;

    /**
     * birthday
     */
    private String birthday;

    /**
     * country
     */
    private String country;

    /**
     * 州
     */
    private String states;

    /**
     * zipCode
     */
    private Integer zipCode;

    /**
     * street
     */
    private String street;

    /**
     * street2
     */
    private String street2;

    /**
     * profession
     */
    private String profession;

    /**
     * industry
     */
    private String industry;

    /**
     * company
     */
    private String company;

    /**
     * city
     */
    private String city;

    /**
     * degree
     */
    private String degree;

    /**
     * school
     */
    private String school;

    /**
     * 真实姓名
     */
    private String truename;

    /**
     * gender
     */
    private String gender;

    /**
     * introduction
     */
    private String introduction;
}
