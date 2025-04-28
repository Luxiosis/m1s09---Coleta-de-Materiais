package br.futurodev.joiville.m1s09exercicios.dtos.collectionpoints;

import java.util.List;

public record CollectionPointResponseDto(
        Long id,
        String name,
        String address,
        String collectionPeriod,
        List<CollectionPointMaterialResponseDto> materials
) {
}
