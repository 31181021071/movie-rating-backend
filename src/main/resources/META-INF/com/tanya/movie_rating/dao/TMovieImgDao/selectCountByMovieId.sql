select
	count(id)
from
	t_movie_review
where
	movie_id = /*movieId*/1
	and
	valid_flag = 1
order by id