package com.chrapkowski.ams.wyszkolenie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ZadaniaController {


    @GetMapping("/wyszkolenie/zadania")
    String zadania() {
        return ("/wyszkolenie/zadania");
    }

    @GetMapping("/zadaniaForm")
    public String userView(Model model){
        model.addAttribute("zadania", new Zadania());
        return "/wyszkolenie/zadaniaForm";
    }

    @PostMapping("/zadaniaForm")
    public String userView(@Valid @ModelAttribute Zadania zadania, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            List<ObjectError> errorsList = bindingResult.getAllErrors();
            for(ObjectError error:errorsList) {
                System.out.println(error);
            }

        }
        return "/wyszkolenie/zadaniaForm";
    }

    }
