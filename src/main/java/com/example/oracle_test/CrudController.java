package com.example.oracle_test;

import Dao.*;
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

    @PostMapping("/update_furnizor")
    public String updateFurnizor(@ModelAttribute Furnizor furnizor){
        FurnizorJdbcDao fDao = new FurnizorJdbcDao(jdbcTemplate);

        fDao.update(furnizor);
        return "redirect:/furnizor";
    }

    private Integer nr_piese=0;

    @GetMapping("/piesa")
    public String getPiesa(Model model){
        PiesaJdbcDao pDao = new PiesaJdbcDao(jdbcTemplate);

        List<Piesa> piese = pDao.readAll();

        model.addAttribute("piese", piese);
        model.addAttribute("piesa_noua", new Piesa());
        model.addAttribute("sterge_piesa", new Piesa());
        model.addAttribute("update_piesa", new Piesa());
        model.addAttribute("nr_piese", new Piesa());
        model.addAttribute("nr_piese_var", nr_piese);

        nr_piese=0;
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

    @PostMapping("/nr_piese")
    public String nrPiese(@ModelAttribute Piesa piesa){
        PiesaJdbcDao pDao = new PiesaJdbcDao(jdbcTemplate);

        nr_piese = pDao.nrPiese(piesa.getIdp());
        return "redirect:/piesa";
    }

    private Integer reducere_idp = 0;

    @GetMapping("/catalog1")
    public String getCatalog1(Model model){
        Catalog1JdbcDao cDao = new Catalog1JdbcDao(jdbcTemplate);

        List<Catalog1> cataloage1 = cDao.readAll();

        model.addAttribute("cataloage1", cataloage1);
        model.addAttribute("catalog1_nou", new Catalog1());
        model.addAttribute("sterge_catalog1", new Catalog1());
        model.addAttribute("update_catalog1", new Catalog1());
        model.addAttribute("reducere_var", reducere_idp);

        reducere_idp=0;
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

    @PostMapping("/reducere")
    public String reducere(@ModelAttribute Catalog1 catalog1){
        Catalog1JdbcDao cDao = new Catalog1JdbcDao(jdbcTemplate);

        reducere_idp = cDao.reducerePret();
        cDao.aplicaReducerea(reducere_idp);
        return "redirect:/catalog1";
    }

    private double pret_comanda=0;


    @GetMapping("/comanda")
    public String getComanda(Model model){
        ComandaJdbcDao comDao = new ComandaJdbcDao(jdbcTemplate);

        List<Comanda> comenzi = comDao.readAll();

        model.addAttribute("comenzi", comenzi);
        model.addAttribute("comanda_noua", new Comanda());
        model.addAttribute("sterge_comanda", new Comanda());
        model.addAttribute("update_comanda", new Comanda());
        model.addAttribute("pret_comanda", new Comanda());
        model.addAttribute("pret_comanda_var", pret_comanda);

        pret_comanda=0;
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

    @PostMapping("/pret_comanda")
    public String pretComanda(@ModelAttribute Comanda comanda){
        ComandaJdbcDao comDao = new ComandaJdbcDao(jdbcTemplate);

        pret_comanda= comDao.pretComanda(comanda.getIdc(), comanda.getIdf(), comanda.getIdp());
        return "redirect:/comanda";
    }

    boolean inserted=false;

    @GetMapping("/surub_comandat")
    public String getSurubComandat(Model model){
        SurubComandatJdbcDao surubComandatDao = new SurubComandatJdbcDao(jdbcTemplate);

        List<SurubComandat> suruburi = surubComandatDao.readAll();


        model.addAttribute("suruburi", suruburi);
        model.addAttribute("surub_nou", new Comanda());
        model.addAttribute("surub_nou_var", inserted);

        inserted=false;
        return "view";
    }

    @PostMapping("/surub_nou")
    public String surubNou(@ModelAttribute SurubComandat surubComandat){
        SurubComandatJdbcDao surubComandatDao = new SurubComandatJdbcDao(jdbcTemplate);

        surubComandatDao.insert_surub(surubComandat.getIdc(), surubComandat.getIdf(), surubComandat.getIdp(), surubComandat.getCantitate());
        inserted = true;
        return "redirect:/surub_comandat";
    }



    @GetMapping("/exceptie")
    public String getExceptie(Model model){
        ExceptiiJdbcDao exceptiiJdbcDao = new ExceptiiJdbcDao(jdbcTemplate);

        List<Exceptie> exceptii = exceptiiJdbcDao.readAll();

        model.addAttribute("exceptii", exceptii);
//        model.addAttribute("comanda_noua", new Comanda());
//        model.addAttribute("sterge_comanda", new Comanda());
//        model.addAttribute("update_comanda", new Comanda());

        return "exceptie";
    }

    @PostMapping("/generare_exceptii")
    public String generareExceptii(@ModelAttribute Comanda comanda){
        ExceptiiJdbcDao exceptiiJdbcDao = new ExceptiiJdbcDao(jdbcTemplate);

        int nr = exceptiiJdbcDao.generare_exceptii();
        System.out.println(nr);
        return "redirect:/exceptie";
    }
}
