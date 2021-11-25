package com.minhasfinancas.MinhasFinancas.model.repository;

import com.minhasfinancas.MinhasFinancas.model.entity.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioRepositotyTest {

    @Autowired
    UsuarioRepository repository;

    @Test
    public void verificaExistenciaEmail(){

        //Cenário
        Usuario usuario = Usuario.builder()
                .nome("andreina")
                .email("andreinaandrade.rr@gmail.com")
                .senha("123456")
                .build();
        repository.save(usuario);

        //ação / execução

        boolean result = repository.existsByEmail("andreinaandrade.rr@gmail.com");

        //Verificacao

        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void retornaFalsoSemEmailCadastrado(){
        //cenário
        repository.deleteAll();

        //acao
        boolean result = repository.existsByEmail("usuario@email.com");

        //verificacao
        Assertions.assertThat(result).isFalse();
    }


}
