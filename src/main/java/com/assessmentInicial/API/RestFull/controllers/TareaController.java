package com.assessmentInicial.API.RestFull.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessmentInicial.API.RestFull.models.TareaModel;
import com.assessmentInicial.API.RestFull.models.UsuarioModel;
import com.assessmentInicial.API.RestFull.services.TareaService;

@RestController
@RequestMapping("/tareas")
public class TareaController {
    @Autowired
    TareaService tareaService;

    @GetMapping()
    public ArrayList<TareaModel> obtenerTareas(){
        return tareaService.obtenerTareas();
    }

    @GetMapping(path = "/{id}")
    public Optional<TareaModel> obtenerTareaPorId(@PathVariable("id") Long id){
        return this.tareaService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<TareaModel> obtenerTareaPorEstado(@RequestParam("estado") Integer estado){
        return this.tareaService.obtenerPorEstado(estado);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.tareaService.eliminarTarea(id);
        if (ok) {
            return "Se eliminó la tarea con id " + id;
        }else{
            return "No se pudo eliminar la tarea con id " + id;
        }
    }

    @PostMapping()
    public TareaModel guardarTarea(@RequestBody TareaModel tarea){
        return this.tareaService.guardarTarea(tarea);
    }
}
