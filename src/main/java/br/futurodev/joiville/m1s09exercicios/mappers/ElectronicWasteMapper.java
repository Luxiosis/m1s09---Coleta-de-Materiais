package br.futurodev.joiville.m1s09exercicios.mappers;

import br.futurodev.joiville.m1s09exercicios.dtos.electronicwastes.ElectronicWasteRequestDto;
import br.futurodev.joiville.m1s09exercicios.dtos.electronicwastes.ElectronicWasteResponseDto;
import br.futurodev.joiville.m1s09exercicios.entities.ElectronicWaste;

import java.util.List;

public class ElectronicWasteMapper {

    private ElectronicWasteMapper() {}

    public static ElectronicWaste toEntity(ElectronicWaste entity, ElectronicWasteRequestDto dto) {
        entity.setType(dto.type());
        entity.setDescription(dto.description());
        return entity;
    }

    public static ElectronicWasteResponseDto toResponseDto(ElectronicWaste entity) {
        return new ElectronicWasteResponseDto(
                entity.getId(),
                entity.getType(),
                entity.getDescription()
        );
    }

    public static List<ElectronicWasteResponseDto> toResponseDtos(List<ElectronicWaste> entities) {
        return entities.stream().map(ElectronicWasteMapper::toResponseDto).toList();
    }

}
