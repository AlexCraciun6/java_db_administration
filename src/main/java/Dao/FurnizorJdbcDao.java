package Dao;

import com.example.oracle_test.Furnizor;
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

    @Override
    public Optional<Furnizor> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Furnizor furnizor, int id) {

    }

    @Override
    public void deleteById(int idf) {
        int deleted =  jdbcTemplate.update("DELETE FROM FURNIZORI WHERE IDF=?", idf);
        System.out.println("Au fost stersi " + deleted + " furnizori");
    }
}
