package com.testebatch.writer;


import com.testebatch.model.Usuario;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JdbcCursorWriterConfig {
    @Bean
    public ItemWriter<Usuario> jdbcCursorWriter() {
        return usuarios -> usuarios.forEach(System.out::println);
    }
}