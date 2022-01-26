package com.ESA.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class OpportunitiesController {
    @GetMapping("/opportunities")
   public String OPage() {
       return "opportunities";
   }
}