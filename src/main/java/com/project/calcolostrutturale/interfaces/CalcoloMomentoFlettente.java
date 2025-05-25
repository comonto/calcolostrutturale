package com.project.calcolostrutturale.interfaces;

import com.project.calcolostrutturale.enums.TipoVincolo;

public interface CalcoloMomentoFlettente {
    double calcolaMomento(ElementoStrutturale elemento, double caricoDistribuito, double posizione);
    double calcolaMomentoMassimo(ElementoStrutturale elemento, double caricoDistribuito);
    TipoVincolo getTipoVincolo();
}