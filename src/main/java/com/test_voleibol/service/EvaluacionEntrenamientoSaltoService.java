package com.test_voleibol.service;

import com.test_voleibol.dto.ResultadosDto;
import com.test_voleibol.entity.EvaluacionEntrenamientoSalto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EvaluacionEntrenamientoSaltoService {

    public List<EvaluacionEntrenamientoSalto> listarDeportistas();

    public void guardar(EvaluacionEntrenamientoSalto evaluacionEntrenamientoSalto);

    public void eliminar(int id_jugador);

    public EvaluacionEntrenamientoSalto encontrarJugador(int id_jugador);

    public ResultadosDto ResultadoEntrenamiento();
}
