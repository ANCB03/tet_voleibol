package com.test_voleibol.controller;

import com.test_voleibol.dto.ResultadosDto;
import com.test_voleibol.entity.EvaluacionEntrenamientoSalto;
import com.test_voleibol.service.EvaluacionEntrenamientoSaltoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class EvaluacionEntrenamientoSaltoController {
    @Autowired
    private EvaluacionEntrenamientoSaltoService evaluacionEntrenamientoSaltoService;

    @GetMapping("/all")
    public List<EvaluacionEntrenamientoSalto> listarJugadores(){
        return evaluacionEntrenamientoSaltoService.listarDeportistas();
    }

    @PostMapping("/guardar")
    public void guardarJugador(@RequestBody EvaluacionEntrenamientoSalto evaluacionEntrenamientoSalto){
        evaluacionEntrenamientoSaltoService.guardar(evaluacionEntrenamientoSalto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarArea(@PathVariable int id) {
        evaluacionEntrenamientoSaltoService.eliminar(id);
    }

    @GetMapping("/{id}")
    public EvaluacionEntrenamientoSalto obtenerArea(@PathVariable int id) {
        return evaluacionEntrenamientoSaltoService.encontrarJugador(id);
    }

    @GetMapping("/resultado")
    public ResultadosDto resultados(){
        return evaluacionEntrenamientoSaltoService.ResultadoEntrenamiento();
    }
}
