package com.calculadora_de_calorias.Services;

import com.calculadora_de_calorias.DTO.PlatoDTO;
import com.calculadora_de_calorias.Entities.Plato;

import java.util.ArrayList;
import java.util.List;

public interface IListadoService {
    ArrayList<PlatoDTO> getListadoPlatos(List<Plato> listado);
}
