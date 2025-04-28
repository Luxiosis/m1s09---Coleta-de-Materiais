package br.futurodev.joiville.m1s09exercicios.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "collection_point_materials")
public class CollectionPointMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "collection_point_id", nullable = false)
    private CollectionPoint collectionPoint;

    @ManyToOne
    @JoinColumn(name = "electronic_waste_id", nullable = false)
    private ElectronicWaste electronicWaste;

    @Column(nullable = false)
    private BigDecimal maxCapacity;

}
