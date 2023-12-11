package Dao;

import com.example.oracle_test.SurubComandat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SurubComandatJdbcDao {

    private JdbcTemplate jdbcTemplate;

    public SurubComandatJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SurubComandat> readAll() {
        return jdbcTemplate.query(
                "SELECT * from surub_comandat",
                BeanPropertyRowMapper.newInstance(SurubComandat.class));
    }
}
