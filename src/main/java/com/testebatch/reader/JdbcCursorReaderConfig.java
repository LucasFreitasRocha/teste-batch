package com.testebatch.reader;

import com.testebatch.model.Usuario;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class JdbcCursorReaderConfig {
    private String name = "teste";
    @Bean
    public JdbcCursorItemReader<Usuario> jdbcCursorReader(
            @Qualifier("appDataSource")DataSource dataSource
    ){
        return new JdbcCursorItemReaderBuilder<Usuario>()
                .name("jdbcCursorReader")
                .dataSource(dataSource)
                .sql(String.format("call getNome('%s')", name))
                .rowMapper((rs, rowNum) -> {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getLong("id"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setNome(rs.getString("nome"));
                    return usuario;
                })
                .build();
    }
}
