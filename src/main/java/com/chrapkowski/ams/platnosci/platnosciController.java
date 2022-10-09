package com.chrapkowski.ams.platnosci;

import com.chrapkowski.ams.uzytkownicy.UzytkownicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class platnosciController {

    /*Płatności*/

    @GetMapping("/platnosci/platnosci")
    public String piloci() {
        return "/platnosci/platnosci";
    }


}
