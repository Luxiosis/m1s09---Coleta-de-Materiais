package br.futurodev.joiville.m1s09exercicios.services;

import br.futurodev.joiville.m1s09exercicios.dtos.electronicwastes.ElectronicWasteRequestDto;
import br.futurodev.joiville.m1s09exercicios.dtos.electronicwastes.ElectronicWasteResponseDto;
import br.futurodev.joiville.m1s09exercicios.errors.exeptions.ElectronicWasteNotFoundException;
import br.futurodev.joiville.m1s09exercicios.entities.ElectronicWaste;
import br.futurodev.joiville.m1s09exercicios.mappers.ElectronicWasteMapper;
import br.futurodev.joiville.m1s09exercicios.repositories.ElectronicWasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectronicWasteServiceImpl implements ElectronicWasteService {

    private final ElectronicWasteRepository repository;

    @Override
    public List<ElectronicWasteResponseDto> findAll() {
        List<ElectronicWaste> entities = repository.findAll();
        return ElectronicWasteMapper.toResponseDtos(entities);
    }

    @Override
    public ElectronicWasteResponseDto findById(Long id) {
        ElectronicWaste entity = findEntityById(id);
        return ElectronicWasteMapper.toResponseDto(entity);
    }

    @Override
    public ElectronicWasteResponseDto create(ElectronicWasteRequestDto dto) {
        ElectronicWaste ew = ElectronicWasteMapper.toEntity(new ElectronicWaste(), dto);
        return ElectronicWasteMapper.toResponseDto(repository.save(ew));
    }

    @Override
    public ElectronicWasteResponseDto update(Long id, ElectronicWasteRequestDto dto) {
        ElectronicWaste ew = findEntityById(id);
        ElectronicWasteMapper.toEntity(ew, dto);
        return ElectronicWasteMapper.toResponseDto(repository.save(ew));
    }

    @Override
    public void delete(Long id) {
        ElectronicWaste ew = findEntityById(id);
        repository.delete(ew);
    }

    @Override
    public ElectronicWaste findEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ElectronicWasteNotFoundException(id));
    }

}
