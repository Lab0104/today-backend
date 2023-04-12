package com.example.jpaself.entity.component;

import com.example.jpaself.entity.mapping.HashtagMappingEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="HASHTAG")
public class HashtagEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hashtag_id", nullable = false)
    private long id;

    //Other columns
    @Column(name="hashtag", length = 45, nullable = true)
    private String tag;

    //slave
    @OneToOne(mappedBy = "hashtagMapping")
    private HashtagMappingEntity meetInfo;
}