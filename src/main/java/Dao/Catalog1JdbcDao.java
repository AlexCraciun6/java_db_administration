package Dao;

import com.example.oracle_test.Catalog1;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Catalog1JdbcDao {

    private JdbcTemplate jdbcTemplate;

    public Catalog1JdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Catalog1> readAll() {
        return jdbcTemplate.query(
                "SELECT * from CATALOG1",
                BeanPropertyRowMapper.newInstance(Catalog1.class));
    }


    public void create(Catalog1 catalog1) {
        int insert = jdbcTemplate.update("INSERT INTO  CATALOG1 (IDF, IDP, PRET, MONEDA) VALUES(?,?,?,?)",
                catalog1.getIdf(), catalog1.getIdp(), catalog1.getPret(), catalog1.getMoneda() );
        if(insert == 1){
            System.out.println("Nou catalog adaugat");
        }
    }


    public void update(Catalog1 catalog1) {
        int insert = jdbcTemplate.update("UPDATE CATALOG1 SET PRET=?, MONEDA=? WHERE IDF=? AND IDP=?",
                catalog1.getPret(), catalog1.getMoneda(), catalog1.getIdf(), catalog1.getIdp() );
        if(insert == 1){
            System.out.println("Modificat catalog");
        }
    }


    public void deleteById(int idf, int idp) {
        int deleted =  jdbcTemplate.update("DELETE FROM CATALOG1 WHERE IDF=? AND IDP=?",idf,  idp);
        System.out.println("Au fost sterse " + deleted + " cataloage");
    }
}
