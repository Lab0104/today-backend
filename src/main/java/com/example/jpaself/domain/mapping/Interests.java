package com.example.jpaself.domain.mapping;

import com.example.jpaself.domain.User;
import com.example.jpaself.domain.component.Category;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="INTERESTS_MP")
public class Interests {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interests_id")
    private long id;

    //Other columns
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="category_id")
    @NotNull
    private Category interestCategory;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    @NotNull
    private User userInterests;
}