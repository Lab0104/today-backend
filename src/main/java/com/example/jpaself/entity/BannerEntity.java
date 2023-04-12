package com.example.jpaself.entity;

import com.example.jpaself.entity.component.ImageEntity;
import com.example.jpaself.entity.mapping.AdvertisementEntity;
import com.example.jpaself.entity.state.BannerTypeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="BANNER")
public class BannerEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "banner_id", nullable = false)
    private long id;

    //Other columns
    @Column(name = "display_period", length = 6)
    private LocalDateTime displayPeriod;

    @Column(length = 45)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String contents;

    @OneToOne
    @JoinColumn(name = "image_id")
    private ImageEntity bannerImage;

    @ManyToOne
    @JoinColumn(name = "banner_type_id", nullable = false)
    private BannerTypeEntity setBannerType;

    @OneToOne
    @JoinColumn(name = "advertisements_mp_id")
    private AdvertisementEntity bannerAdvertisement;

    //Slave

}