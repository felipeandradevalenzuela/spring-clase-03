package com.calculadora_de_calorias.Services;

import com.calculadora_de_calorias.DTO.PlatoDTO;
import com.calculadora_de_calorias.Entities.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ListadoServiceImpl")
public class ListadoServiceImpl  implements IListadoService{

    @Autowired
    private ICalculateService calculateService;

    @Override
    public ArrayList<PlatoDTO> getListadoPlatos(List<Plato> listado) {
        var tmp = new ArrayList<PlatoDTO>();
        for (Plato plato : listado) {
            PlatoDTO tmpDTO = new PlatoDTO();
            tmpDTO = calculateService.resultadoPlato(plato);
            tmp.add(tmpDTO);

        }
        return tmp;
    }
}
