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
@Table(name="HISTORY")
public class History {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private long id;

    //Other columns
    @Column
    private float score;

    @Column(columnDefinition = "TEXT")
    private String review;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "meet_id")
    @NotNull
    private Meet meetInfo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @NotNull
    private User userHistory;

}