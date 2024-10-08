package com.tanya.movie_rating.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "m_codes")
public class MCodes extends CommonEntity {

	@Id
    @Column(name = "code_type")
    private String codeType;

    @Column(name = "code_type_name")
    private String codeTypeName;

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "code_name")
    private String codeName;
}
