package com.example.jpaself.entity.mapping;

import com.example.jpaself.entity.MeetEntity;
import com.example.jpaself.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="HISTORY")
public class HistoryEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "history_id", nullable = false)
    private long id;

    //Other columns
    @Column(nullable = true)
    private float score;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String review;

    @OneToOne
    @JoinColumn(name = "meet_id", nullable = false)
    private MeetEntity meetInfo;

    @ManyToOne
    @JoinColumn(name="host_user_id", nullable = false)
    private MeetEntity hostUser;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userHistory;

}