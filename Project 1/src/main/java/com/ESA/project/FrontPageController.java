package com.ESA.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FrontPageController {
   @GetMapping("/Frontpage")
   public String FrongPage() {
       return "FrontPage";
   }
}