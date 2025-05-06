package PALESTRA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BoxLayout;


public class Stampa extends javax.swing.JPanel {

    private HashMap<Iscritti, ArrayList<Abbonamenti>> elenco = new HashMap<>();
    private PresenterStampa PS = new PresenterStampa();
    
    
    public Stampa() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Layout verticale
    }
    
    
    private void stampa() {
    elenco = PS.Elenco(); 
    
    if(elenco==null){
       jLabel1.setText("Nessun abbonamento presente");
       return;
    }
    else if (elenco.isEmpty()) {
        jLabel1.setText("Nessun abbonamento presente");
        return;
    } else {
        StringBuilder testo = new StringBuilder("<html>");
        for (Map.Entry<Iscritti, ArrayList<Abbonamenti>> entry : elenco.entrySet()) {
            
            testo.append(entry.getKey().nome).append(" ").append(entry.getKey().cognome).append(" (").append(entry.getKey().codiceFiscale).append(")");

            for (int i = 0; i < entry.getValue().size(); i++) {
                testo.append(entry.getValue().get(i).toString());
                if (i < entry.getValue().size() - 1) {
                    testo.append(", ");
                }
            }
            testo.append(")<br>");
        }
        testo.append("</html>");

        jLabel1.setText(testo.toString());
    }
    revalidate(); // Aggiorna il layout
    repaint(); // Ridisegna il pannello
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("STORICO DEGLI ISCRITTI ALLA PALESTRA"));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setViewportView(jLabel1);

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setText("STAMPA STORICO DEGLI ISCRITTI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      stampa();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}





