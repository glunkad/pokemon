package com.example.pokemon.exception;


public class PokemonNotFoundException extends  RuntimeException{
    private static final long serialVersionId = 1;

    public PokemonNotFoundException(String message) {
        super(message);
    }
}
