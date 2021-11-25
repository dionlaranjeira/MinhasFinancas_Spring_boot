package com.minhasfinancas.MinhasFinancas.service;

import com.minhasfinancas.MinhasFinancas.model.entity.Usuario;
import com.minhasfinancas.MinhasFinancas.model.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @Autowired
    UsuarioService service;

    @Autowired
    UsuarioRepository repository;

    @Test
    public void deveValidarEmail(){
        //cenario
        repository.deleteAll();

        //acao
        service.validarEmail("email@email.com");
    }


    @Test
    public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado(){
        //cenario
        Usuario usuario = Usuario.builder().nome("usuario")
                .email("email@email.com").build();
        repository.save(usuario);

        //acao
        service.validarEmail("email@email.com");
    }
}
