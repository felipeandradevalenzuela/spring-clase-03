package com.calculadora_de_calorias.Controllers;

import com.calculadora_de_calorias.DTO.PlatoDTO;
import com.calculadora_de_calorias.Entities.Plato;
import com.calculadora_de_calorias.Services.ICalculateService;
import com.calculadora_de_calorias.Services.IListadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlatoController {

    @Autowired
    @Qualifier("CalculateServiceImpl")
    private ICalculateService calculateService;
    @Autowired
    @Qualifier("ListadoServiceImpl")
    private IListadoService listadoService;

    @PostMapping("/calculateCalories")
    public PlatoDTO calculateCalories(@RequestBody Plato plato){
        return calculateService.resultadoPlato(plato);
    }

    @PostMapping("/getPlatos")
    public ArrayList<PlatoDTO> getPlatos(@RequestBody List<Plato> listado){
        return listadoService.getListadoPlatos(listado);
        //return listadoService.getListadoPlatos(listado);
    }

    @PostMapping("/testPlato")
    public List<Plato> testPlato(@RequestBody List<Plato> listado){
        return listado;
    }
}
