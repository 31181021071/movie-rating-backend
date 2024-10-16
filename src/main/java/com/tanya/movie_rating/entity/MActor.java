package com.tanya.movie_rating.entity;

import java.time.LocalDate;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "m_actor")
public class MActor extends CommonEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private byte[] image;

}
