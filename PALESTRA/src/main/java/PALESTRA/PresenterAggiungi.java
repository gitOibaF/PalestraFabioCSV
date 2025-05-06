package PALESTRA;

import java.time.LocalDate;


public class PresenterAggiungi {

    LocalDate inizio;

    
    public boolean addI(String nome, String cognome,String codice) {
       return Model.getIstance().AddIscritto(nome, cognome, codice);
    }
 
    public boolean addA(String abbonamento, String codice) {
       return Model.getIstance().AddAbbonamento(codice,abbonamento,inizio);
    }
}
