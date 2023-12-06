package com.example.oracle_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomePageController {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String greet(Model model){
        model.addAttribute("something", "this is coming from controller");

        List<Furnizor> furnizori_3a = Interogari.getInterogare3a(jdbcTemplate, 8);

        model.addAttribute("furnizori_3a", furnizori_3a);
        return "index";
    }

}
