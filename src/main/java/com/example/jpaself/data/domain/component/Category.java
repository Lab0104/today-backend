package com.example.jpaself.data.domain.component;

import com.example.jpaself.data.domain.Meet;
import com.example.jpaself.data.domain.mapping.Interests;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="CATEGORY")
public class Category {
    //Id column
    @Id @GeneratedValue
    @Column(name = "category_id")
    private long id;

    //Other columns
    @Column(name = "category_name", length = 20)
    @NotNull
    private String name;

    @Column
    private int depth;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image categoryImage;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="top_category_id")
    private Category topCategory; //자기참조

    //slave
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topCategory", orphanRemoval = true)
    List<Category> topCategoryId = new ArrayList<>(); //자기참조

    @OneToMany(mappedBy = "meetCategory")
    List<Meet> meetList = new ArrayList<>(); //meet 정보 검색

    @OneToMany(mappedBy = "interestCategory")
    List<Interests> userList = new ArrayList<>();

}