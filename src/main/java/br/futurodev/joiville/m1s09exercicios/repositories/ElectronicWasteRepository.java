package br.futurodev.joiville.m1s09exercicios.repositories;

import br.futurodev.joiville.m1s09exercicios.entities.ElectronicWaste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectronicWasteRepository extends JpaRepository<ElectronicWaste, Long> {
}
