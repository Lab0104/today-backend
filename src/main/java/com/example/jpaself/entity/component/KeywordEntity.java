package com.example.jpaself.entity.component;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="KEYWORD")
public class KeywordEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "keyword_id", nullable = false)
    private long id;

    //Other columns
    @Column(length = 45, nullable = false, columnDefinition = "TEXT")
    private String Keyword;
}
