package com.example.jpaself.entity.state;

import com.example.jpaself.entity.BannerEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="BANNER_TYPE")
public class BannerTypeEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "banner_type_id", nullable = false)
    private long id;

    //Other columns
    @Column(length = 45, nullable = false)
    private String type;

    //Slave
    @OneToMany(mappedBy = "setBannerType")
    List<BannerEntity> bannerList = new ArrayList<>();
}
