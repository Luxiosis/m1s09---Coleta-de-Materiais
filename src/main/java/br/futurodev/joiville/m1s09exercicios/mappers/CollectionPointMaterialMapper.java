package br.futurodev.joiville.m1s09exercicios.mappers;

import br.futurodev.joiville.m1s09exercicios.dtos.collectionpoints.CollectionPointMaterialResponseDto;
import br.futurodev.joiville.m1s09exercicios.entities.CollectionPointMaterial;

import java.util.List;

public class CollectionPointMaterialMapper {

    private CollectionPointMaterialMapper() {}

    public static CollectionPointMaterialResponseDto toResponseDto(CollectionPointMaterial entity) {
        return new CollectionPointMaterialResponseDto(
                entity.getId(),
                ElectronicWasteMapper.toResponseDto(entity.getElectronicWaste()),
                entity.getMaxCapacity()
        );
    }

    public static List<CollectionPointMaterialResponseDto> toResponseDtos(List<CollectionPointMaterial> entities) {
        return entities.stream().map(CollectionPointMaterialMapper::toResponseDto).toList();
    }

}
