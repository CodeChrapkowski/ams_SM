package com.chrapkowski.ams.uzytkownicy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UzytkownicyRegistrationController {

    private UzytkownicyService uzytkownicyService;

    public UzytkownicyRegistrationController(UzytkownicyService uzytkownicyService) {
        this.uzytkownicyService = uzytkownicyService;
    }

    @ModelAttribute("uzytkownicy")
    public UzytkownicyRegistrationDto uzytkownicyRegistrationDto() {
        return new UzytkownicyRegistrationDto();

    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("uztkownicy", new UzytkownicyRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String registernUserAccount(@ModelAttribute("uzytkownicy") UzytkownicyRegistrationDto registrationDto) {
        uzytkownicyService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
