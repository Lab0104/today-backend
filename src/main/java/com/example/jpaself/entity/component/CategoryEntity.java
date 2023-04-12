package com.example.jpaself.entity.component;

import com.example.jpaself.entity.MeetEntity;
import com.example.jpaself.entity.mapping.InterestsEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="CATEGORY")
public class CategoryEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", nullable = false)
    private long id;

    //Other columns
    @Column(name = "category_name", length = 20, nullable = false)
    private String name;

    @Column
    private int depth;

    @OneToOne
    @JoinColumn(name = "image_id")
    private ImageEntity categoryImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="top_category_id")
    private CategoryEntity topCategory; //자기참조

    //slave
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topCategory")
    List<CategoryEntity> topCategoryId = new ArrayList<>(); //자기참조

    @OneToMany(mappedBy = "meetCategory")
    List<MeetEntity> meetList = new ArrayList<>(); //meet 정보 검색

    @OneToMany(mappedBy = "interestCategory")
    List<InterestsEntity> userList = new ArrayList<>();

}