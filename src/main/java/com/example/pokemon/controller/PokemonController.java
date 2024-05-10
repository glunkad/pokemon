package com.example.pokemon.controller;

import com.example.pokemon.dto.PokemonDto;
import com.example.pokemon.dto.PokemonResponse;
import com.example.pokemon.model.Pokemon;
import com.example.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PokemonController {
    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }


    @GetMapping("pokemon")
    public ResponseEntity<PokemonResponse> getAllPokemons(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
        ) {
        return new ResponseEntity<>(pokemonService.getAllPokemons(pageNo,pageSize), HttpStatus.OK);
    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<PokemonDto> pokemonDetail(
            @PathVariable int id
    ) {
        return  ResponseEntity.ok(pokemonService.getPokemonById(id));
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> createPokemon(
            @RequestBody PokemonDto pokemonDto
    ) {

        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<PokemonDto> updatePokemon(
            @RequestBody PokemonDto pokemonDto,
            @PathVariable("id") int pokemonId
    ) {
        PokemonDto response = pokemonService.updatePokemon(pokemonDto,pokemonId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(
            @PathVariable("id") int pokemonId
    ) {
        pokemonService.deletePokemon(pokemonId);
        return new ResponseEntity<>("Pokemon deleted", HttpStatus.OK);
    }

}
