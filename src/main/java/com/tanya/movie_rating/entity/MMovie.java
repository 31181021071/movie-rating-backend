package com.tanya.movie_rating.entity;

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
@Table(name = "m_movie")
public class MMovie extends CommonEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    private Integer id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "country")
    private String country;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "genre")
    private String genre;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "rating")
    private double rating;

    @Column(name = "is_show")
    private Boolean isShow;
}
