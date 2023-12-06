package com.example.oracle_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomePageController {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public class Ending{
        private String ending;

        public String getEnding() {
            return ending;
        }

        public void setEnding(String ending) {
            this.ending = ending;
        }

    }

    @GetMapping("/get_data_3a")
    public String getData3a(Model model){



        model.addAttribute("ending", new Ending());
        return "get_data_3a";
    }

    @PostMapping("/interogare3a")
    public String interogare3a(@ModelAttribute Ending ending, Model model){

        List<Furnizor> furnizori_3a = Interogari.getInterogare3a(jdbcTemplate, Integer.parseInt(ending.getEnding()));

        model.addAttribute("furnizori_3a", furnizori_3a);
        return "interogare_3a";
    }

    @GetMapping("/interogare3b")
    public String interogare3b(Model model){
        List<Comanda> comenzi_3b = Interogari.getInterogare3b(jdbcTemplate);

        model.addAttribute("comenzi_3b", comenzi_3b);
        return "interogare_3b";
    }



    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("something", "this is coming from controller");
        return "index";
    }

}
