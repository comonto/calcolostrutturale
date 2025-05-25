package com.project.calcolostrutturale.interfaces;

import com.project.calcolostrutturale.enums.TipoElementoStrutturale;

public interface ElementoStrutturale {

    TipoElementoStrutturale getTipo();
    // Potresti aggiungere metodi per la geometria, materiale, ecc.
    double getLunghezza(); // Aggiunto per le travi
}