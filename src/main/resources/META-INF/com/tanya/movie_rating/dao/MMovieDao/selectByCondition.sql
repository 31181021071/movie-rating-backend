select
	/*%expand*/*
from
	m_movie
where
	valid_flag = 1
/*%if condition.movieName != null && condition.movieName != ""*/
	and movie_name like '%'||/*condition.movieName*/'movie'||'%'
/*%end*/
/*%if condition.releaseDateFrom != null && condition.releaseDateFrom != ""*/
	and release_date >= /*condition.releaseDateFrom*/'2024-10-01'
/*%end*/
/*%if condition.releaseDateTo != null && condition.releaseDateTo != ""*/
	and release_date <= /*condition.releaseDateTo*/'2024-10-01'
/*%end*/
/*%if condition.country != null && !condition.country.isEmpty()*/
	and country in /*condition.country*/('1','2')
/*%end*/
/*%if condition.genre != null && !condition.genre.isEmpty()*/
	and (
    /*%for genre : condition.genre */
           ( genre like '%' || /*genre*/'dummy' || '%' )
       /*%if genre_has_next */
           /*# "OR" */
       /*%end */
    /*%end*/
      )
/*%end*/
/*%if condition.ratingFrom != null*/
	and rating >= /*condition.ratingFrom*/'5.6'
/*%end*/
/*%if condition.ratingTo != null*/
	and rating <= /*condition.ratingTo*/'5.6'
/*%end*/
/*%if condition.isShow != null && !condition.isShow.isEmpty()*/
	and is_show in /*condition.isShow*/('1','0')
/*%end*/
order by id