package com.assessmentInicial.API.RestFull.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessmentInicial.API.RestFull.models.TareaModel;
import com.assessmentInicial.API.RestFull.models.UsuarioModel;

@Repository
public interface TareaRepository extends CrudRepository<TareaModel, Long> {
    public abstract ArrayList<TareaModel> findByEstado(Integer estado);
}
