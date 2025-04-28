package br.futurodev.joiville.m1s09exercicios.repositories;

import br.futurodev.joiville.m1s09exercicios.entities.CollectionPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollectionPointRepository extends JpaRepository<CollectionPoint, Long> {

    @Query(value = "select distinct c.* from collection_points c\n" +
            "INNER JOIN collection_point_materials p\n" +
            "ON p.collection_point_id = c.id\n" +
            "inner join electronic_waste e\n" +
            "on p.electronic_waste_id = e.id\n" +
            "AND UPPER(e.description) LIKE '%'||UPPER(:name)||'%'", nativeQuery = true)
    public List<CollectionPoint> findByElectronicWasteName(String name);
}
