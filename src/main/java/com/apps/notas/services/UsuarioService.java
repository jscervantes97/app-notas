package com.apps.notas.services;

import com.apps.notas.entity.DTO.UsuarioDTO;
import com.apps.notas.entity.Usuarios;
import com.apps.notas.entity.repositorys.NotaRepository;
import com.apps.notas.entity.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void crearUsuario(UsuarioDTO usuarioDTO){

        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setNombre(usuarioDTO.getNombre());
        nuevoUsuario.setActivo(Boolean.TRUE);

        this.usuarioRepository.save(nuevoUsuario);

    }

    public List<Usuarios> obtenerTodosLosUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public UsuarioDTO obtenerUsuarioPorId(Integer idUsuario){
        Usuarios usuario = this.usuarioRepository.findById(idUsuario).orElseThrow();
        return UsuarioDTO.builder()
                .id(usuario.getIdUsuario())
                .nombre(usuario.getNombre())
                .notas(usuario.getNotas())
                .build();
    }

    public void actualizarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        //Usuarios usuario = this.usuarioRepository.findByidUsuario(usuarioDTO.getId());
        Usuarios usuario = this.usuarioRepository.findById(usuarioDTO.getId()).orElse(null);
        if (usuario == null){
            throw new Exception("Usuario No encontrado");
        }else{
            usuario.setNombre(usuarioDTO.getNombre());
            this.usuarioRepository.save(usuario);
        }
    }

}
