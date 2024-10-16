select
	/*%expand*/*
from
	m_actor
where
	valid_flag = 1
/*%if condition.name != null && condition.name != ""*/
	and name like CONCAT('%', /*condition.name*/'director', '%')
/*%end*/
/*%if condition.birthFrom != null && condition.birthFrom != ""*/
	and birth >= /*condition.birthFrom*/'2024-10-01'
/*%end*/
/*%if condition.birthTo != null && condition.birthTo != ""*/
	and birth <= /*condition.birthTo*/'2024-10-01'
/*%end*/
/*%if condition.country != null && !condition.country.isEmpty()*/
	and country in /*condition.country*/('1','2')
/*%end*/
order by id