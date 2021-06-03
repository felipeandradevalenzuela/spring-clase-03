package com.calculadora_de_calorias.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Plato {
    String nombre;
    List<Ingrediente> ingredientes;
}
