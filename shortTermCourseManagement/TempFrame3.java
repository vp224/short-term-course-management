/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortTermCourseManagement;

import java.awt.Container;
import java.awt.GridLayout;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class TempFrame3 extends javax.swing.JFrame {

    /**
     * Creates new form TempFrame3
     */
    public JButton b1;
    public JTextField facdept;
    public JTextField facnam;
    public JTextField facadd;
    public JTextField facemail;
    public JTextField facmob;
    public Faculty f;
    public TempFrame3(JButton b1,Faculty f) {
       this.b1=b1;
       this.f=f;
       tempframe3();
    }
    public void tempframe3()
    {
        Container c=getContentPane();
        c.setLayout(new GridLayout(0,2));
        c.add(new JLabel("Faculty dept"));
        facdept=new JTextField(f.dept);
        c.add(facdept);
        c.add(new JLabel("Faculty Name"));
        facnam=new JTextField(f.personName);
        c.add(facnam);
        c.add(new JLabel("Faculty Address"));
        facadd=new JTextField(f.personAddress);
        c.add(facadd);
        c.add(new JLabel("Faculty email"));
        facemail=new JTextField(f.personEmail);
        c.add(facemail);
        c.add(new JLabel("Faculty Mobile"));
        facmob=new JTextField(Long.toString(f.personMobile));
        c.add(facmob);
        c.add(new JPanel());
        c.add(b1);
        
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