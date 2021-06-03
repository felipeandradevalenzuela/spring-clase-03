package com.star_wars.Repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.star_wars.Entities.Character;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SearchRepository implements ISearchRepository{

    List<Character> personajes;

    public SearchRepository(){
        this.personajes = loadFromDB();
    }

    private static List<Character> loadFromDB(){
        List<Character> rfm = null;

        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e){
            System.out.println("NO EXISTE EL ARCHIVO");
            e.printStackTrace();
        }

        var objectMapper = new ObjectMapper();

        try{
            rfm = objectMapper.readValue(file, new TypeReference<List<Character>>() {});
        } catch (IOException e){
            e.printStackTrace();
        }

        return rfm;
    }

    @Override
    public List<Character> getCharacterByName(String name) throws NoSuchFieldException {
        return this.personajes.stream()
                .filter(personaje -> personaje.getName()
                .contains(name)).collect(Collectors.toList());
    }
}
