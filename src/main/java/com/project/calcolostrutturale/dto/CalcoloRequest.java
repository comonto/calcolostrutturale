package com.project.calcolostrutturale.dto;

import com.project.calcolostrutturale.enums.TipoElementoStrutturale;
import com.project.calcolostrutturale.enums.TipoVincolo;
import lombok.Data;

import java.util.Map;

/**
 * DTO per la richiesta di calcolo.
 */
@Data
public class CalcoloRequest {
    private TipoElementoStrutturale tipoElemento;
    private Map<String, Object> parametriElemento; // Es: {"lunghezza": 5.0, "materiale": "Acciaio", "sezione": "IPE200"}
    private TipoVincolo tipoVincolo;
    private double caricoDistribuito;
    private double posizione; // Solo per il calcolo in una posizione specifica
}