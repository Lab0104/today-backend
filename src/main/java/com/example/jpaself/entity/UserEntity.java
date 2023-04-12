package com.example.jpaself.entity;

import com.example.jpaself.entity.mapping.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="USER")
public class UserEntity {
    //Id column
    @Id
    @Column(name = "user_id", length = 45)
    private String id;

    //Other columns
    @Column(length = 45, nullable = false) private String email;
    @Column(length = 45, nullable = false) private String nickname;
    @Column(nullable = true, columnDefinition = "TEXT") private String address;
    @Column(name = "address_latitude", nullable = true) private double addressLatitude;
    @Column(name = "address_longitude", nullable = true) private double addressLongitude;
    @Column(nullable = false) private float score;
    @Column(name = "login_method", length = 20, nullable = false) private String loginMethod;
    @Column(name = "password_key", length = 45, nullable = false) private String passwordKey;

    //slave
    @OneToMany(mappedBy = "userProfile") List<ProfileEntity> myProfile = new ArrayList<>(); //프로필 조회
    @OneToMany(mappedBy = "userAlarm") List<AlarmEntity> myAlarm = new ArrayList<>(); //알람 조회
    @OneToMany(mappedBy = "userAdvertisement") List<AdvertisementEntity> myAdvertisement = new ArrayList<>(); //광고 조회
    @OneToMany(mappedBy = "userMeet") List<MeetEntity> myMeet = new ArrayList<>(); //게시글 조회
    @OneToMany(mappedBy = "userInterests") List<InterestsEntity> myInterests = new ArrayList<>(); //관심사 카테고리 조회
    @OneToMany(mappedBy = "userLikes") List<LikesEntity> myLikes = new ArrayList<>(); //좋아요 조회
    @OneToMany(mappedBy = "userHistory") List<HistoryEntity> myHistory = new ArrayList<>(); //후기 내역 조회
    @OneToMany(mappedBy = "userInfo") List<MemberEntity> myMember = new ArrayList<>(); //참가중인 모임 조회

}