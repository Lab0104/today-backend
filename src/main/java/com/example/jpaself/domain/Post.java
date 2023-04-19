package com.example.jpaself.domain;

import com.example.jpaself.domain.mapping.Advertisement;
import com.sun.istack.NotNull;
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
public class Post {
    //Id column
    @Id
    @Column(name = "post_id",length = 45)
    private String id;

    //Other columns
    @Column(columnDefinition = "TEXT")
    @NotNull
    private String title;

    @Column(name = "sub_title", length = 45)
    @NotNull
    private String subTitle;

    @Column(columnDefinition = "TEXT")
    @NotNull
    private String content;

    @Column(name = "hits_count")
    private long hitsCount;

    @Column(name = "date_created", length = 6)
    @NotNull
    private LocalDateTime dateCreate;

    //Slave
    @OneToMany(mappedBy = "advertisementPost")
    List<Advertisement> postAdvertisement = new ArrayList<>();

    @OneToOne(mappedBy = "meetPost", orphanRemoval = true)
    private Meet meetInfo;


}