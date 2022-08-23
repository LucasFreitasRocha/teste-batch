package com.testebatch.processor;

import com.testebatch.model.Turma;
import com.testebatch.model.Usuario;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcCursorProcessorConfig implements ItemProcessor<Usuario, Usuario> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Usuario process(Usuario usuario) throws Exception {

        List<Turma> turmas = (jdbcTemplate.query(String.format("call getTurma(%s)",usuario.getId()), new RowMapper<Turma>() {
            @Override
            public Turma mapRow(ResultSet rs, int rowNum) throws SQLException {
                Turma t = new Turma();
                t.setId(rs.getLong("id"));
                t.setCodigo(rs.getString("codigo"));
                t.setName(rs.getString("name"));
                return t;
            }
        }));
        usuario.setTurmas(turmas);
        return usuario;
    }
}
