package com.apps.notas.entity.DTO;

import com.apps.notas.entity.Notas;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UsuarioDTO {

    private Integer id ;

    private String nombre;

    private List<Notas> notas ;

}
