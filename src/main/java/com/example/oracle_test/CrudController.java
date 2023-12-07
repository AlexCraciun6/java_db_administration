package com.example.oracle_test;

import Dao.Catalog1JdbcDao;
import Dao.ComandaJdbcDao;
import Dao.FurnizorJdbcDao;
import Dao.PiesaJdbcDao;
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

        List<Furnizor> furnizori = fDao.readAll();

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

    @GetMapping("/piesa")
    public String getPiesa(Model model){
        PiesaJdbcDao pDao = new PiesaJdbcDao(jdbcTemplate);

        List<Piesa> piese = pDao.readAll();

        model.addAttribute("piese", piese);
        model.addAttribute("piesa_noua", new Piesa());
        model.addAttribute("sterge_piesa", new Piesa());
        model.addAttribute("update_piesa", new Piesa());

        return "piesa";
    }

    @PostMapping("/piesa_noua")
    public String newPiesa(@ModelAttribute Piesa piesa)
    {
        PiesaJdbcDao pDao = new PiesaJdbcDao(jdbcTemplate);

        pDao.create(piesa);
        return "redirect:/piesa";
    }

    @PostMapping("/sterge_piesa")
    public String deletePiesa(@ModelAttribute Piesa piesa)
    {
        PiesaJdbcDao pDao = new PiesaJdbcDao(jdbcTemplate);

        pDao.deleteById(piesa.getIdp());
        return "redirect:/piesa";
    }


    @PostMapping("/update_piesa")
    public String updatePiesa(@ModelAttribute Piesa piesa){
        PiesaJdbcDao pDao = new PiesaJdbcDao(jdbcTemplate);

        pDao.update(piesa);
        return "redirect:/piesa";
    }


    @GetMapping("/catalog1")
    public String getCatalog1(Model model){
        Catalog1JdbcDao cDao = new Catalog1JdbcDao(jdbcTemplate);

        List<Catalog1> cataloage1 = cDao.readAll();

        model.addAttribute("cataloage1", cataloage1);
        model.addAttribute("catalog1_nou", new Catalog1());
        model.addAttribute("sterge_catalog1", new Catalog1());
        model.addAttribute("update_catalog1", new Catalog1());

        return "catalog1";
    }

    @PostMapping("/catalog1_nou")
    public String newCatalog1(@ModelAttribute Catalog1 catalog1)
    {
        Catalog1JdbcDao cDao = new Catalog1JdbcDao(jdbcTemplate);

        cDao.create(catalog1);
        return "redirect:/catalog1";
    }

    @PostMapping("/sterge_catalog1")
    public String deleteCatalog1(@ModelAttribute Catalog1 catalog1)
    {
        Catalog1JdbcDao cDao = new Catalog1JdbcDao(jdbcTemplate);

        cDao.deleteById(catalog1.getIdf(), catalog1.getIdp());
        return "redirect:/catalog1";
    }


    @PostMapping("/update_catalog1")
    public String updateCatalog1(@ModelAttribute Catalog1 catalog1){
        Catalog1JdbcDao cDao = new Catalog1JdbcDao(jdbcTemplate);

        cDao.update(catalog1);
        return "redirect:/catalog1";
    }


    @GetMapping("/comanda")
    public String getComanda(Model model){
        ComandaJdbcDao comDao = new ComandaJdbcDao(jdbcTemplate);

        List<Comanda> comenzi = comDao.readAll();

        model.addAttribute("comenzi", comenzi);
        model.addAttribute("comanda_noua", new Comanda());
        model.addAttribute("sterge_comanda", new Comanda());
        model.addAttribute("update_comanda", new Comanda());

        return "comanda";
    }

    @PostMapping("/comanda_noua")
    public String newComanda(@ModelAttribute Comanda comanda)
    {
        ComandaJdbcDao comDao = new ComandaJdbcDao(jdbcTemplate);

        comDao.create(comanda);
        return "redirect:/comanda";
    }

    @PostMapping("/sterge_comanda")
    public String deleteComanda1(@ModelAttribute Comanda comanda)
    {
        ComandaJdbcDao comDao = new ComandaJdbcDao(jdbcTemplate);

        comDao.deleteById(comanda.getIdc(), comanda.getIdf(), comanda.getIdp());
        return "redirect:/comanda";
    }


    @PostMapping("/update_comanda")
    public String updateComanda(@ModelAttribute Comanda comanda){
        ComandaJdbcDao comDao = new ComandaJdbcDao(jdbcTemplate);

        comDao.update(comanda);
        return "redirect:/comanda";
    }

}
