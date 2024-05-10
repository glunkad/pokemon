package com.example.pokemon.service;

import com.example.pokemon.dto.PokemonDto;
import com.example.pokemon.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(int pokemonId,ReviewDto reviewDto);
    List<ReviewDto> getReviewsByPokemonId(int id);
    ReviewDto getReviewById(int reviewId, int pokemonId);
    ReviewDto updateReview(int pokemonId, int reviewId,ReviewDto reviewDto);

    void deleteRewview(int pokemonId, int reviewId);
}
