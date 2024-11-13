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
@Table(name = "t_movie_img")
public class TMovieImg extends CommonEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    private Integer id;

    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "img_byte")
    private byte[] imgByte;
}
