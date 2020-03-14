package pt.uporto.les.petcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        System.out.println("Entrou na página Home.");
        return "Bem Vindo ao PetCare!";
    }

}
