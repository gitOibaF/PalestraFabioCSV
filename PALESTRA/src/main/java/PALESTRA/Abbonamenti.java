package PALESTRA;

import java.time.LocalDate;


public class Abbonamenti {
    String tipo;
    LocalDate dataInizio;
    LocalDate dataFine;

    public Abbonamenti(String tipo, LocalDate inizio, LocalDate fine){
        this.tipo=tipo;
        this.dataInizio=inizio;
        this.dataFine=fine;
    }

    public Abbonamenti(String tipo, String inizio, String fine){
        this.tipo=tipo;
        this.dataInizio = LocalDate.parse(inizio.trim());
        this.dataFine = LocalDate.parse(fine.trim());
    }
    
    @Override
    public String toString() {
        if(tipo == null || dataInizio==null || dataFine==null) return " null";
            return "Tipo abbonamento: " + tipo + " | Inizio: " + dataInizio + " | Fine: " + dataFine;
        }

    public String getTipo(){
        return tipo;
    }
    
    public LocalDate getDataInizio(){
        return dataInizio;
    }
       
    public LocalDate getDataFine(){
        return dataFine;
    }
    
    public static Abbonamenti parseAbbonamento(String s) {
    String[] parts = s.split(";");
    if(parts.length >= 3) {
        String tipo = parts[0];
        LocalDate inizio = LocalDate.parse(parts[1]);
        LocalDate fine = LocalDate.parse(parts[2]);
        return new Abbonamenti(tipo, inizio, fine);
    }
    return null;
}

}