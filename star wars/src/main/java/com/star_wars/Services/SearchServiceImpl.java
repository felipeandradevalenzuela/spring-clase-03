package com.star_wars.Services;

import com.star_wars.Entities.Character;
import com.star_wars.Repositories.ISearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("SearchServiceImpl")
@Primary
public class SearchServiceImpl implements ISearchService{

    @Autowired
    ISearchRepository searchRepository;

    @Override
    public List<Character> getByName(String name) {
        List<Character> personajes = null;
        try {
            personajes = searchRepository.getCharacterByName(name);
            System.out.println(personajes.toString());
        }catch ( NoSuchFieldException e) {
            e.printStackTrace();
        }
        return personajes;
    }
}
