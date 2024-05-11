package com.talenthub.marketing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "possibleclient")
public class Possibleclient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "phonecontact")
    private Integer phonecontact;

    @Column(name = "menssage")
    private String menssage;

    @Column(name = "marketingstatusid", nullable = false)
    private Integer marketingstatusid;

}
