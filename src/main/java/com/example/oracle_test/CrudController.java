package com.example.oracle_test;

import Dao.FurnizorJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CrudController {

    @Autowired
    public JdbcTemplate jdbcTemplate;


    @GetMapping("/furnizor")
    public String getFurnizor(Model model){
        FurnizorJdbcDao fDao = new FurnizorJdbcDao(jdbcTemplate);

        List<Furnizor> furnizori = fDao.findAll();

        model.addAttribute("furnizori", furnizori);
        model.addAttribute("furnizor_nou", new Furnizor());
        model.addAttribute("sterge_furnizor", new Furnizor());

        return "furnizor";
    }

    @PostMapping("/furnizor_nou")
    public String newFurnizor(@ModelAttribute Furnizor furnizor)
    {
        FurnizorJdbcDao fDao = new FurnizorJdbcDao(jdbcTemplate);

        fDao.create(furnizor);
        return "redirect:/furnizor";
    }

    @PostMapping("/sterge_furnizor")
    public String deleteFurnizor(@ModelAttribute Furnizor furnizor)
    {
        FurnizorJdbcDao fDao = new FurnizorJdbcDao(jdbcTemplate);

        fDao.deleteById(furnizor.getIdf());
        return "redirect:/furnizor";
    }
}
