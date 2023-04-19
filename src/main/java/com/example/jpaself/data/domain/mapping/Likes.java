package com.example.jpaself.data.domain.mapping;

import com.example.jpaself.data.domain.Meet;
import com.example.jpaself.data.domain.User;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="LIKES_MP")
public class Likes {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likes_id")
    private long id;

    //Other columns
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="meet_id")
    @NotNull
    private Meet likesMeet;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    @NotNull
    private User userLikes;
}