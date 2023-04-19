package com.example.jpaself.domain;

import com.example.jpaself.domain.component.Category;
import com.example.jpaself.domain.mapping.HashtagMapping;
import com.example.jpaself.domain.mapping.Likes;
import com.example.jpaself.domain.mapping.Member;
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
@Table(name="MEET")
public class Meet {
    //Id column
    @Id
    @Column(name = "meet_id", length = 45)
    private String id;

    //Other columns
    @Column(length = 6)
    @NotNull
    private LocalDateTime date;

    @Column(length = 6)
    @NotNull
    private LocalDateTime deadline;

    @Column(name = "maximum_participants")
    private int maximum;

    @Column(name = "registered_participants_count")
    @NotNull
    private int registeredCount;

    @Column(columnDefinition = "TEXT")
    @NotNull
    private String address;

    @Column(name = "address_latitude")
    private double addressLatitude;

    @Column(name = "address_longitude")
    private double addressLongitude;

    @Column(name = "user_id")
    @NotNull
    private String hostUser;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name="category_id")
    @NotNull
    private Category meetCategory;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "post_id")
    @NotNull
    private Post meetPost;

    //Slave
    @OneToMany(mappedBy = "meetMapping", orphanRemoval = true)
    List<HashtagMapping> hashtagList = new ArrayList<>();

    @OneToOne(mappedBy = "likesMeet", orphanRemoval = true)
    private Likes likesState;

    @OneToMany(mappedBy = "meetMember", orphanRemoval = true)
    List<Member> memberList = new ArrayList<>();
}