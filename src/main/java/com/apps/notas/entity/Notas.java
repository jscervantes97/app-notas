package com.apps.notas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNota ;

    private String titulo ;

    private String contenido ;

    private boolean eliminado ;

    @ManyToOne()
    @JoinColumn(name = "usuario_nota", referencedColumnName = "idUsuario")
    private Usuarios usuario;

}
