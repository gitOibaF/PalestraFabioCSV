package PALESTRA;

import java.util.ArrayList;
import java.util.HashMap;


public class PresenterStampa {
    
    public HashMap<Iscritti, ArrayList<Abbonamenti>> Elenco(){
        return Model.getIstance().LetturaCSV();
    }
    
   
    
    
    
}
