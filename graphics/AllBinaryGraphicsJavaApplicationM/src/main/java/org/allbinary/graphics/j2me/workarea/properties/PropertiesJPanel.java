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
package org.allbinary.graphics.j2me.workarea.properties;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.allbinary.graphics.j2me.workarea.WorkAreaJPanelInterface;

public class PropertiesJPanel extends javax.swing.JPanel
{   
   //private WorkAreaJPanelInterface workArea;
      
   public PropertiesJPanel()//WorkAreaJPanelInterface workArea)
   {
      //this.workArea = workArea;
      initComponents();
   }
   
   public void set(JPanel panel)
   {      
      workAreaPropertiesJPanel.add(panel);      
      this.repaint();
   }   
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */   
   private void initComponents()//GEN-BEGIN:initComponents
   {
      workAreaPropertiesJPanel = new javax.swing.JPanel();
      modifierJPanel = new javax.swing.JPanel();
      copyVerticalJButton = new javax.swing.JButton();
      copyHorizontalJButton = new javax.swing.JButton();
      rotateJPanel = new javax.swing.JPanel();
      rotateJButton = new javax.swing.JButton();
      angleJTextField = new javax.swing.JTextField();
      jPanel7 = new javax.swing.JPanel();
      upJButton = new javax.swing.JButton();
      downJButton = new javax.swing.JButton();
      jPanel8 = new javax.swing.JPanel();
      leftJButton = new javax.swing.JButton();
      rightJButton = new javax.swing.JButton();

      setLayout(new java.awt.GridLayout(2, 1));

      workAreaPropertiesJPanel.setLayout(new java.awt.GridLayout());

      add(workAreaPropertiesJPanel);

      modifierJPanel.setLayout(new java.awt.GridLayout(6, 0));

      copyVerticalJButton.setFont(new java.awt.Font("Dialog", 0, 10));
      copyVerticalJButton.setText("Copy Vertical");
      modifierJPanel.add(copyVerticalJButton);

      copyHorizontalJButton.setFont(new java.awt.Font("Dialog", 0, 10));
      copyHorizontalJButton.setText("Copy Horizontal");
      modifierJPanel.add(copyHorizontalJButton);

      rotateJPanel.setLayout(new java.awt.GridLayout(1, 2));

      rotateJButton.setFont(new java.awt.Font("Dialog", 0, 10));
      rotateJButton.setText("Rotate");
      rotateJPanel.add(rotateJButton);

      angleJTextField.setText("Angle");
      rotateJPanel.add(angleJTextField);

      modifierJPanel.add(rotateJPanel);

      jPanel7.setLayout(new java.awt.GridLayout(1, 2));

      upJButton.setFont(new java.awt.Font("Dialog", 0, 10));
      upJButton.setText("Up");
      jPanel7.add(upJButton);

      downJButton.setFont(new java.awt.Font("Dialog", 0, 10));
      downJButton.setText("Down");
      jPanel7.add(downJButton);

      modifierJPanel.add(jPanel7);

      jPanel8.setLayout(new java.awt.GridLayout(1, 2));

      leftJButton.setFont(new java.awt.Font("Dialog", 0, 10));
      leftJButton.setText("Left");
      jPanel8.add(leftJButton);

      rightJButton.setFont(new java.awt.Font("Dialog", 0, 10));
      rightJButton.setText("Right");
      jPanel8.add(rightJButton);

      modifierJPanel.add(jPanel8);

      add(modifierJPanel);

   }//GEN-END:initComponents
   
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton rotateJButton;
   private javax.swing.JButton copyVerticalJButton;
   private javax.swing.JButton leftJButton;
   private javax.swing.JPanel rotateJPanel;
   private javax.swing.JTextField angleJTextField;
   private javax.swing.JPanel workAreaPropertiesJPanel;
   private javax.swing.JPanel modifierJPanel;
   private javax.swing.JButton upJButton;
   private javax.swing.JPanel jPanel8;
   private javax.swing.JButton downJButton;
   private javax.swing.JPanel jPanel7;
   private javax.swing.JButton rightJButton;
   private javax.swing.JButton copyHorizontalJButton;
   // End of variables declaration//GEN-END:variables
   
}