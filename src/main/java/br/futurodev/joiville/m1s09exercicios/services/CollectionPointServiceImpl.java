package br.futurodev.joiville.m1s09exercicios.services;

import br.futurodev.joiville.m1s09exercicios.dtos.collectionpoints.CollectionPointMaterialRequestDto;
import br.futurodev.joiville.m1s09exercicios.dtos.collectionpoints.CollectionPointRequestDto;
import br.futurodev.joiville.m1s09exercicios.dtos.collectionpoints.CollectionPointResponseDto;
import br.futurodev.joiville.m1s09exercicios.errors.exeptions.CollectionPointNotFoundException;
import br.futurodev.joiville.m1s09exercicios.entities.CollectionPoint;
import br.futurodev.joiville.m1s09exercicios.entities.CollectionPointMaterial;
import br.futurodev.joiville.m1s09exercicios.entities.ElectronicWaste;
import br.futurodev.joiville.m1s09exercicios.mappers.CollectionPointMapper;
import br.futurodev.joiville.m1s09exercicios.repositories.CollectionPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectionPointServiceImpl implements CollectionPointService {

    private final CollectionPointRepository repository;
    private final ElectronicWasteService electronicWasteService;

    @Override
    public List<CollectionPointResponseDto> findAll() {
        List<CollectionPoint> entities = repository.findAll();
        return CollectionPointMapper.toResponseDtos(entities);
    }

    @Override
    public List<CollectionPointResponseDto> findByElectronicWasteName(String name) {
        List<CollectionPoint> entities = repository.findByElectronicWasteName(name);
        return CollectionPointMapper.toResponseDtos(entities);
    }

    @Override
    public CollectionPointResponseDto findById(Long id) {
        CollectionPoint entity = findEntityById(id);
        return CollectionPointMapper.toResponseDto(entity);
    }

    @Override
    public CollectionPointResponseDto create(CollectionPointRequestDto dto) {
        return save(new CollectionPoint(), dto);
    }

    @Override
    public CollectionPointResponseDto update(Long id, CollectionPointRequestDto dto) {
        CollectionPoint cp = findEntityById(id);
        return save(cp, dto);
    }

    @Override
    public void delete(Long id) {
        CollectionPoint cp = findEntityById(id);
        repository.delete(cp);
    }

    private CollectionPoint findEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CollectionPointNotFoundException(id));
    }

    private CollectionPointResponseDto save(CollectionPoint cp, CollectionPointRequestDto dto) {
        CollectionPointMapper.toEntity(cp, dto);

        for (CollectionPointMaterialRequestDto materialDto : dto.materials()) {
            CollectionPointMaterial material = new CollectionPointMaterial();
            material.setCollectionPoint(cp);
            material.setMaxCapacity(materialDto.maxCapacity());

            ElectronicWaste ew = electronicWasteService.findEntityById(materialDto.electronicWasteId());
            material.setElectronicWaste(ew);

            cp.getMaterials().add(material);
        }
        return CollectionPointMapper.toResponseDto(repository.save(cp));
    }
}
