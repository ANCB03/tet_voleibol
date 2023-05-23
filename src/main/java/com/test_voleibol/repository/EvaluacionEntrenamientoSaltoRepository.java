package com.test_voleibol.repository;

import com.test_voleibol.entity.EvaluacionEntrenamientoSalto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionEntrenamientoSaltoRepository extends JpaRepository<EvaluacionEntrenamientoSalto, Integer> {
    @Query(
            value = "SELECT * FROM evaluacion_entrenamiento_salto e where e.post_test_sin>e.test_sin and e.post_test_con>e.test_con",
            nativeQuery=true
    )
    List<EvaluacionEntrenamientoSalto> findJugadoresByResultados();
}
