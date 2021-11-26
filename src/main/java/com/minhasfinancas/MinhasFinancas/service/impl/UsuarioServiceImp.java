package com.minhasfinancas.MinhasFinancas.service.impl;

import com.minhasfinancas.MinhasFinancas.exception.ErroAutenticacao;
import com.minhasfinancas.MinhasFinancas.exception.RegraNegocioException;
import com.minhasfinancas.MinhasFinancas.model.entity.Usuario;
import com.minhasfinancas.MinhasFinancas.model.repository.UsuarioRepository;
import com.minhasfinancas.MinhasFinancas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private UsuarioRepository repository;

    public UsuarioServiceImp(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {

        Optional <Usuario> usuario = repository.findByEmail(email);

        if(!usuario.isPresent()){
            throw new ErroAutenticacao("Usuário não encontrado");
        }

        if(!usuario.get().equals(senha)){
            throw new ErroAutenticacao("Senha inválida");
        }


        return usuario.get();
    }

    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {

        validarEmail(usuario.getEmail());
        return repository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
       boolean existe = repository.existsByEmail(email);

       if(existe){
           throw new RegraNegocioException("Já existe um usuário cadastrado com esse email");
       }
    }
}
