package com.test_voleibol.implement;

import com.test_voleibol.dto.ResultadosDto;
import com.test_voleibol.entity.EvaluacionEntrenamientoSalto;
import com.test_voleibol.repository.EvaluacionEntrenamientoSaltoRepository;
import com.test_voleibol.service.EvaluacionEntrenamientoSaltoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EvaluacionEntrenamientoSaltoImplement implements EvaluacionEntrenamientoSaltoService {

    @Autowired
    private EvaluacionEntrenamientoSaltoRepository evaluacionEntrenamientoSaltoRepository;
    @Override
    public List<EvaluacionEntrenamientoSalto> listarDeportistas() {
        return evaluacionEntrenamientoSaltoRepository.findAll();
    }

    @Override
    public void guardar(EvaluacionEntrenamientoSalto evaluacionEntrenamientoSalto) {
        evaluacionEntrenamientoSaltoRepository.save(evaluacionEntrenamientoSalto);
    }

    @Override
    public void eliminar(int id_jugador) {
        if(evaluacionEntrenamientoSaltoRepository.findById(id_jugador).isPresent()){
            evaluacionEntrenamientoSaltoRepository.deleteById(id_jugador);
        }else{
            throw new RuntimeException("No se encuentra el jugador");
        }
    }


    @Override
    public EvaluacionEntrenamientoSalto encontrarJugador(int id_jugador) {
        EvaluacionEntrenamientoSalto entrenamientoSalto = evaluacionEntrenamientoSaltoRepository.findById(id_jugador).get();
        if(entrenamientoSalto != null){
            return entrenamientoSalto;
        }else{
            throw new RuntimeException("No se encuentra el jugador");
        }
    }

    @Override
    public ResultadosDto ResultadoEntrenamiento() {
        List<EvaluacionEntrenamientoSalto> jugadores = evaluacionEntrenamientoSaltoRepository.findJugadoresByResultados();
        int numeroJugadores = jugadores.size();
        int totalJugadores = evaluacionEntrenamientoSaltoRepository.findAll().size();
        ResultadosDto resultado = new ResultadosDto();
        if((numeroJugadores*100)/totalJugadores >= 80){
            resultado.setConteoDeportistas(numeroJugadores);
            resultado.setMensaje("Plan de entrenamiento fue exitoso");
            return  resultado;
        }else{
            resultado.setConteoDeportistas(numeroJugadores);
            resultado.setMensaje("Se debe plantear otro plan de entrenamiento para mejorar el salto");
            return resultado;
        }
    }
}
