
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BusLot.java
 *
 * Created on May 5, 2014, 9:44:08 AM
 */
/**
 *
 * @author S500900
 */
public class BusLot extends javax.swing.JFrame {

    ArrayList<Integer> usedSpots;
    int[] possibleSpaces;

    /** Creates new form BusLot */
    public BusLot() throws IOException {
        initComponents();
        this.setResizable(false);
        this.setTitle("KO Parking Spots Program");
        File database = new File("ParkingSpots.accdb");
        Database db = DatabaseBuilder.open(database);
        Table busLot = db.getTable("Bus Lot");
        usedSpots = new ArrayList<Integer>();
        for (Row r : busLot) {
            Object val = r.get("Parking Spot");
            String h = val.toString();
            Integer yo = Integer.parseInt(h);
            if (!usedSpots.contains(yo)) {
                usedSpots.add(yo);
            }
            updateSpots();
        }
        

    }

    public Map<String, Person> createMap(Person[] students, int[] possible_spaces) {
        Map<String, Person> ordered = new TreeMap<String, Person>();
        for (Person a : students) {
            ordered.put(a.last_name + ", " + a.first_name, a);
        }
        for (Map.Entry<String, Person> val : ordered.entrySet()) {
            Random gen = new Random();
            int num = gen.nextInt(possible_spaces.length);
            num = possible_spaces[num];
            val.getValue().setParkingSpaceNumber(num);
            usedSpots.add(num);
            updateSpots();
        }
        return ordered;
    }

    public void assignSpot(Person student) {
        Random gen = new Random();
        int num = gen.nextInt(possibleSpaces.length);
        num = possibleSpaces[num];
        student.setParkingSpaceNumber(num);
        usedSpots.add(num);
        updateSpots();
    }

    private void updateSpots() {
        int[] possible_spaces = new int[92 - usedSpots.size()];
        int index = 0;
        for (int i = 1; i < 93; i++) {
            if (!usedSpots.contains(i)) {
                possible_spaces[index] = i;
                index++;
            }
        }
        possibleSpaces = possible_spaces;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addSpot = new javax.swing.JButton();
        getSpot = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        HomeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addSpot.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        addSpot.setText("Assign New Spot");
        addSpot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSpotActionPerformed(evt);
            }
        });

        getSpot.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        getSpot.setText("Retrieve Spot");
        getSpot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getSpotActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bus Lot");

        HomeButton.setIcon(new javax.swing.ImageIcon("E:\\11th Grade\\Documents\\Documents\\HomeButton.png")); // NOI18N
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(getSpot))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(addSpot))
                    .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(getSpot, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addSpot, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSpotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSpotActionPerformed
        RunProgram.addInterface.show();
        this.dispose();
}//GEN-LAST:event_addSpotActionPerformed

    private void getSpotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getSpotActionPerformed
        RunProgram.getInterface.show();
        this.dispose();
}//GEN-LAST:event_getSpotActionPerformed

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        this.show(false);
        RunProgram.main_menu.show();
}//GEN-LAST:event_HomeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new BusLot().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(BusLot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton addSpot;
    private javax.swing.JButton getSpot;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
