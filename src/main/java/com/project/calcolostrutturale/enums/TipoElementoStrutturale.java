package com.project.calcolostrutturale.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * Enumerator che definisce il tipo di elemento strutturale da considerare
 */
public enum TipoElementoStrutturale {
    TRAVE(0),
    PILASTRO(1),
    NODO(2);

    private final int value;

    TipoElementoStrutturale(int value){
        this.value = value;
    }

    public static TipoElementoStrutturale getEnumFromValue(int value) {
        Optional<TipoElementoStrutturale> first = Arrays.stream(values())
                .filter(tipo -> tipo.value == value)
                .findFirst();
        return first;
    }
}