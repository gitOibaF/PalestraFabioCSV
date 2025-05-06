package PALESTRA;

import java.util.ArrayList;


public class PresenterCerca {
    
    ArrayList risultato;
    
    public ArrayList<Abbonamenti> search(String codice){
        return risultato=Model.getIstance().Search(codice);
      }
    
    
    
    
}
