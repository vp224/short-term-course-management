/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortTermCourseManagement;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class TempFrame4 extends javax.swing.JFrame {

    /**
     * Creates new form TempFrame4
     */
    public JButton b2;
    public Participant tempp;
    public JTextField partnam;
    public JTextField partadd;
    public JTextField partmob;
    public JTextField partorg;
    public JTextField partemail;
    public TempFrame4(JButton b2,Participant tempp) {
        this.b2=b2;
        this.tempp=tempp;
        tempframe4();
    }
    public void tempframe4()
    {
        Container c=getContentPane();
        c.setLayout(new GridLayout(0,2));
        c.add(new JLabel("Participant name"));
        partnam=new JTextField(tempp.personName);
        c.add(partnam);
        c.add(new JLabel("Participant Address"));
        partadd=new JTextField(tempp.personAddress);
        c.add(partadd);
        c.add(new JLabel("Participant Mobile"));
        partmob=new JTextField(Long.toString(tempp.personMobile));
        c.add(partmob);
        c.add(new JLabel("Participant org"));
        partorg=new JTextField(tempp.org_name);
        c.add(partorg);
        c.add(new JLabel("Participant email"));
        partemail=new JTextField(tempp.personEmail);
        c.add(partemail);
        c.add(new JPanel());
        c.add(b2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,650);
        setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}