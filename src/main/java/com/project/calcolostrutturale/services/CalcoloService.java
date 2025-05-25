package com.project.calcolostrutturale.services;

import com.project.calcolostrutturale.enums.TipoElementoStrutturale;
import com.project.calcolostrutturale.enums.TipoVincolo;
import com.project.calcolostrutturale.interfaces.CalcoloMomentoFlettente;
import com.project.calcolostrutturale.interfaces.ElementoStrutturale;
import com.project.calcolostrutturale.models.Trave; // Necessario per il casting
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalcoloService {

    private final ElementoStrutturaleFactory factory;

    public CalcoloService(ElementoStrutturaleFactory factory) {
        this.factory = factory;
    }

    public double calcolaMomentoFlettente(TipoElementoStrutturale tipoElemento, Map<String, Object> parametriElemento, TipoVincolo tipoVincolo, double caricoDistribuito, double posizione) {
        ElementoStrutturale elemento = factory.creaElemento(tipoElemento, parametriElemento);
        CalcoloMomentoFlettente strategia = factory.creaCalcoloStrategy(tipoVincolo);

        // Verifica che l'elemento sia una Trave per i calcoli del momento flettente
        if (!(elemento instanceof Trave)) {
            throw new IllegalArgumentException("Il calcolo del momento flettente è applicabile solo a elementi di tipo TRAVE.");
        }

        return strategia.calcolaMomento(elemento, caricoDistribuito, posizione);
    }

    public double calcolaMomentoFlettenteMassimo(TipoElementoStrutturale tipoElemento, Map<String, Object> parametriElemento, TipoVincolo tipoVincolo, double caricoDistribuito) {
        ElementoStrutturale elemento = factory.creaElemento(tipoElemento, parametriElemento);
        CalcoloMomentoFlettente strategia = factory.creaCalcoloStrategy(tipoVincolo);

        if (!(elemento instanceof Trave)) {
            throw new IllegalArgumentException("Il calcolo del momento flettente massimo è applicabile solo a elementi di tipo TRAVE.");
        }

        return strategia.calcolaMomentoMassimo(elemento, caricoDistribuito);
    }
}