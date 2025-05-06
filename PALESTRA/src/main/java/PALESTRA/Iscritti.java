package PALESTRA;

import java.util.Objects;


public class Iscritti {
    String nome;
    String cognome;
    String codiceFiscale;
    
    public Iscritti(String nome,String cognome, String codiceFiscale){
        this.nome=nome;
        this.cognome=cognome;
        this.codiceFiscale=codiceFiscale;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Iscritti iscritti = (Iscritti) obj;
        return codiceFiscale.equals(iscritti.codiceFiscale) && nome.equals(iscritti.nome) && cognome.equals(iscritti.cognome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, codiceFiscale);
    }
    
    @Override
    public String toString() {
       return nome + " " + cognome + " (Codice: " + codiceFiscale + ")";
    }

    public static Iscritti parseIscritto(String s) {
    String[] parts = s.split(" ");
    if(parts.length >= 3) {
        String nome = parts[0];
        String cognome = parts[1];
        String codiceFiscale = parts[2];
        return new Iscritti(nome, cognome, codiceFiscale);
    }
    return null;
    }
    
    
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
}
