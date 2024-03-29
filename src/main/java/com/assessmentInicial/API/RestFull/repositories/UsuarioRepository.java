package com.assessmentInicial.API.RestFull.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessmentInicial.API.RestFull.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    public abstract ArrayList<UsuarioModel> findByPrioriodad(Integer prioridad);

    Optional<UsuarioModel> findOneByEmail(String email);
}
