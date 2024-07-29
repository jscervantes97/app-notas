package com.apps.notas.services;

import com.apps.notas.entity.DTO.NotaDTO;
import com.apps.notas.entity.Notas;
import com.apps.notas.entity.Usuarios;
import com.apps.notas.entity.repositorys.NotaRepository;
import com.apps.notas.entity.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    NotaRepository notaRepository ;

    @Autowired
    UsuarioRepository usuarioRepository ;

    public void crearNota(NotaDTO nota){
        Usuarios usuario = this.usuarioRepository.findById(nota.getIdUsuario()).orElseThrow();
        Notas notaNueva = new Notas();
        notaNueva.setUsuario(usuario);
        notaNueva.setTitulo(nota.getTitulo());
        notaNueva.setContenido(nota.getContenido());
        notaNueva.setEliminado(false);

        this.notaRepository.save(notaNueva);
    }

    public void actualizarNota(NotaDTO nota){
        Usuarios usuario = this.usuarioRepository.findById(nota.getIdUsuario()).orElseThrow();
        Notas notaNueva = this.notaRepository.findById(usuario.getIdUsuario()).orElseThrow();
        notaNueva.setTitulo(nota.getTitulo());
        notaNueva.setContenido(nota.getContenido());
        notaNueva.setEliminado(false);

        this.notaRepository.save(notaNueva);
    }

    public void eliminarNota(Integer idNota){
        Notas nota = this.notaRepository.findById(idNota).orElseThrow();
        this.notaRepository.delete(nota);
    }

    public Notas buscarNota(Integer idNota){
        return this.notaRepository.findById(idNota).orElseThrow();
    }

    public List<Notas> obtenerNotasPorUsuario(Integer idUsuario){
        Usuarios usuarios = this.usuarioRepository.findById(idUsuario).orElse(null);
        //System.out.println(usuarios.getNotas());
        return usuarios.getNotas();
    }

}
