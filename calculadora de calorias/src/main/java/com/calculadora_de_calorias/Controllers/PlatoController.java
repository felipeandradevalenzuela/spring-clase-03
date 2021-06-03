package com.calculadora_de_calorias.Controllers;

import com.calculadora_de_calorias.DTO.PlatoDTO;
import com.calculadora_de_calorias.Entities.Plato;
import com.calculadora_de_calorias.Services.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {

    @Autowired
    @Qualifier("CalculateServiceImpl")
    private ICalculateService calculateService;

    @PostMapping("/calculateCalories")
    public PlatoDTO calculateCalories(@RequestBody Plato plato){
        return calculateService.resultadoPlato(plato);
    }
}
