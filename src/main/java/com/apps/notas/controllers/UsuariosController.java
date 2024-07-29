package com.apps.notas.controllers;

import com.apps.notas.entity.DTO.ResponseDTO;
import com.apps.notas.entity.DTO.UsuarioDTO;
import com.apps.notas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseDTO getAllUsuarios(){
        return new ResponseDTO("Usuarios Encontrados" , this.usuarioService.obtenerTodosLosUsuarios());
    }

    @GetMapping("/{idUsuario}")
    public ResponseDTO obtenerUsuarioPorId(@PathVariable Integer idUsuario){
        return new ResponseDTO("Usuarios Encontrados" , this.usuarioService.obtenerUsuarioPorId(idUsuario));
    }

    @PostMapping("/")
    public ResponseDTO crearUsuario(@RequestBody UsuarioDTO usuarioNuevo){
        this.usuarioService.crearUsuario(usuarioNuevo);
        return new ResponseDTO("Usuarios Creado" , null);
    }

    @PutMapping("/")
    public ResponseDTO actualizarUsuario(@RequestBody UsuarioDTO usuario) throws Exception {
        this.usuarioService.actualizarUsuario(usuario);
        return new ResponseDTO("Usuario Actualizado" , null);
    }


}
