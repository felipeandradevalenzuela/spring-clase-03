package com.calculadora_de_calorias.Services;

import com.calculadora_de_calorias.Entities.Ingrediente;
import com.calculadora_de_calorias.Entities.IngredienteJson;
import com.calculadora_de_calorias.Entities.Plato;
import com.calculadora_de_calorias.Repositories.ICaloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CalculateServiceImpl")
@Primary
public class CalculateServiceImpl implements ICalculateService{

    private static Double calorias=0.0;
    private static List<IngredienteJson> listado= new ArrayList();

    @Autowired
    ICaloriasRepository caloriasRepository;

    public String resultadoPlato(Plato plato){
        var caloriasPorPlato = calcularCaloriasPorPlato(plato);
        var caloriasPorIngrediente = calcularCaloriasPorIngrediente();
        var ingredienteMayorCalorias = calcularIngredienteConMasCalorias();

        String resp = "";

        resp = "La totalidad de las calorias en el plato es: "+caloriasPorPlato;
        resp += "\n El listado de ingredientes es:";
        for (IngredienteJson ingrediente : caloriasPorIngrediente) {
            resp += "\n ingrediente: "+ingrediente.getName()+ ", calorias: "+ingrediente.getCalories();
        }

        resp += "\n El ingrediente con mayor cantidad de calorias es: "+ingredienteMayorCalorias.getName();


        return resp;
    }

    @Override
    public Double calcularCaloriasPorPlato(Plato plato) {
        IngredienteJson tmp;
        calorias = 0.0;
        //recorremos los ingredientes del plato
        for (Ingrediente ingrediente : plato.getIngredientes()) {
            try {
                //asignamos el ingrediente como temporal
                tmp = caloriasRepository.getCaloriasPorIngrediente(ingrediente.getNombre());

                //a calorias le sumamos la multiplicación entre el temporal
                // que contiene las calorias y el peso del ingrediente enviado
                calorias += tmp.getCalories() * ingrediente.getPeso();

                //guardamos el ingrediente y sus calorias
                listado.add(new IngredienteJson(ingrediente.getNombre(),tmp.getCalories()* ingrediente.getPeso()));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return calorias;
    }

    @Override
    public List<IngredienteJson> calcularCaloriasPorIngrediente() {
        return listado;
    }

    @Override
    public IngredienteJson calcularIngredienteConMasCalorias() {
        int max = 0;
        double cont = 0.0;
        for (int i = 0; i < listado.size(); i++) {

            if(cont < listado.get(i).getCalories()){
                cont = listado.get(i).getCalories();
                max = i;
            }
        }
        return listado.get(max);
    }

}
