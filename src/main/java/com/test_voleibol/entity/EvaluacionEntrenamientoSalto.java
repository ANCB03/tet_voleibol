package com.test_voleibol.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "evaluacion_entrenamiento_salto")
public class EvaluacionEntrenamientoSalto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jugador;
    @Column(nullable = false, length = 60)
    private String nombre;

    private float estatura;

    private float peso;

    private float alcance;

    private float pre_test_con;

    private float pre_test_sin;

    private float test_sin;

    private float test_con;

    private float post_test_con;

    private float post_test_sin;
}
