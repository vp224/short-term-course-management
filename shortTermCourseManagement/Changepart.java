/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortTermCourseManagement;

import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

/**
 *
 * @author user
 */
public class Changepart extends javax.swing.JFrame {

    /**
     * Creates new form Changepart
     */
    public Yeartochp yp;
    public Institute instii;
    public ActionListener s;
    public JButton change = new JButton("Change");
    public DefaultListModel<String> list=new DefaultListModel<>();
    public Changepart(Yeartochp yp) {
        this.yp=yp;
        this.instii=yp.instii;
        
        changepart();
    }
public void changepart()
{
    jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList(list);
        instii.assments.get(Integer.parseInt(yp.jTextField1.getText())-Integer.parseInt(yp.c8.y1.jTextField1.getText())).courseArray.forEach(e->list.addElement(e.courseName));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("CHOOSE");
        s=new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        };
        jLabel1.setText("Course list to change participant");
        jButton1.addActionListener(s);
        
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("CHOOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Course list to change participant");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Course tempC=new Course();
        instii.assments.get(Integer.parseInt(yp.jTextField1.getText())-Integer.parseInt(yp.c8.y1.jTextField1.getText())).
                courseArray.stream().filter((e)->(e.courseName.equals((String)jList1.getSelectedValue()))).forEach(tempC::initCourse);
        ChangePart1 cp1=new ChangePart1(this,tempC);
        cp1.setVisible(true);
       /* list.removeAllElements();
        jLabel1.setText("Participants in selected Course : " + tempC.courseName);
        tempC.arrStudents.forEach(e->list.addElement(e.personName));
        jButton1.setText("Change Participant");
        jButton1.removeActionListener(jButton1.getActionListeners()[0]);
        jButton1.addActionListener(e -> {
            try {
                jButton2ActionPerformed(e,tempC);
            } catch (Exception ex) {
                Logger.getLogger(ChangeFac.class.getName()).log(Level.SEVERE, null, ex);
            }
        });*/
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt, Course tempC) throws Exception
    {
        Participant p=new Participant();
         for(int i=0;i<tempC.arrStudents.size();i++)
            {
                if(tempC.arrStudents.get(i).personName.equals(jList1.getSelectedValue()))
                {
                    p.org_name=tempC.arrStudents.get(i).org_name;
                    p.personAddress=tempC.arrStudents.get(i).personAddress;
                    p.personEmail=tempC.arrStudents.get(i).personEmail;
                    p.personName=tempC.arrStudents.get(i).personName;
                    p.personMobile=tempC.arrStudents.get(i).personMobile;
                }
            }
          TempFrame4 tf=new TempFrame4(jButton1,p);
          String var=tempC.courseName;
          jButton1.addActionListener(e->{
                for (int k = 0; k < tempC.arrStudents.size(); k++) {
                    if (tempC.arrStudents.get(k).personName.equals(jList1.getSelectedValue())) 
                    {
                        tempC.arrStudents.get(k).org_name=tf.partorg.getText();
                        tempC.arrStudents.get(k).personName=tf.partnam.getText();
                        tempC.arrStudents.get(k).personAddress=tf.partadd.getText();
                        tempC.arrStudents.get(k).personEmail=tf.partemail.getText();
                        tempC.arrStudents.get(k).personMobile=Long.parseLong(tf.partmob.getText());
                    }
                }
                for (int n = 0; n < instii.assments.get(0).courseArray.size(); n++) {
                                                    if (instii.assments.get(0).courseArray.get(n).equals(var)) {
                                                        instii.assments.get(0).courseArray.set(n, tempC);
                                                    }
                                                }
                tf.dispose();
                jButton1.removeActionListener(jButton1.getActionListeners()[0]);
                jButton1.addActionListener(s);
                list.set(jList1.getSelectedIndex(), tempC.courseName);
            });
            tf.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}