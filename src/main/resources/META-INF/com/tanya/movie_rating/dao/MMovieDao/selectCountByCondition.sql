select
	count(id)
from
	m_movie
where
	valid_flag = 1
/*%if condition.movieName != null && condition.movieName != ""*/
	and movie_name like CONCAT('%', /*condition.movieName*/'movie', '%')
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
           ( genre like CONCAT('%', /*genre*/'1', '%') )
       /*%if genre_has_next */
           /*# "OR" */
       /*%end */
    /*%end*/
      )
/*%end*/
/*%if condition.director != null && !condition.director.isEmpty()*/
	and (
    /*%for director : condition.director */
           ( director like CONCAT('%', /*director*/'1', '%') )
       /*%if director_has_next */
           /*# "OR" */
       /*%end */
    /*%end*/
      )
/*%end*/
/*%if condition.actor != null && !condition.actor.isEmpty()*/
	and (
    /*%for actor : condition.actor */
           ( actor like CONCAT('%', /*actor*/'1', '%') )
       /*%if actor_has_next */
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
	and is_show in /*condition.isShow*/('1','2')
/*%end*/
order by id