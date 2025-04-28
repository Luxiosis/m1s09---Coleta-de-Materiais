package br.futurodev.joiville.m1s09exercicios.dtos.collectionpoints;

import java.util.List;

public record CollectionPointRequestDto(
        String name,
        String address,
        String collectionPeriod,
        List<CollectionPointMaterialRequestDto> materials
) {
}
