package com.example.jpaself.entity.mapping;

import com.example.jpaself.entity.BannerEntity;
import com.example.jpaself.entity.PostEntity;
import com.example.jpaself.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="ADVERTISEMENTS_MP")
public class AdvertisementEntity {
    //Id column
    @Id
    @Column(name = "advertisements_mp_id", length = 45, nullable = false)
    private String id;

    //Other columns
    @ManyToOne
    @JoinColumn(name= "post_id", nullable = false)
    private PostEntity advertisementPost;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private UserEntity userAdvertisement;

    //Slave
    @OneToOne(mappedBy = "bannerAdvertisement")
    private BannerEntity advertisementBanner;
}
