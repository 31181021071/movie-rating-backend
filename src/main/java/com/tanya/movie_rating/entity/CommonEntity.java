package com.tanya.movie_rating.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommonEntity {
    @Column(name = "valid_flag")
    private Boolean validFlag;

    @Column(name = "create_dt")
    private LocalDateTime createdAt;

    @Column(name = "create_by")
    private String createdBy;

    @Column(name = "update_dt")
    private LocalDateTime updatedAt;

    @Column(name = "update_by")
    private String updatedBy;

    @Column(name = "version")
    private Integer version; 
}
