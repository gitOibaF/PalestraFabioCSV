package PALESTRA;

import java.io.*;
import java.util.*;

public class CSVmanager {

    public void Scrittura(HashMap<Iscritti, ArrayList<Abbonamenti>> elenco) {
        try (FileWriter writer = new FileWriter("CSV.csv", true);
             BufferedWriter bw = new BufferedWriter(writer)) { 

            for (Map.Entry<Iscritti, ArrayList<Abbonamenti>> entry : elenco.entrySet()) {
                bw.append(entry.getKey().toString());
                for (Abbonamenti abbonamento : entry.getValue()) {
                    bw.append(",").append(abbonamento.toString());
                }
                bw.append("\n");
            }
            System.out.println("File CSV aggiornato con successo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Iscritti, ArrayList<Abbonamenti>> Lettura() {
        HashMap<Iscritti, ArrayList<Abbonamenti>> elenco = new HashMap<>();
        File file = new File("CSV.csv");

        if (!file.exists()) return elenco;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                if(line.isEmpty()) continue;

                String[] dati = line.split(",");
                
                if (dati.length < 3) {
                    System.out.println("Riga CSV con dati iscritto insufficienti: " + Arrays.toString(dati));
                    continue;
                }
                
                Iscritti iscritto = new Iscritti(dati[0], dati[1], dati[2]);
                ArrayList<Abbonamenti> listaAbbonamenti = new ArrayList<>();

                for (int i = 3; i < dati.length; i += 3) {
                    if (i + 2 < dati.length) {  
                        listaAbbonamenti.add(new Abbonamenti(dati[i], dati[i + 1], dati[i + 2]));
                    } else {
                        System.out.println("Riga CSV con dati abbonamento insufficienti: " + Arrays.toString(dati));
                    }
                }

                elenco.put(iscritto, listaAbbonamenti);
            }
            System.out.println("File CSV letto con successo.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return elenco;
    }
}
