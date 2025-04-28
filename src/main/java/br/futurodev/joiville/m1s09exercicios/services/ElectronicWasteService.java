package br.futurodev.joiville.m1s09exercicios.services;

import br.futurodev.joiville.m1s09exercicios.dtos.electronicwastes.ElectronicWasteRequestDto;
import br.futurodev.joiville.m1s09exercicios.dtos.electronicwastes.ElectronicWasteResponseDto;
import br.futurodev.joiville.m1s09exercicios.entities.ElectronicWaste;

import java.util.List;

public interface ElectronicWasteService {

    List<ElectronicWasteResponseDto> findAll();
    ElectronicWasteResponseDto findById(Long id);
    ElectronicWasteResponseDto create(ElectronicWasteRequestDto dto);
    ElectronicWasteResponseDto update(Long id, ElectronicWasteRequestDto dto);
    void delete(Long id);

    ElectronicWaste findEntityById(Long id);

}
