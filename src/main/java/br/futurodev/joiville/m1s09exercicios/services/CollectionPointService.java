package br.futurodev.joiville.m1s09exercicios.services;

import br.futurodev.joiville.m1s09exercicios.dtos.collectionpoints.CollectionPointRequestDto;
import br.futurodev.joiville.m1s09exercicios.dtos.collectionpoints.CollectionPointResponseDto;

import java.util.List;

public interface CollectionPointService {

    List<CollectionPointResponseDto> findAll();
    CollectionPointResponseDto findById(Long id);
    CollectionPointResponseDto create(CollectionPointRequestDto dto);
    CollectionPointResponseDto update(Long id, CollectionPointRequestDto dto);
    List<CollectionPointResponseDto>  findByElectronicWasteName(String name);
    void delete(Long id);

}
