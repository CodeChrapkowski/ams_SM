package com.chrapkowski.ams.administracja;

import com.chrapkowski.ams.uzytkownicy.UzytkownicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
public class AdministracjaController {

    @Autowired
    private TaryfyService taryfyService;

    @GetMapping("/administracja/administracja")
    public String administracja() {
        return "/administracja/administracja";
    }


    @GetMapping("/ZobaczNoweTaryfyForm")
    public String ZobaczNoweTaryfyForm(Model model) {
        Taryfy taryfy = new Taryfy();
        model.addAttribute("taryfy", taryfy);
        return "/administracja/NoweTaryfyForm";
    }

    @GetMapping("/administracja/taryfy")
    public String taryfy(Model model, String keyword) {

        if (keyword != null) {
            model.addAttribute("listaTaryf", taryfyService.findByKeyword(keyword));
        } else {
            model.addAttribute("listaTaryf", taryfyService.PokazWszystkieTaryfy());
        }
        /*        return findPaginatedTaryfy(1, "nazwa", "asc", model);*/
        return "administracja/taryfy";
    }

    @PostMapping("/zapiszTaryfe")
    public String zapiszTaryfe(@ModelAttribute("taryfy") Taryfy taryfy) {
        // Zapis taryfy do bazy danych
        taryfyService.ZapiszTaryfe(taryfy);
        return "redirect:/administracja/taryfy";
    }

    @GetMapping("/pokazFormTaryfaAktualizacja/{id}")
    public String pokazFormTaryfaAktualizacja(@PathVariable(value = "id") long id, Model model) {
        Taryfy taryfy = taryfyService.AktualizujTaryfePoId(id);
        model.addAttribute("taryfy", taryfy);
        return "administracja/aktualizacjaTaryfaForm";
    }

    @GetMapping("/usunTaryfe/{id}")
    public String usunTaryfePoId(@PathVariable(value = "id") long id) {
        this.taryfyService.UsunTaryfePoId(id);
        return "redirect:/administracja/taryfy";
    }

    /*Paginacja taryf ze sortowaniem*/
    @GetMapping("/administracja/taryfy/page/{pageNo}")
    public String findPaginatedTaryfy(@PathVariable(value = "pageNo") int pageNo,
                                      @RequestParam("sortField") String sortField,
                                      @RequestParam("sortDirection") String sortDirection,
                                      Model model) {
        int pageSize = 4;

        Page<Taryfy> page = taryfyService.findPaginated(pageNo, pageSize, sortField, sortDirection);
        List<Taryfy> PokazWszystkieTaryfy = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sorDirection", sortDirection);
        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");

        model.addAttribute("listaTaryf", PokazWszystkieTaryfy);
        return "administracja/taryfy";
    }

    /*    ###### Cenniki ######*/

    @Autowired
    private CennikiService cennikiService;


    /* Wszyświetlanie listy cenników z paginacją*/
   /* @GetMapping("/administracja/cenniki")
    public String cenniki(Model model) {
        model.addAttribute("listaCennikow", cennikiService.PokazWszystkieCenniki());
        model.addAttribute("listaTaryf", taryfyService.PokazWszystkieTaryfy());

        return findPaginated(1, model);
        *//*  return "/administracja/cenniki";*//*
    }*/

    /* Wszyświetlanie listy cenników z paginacja i sortowaniem */
    @GetMapping("/administracja/cenniki")
    public String cenniki(Model model) {
        model.addAttribute("listaCennikow", cennikiService.PokazWszystkieCenniki());
        model.addAttribute("listaTaryf", taryfyService.PokazWszystkieTaryfy());
        return findPaginated(1, "nazwa", "asc", model);

        /*  return "/administracja/cenniki";*/
    }

    /* Zapisywanie Cenników*/
    @PostMapping("zapiszCennik")
    public String ZapiszCennik(@ModelAttribute("cenniki") Cenniki cenniki) {
        // Zapis taryfy do bazy danych


        cennikiService.ZapiszCennik(cenniki);
        return "redirect:/administracja/cenniki";
    }

