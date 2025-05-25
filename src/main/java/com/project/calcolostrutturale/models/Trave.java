package com.project.calcolostrutturale.models;

import com.project.calcolostrutturale.interfaces.ElementoStrutturale;

import lombok.Builder;

import com.project.calcolostrutturale.enums.TipoElementoStrutturale;

/**
 * Rappresenta una trave come elemento strutturale.
 * <p>
 * La classe Trave implementa l'interfaccia {@link ElementoStrutturale} e contiene
 * informazioni sulla lunghezza, il materiale e la sezione trasversale della trave.
 * </p>
 *
 * @author [Inserire autore]
 */
@Builder
public class Trave implements ElementoStrutturale {

    private double lunghezza;
    private String materiale; // Aggiunto per rappresentare il materiale della trave
    private double sezione; // Potresti voler aggiungere una sezione trasversale

    public Trave(double lunghezza, String materiale, double sezione) {
        this.lunghezza = lunghezza;
        this.materiale = materiale;
        this.sezione = sezione;
    }

    public TipoElementoStrutturale getTipo() {
        return TipoElementoStrutturale.TRAVE;
    }

    public double getLunghezza() {
        return lunghezza;
    }

}
