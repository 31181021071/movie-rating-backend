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
@Table(name = "t_movie_review_report")
public class TMovieReivewReport extends CommonEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    private Integer id;

    @Column(name = "movie_review_id")
    private Integer movieReviewId;
    
    @Column(name = "user_review_id")
    private Integer userReviewId;

    @Column(name = "user_report_id")
    private Integer userReportId;
}
