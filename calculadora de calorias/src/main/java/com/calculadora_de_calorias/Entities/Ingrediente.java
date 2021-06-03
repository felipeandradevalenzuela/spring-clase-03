package com.calculadora_de_calorias.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingrediente {
    String nombre;
    Double peso;
}
