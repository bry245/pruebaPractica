package com.practica01.controller;

import com.practica01.domain.Pais;
import com.practica01.service.PaisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired //Crea instancia de forma automatica
    private PaisService paisService;
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Estamos usando una arquitectura mvc");
        
        var paises = paisService.getPaises();
                
        model.addAttribute("paises", paises);
        return "index";
    }
    
    @GetMapping("/nuevoPais")
    public String nuevoPais(Pais pais){
        return "ModificarPais";
    }
    
    @PostMapping("/guardarPais")
    public String guardarPais(Pais pais){
        paisService.save(pais);
        return "redirect:/";
    }
    
    @GetMapping ("/modificarPais/{idPais}")
    public String modificarPais(Pais pais, Model model){
        pais = paisService.getPais(pais);
        model.addAttribute("pais", pais);
        return "ModificarPais";
    }
    
    @GetMapping ("/eliminarPais/{idPais}")
    public String eliminarPais(Pais pais){
        paisService.delete(pais);
        return "redirect:/";
    }
}
