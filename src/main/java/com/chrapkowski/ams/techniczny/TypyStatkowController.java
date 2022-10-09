package com.chrapkowski.ams.techniczny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TypyStatkowController {
    @Autowired
    private TypyStatkowService typyStatkowService;

    @GetMapping("/techniczny/dzialtechnicznyy")
    public String typystatkow(Model model){
        model.addAttribute("listaTypowStatkow",typyStatkowService.PokazWszystkieTypyStatkow());
        return "techniczny/dzialtechniczny";
    }

}
