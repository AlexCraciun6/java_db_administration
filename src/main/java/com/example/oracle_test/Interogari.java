package com.example.oracle_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

public class Interogari {

    public static List<Furnizor> getInterogare3a(JdbcTemplate jdbcTemplate, int nr) {

        String sql_3a = "SELECT *\n" +
                "FROM Furnizori\n" +
                "WHERE SUBSTR(adresa, -1) = " + nr + "\n" +
                "ORDER BY adresa";

        List<Furnizor> furnizori_3a = jdbcTemplate.query(sql_3a,
                BeanPropertyRowMapper.newInstance(Furnizor.class));

        return furnizori_3a;
    }


    public static List<Comanda> getInterogare3b(JdbcTemplate jdbcTemplate) {
        String sql_3b = "SELECT *\n" +
                "FROM Comenzi\n" +
                "WHERE cantitate > 200 AND cantitate != 300";

        List<Comanda> comenzi_3b = jdbcTemplate.query(sql_3b,
                BeanPropertyRowMapper.newInstance(Comanda.class));

        return comenzi_3b;
    }

    public static List<Comanda> getInterogare4a(JdbcTemplate jdbcTemplate) {
        String sql_4a =
                "SELECT Comenzi.idc, Comenzi.idf, Comenzi.idp, Comenzi.cantitate\n" +
                        "FROM Comenzi\n" +
                        "JOIN Catalog1 ON Comenzi.idf = Catalog1.idf AND Comenzi.idp = Catalog1.idp\n" +
                        "WHERE (Catalog1.pret * Comenzi.cantitate) BETWEEN 10 AND 20 AND Catalog1.moneda = 'EUR'";

        List<Comanda> comenzi_4a = jdbcTemplate.query(sql_4a,
                BeanPropertyRowMapper.newInstance(Comanda.class));


        return comenzi_4a;
    }

    public static List<Comanda_4b> getInterogare4b(JdbcTemplate jdbcTemplate) {
        String sql_4b = "SELECT DISTINCT c1.idf AS idf1, c2.idf AS idf2\n" +
                "FROM Comenzi c1\n" +
                "JOIN Comenzi c2 ON c1.idp = c2.idp AND c1.cantitate = c2.cantitate AND c1.idc < c2.idc AND c1.idf <> c2.idf";

        List<Comanda_4b> comenzi_4b = jdbcTemplate.query(sql_4b,
                BeanPropertyRowMapper.newInstance(Comanda_4b.class));


        return comenzi_4b;
    }

    public static List<String> getInterogare5a(JdbcTemplate jdbcTemplate) {
        String sql_5a = "SELECT DISTINCT f.numef\n" +
                "FROM Furnizori f\n" +
                "WHERE NOT EXISTS (\n" +
                "    SELECT c1.idp\n" +
                "    FROM Catalog1 c1\n" +
                "    WHERE c1.idf = 101\n" +
                "    MINUS\n" +
                "    SELECT c2.idp\n" +
                "    FROM Catalog1 c2\n" +
                "    WHERE c2.idf = f.idf\n" +
                ") and f.idf != 101";

        List<Furnizor> furnziori_5a = jdbcTemplate.query(sql_5a,
                BeanPropertyRowMapper.newInstance(Furnizor.class));

        List<String> nume_furnizori = new ArrayList<String>();
        for (Furnizor f : furnziori_5a)
            nume_furnizori.add(f.getNumef());
        ;
        return nume_furnizori;
    }

    public static Catalog1 getInterogare5b(JdbcTemplate jdbcTemplate) {
        String sql_5b = "SELECT *\n" +
                "FROM Catalog1 c1\n" +
                "WHERE NOT EXISTS (\n" +
                "    SELECT 1\n" +
                "    FROM Catalog1 c2\n" +
                "    WHERE c2.pret > c1.pret\n" +
                ")";

        Catalog1 piesa = jdbcTemplate.queryForObject(sql_5b,
                BeanPropertyRowMapper.newInstance(Catalog1.class));


        return piesa;
    }

    public static List<Catalog1_6a> getInterogare6a(JdbcTemplate jdbcTemplate) {
        String sql_6a = "SELECT C.idf, C.moneda, MIN(C.pret) AS pret_minim, MAX(C.pret) AS pret_maxim\n" +
                "FROM Catalog1 C\n" +
                "GROUP BY C.idf, C.moneda\n" +
                "ORDER BY C.idf";

        List<Catalog1_6a> furnizori_6a = jdbcTemplate.query(sql_6a,
                BeanPropertyRowMapper.newInstance(Catalog1_6a.class));

        return furnizori_6a;
    }

    public static List<Comanda_6b> getInterogare6b(JdbcTemplate jdbcTemplate) {
        String sql_6b = "SELECT idc, COUNT(DISTINCT idp) AS numar_piese\n" +
                "FROM Comenzi\n" +
                "GROUP BY idc\n" +
                "ORDER BY idc";

        List<Comanda_6b> comenzi_6b = jdbcTemplate.query(sql_6b,
                BeanPropertyRowMapper.newInstance(Comanda_6b.class));

        return comenzi_6b;
    }

}
