package Dao;


import com.example.oracle_test.Piesa;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PiesaJdbcDao implements Dao<Piesa> {

    private JdbcTemplate jdbcTemplate;

    public PiesaJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Piesa> readAll() {
        return jdbcTemplate.query(
                "SELECT * from PIESE",
                BeanPropertyRowMapper.newInstance(Piesa.class));
    }

    @Override
    public void create(Piesa piesa) {
        int insert = jdbcTemplate.update("INSERT INTO PIESE (IDP, NUMEP, CULOARE) VALUES(?,?,?)",
                piesa.getIdp(), piesa.getNumep(), piesa.getCuloare() );
        if(insert == 1){
            System.out.println("Noua piesa adaugata");
        }
    }

    @Override
    public void update(Piesa piesa) {
        int insert = jdbcTemplate.update("UPDATE PIESE SET NUMEP=?, CULOARE=? WHERE IDP=?",
                piesa.getNumep(), piesa.getCuloare(), piesa.getIdp() );
        if(insert == 1){
            System.out.println("Modificat piesa");
        }
    }

    @Override
    public void deleteById(int idp) {
        int deleted =  jdbcTemplate.update("DELETE FROM PIESE WHERE IDP=?", idp);
        System.out.println("Au fost sterse " + deleted + " piese");
    }


    public Integer nrPiese(int idp) {
        return jdbcTemplate.queryForObject("SELECT TotalPieseComandate(" + idp + ") FROM dual", Integer.class);
    }
}
