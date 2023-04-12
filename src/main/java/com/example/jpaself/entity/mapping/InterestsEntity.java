package com.example.jpaself.entity.mapping;

import com.example.jpaself.entity.UserEntity;
import com.example.jpaself.entity.component.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="INTERESTS_MP")
public class InterestsEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "interests_id", nullable = false)
    private long id;

    //Other columns
    @ManyToOne
    @JoinColumn(name="category_id", nullable = true)
    private CategoryEntity interestCategory;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userInterests;

    //Slave

}