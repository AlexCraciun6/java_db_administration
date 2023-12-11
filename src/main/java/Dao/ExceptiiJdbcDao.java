package Dao;

import com.example.oracle_test.Exceptie;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ExceptiiJdbcDao {

    private JdbcTemplate jdbcTemplate;

    public ExceptiiJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Exceptie> readAll() {
        return jdbcTemplate.query(
                "SELECT * from exceptii ORDER BY idf",
                BeanPropertyRowMapper.newInstance(Exceptie.class));
    }

    public int generare_exceptii(){
        return jdbcTemplate.update("call generateexceptions()");
    }
}
