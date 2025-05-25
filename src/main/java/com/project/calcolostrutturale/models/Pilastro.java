package com.project.calcolostrutturale.models;

import com.project.calcolostrutturale.enums.TipoElementoStrutturale;
import com.project.calcolostrutturale.interfaces.ElementoStrutturale;

import lombok.Builder;

@Builder
public class Pilastro implements ElementoStrutturale {

    private double lunghezza;
    private String materiale;
    private Double sezione; // Potresti voler aggiungere una sezione trasversale

    public Pilastro(double lunghezza, String materiale, Double sezione) {
        if (lunghezza <= 0) {
            throw new IllegalArgumentException("La lunghezza del pilastro deve essere maggiore di zero.");
        }               
        this.lunghezza = lunghezza;
        this.materiale = materiale;
        this.sezione = sezione;
    }

    @Override
    public TipoElementoStrutturale getTipo() {
        return TipoElementoStrutturale.PILASTRO;
    }

    @Override
    public double getLunghezza() {
        return lunghezza;
    }
}