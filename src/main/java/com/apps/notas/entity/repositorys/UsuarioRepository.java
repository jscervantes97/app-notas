package com.apps.notas.entity.repositorys;

import com.apps.notas.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {


    Usuarios findByidUsuario(Integer idUsuario);
}
