package com.star_wars.Controllers;

import com.star_wars.Entities.Character;
import com.star_wars.Services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    @Qualifier("SearchServiceImpl")
    private ISearchService searchService;

    @PostMapping
    public List<Character> searchCharacter(@RequestBody String nombre){
        return searchService.getByName(nombre);
    }
}
