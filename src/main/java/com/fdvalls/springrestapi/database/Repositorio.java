package com.fdvalls.springrestapi.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fdvalls.springrestapi.model.ModeloPatente;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class Repositorio {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public Repositorio(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
    }

    public ModeloPatente getPatente(String patente) {
        String query = "select * from patente where NroPatente = ?";
        try {
            ModeloPatente modeloPatente = this.jdbcTemplate.queryForObject(query, new PatenteRowMapper(), patente);
            return modeloPatente;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<ModeloPatente> getAllPatente() {
        String query = "select * from patente";
        List<ModeloPatente> all = this.jdbcTemplate.query(query, new PatenteRowMapper());
        return all;
    }

    public Number addRow(ModeloPatente emp) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("NroPatente", emp.getNroPatente());
        return simpleJdbcInsert.executeAndReturnKey(parameters);
    }

    private static class PatenteRowMapper implements RowMapper<ModeloPatente> {

        @Override
        public ModeloPatente mapRow(ResultSet rs, int rowNum) throws SQLException {
            String nroPatente = rs.getString("NroPatente");
            Long id = rs.getLong("id");
            return new ModeloPatente(id, nroPatente);
        }

    }

}
