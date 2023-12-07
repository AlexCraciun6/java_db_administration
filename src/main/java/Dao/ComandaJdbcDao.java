package Dao;

import com.example.oracle_test.Comanda;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ComandaJdbcDao {

    private JdbcTemplate jdbcTemplate;

    public ComandaJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Comanda> readAll() {
        return jdbcTemplate.query(
                "SELECT * from COMENZI",
                BeanPropertyRowMapper.newInstance(Comanda.class));
    }


    public void create(Comanda comanda) {
        int insert = jdbcTemplate.update("INSERT INTO  COMENZI (IDC, IDF, IDP, CANTITATE) VALUES(?,?,?,?)",
                comanda.getIdc(), comanda.getIdf(), comanda.getIdp(), comanda.getCantitate() );
        if(insert == 1){
            System.out.println("Noua comanda adaugata");
        }
    }


    public void update(Comanda comanda) {
        int insert = jdbcTemplate.update("UPDATE COMENZI SET CANTITATE=? WHERE IDC=? AND IDF=? AND IDP=?",
                comanda.getCantitate(), comanda.getIdc(), comanda.getIdf(), comanda.getIdp() );
        if(insert == 1){
            System.out.println("Modificat comanda");
        }
    }


    public void deleteById(int idc, int idf, int idp) {
        int deleted =  jdbcTemplate.update("DELETE FROM COMENZI WHERE IDC=? AND IDF=? AND IDP=?",idc, idf,  idp);
        System.out.println("Au fost sterse " + deleted + " comenzi");
    }
}
