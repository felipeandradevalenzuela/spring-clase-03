package com.star_wars.Repositories;

import com.star_wars.Entities.Character;

import java.util.List;

public interface ISearchRepository {
        List<Character> getCharacterByName(String name) throws NoSuchFieldException;
}
