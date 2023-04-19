package com.example.jpaself.data.domain.component;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="IMAGE")
public class Image {
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long id;

    //Other columns
    @Column(columnDefinition = "TEXT")
    @NotNull
    private String url;
}