    @GetMapping("/ZobaczNoweCennikiForm")
    public String ZobaczNoweCennikiForm(Model model) {
        Cenniki cenniki = new Cenniki();
        model.addAttribute("cenniki", cenniki);
        /* Wyswietlenie listy taryf*/
        model.addAttribute("listaTaryf", taryfyService.PokazWszystkieTaryfy());
        return "/administracja/NoweCennikiForm";
    }

    @GetMapping("/pokazFormCennikEdycja/{id}")
    public String pokazFormCennikiEdycja(@PathVariable(value = "id") long id, Model model) {
        Cenniki cenniki = cennikiService.EdytuTaryfePoId(id);
        model.addAttribute("cenniki", cenniki);
        /* Wyswietlenie listy typow staków*/
        model.addAttribute("listaTaryf", taryfyService.PokazWszystkieTaryfy());
        return "administracja/EdycjaCennikForm";
    }

    @GetMapping("/usunCennik/{id}")
    public String usunCennikPoId(@PathVariable(value = "id") long id) {
        this.cennikiService.UsunCennikPoId(id);
        return "redirect:/administracja/cenniki";
    }


    /*Paginacja cenników*/

 /*   @GetMapping("/administracja/cenniki/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNO, Model model) {
        int pageSize = 4;

        Page<Cenniki> page = cennikiService.findPaginated(pageNO,pageSize);
        List<Cenniki> PokazWszystkieCenniki = page.getContent();

        model.addAttribute("currentPage", pageNO);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("listaCennikow", PokazWszystkieCenniki);
        return "administracja/cenniki";
    }   */

    /*Paginacja cenników ze sortowaniem*/

    @GetMapping("/administracja/cenniki/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNO,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDirection") String sortDirection,
                                Model model) {
        int pageSize = 4;

        Page<Cenniki> page = cennikiService.findPaginated(pageNO, pageSize, sortField, sortDirection);
        List<Cenniki> PokazWszystkieCenniki = page.getContent();

        model.addAttribute("currentPage", pageNO);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");


        model.addAttribute("listaCennikow", PokazWszystkieCenniki);
        return "administracja/cenniki";
    }


    /*Pracownicy*/

    @GetMapping("/administracja/pracownicy")
    public String pracownicy() {
        return "/administracja/pracownicy";
    }

    /*Piloci*/

    @GetMapping("/administracja/piloci")
    public String piloci() {
        return "/administracja/piloci";
    }

    /*Użytkownicy*/

    @Autowired
    private UzytkownicyService uzytkownicyService;

    //wyświetlenie listy uzytkowników
    @GetMapping("/administracja/uzytkownicy")
    public String platnosci(Model model) {
        model.addAttribute("listUzytkownicy", uzytkownicyService.getAllUzytkownicy());
        return "/administracja/uzytkownicy";
    }

    /*Członkostwa*/
    @Autowired
    private CzlonkostwaService czlonkostwaService;

    @GetMapping("/administracja/czlonkostwa")
    public String czlonkostwa(Model model) {
        model.addAttribute("listCzlonkostwa", czlonkostwaService.listCzlonkostwa());
        return "/administracja/czlonkostwa";
    }

    /*Sekcje*/
    @Autowired
    private SekcjeService sekcjeService;

    @GetMapping("/administracja/sekcje")
    public String sekcje(Model model, String keyword) {
        model.addAttribute("listSekcje", sekcjeService.listSekcje());
        return "/administracja/sekcje";
    }

    @GetMapping("/zobaczSekcjeNoweForm")
    public String zobaczSekcjeNoweForm(Sekcje sekcje, Model model) {

        //  Sekcje sekcje = new Sekcje();
        model.addAttribute("sekcje", sekcje);
        /* Wyswietlenie listy taryf*/

        return "/administracja/sekcjeNoweForm";
    }

    /* Zapisywanie sekcji*/
    @PostMapping( "/zobaczSekcjeNoweForm")
    public String zapiszSekcje(@ModelAttribute("sekcje") Sekcje sekcje) {

        sekcjeService.ZapiszSekcje(sekcje);

        return "redirect:/administracja/sekcje";
    }

//
}

