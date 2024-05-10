package com.example.pokemon.service;

import com.example.pokemon.dto.PokemonDto;
import com.example.pokemon.dto.PokemonResponse;

public interface PokemonService {

    PokemonDto createPokemon(PokemonDto pokemonDto);
    PokemonResponse getAllPokemons(int pageNo, int PageSize);
    PokemonDto getPokemonById(int id);
    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);

    void deletePokemon(int id);
}
