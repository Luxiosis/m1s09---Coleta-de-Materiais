package br.futurodev.joiville.m1s09exercicios.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "collection_points")
public class CollectionPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String collectionPeriod;

    @OneToMany(mappedBy = "collectionPoint", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CollectionPointMaterial> materials = new ArrayList<>();

}
