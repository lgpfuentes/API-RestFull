package com.assessmentInicial.API.RestFull.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessmentInicial.API.RestFull.models.TareaModel;
import com.assessmentInicial.API.RestFull.models.UsuarioModel;
import com.assessmentInicial.API.RestFull.repositories.TareaRepository;

@Service
public class TareaService {
    @Autowired
    TareaRepository tareaRepository;

    public ArrayList<TareaModel> obtenerTareas(){
        return (ArrayList<TareaModel>) tareaRepository.findAll();
    }

    public TareaModel guardarTarea(TareaModel tarea){
        return tareaRepository.save(tarea);
    }

    public Optional<TareaModel> obtenerPorId(Long id){
        return tareaRepository.findById(id);
    }

    public ArrayList<TareaModel> obtenerPorEstado(Integer estado){
        return tareaRepository.findByEstado(estado);
    }

    public boolean eliminarTarea(Long id){
        try {
            tareaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
