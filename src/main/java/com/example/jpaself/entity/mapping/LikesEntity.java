package com.example.jpaself.entity.mapping;

import com.example.jpaself.entity.MeetEntity;
import com.example.jpaself.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="LIKES_MP")
public class LikesEntity {
    //Id column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "likes_id", nullable = false)
    private long id;

    //Other columns
    @OneToOne
    @JoinColumn(name="meet_id", nullable = false)
    private MeetEntity likesMeet;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private UserEntity userLikes;

    //Slave
}