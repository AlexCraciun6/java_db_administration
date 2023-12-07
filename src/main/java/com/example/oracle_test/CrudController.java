package com.example.oracle_test;

import Dao.FurnizorJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
//        model.addAttribute("furnizor_by_idf", new Furnizor());
        model.addAttribute("update_furnizor", new Furnizor());

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

//    @PostMapping("/furnizor_by_idf")
//    public String furnizorByIdf(@ModelAttribute Furnizor furnizor){
//        FurnizorJdbcDao fDao = new FurnizorJdbcDao(jdbcTemplate);
//
//        Optional<Furnizor> f = fDao.findById(furnizor.getIdf());
//        System.out.println(f);
//        return "redirect:/furnizor";
//    }

    @PostMapping("/update_furnizor")
    public String updateFurnizor(@ModelAttribute Furnizor furnizor){
        FurnizorJdbcDao fDao = new FurnizorJdbcDao(jdbcTemplate);

        fDao.update(furnizor);
        return "redirect:/furnizor";
    }
}
