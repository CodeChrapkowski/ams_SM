package com.chrapkowski.ams.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/odprawa/briefing")
    public String briefing() {
        return "/odprawa/briefing";
    }

    @GetMapping("/echrono/echrono")
    public String echronos() {
        return "/echrono/echrono";
    }

  /*  @GetMapping("/account/client/dzialtechniczny")
    public String dzialtechniczny() {
        return "/account/client/dzialtechniczny";
    }
*/
   /* @GetMapping("/account/client/platnosci")
    public String platnosci() {
        return "/account/client/platnosci";
    }*/

    @GetMapping("/administracja/profile")
    public String profile() {
        return "/administracja/profile";
    }

    @GetMapping("/")
    public String home() {
        return "/account/client/index";
    }


    @GetMapping("/account/client/index")
    public String index() {
        return "/account/client/index";
    }


    @GetMapping("/t")
    public String t() {
        return "t";
    }
}
