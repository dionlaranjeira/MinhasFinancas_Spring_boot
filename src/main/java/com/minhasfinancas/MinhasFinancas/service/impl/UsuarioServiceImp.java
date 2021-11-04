package com.minhasfinancas.MinhasFinancas.service.impl;

import com.minhasfinancas.MinhasFinancas.exception.RegraNegocioException;
import com.minhasfinancas.MinhasFinancas.model.entity.Usuario;
import com.minhasfinancas.MinhasFinancas.model.repository.UsuarioRepository;
import com.minhasfinancas.MinhasFinancas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private UsuarioRepository repository;

    public UsuarioServiceImp(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        return null;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void validarEmail(String email) {
       boolean existe = repository.existsByEmail(email);

       if(existe){
           throw new RegraNegocioException("Já existe um usuário cadastrado com esse email");
       }
    }
}
