package com.chrapkowski.ams.techniczny;

import com.chrapkowski.ams.techniczny.StatkiPowietrzne;
import com.chrapkowski.ams.techniczny.StatkiPowietrzneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StatkiPowietrzneController {

    @Autowired
    private StatkiPowietrzneService statkiPowietrzneService;
    @Autowired
    private TypyStatkowService typyStatkowService;

    //Wyświetlanie listy statków powietrznych wraz z typami statków
    @GetMapping("/techniczny/dzialtechniczny")
    public String dzialtechniczny(Model model) {
        model.addAttribute("listaStatkowPowietrznych", statkiPowietrzneService.getAllStatkiPowietrzne());
        model.addAttribute("listaTypowStatkow", typyStatkowService.PokazWszystkieTypyStatkow());
        return "techniczny/dzialtechniczny";

    }

    @GetMapping("/showNewStatekPowietrznyForm")
    public String showNewStatekPowietrznyForm(Model model) {
        StatkiPowietrzne statkiPowietrzne = new StatkiPowietrzne();
        model.addAttribute("statkiPowietrzne", statkiPowietrzne);
        /* Wyswietlenie listy typow staków*/
        model.addAttribute("listaTypowStatkow", typyStatkowService.PokazWszystkieTypyStatkow());
        return "/techniczny/NewStatekPowietrzny";
    }

 /*   @PostMapping("/saveStatkiPowietrzne")
    public String saveStatkiPowietrzne(@ModelAttribute("statkiPowietrzne") StatkiPowietrzne statkiPowietrzne) {


        // Zapis statku do bazy danych
        statkiPowietrzneService.saveStatkiPowietrzne(statkiPowietrzne);
        return "redirect:/techniczny/dzialtechniczny";
    } */

    @PostMapping("/saveStatkiPowietrzne")
    public String saveStatkiPowietrzne(@Valid @ModelAttribute("statkiPowietrzne") StatkiPowietrzne statkiPowietrzne, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {


            List<ObjectError> errorsList = bindingResult.getAllErrors();
            for (ObjectError error : errorsList)

            {
                System.out.println(error);


            }
            return "redirect:/showNewStatekPowietrznyForm";
        }


            // Zapis statku do bazy danych
            statkiPowietrzneService.saveStatkiPowietrzne(statkiPowietrzne);
            return "redirect:/techniczny/dzialtechniczny";
        }






    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        //get Statek Powietrzny from the service
        StatkiPowietrzne statkiPowietrzne = statkiPowietrzneService.getStatkiPowietrzneById(id);

        // set Statki Powietrzne as a model attribute to pre-populate the from

        model.addAttribute("statkiPowietrzne", statkiPowietrzne);

        /* Wyswietlenie listy typow staków*/
        model.addAttribute("listaTypowStatkow", typyStatkowService.PokazWszystkieTypyStatkow());
        return "/techniczny/update_statek_powietrzny";
    }

    @GetMapping("/deleteStatkiPowietrzne/{id}")
    public String deleteStatkiPowietrzne(@PathVariable(value = "id") long id) {

        // call delete StatekPowietrzny po ID
        this.statkiPowietrzneService.deleteStatkiPowietrzneById(id);
        return "redirect:/techniczny/dzialtechniczny";
    }
}
