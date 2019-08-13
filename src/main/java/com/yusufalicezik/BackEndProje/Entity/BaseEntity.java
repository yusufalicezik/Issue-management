package com.yusufalicezik.BackEndProje.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter//annotation ekle, implements etmek gibi düşünülebilir. getter setter eklenmiş kabul ediliyor lombok ile.
@MappedSuperclass
public abstract class BaseEntity implements Serializable { //serializable
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "created_by", length = 100) //default 255
    private String createdBy;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by", length = 100) //default 255
    private String updatedBy;
    @Column(name = "status") //default 255
    private Boolean status; //kaydın aktif olup olmadığını anlamak için.


}
