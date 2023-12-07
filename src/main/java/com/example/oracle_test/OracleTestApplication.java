package com.example.oracle_test;

import Dao.FurnizorJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

@SpringBootApplication
public class OracleTestApplication implements CommandLineRunner {

    @Autowired
    public JdbcTemplate jdbcTemplate;


    public static void main(String[] args) {
        SpringApplication.run(OracleTestApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

        System.out.println("Interogari: ");

        System.out.println("12.03:");
        System.out.println("a:");


//        List<Furnizor> furnizori_3a = Interogari.getInterogare3a(jdbcTemplate, 8);
//        furnizori_3a.forEach(System.out::println);

        System.out.println("b:");

        List<Comanda> comenzi_3b = Interogari.getInterogare3b(jdbcTemplate);
        comenzi_3b.forEach(System.out::println);

        System.out.println("12.04:");
        System.out.println("a:");

        List<Comanda> comenzi_4a = Interogari.getInterogare4a(jdbcTemplate);
        comenzi_4a.forEach(System.out::println);

        System.out.println("b:");

        List<Comanda_4b> comenzi_4b = Interogari.getInterogare4b(jdbcTemplate);
        comenzi_4b.forEach(System.out::println);

        System.out.println("12.05:");
        System.out.println("a:");

        List<String> furnizori_5a = Interogari.getInterogare5a(jdbcTemplate);
        furnizori_5a.forEach(System.out::println);

        System.out.println("b:");

        Catalog1 piesa = Interogari.getInterogare5b(jdbcTemplate);
        System.out.println(piesa);

        System.out.println("12.06:");
        System.out.println("a:");

        List<Catalog1_6a> cataloage_6a = Interogari.getInterogare6a(jdbcTemplate);
        cataloage_6a.forEach(System.out::println);

        System.out.println("b:");

        List<Comanda_6b> comenzi_6b = Interogari.getInterogare6b(jdbcTemplate);
        comenzi_6b.forEach(System.out::println);

    }
}
