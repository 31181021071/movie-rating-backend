package com.tanya.movie_rating.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MUser extends CommonEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "pwd")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "is_enable")
    private Boolean isEnabled;

}
