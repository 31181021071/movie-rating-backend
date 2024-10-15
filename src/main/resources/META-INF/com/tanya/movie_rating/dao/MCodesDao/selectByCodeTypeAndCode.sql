select
	/*%expand*/*
from
	m_codes
where
	code_type = /*codeType*/'0000000001'
	and code = /*code*/'001'
	and valid_flag = 1