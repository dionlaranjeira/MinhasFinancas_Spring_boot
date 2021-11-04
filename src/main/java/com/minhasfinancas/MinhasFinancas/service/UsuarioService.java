package com.minhasfinancas.MinhasFinancas.service;

import com.minhasfinancas.MinhasFinancas.model.entity.Usuario;

public interface UsuarioService {

    Usuario autenticar(String email, String senha);

    Usuario salvarUsuario(Usuario usuario);

    void validarEmail(String email);

}
