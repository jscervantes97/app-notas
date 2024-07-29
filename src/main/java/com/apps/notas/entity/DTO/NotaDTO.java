package com.apps.notas.entity.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotaDTO {

    private Integer idUsuario ;

    private Integer idNota ;

    private String titulo ;

    private String contenido ;

}
