package com.assessmentInicial.API.RestFull.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assessmentInicial.API.RestFull.models.UsuarioModel;
import com.assessmentInicial.API.RestFull.repositories.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        UsuarioModel usuario = usuarioRepository
            .findOneByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + email + " no existe"));

            return new UserDetailsImpl(usuario);
    }
}
