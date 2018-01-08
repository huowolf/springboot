package com.huowolf.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by huowolf on 2018/1/6.
 */
@Entity
@Table(name = "t_user")
@Data
@DynamicInsert
@DynamicUpdate
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String email;

    private String userName;

    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    private short userType;

    private String preferLanguage;

    private int accepted;

    private int submitted;

    private String bio;

    private boolean sendCode;
}
