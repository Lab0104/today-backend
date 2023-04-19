package com.example.jpaself.domain.component;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="KEYWORD")
public class Keyword {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private long id;

    //Other columns
    @Column(length = 45, columnDefinition = "TEXT")
    @NotNull
    private String Keyword;
}
