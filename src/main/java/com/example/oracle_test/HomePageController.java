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

    public static class Ending{
        private String ending;

        public String getEnding() {
            return ending;
        }

        public void setEnding(String ending) {
            this.ending = ending;
        }

    }

    @GetMapping("/crud")
    public String getCrudOperations(){
        return "crud";
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

    @GetMapping("/interogare4a")
    public String interogare4a(Model model){

        List<Comanda> comenzi_4a = Interogari.getInterogare4a(jdbcTemplate);

        model.addAttribute("comenzi_4a", comenzi_4a);
        return "interogare_4a";
    }

    @GetMapping("/interogare4b")
    public String interogare4b(Model model){
        List<Comanda_4b> comenzi_4b = Interogari.getInterogare4b(jdbcTemplate);

        model.addAttribute("comenzi_4b", comenzi_4b);
        return "interogare_4b";
    }

    @GetMapping("/interogare5a")
    public String interogare5a(Model model){

        List<String> furnizori_5a = Interogari.getInterogare5a(jdbcTemplate);

        model.addAttribute("furnizori_5a", furnizori_5a);
        return "interogare_5a";
    }

    @GetMapping("/interogare5b")
    public String interogare5b(Model model){
        Catalog1 piesa = Interogari.getInterogare5b(jdbcTemplate);

        model.addAttribute("piesa", piesa);
        return "interogare_5b";
    }

    @GetMapping("/interogare6a")
    public String interogare6a(Model model){

        List<Catalog1_6a> cataloage_6a = Interogari.getInterogare6a(jdbcTemplate);

        model.addAttribute("cataloage_6a", cataloage_6a);
        return "interogare_6a";
    }

    @GetMapping("/interogare6b")
    public String interogare6b(Model model){
        List<Comanda_6b> comenzi_6b = Interogari.getInterogare6b(jdbcTemplate);

        model.addAttribute("comenzi_6b", comenzi_6b);
        return "interogare_6b";
    }


    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("something", "this is coming from controller");
        return "index";
    }

}
