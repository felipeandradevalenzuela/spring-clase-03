package com.calculadora_de_calorias.DTO;

import com.calculadora_de_calorias.Entities.IngredienteJson;
import lombok.*;

import java.util.List;
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    Double totalCalorias;
    List<IngredienteJson> ingredientes;
    String ingredienteConMayorCalorias;
}
