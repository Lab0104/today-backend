package com.example.jpaself.domain.mapping;

import com.example.jpaself.domain.Meet;
import com.example.jpaself.domain.component.Hashtag;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="MEET_HASHTAG_MP")
public class HashtagMapping {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meet_hashtag_mp_id")
    private long id;

    //Other columns
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "meet_id")
    @NotNull
    private Meet meetMapping;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true) //orphanRemoval hashtag가 삭제되는지 주의 요망
    @JoinColumn(name = "hashtag_id")
    @NotNull
    private Hashtag hashtagMapping;
}