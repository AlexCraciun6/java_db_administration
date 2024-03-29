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

    public int insert_surub(int idc, int idf, int idp, int cantitate){
        return jdbcTemplate.update("call AdaugaInComenziSurubComandat(?,?,?,?)", idc, idf, idp, cantitate);
    }
}
