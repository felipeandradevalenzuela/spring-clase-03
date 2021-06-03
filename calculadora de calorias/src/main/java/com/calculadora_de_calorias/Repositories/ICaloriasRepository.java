package com.calculadora_de_calorias.Repositories;

import com.calculadora_de_calorias.Entities.Ingrediente;
import com.calculadora_de_calorias.Entities.IngredienteJson;

public interface ICaloriasRepository {
     IngredienteJson getCaloriasPorIngrediente(String name) throws NoSuchFieldException;
}
