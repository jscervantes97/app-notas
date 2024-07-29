package com.apps.notas.entity.repositorys;

import com.apps.notas.entity.Notas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<Notas, Integer> {



}
