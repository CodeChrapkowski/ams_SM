package com.chrapkowski.ams.wyszkolenie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class wyszkolenieController {

    @GetMapping("/wyszkolenie/wyszkolenie")
    String wyszkolenie (){
        return ("/wyszkolenie/wyszkolenie");
    }


}
