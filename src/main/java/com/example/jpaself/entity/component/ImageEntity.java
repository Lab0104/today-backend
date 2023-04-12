package com.example.jpaself.entity.component;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="IMAGE")
public class ImageEntity {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private long id;

    //Other columns
    @Column(nullable = false, columnDefinition = "TEXT")
    private String url;
}