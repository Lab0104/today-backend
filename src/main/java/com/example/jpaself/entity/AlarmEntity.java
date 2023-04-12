package com.example.jpaself.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="ALARM")
public class AlarmEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "alarm_id", nullable = false)
    private long id;

    //Other columns
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userAlarm;
}