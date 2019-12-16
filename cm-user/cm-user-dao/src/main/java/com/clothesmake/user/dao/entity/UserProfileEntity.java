package com.clothesmake.user.dao.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name="user_profile")
public class UserProfileEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public UserProfileEntity() {
    }

}