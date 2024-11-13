package com.tanya.movie_rating.entity;

import java.math.BigDecimal;

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
@Table(name = "t_movie_review")
public class TMovieReview extends CommonEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    private Integer id;

    @Column(name = "movie_id")
    private Integer movieId;
    
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "review")
    private String review;

    @Column(name = "rating")
    private BigDecimal rating;
}
