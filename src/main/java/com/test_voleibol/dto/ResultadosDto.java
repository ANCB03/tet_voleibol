package com.test_voleibol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultadosDto {
    private int conteoDeportistas;

    private String mensaje;
}
