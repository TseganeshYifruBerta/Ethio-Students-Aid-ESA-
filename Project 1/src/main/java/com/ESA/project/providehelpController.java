package com.ESA.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class providehelpController {
    @GetMapping("/providehelp")
    public String get(){
        return "ProvideAnswer";
    }
    
}
