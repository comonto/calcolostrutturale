package com.project.calcolostrutturale.controllers;

import com.project.calcolostrutturale.dto.CalcoloRequest;
import com.project.calcolostrutturale.services.CalcoloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcolo")
public class CalcoloController {

    private final CalcoloService calcoloService;

    public CalcoloController(CalcoloService calcoloService) {
        this.calcoloService = calcoloService;
    }

    @PostMapping("/momento-flettente")
    public ResponseEntity<Double> getMomentoFlettente(@RequestBody CalcoloRequest request) {
        try {
            double momento = calcoloService.calcolaMomentoFlettente(
                    request.getTipoElemento(),
                    request.getParametriElemento(),
                    request.getTipoVincolo(),
                    request.getCaricoDistribuito(),
                    request.getPosizione()
            );
            return ResponseEntity.ok(momento);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // O un messaggio di errore più dettagliato
        }
    }

    @PostMapping("/momento-flettente-massimo")
    public ResponseEntity<Double> getMomentoFlettenteMassimo(@RequestBody CalcoloRequest request) {
        try {
            double momentoMax = calcoloService.calcolaMomentoFlettenteMassimo(
                    request.getTipoElemento(),
                    request.getParametriElemento(),
                    request.getTipoVincolo(),
                    request.getCaricoDistribuito()
            );
            return ResponseEntity.ok(momentoMax);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null); // O un messaggio di errore più dettagliato
        }
    }
}