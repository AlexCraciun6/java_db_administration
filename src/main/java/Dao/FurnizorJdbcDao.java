package Dao;

import com.example.oracle_test.Furnizor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FurnizorJdbcDao implements Dao<Furnizor> {

    private JdbcTemplate jdbcTemplate;

    public FurnizorJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Furnizor> findAll() {
        return jdbcTemplate.query(
                "SELECT * from FURNIZORI",
                BeanPropertyRowMapper.newInstance(Furnizor.class));
    }

    @Override
    public void create(Furnizor furnizor) {
        int insert = jdbcTemplate.update("INSERT INTO FURNIZORI (IDF, NUMEF, ADRESA) VALUES(?,?,?)",
                 furnizor.getIdf(), furnizor.getNumef(), furnizor.getAdresa() );
        if(insert == 1){
            System.out.println("Nou furnizor adaugat");
        }
    }

//    @Override
//    public Optional<Furnizor> findById(int idf) {
//        try {
//            Furnizor furnizor = jdbcTemplate.queryForObject("SELECT * FROM FURNIZORI WHERE IDF=?",
//                    BeanPropertyRowMapper.newInstance(Furnizor.class), idf);
//
//            return Optional.ofNullable(furnizor);
//        } catch (IncorrectResultSizeDataAccessException e) {
//            return Optional.empty();
//        }
//    }

    @Override
    public void update(Furnizor furnizor) {
        int insert = jdbcTemplate.update("UPDATE FURNIZORI SET NUMEF=?, ADRESA=? WHERE IDF=?",
                 furnizor.getNumef(), furnizor.getAdresa(), furnizor.getIdf() );
        if(insert == 1){
            System.out.println("Modificat furnizor");
        }
    }

    @Override
    public void deleteById(int idf) {
        int deleted =  jdbcTemplate.update("DELETE FROM FURNIZORI WHERE IDF=?", idf);
        System.out.println("Au fost stersi " + deleted + " furnizori");
    }
}
