package com.example.jpaself.data.domain.state;

import com.example.jpaself.data.domain.Banner;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="BANNER_TYPE")
public class BannerType {
    //Id column
    @Id @GeneratedValue
    @Column(name = "banner_type_id")
    private long id;

    //Other columns
    @Column(length = 45)
    @NotNull
    private String type;

    //Slave
    @OneToMany(mappedBy = "setBannerType")
    List<Banner> bannerList = new ArrayList<>();
}
