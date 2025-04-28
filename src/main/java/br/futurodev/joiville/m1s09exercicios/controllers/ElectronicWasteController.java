package br.futurodev.joiville.m1s09exercicios.controllers;

import br.futurodev.joiville.m1s09exercicios.dtos.electronicwastes.ElectronicWasteRequestDto;
import br.futurodev.joiville.m1s09exercicios.dtos.electronicwastes.ElectronicWasteResponseDto;
import br.futurodev.joiville.m1s09exercicios.services.ElectronicWasteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("electronic-wastes")
public class ElectronicWasteController {

    private final ElectronicWasteService service;

    @GetMapping
    public List<ElectronicWasteResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public ElectronicWasteResponseDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ElectronicWasteResponseDto save(@RequestBody ElectronicWasteRequestDto dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public ElectronicWasteResponseDto update(@PathVariable Long id, @RequestBody ElectronicWasteRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
