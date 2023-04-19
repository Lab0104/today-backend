package com.example.jpaself.data.domain.mapping;

import com.example.jpaself.data.domain.Banner;
import com.example.jpaself.data.domain.Post;
import com.example.jpaself.data.domain.User;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="ADVERTISEMENTS_MP")
public class Advertisement {
    //Id column
    @Id
    @Column(name = "advertisements_mp_id", length = 45)
    private String id;

    //Other columns
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name= "post_id")
    @NotNull
    private Post advertisementPost;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name="user_id")
    @NotNull
    private User userAdvertisement;

    //Slave
    @OneToOne(mappedBy = "bannerAdvertisement")
    private Banner advertisementBanner;
}
