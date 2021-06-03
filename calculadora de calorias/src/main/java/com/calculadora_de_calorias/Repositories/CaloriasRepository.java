package com.calculadora_de_calorias.Repositories;

import com.calculadora_de_calorias.Entities.IngredienteJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CaloriasRepository implements ICaloriasRepository{

     List<IngredienteJson> ingredientes;

    public CaloriasRepository(){
        this.ingredientes = loadFromDB();
    }

    private static List<IngredienteJson> loadFromDB() {
        List<IngredienteJson> rfm = null;

        File file = null;

        try{
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        var objectMapper = new ObjectMapper();

        try {
            rfm = objectMapper.readValue(file, new TypeReference<List<IngredienteJson>>() {});
        } catch (IOException e){
            e.printStackTrace();
        }

        return rfm;
    }

    @Override
    public IngredienteJson getCaloriasPorIngrediente(String name) throws NoSuchFieldException {
        return this.ingredientes.stream()
                .filter(ingrediente -> ingrediente.getName().equals(name))
                .findFirst().orElseThrow(NoSuchFieldException::new);
    }
}
