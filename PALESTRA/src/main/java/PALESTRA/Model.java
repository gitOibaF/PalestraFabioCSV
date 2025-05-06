package PALESTRA;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Model {
    private Iscritti nuovoI;
    private Abbonamenti nuovoA;
    private LocalDate fine;
    int ID=0;
    private static HashMap<Iscritti, ArrayList<Abbonamenti>> Elenco; //statica   //getistance  
    private ArrayList<Abbonamenti> ListaAbb;
    private static Model model = null;
    private CSVmanager csv;

    private Model(){
        this.Elenco= new HashMap<>();
        nuovoI = new Iscritti("", "", ""); // Valori di default
        nuovoA = new Abbonamenti("", LocalDate.now(), LocalDate.now());
        fine = LocalDate.of(1,1, 1);
        csv = new CSVmanager();
        LetturaCSV();
    }
    
    public static Model getIstance(){
        if(model==null){
            model = new Model();
        }
        return model;
    }
    
    
    public Abbonamenti CalcoloDurataAbbonamenti(String abbonamento, LocalDate inizio){
        if(abbonamento.equals("mensile")){
           this.fine = inizio.plusMonths(1);
        }
        else if(abbonamento.equals("annuale")){
           this.fine = inizio.plusYears(1);
        }
        return new Abbonamenti(abbonamento, inizio, fine);
    }
    

    public boolean AddIscritto(String nome, String cognome, String codice){
        
        for(Map.Entry<Iscritti, ArrayList<Abbonamenti>> entry : Elenco.entrySet()){
            if(entry.getKey().codiceFiscale.equals(codice)){
                return false;
            }
        }
        nuovoI = new Iscritti(nome,cognome,codice);
        ListaAbb= new ArrayList();
        Elenco.put(nuovoI,ListaAbb);
        ScritturaCSV();
       return true;
    }
    
    
    public boolean AddAbbonamento(String codice, String abbonamento, LocalDate inizio){ 
        Abbonamenti nuovoA = CalcoloDurataAbbonamenti(abbonamento, inizio);
        
        for(Map.Entry<Iscritti, ArrayList<Abbonamenti>> entry : Elenco.entrySet()){
            if(entry.getKey().codiceFiscale.equals(codice)){
                entry.getValue().add(nuovoA);
                ScritturaCSV();
                return true;
            }
        }
        
        return false;    
    }
    
    public ArrayList<Abbonamenti> Search(String codice){
        Elenco=LetturaCSV();
        
        if (Elenco == null || Elenco.isEmpty()) { 
        return new ArrayList<>();
        }
        
        for(Map.Entry<Iscritti, ArrayList<Abbonamenti>> entry : Elenco.entrySet()){
            if(entry.getKey().codiceFiscale.equals(codice)){
                return entry.getValue();           
            }
        }       
            
        return null;
    }
    
    public void ScritturaCSV(){
        if (Elenco == null) {
            Elenco = new HashMap<>();
        }
            csv.Scrittura(Model.Elenco);
        }

    public HashMap<Iscritti, ArrayList<Abbonamenti>> LetturaCSV(){
        return Elenco=csv.Lettura();
    }
    
//    public  HashMap<Iscritti, ArrayList<Abbonamenti>> getElenco(){
//        return LetturaCSV();
//    }
    
}
