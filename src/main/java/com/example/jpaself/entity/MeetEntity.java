package com.example.jpaself.entity;

import com.example.jpaself.entity.component.CategoryEntity;
import com.example.jpaself.entity.mapping.HashtagMappingEntity;
import com.example.jpaself.entity.mapping.LikesEntity;
import com.example.jpaself.entity.mapping.MemberEntity;
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
public class MeetEntity {
    //Id column
    @Id
    @Column(name = "meet_id", length = 45, nullable = false)
    private String id;

    //Other columns
    @Column(length = 6, nullable = false) private LocalDateTime date;
    @Column(length = 6, nullable = false) private LocalDateTime deadline;
    @Column(name = "maximum_participants", nullable = false) private int maximum;
    @Column(name = "registered_participants_count", nullable = false) private int registeredCount;
    @Column(nullable = false, columnDefinition = "TEXT") private String address;
    @Column(name = "address_latitude", nullable = true) private double addressLatitude;
    @Column(name = "address_longitude", nullable = true) private double addressLongitude;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    private CategoryEntity meetCategory;

    @OneToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity meetPost;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userMeet;

    //Slave
    @OneToMany(mappedBy = "meetMapping")
    List<HashtagMappingEntity> hashtagList = new ArrayList<>();

    @OneToOne(mappedBy = "likesMeet")
    private LikesEntity checkLikes;

    @OneToMany(mappedBy = "meetMember")
    List<MemberEntity> memberList = new ArrayList<>();
}