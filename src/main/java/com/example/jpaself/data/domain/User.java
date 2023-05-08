package com.example.jpaself.data.domain;

import com.example.jpaself.data.domain.mapping.*;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="USER")
public class User {
    //Id column
    @Id @GeneratedValue
    @Column(name = "user_id", length = 45)
    private Long id;

    //Other columns
    @Column(length = 45)
    @NotNull
    private String email;

    @Column(length = 45)
    @NotNull
    private String nickname;

    @Column(columnDefinition = "TEXT")
    @NotNull
    private String address;

    @Column(name = "address_latitude")
    private double addressLatitude;

    @Column(name = "address_longitude")
    private double addressLongitude;

    @Column
    @NotNull
    private float score;

    @Column(name = "login_method", length = 20)
    @NotNull
    private String loginMethod;

    @Column(name = "password_key", length = 45)
    @NotNull
    private String passwordKey;

    //slave
//    @OneToMany(mappedBy = "userProfile", orphanRemoval = true)
//    List<Profile> myProfile = new ArrayList<>(); //프로필 조회
//
//    @OneToMany(mappedBy = "userAlarm", orphanRemoval = true)
//    List<Alarm> myAlarm = new ArrayList<>(); //알람 조회
//
//    @OneToMany(mappedBy = "userAdvertisement")
//    List<Advertisement> myAdvertisement = new ArrayList<>(); //광고 조회
//
//    @OneToMany(mappedBy = "userInterests", orphanRemoval = true)
//    List<Interests> myInterests = new ArrayList<>(); //관심사 카테고리 조회
//
//    @OneToMany(mappedBy = "userLikes")
//    List<Likes> myLikes = new ArrayList<>(); //좋아요 조회
//
//    @OneToMany(mappedBy = "userHistory", orphanRemoval = true)
//    List<History> myHistory = new ArrayList<>(); //후기 내역 조회
//
//    @OneToMany(mappedBy = "userInfo", orphanRemoval = true)
//    List<Member> myMember = new ArrayList<>(); //참가중인 모임 조회

}