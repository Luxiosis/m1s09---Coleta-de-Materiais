package br.futurodev.joiville.m1s09exercicios.dtos.collectionpoints;

import br.futurodev.joiville.m1s09exercicios.dtos.electronicwastes.ElectronicWasteResponseDto;

import java.math.BigDecimal;

public record CollectionPointMaterialResponseDto(
        Long id,
        ElectronicWasteResponseDto electronicWaste,
        BigDecimal maxCapacity
) {
}
