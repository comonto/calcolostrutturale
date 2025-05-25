package com.project.calcolostrutturale.services;

import com.project.calcolostrutturale.enums.TipoElementoStrutturale;
import com.project.calcolostrutturale.enums.TipoVincolo;
import com.project.calcolostrutturale.interfaces.CalcoloMomentoFlettente;
import com.project.calcolostrutturale.interfaces.ElementoStrutturale;
import com.project.calcolostrutturale.models.Pilastro;
import com.project.calcolostrutturale.models.Trave;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@Service
public class ElementoStrutturaleFactory {

    private final Map<TipoElementoStrutturale, BiFunction<Map<String, Object>, TipoElementoStrutturale, ElementoStrutturale>> elementoCreators = new HashMap<>();
    private final Map<TipoVincolo, Supplier<CalcoloMomentoFlettente>> calcoloStrategyCreators = new HashMap<>();

    // Spring inietta tutte le implementazioni di CalcoloMomentoFlettente
    @Autowired
    private List<CalcoloMomentoFlettente> calcoloStrategies;

    @PostConstruct // Questo metodo viene eseguito dopo che le dipendenze sono state iniettate
    public void init() {
        // Registrazione dei creatori di elementi
        elementoCreators.put(TipoElementoStrutturale.TRAVE, (params, tipo) ->
                Trave.builder()
                        .lunghezza((Double) params.get("lunghezza"))
                        .materiale((String) params.get("materiale"))
                        .sezione((Double) params.get("sezione"))
                        .build());
        elementoCreators.put(TipoElementoStrutturale.PILASTRO, (params, tipo) ->
                Pilastro.builder()
                        .lunghezza((Double) params.get("lunghezza"))
                        .materiale((String) params.get("materiale"))
                        .sezione((Double) params.get("sezione"))
                        .build());
        // Aggiungi qui altri elementi

        // Registrazione delle strategie di calcolo usando l'enum TipoVincolo
        // Iteriamo sulle strategie iniettate e le registriamo nella mappa
        for (CalcoloMomentoFlettente strategy : calcoloStrategies) {
            calcoloStrategyCreators.put(strategy.getTipoVincolo(), () -> strategy);
        }
    }

    public ElementoStrutturale creaElemento(TipoElementoStrutturale tipo, Map<String, Object> parametri) {
        BiFunction<Map<String, Object>, TipoElementoStrutturale, ElementoStrutturale> creator = elementoCreators.get(tipo);
        if (creator == null) {
            throw new IllegalArgumentException("Tipo di elemento sconosciuto: " + tipo);
        }
        return creator.apply(parametri, tipo);
    }

    public CalcoloMomentoFlettente creaCalcoloStrategy(TipoVincolo tipoVincolo) {
        Supplier<CalcoloMomentoFlettente> creator = calcoloStrategyCreators.get(tipoVincolo);
        if (creator == null) {
            throw new IllegalArgumentException("Tipo di vincolo sconosciuto: " + tipoVincolo);
        }
        return creator.get();
    }
}