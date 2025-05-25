package com.project.calcolostrutturale.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * Enumerator che definisce il tipo di elemento strutturale da considerare.
 */
public enum TipoElementoStrutturale {
    TRAVE(0),
    PILASTRO(1),
    NODO(2);

    private final int value;

    TipoElementoStrutturale(int value){
        this.value = value;
    }

    /**
     * Restituisce il valore intero associato all'enum.
     */
    public int getValue() {
        return value;
    }

    /**
     * Restituisce l'enum corrispondente al valore passato, se presente.
     */
    public static Optional<TipoElementoStrutturale> getEnumFromValue(int value) {
        return Arrays.stream(values())
                .filter(tipo -> tipo.value == value)
                .findFirst();
    }
}