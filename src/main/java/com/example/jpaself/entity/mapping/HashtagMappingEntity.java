package com.example.jpaself.entity.mapping;

import com.example.jpaself.entity.MeetEntity;
import com.example.jpaself.entity.component.HashtagEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="MEET_HASHTAG_MP")
public class HashtagMappingEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meet_hashtag_mp_id", nullable = false)
    private int id;

    //Other columns
    @ManyToOne
    @JoinColumn(name = "meet_id", nullable = false)
    private MeetEntity meetMapping;

    @OneToOne
    @JoinColumn(name = "hashtag_id", nullable = false)
    private HashtagEntity hashtagMapping;
}