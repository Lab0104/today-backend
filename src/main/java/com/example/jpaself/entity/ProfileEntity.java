package com.example.jpaself.entity;

import com.example.jpaself.entity.component.ImageEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="PROFILE")
public class ProfileEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id", nullable = false)
    private long id;

    //Other columns
    @OneToOne
    @JoinColumn(name="background_image_id")
    private ImageEntity backImage; //백그라운드 이미지

    @OneToOne
    @JoinColumn(name="profile_image_id")
    private ImageEntity profileImage; //프로필 이미지

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userProfile;
}