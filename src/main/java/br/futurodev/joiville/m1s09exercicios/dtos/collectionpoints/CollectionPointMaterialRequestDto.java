package br.futurodev.joiville.m1s09exercicios.dtos.collectionpoints;

import java.math.BigDecimal;

public record CollectionPointMaterialRequestDto(
        Long electronicWasteId,
        BigDecimal maxCapacity
) {
}
