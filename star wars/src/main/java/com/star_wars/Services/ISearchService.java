package com.star_wars.Services;

import com.star_wars.Entities.Character;

import java.util.List;

public interface ISearchService {

    List<Character> getByName(String name);
}
