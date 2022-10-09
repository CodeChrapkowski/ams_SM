package com.chrapkowski.ams.uzytkownicy;

import com.chrapkowski.ams.uzytkownicy.UzytkownicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class UzytkownicyController {

    @Autowired
    private UzytkownicyService uzytkownicyService;

/*    //wyświetlenie listy uzytkowników
    @GetMapping("/platnosci/platnosci")
    public String platnosci(Model model){
model.addAttribute("listUzytkownicy", uzytkownicyService.getAllUzytkownicy());
return "platnosci/platnosci";
    }*/
}

