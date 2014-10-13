/*
* AllBinary Open License Version 1
* Copyright (c) 2011 AllBinary
* 
* By agreeing to this license you and any business entity you represent are
* legally bound to the AllBinary Open License Version 1 legal agreement.
* 
* You may obtain the AllBinary Open License Version 1 legal agreement from
* AllBinary or the root directory of AllBinary's AllBinary Platform repository.
* 
* Created By: Travis Berthelot
* 
*/
package org.allbinary.gui.dialog;

import java.io.File;

import org.allbinary.logic.communication.log.LogFactory;
import org.allbinary.logic.communication.log.LogUtil;

/**
 *
 * @author  USER
 */
public class FileJDialog extends javax.swing.JDialog
{
    private FileJDialogListenerInterface finishedListenerInterface;
    
    /** Creates new form FileJDialog */
    public FileJDialog()
    {
        super();
        initComponents();
        this.getJFileChooser1().setMultiSelectionEnabled(true);
    }
    
    public FileJDialog(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        this.getJFileChooser1().setMultiSelectionEnabled(true);
    }
    
    public void addFinishedListener(
        FileJDialogListenerInterface finishedListenerInterface)
    {
        this.finishedListenerInterface = finishedListenerInterface;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jFileChooser1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jFileChooser1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jFileChooser1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 357, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jFileChooser1ActionPerformed
   {//GEN-HEADEREND:event_jFileChooser1ActionPerformed
// TODO add your handling code here:
       
       LogUtil.put(LogFactory.getInstance("Starting Action Command: " + evt.getActionCommand(), this, "ActionPerformed"));
       
       File files[] = this.getJFileChooser1().getSelectedFiles();
       
       if(evt.getActionCommand() == this.getJFileChooser1().CANCEL_SELECTION)
       {
           this.setVisible(false);
       }
       //File files[] = new File[1];
       //files[0] = this.getJFileChooser1().getSelectedFile();
       
       if(evt.getActionCommand() == this.getJFileChooser1().APPROVE_SELECTION)
       {
           if(files != null && files.length > 0)
           {
               this.finishedListenerInterface.onFiles(files);
           }
       }
       //new BasicTextJDialog((Frame) this.getParent(), false, "No File(s) Selected").setVisible(true);
   }//GEN-LAST:event_jFileChooser1ActionPerformed
   
   /**
    * @param args the command line arguments
    */
   public static void main(String args[])
   {
       java.awt.EventQueue.invokeLater(new Runnable()
       {
           public void run()
           {
               new FileJDialog(new javax.swing.JFrame(), true).setVisible(true);
           }
       });
   }
   
   public javax.swing.JFileChooser getJFileChooser1()
   {
       return jFileChooser1;
   }
   
   public void setJFileChooser1(javax.swing.JFileChooser jFileChooser1)
   {
       this.jFileChooser1 = jFileChooser1;
   }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
    
}
