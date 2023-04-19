package com.example.jpaself.data.domain.component;

import com.example.jpaself.data.domain.mapping.HashtagMapping;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="HASHTAG")
public class Hashtag {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_id")
    private long id;

    //Other columns
    @Column(name="hashtag", length = 45)
    @NotNull
    private String tag;

    //slave
    @OneToOne(mappedBy = "hashtagMapping")
    private HashtagMapping meetInfo;
}