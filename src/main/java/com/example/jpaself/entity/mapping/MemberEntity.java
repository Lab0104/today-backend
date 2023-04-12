package com.example.jpaself.entity.mapping;

import com.example.jpaself.entity.MeetEntity;
import com.example.jpaself.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="MEMBER_MP")
public class MemberEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", nullable = false)
    private long id;

    //Other columns
    @ManyToOne
    @JoinColumn(name = "meet_id", nullable = false)
    private MeetEntity meetMember;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userInfo;
}
