package com.testebatch.step;


import com.testebatch.model.Usuario;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcCursorReaderStepConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;




    @Bean
    public Step jdbcCursorReaderStep(
            ItemReader<Usuario> jdbcCursorReader,
            ItemWriter<Usuario> jdbcCursorWriter,
            ItemProcessor itemProcessor ) {
        return stepBuilderFactory
                .get("jdbcCursorReaderStep")
                .<Usuario, Usuario>chunk(1)
                .reader(jdbcCursorReader)
                .processor(itemProcessor)
                .writer(jdbcCursorWriter)
                .build();
    }

}
