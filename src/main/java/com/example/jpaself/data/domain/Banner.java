package com.example.jpaself.data.domain;

import com.example.jpaself.data.domain.state.BannerType;
import com.example.jpaself.data.domain.component.Image;
import com.example.jpaself.data.domain.mapping.Advertisement;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="BANNER")
public class Banner {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banner_id")
    private long id;

    //Other columns
    @Column(name = "display_period", length = 6)
    private LocalDateTime displayPeriod;

    @Column(length = 45)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String contents;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image bannerImage;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "banner_type_id")
    @NotNull
    private BannerType setBannerType;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "advertisements_mp_id")
    private Advertisement bannerAdvertisement;

}