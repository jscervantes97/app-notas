package com.apps.notas.controllers;

import com.apps.notas.entity.DTO.NotaDTO;
import com.apps.notas.entity.DTO.ResponseDTO;
import com.apps.notas.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    private NotaService notaService;

    @GetMapping("/usuario/{idUsuario}")
    public ResponseDTO obtenerNotasPorUsuario(@PathVariable Integer idUsuario){
        return new ResponseDTO("Notas Encontradas", this.notaService.obtenerNotasPorUsuario(idUsuario));
    }

    @GetMapping("/{idNota}")
    public ResponseDTO obtenerNotasPorIdNota(@PathVariable Integer idNota){
        return new ResponseDTO("Notas Encontradas", this.notaService.buscarNota(idNota));
    }
    @PostMapping("/")
    public ResponseDTO crearNota(@RequestBody NotaDTO notaDTO){
        this.notaService.crearNota(notaDTO);
        return new ResponseDTO("Nota Creada", null);
    }

    @PutMapping("/")
    public ResponseDTO actualizarNota(@RequestBody NotaDTO notaDTO){
        this.notaService.actualizarNota(notaDTO);
        return new ResponseDTO("Nota Actualizada", null);
    }

    @DeleteMapping("/{idNota}")
    public ResponseDTO eliminarNota(@PathVariable Integer idNota){
        this.notaService.eliminarNota(idNota);
        return new ResponseDTO("Nota Eliminada", null);
    }





}
