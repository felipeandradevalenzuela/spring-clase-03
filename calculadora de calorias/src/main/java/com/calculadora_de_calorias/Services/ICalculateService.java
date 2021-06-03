package com.calculadora_de_calorias.Services;

import com.calculadora_de_calorias.DTO.PlatoDTO;
import com.calculadora_de_calorias.Entities.IngredienteJson;
import com.calculadora_de_calorias.Entities.Plato;

import java.util.List;

public interface ICalculateService {
    PlatoDTO resultadoPlato(Plato plato);
    Double calcularCaloriasPorPlato(Plato plato);
    List<IngredienteJson> calcularCaloriasPorIngrediente();
    IngredienteJson calcularIngredienteConMasCalorias();
}
