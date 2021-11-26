package com.minhasfinancas.MinhasFinancas.model.repository;

import com.minhasfinancas.MinhasFinancas.model.entity.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioRepositotyTest {

    @Autowired
    UsuarioRepository repository;
    @Autowired
    TestEntityManager entityManager;

    @Test
    public void verificaExistenciaEmail(){

        //Cenário
        Usuario usuario = Usuario.builder()
                .nome("andreina")
                .email("andreinaandrade.rr@gmail.com")
                .senha("123456")
                .build();
        entityManager.persist(usuario);

        //ação / execução

        boolean result = repository.existsByEmail("andreinaandrade.rr@gmail.com");

        //Verificacao

        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void retornaFalsoSemEmailCadastrado(){
        //cenário

        //acao
        boolean result = repository.existsByEmail("usuario@email.com");

        //verificacao
        Assertions.assertThat(result).isFalse();
    }


}
