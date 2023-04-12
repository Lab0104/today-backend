package com.example.jpaself.entity;

import com.example.jpaself.entity.mapping.AdvertisementEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="POST")
public class PostEntity {
    //Id column
    @Id
    @Column(name = "post_id",length = 45, nullable = false)
    private long id;

    //Other columns
    @Column(columnDefinition = "TEXT", nullable = false)
    private String title;

    @Column(name = "sub_title", length = 45)
    private String subTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "hits_count", nullable = false)
    private long hitsCount;

    @Column(name = "date_created", length = 6, nullable = false)
    private LocalDateTime dateCreate;

    //Slave
    @OneToMany(mappedBy = "advertisementPost")
    List<AdvertisementEntity> postAdvertisement = new ArrayList<>();

    @OneToOne(mappedBy = "meetPost")
    private MeetEntity meetInfo;


}