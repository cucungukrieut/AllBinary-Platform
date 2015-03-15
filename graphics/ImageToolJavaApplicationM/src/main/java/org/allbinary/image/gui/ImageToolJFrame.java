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
package org.allbinary.image.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import org.allbinary.logic.communication.log.LogUtil;

import org.allbinary.gui.dialog.FileJDialog;
import org.allbinary.gui.dialog.FileJDialogListenerInterface;
import org.allbinary.logic.communication.log.LogFactory;

import org.allbinary.media.image.analysis.ColorRange;
import org.allbinary.media.image.analysis.ColorRangeInterface;
import org.allbinary.media.image.analysis.ImageAnalysis;
import org.allbinary.media.image.analysis.ImageAnalysisResults;

public class ImageToolJFrame extends javax.swing.JFrame
   implements FileJDialogListenerInterface
{

   private static ImageProcessorInputCompositeInterface imageProcessorInputCompositeInterface;
   private FileJDialog fileJDialog;
   private ImageProcessorInput imageProcessorInput;

   public ImageToolJFrame() throws Exception
   {
      initComponents();

      //this.fileJDialog = new FileJDialog(this, true);

      //this.fileJDialog.getJFileChooser1().addActionListener()
      //this.jPanel1.setLayout(new java.awt.FlowLayout());

      this.setSize(640, 480);

      this.getMaxRedJTextField().setText("255");
      this.getMaxGreenJTextField().setText("255");
      this.getMaxBlueJTextField().setText("255");

      this.getMinRedJTextField().setText("0");
      this.getMinGreenJTextField().setText("0");
      this.getMinBlueJTextField().setText("0");

      fileJDialog = new FileJDialog();
      fileJDialog.addFinishedListener(this);
   }

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      analysisActionJDialog = new javax.swing.JDialog();
      titleJLabel = new javax.swing.JLabel();
      colorRangeJLabel = new javax.swing.JLabel();
      redJLabel = new javax.swing.JLabel();
      minJLabel = new javax.swing.JLabel();
      maxJLabel = new javax.swing.JLabel();
      greenJLabel = new javax.swing.JLabel();
      blueJLabel = new javax.swing.JLabel();
      minRedJTextField = new javax.swing.JTextField();
      maxRedJTextField = new javax.swing.JTextField();
      maxGreenJTextField = new javax.swing.JTextField();
      minBlueJTextField = new javax.swing.JTextField();
      maxBlueJTextField = new javax.swing.JTextField();
      okJButton = new javax.swing.JButton();
      minGreenJTextField = new javax.swing.JTextField();
      jPanel1 = new javax.swing.JPanel();
      mainJMenuBar = new javax.swing.JMenuBar();
      fileJMenu = new javax.swing.JMenu();
      openImageJMenuItem = new javax.swing.JMenuItem();
      processingJMenu = new javax.swing.JMenu();
      analyzeJMenuItem = new javax.swing.JMenuItem();
      generateMirrorSpriteMenuItem = new javax.swing.JMenuItem();
      generateRotationSpriteJMenuItem = new javax.swing.JMenuItem();
      createStripImageJMenuItem = new javax.swing.JMenuItem();
      mirrorJMenuItem = new javax.swing.JMenuItem();
      scaleImagesJMenuItem = new javax.swing.JMenuItem();

      analysisActionJDialog.setMinimumSize(new java.awt.Dimension(350, 250));

      titleJLabel.setText("              Color At Action Options            ");

      colorRangeJLabel.setText("Color Range");

      redJLabel.setText("Red:");

      minJLabel.setText("Minimum");

      maxJLabel.setText("Maximum");

      greenJLabel.setText("Green:");

      blueJLabel.setText("Blue:");

      okJButton.setText("OK");
      okJButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            okJButtonActionPerformed(evt);
         }
      });

      org.jdesktop.layout.GroupLayout analysisActionJDialogLayout = new org.jdesktop.layout.GroupLayout(analysisActionJDialog.getContentPane());
      analysisActionJDialog.getContentPane().setLayout(analysisActionJDialogLayout);
      analysisActionJDialogLayout.setHorizontalGroup(
         analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(analysisActionJDialogLayout.createSequentialGroup()
            .addContainerGap()
            .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(analysisActionJDialogLayout.createSequentialGroup()
                  .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                     .add(blueJLabel)
                     .add(greenJLabel)
                     .add(redJLabel)
                     .add(colorRangeJLabel))
                  .add(29, 29, 29)
                  .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                     .add(org.jdesktop.layout.GroupLayout.TRAILING, minJLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                     .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, minBlueJTextField)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, minGreenJTextField)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, minRedJTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, okJButton)))
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                  .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                     .add(org.jdesktop.layout.GroupLayout.LEADING, analysisActionJDialogLayout.createSequentialGroup()
                        .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                           .add(org.jdesktop.layout.GroupLayout.LEADING, maxRedJTextField)
                           .add(org.jdesktop.layout.GroupLayout.LEADING, analysisActionJDialogLayout.createSequentialGroup()
                              .add(1, 1, 1)
                              .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                 .add(maxBlueJTextField)
                                 .add(maxGreenJTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE))
                     .add(org.jdesktop.layout.GroupLayout.LEADING, maxJLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                  .addContainerGap())
               .add(org.jdesktop.layout.GroupLayout.TRAILING, analysisActionJDialogLayout.createSequentialGroup()
                  .add(titleJLabel)
                  .add(25, 25, 25))))
      );
      analysisActionJDialogLayout.setVerticalGroup(
         analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(analysisActionJDialogLayout.createSequentialGroup()
            .add(titleJLabel)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(minJLabel)
               .add(colorRangeJLabel)
               .add(maxJLabel))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
               .add(redJLabel)
               .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                  .add(minRedJTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .add(maxRedJTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
               .add(greenJLabel)
               .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                  .add(minGreenJTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .add(maxGreenJTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
               .add(blueJLabel)
               .add(analysisActionJDialogLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                  .add(minBlueJTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .add(maxBlueJTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
            .add(16, 16, 16)
            .add(okJButton)
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      getContentPane().setLayout(new java.awt.GridLayout(1, 0));

      jPanel1.setLayout(new java.awt.GridLayout(1, 0));
      getContentPane().add(jPanel1);

      fileJMenu.setText("File");
      fileJMenu.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            fileJMenuActionPerformed(evt);
         }
      });

      openImageJMenuItem.setText("Open");
      openImageJMenuItem.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            openImageJMenuItemActionPerformed(evt);
         }
      });
      fileJMenu.add(openImageJMenuItem);

      mainJMenuBar.add(fileJMenu);

      processingJMenu.setText("Processing");
      processingJMenu.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            processingJMenuActionPerformed(evt);
         }
      });

      analyzeJMenuItem.setText("Image Analyze");
      analyzeJMenuItem.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            analyzeJMenuItemActionPerformed(evt);
         }
      });
      processingJMenu.add(analyzeJMenuItem);

      generateMirrorSpriteMenuItem.setText("Mirror Sprite Generator");
      generateMirrorSpriteMenuItem.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            generateMirrorSpriteMenuItemActionPerformed(evt);
         }
      });
      processingJMenu.add(generateMirrorSpriteMenuItem);

      generateRotationSpriteJMenuItem.setText("Rotation Sprite Generator");
      generateRotationSpriteJMenuItem.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            generateRotationSpriteJMenuItemActionPerformed(evt);
         }
      });
      processingJMenu.add(generateRotationSpriteJMenuItem);

      createStripImageJMenuItem.setText("Multi Image Unifier");
      createStripImageJMenuItem.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            createStripImageJMenuItemActionPerformed(evt);
         }
      });
      processingJMenu.add(createStripImageJMenuItem);

      mirrorJMenuItem.setText("Mirror Image(s)");
      mirrorJMenuItem.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mirrorJMenuItemActionPerformed(evt);
         }
      });
      processingJMenu.add(mirrorJMenuItem);

      scaleImagesJMenuItem.setText("Scale Image(s)");
      scaleImagesJMenuItem.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            scaleImagesJMenuItemActionPerformed(evt);
         }
      });
      processingJMenu.add(scaleImagesJMenuItem);

      mainJMenuBar.add(processingJMenu);

      setJMenuBar(mainJMenuBar);

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void createStripImageJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_createStripImageJMenuItemActionPerformed
    {//GEN-HEADEREND:event_createStripImageJMenuItemActionPerformed
       try
       {
          ImageUnifierJPanel imageUnifierJPanel =
             new ImageUnifierJPanel(this.imageProcessorInput);
          this.jPanel1.removeAll();
          this.jPanel1.add(imageUnifierJPanel);
          this.jPanel1.updateUI();

          imageProcessorInputCompositeInterface = imageUnifierJPanel;
       }
       catch (Exception e)
       {
          LogUtil.put(LogFactory.getInstance("Exception", this, "createStripImageJMenuItemActionPerformed", e));
       }
    }//GEN-LAST:event_createStripImageJMenuItemActionPerformed

    private void okJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_okJButtonActionPerformed
    {//GEN-HEADEREND:event_okJButtonActionPerformed
       try
       {
          LogUtil.put(LogFactory.getInstance("Starting", this, "okJButtonActionPerformed"));

          ImageAnalysisResults imageAnalysisResultsArray[] = ImageAnalysis.process(
             imageProcessorInput.getBufferedImageArray(), this.getColorRangeInterface());

          this.jPanel1.removeAll();
          this.jPanel1.add(new ImageAnalysisResultsJPanel(
             imageAnalysisResultsArray));
          this.jPanel1.updateUI();

          this.analysisActionJDialog.setVisible(false);

          imageProcessorInputCompositeInterface = null;
       }
       catch (Exception e)
       {
          LogUtil.put(LogFactory.getInstance("Exception", this, "okJButtonActionPerformed", e));
       }
    }//GEN-LAST:event_okJButtonActionPerformed

    private void processingJMenuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_processingJMenuActionPerformed
    {//GEN-HEADEREND:event_processingJMenuActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_processingJMenuActionPerformed

    private void openImageJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openImageJMenuItemActionPerformed
    {//GEN-HEADEREND:event_openImageJMenuItemActionPerformed
       try
       {
          LogUtil.put(LogFactory.getInstance("Starting", this, "openImageJMenuItemActionPerformed"));
          fileJDialog.setVisible(true);
       }
       catch (Exception e)
       {
          LogUtil.put(LogFactory.getInstance("Exception", this, "openImageJMenuItemActionPerformed", e));
       }
    }//GEN-LAST:event_openImageJMenuItemActionPerformed

   public void onFiles(File[] files)
   {
      try
      {
         LogUtil.put(LogFactory.getInstance("Reading " + files.length + " files.", this, "onFiles"));

         BufferedImage[] bufferedImageArray = new BufferedImage[files.length];

         for (int index = 0; index < files.length; index++)
         {
            bufferedImageArray[index] = ImageIO.read(files[index]);
            if(bufferedImageArray[index] == null)
            {
                throw new Exception("Unable to read file: " + files[index].getPath());
            }
         }

         this.imageProcessorInput = new ImageProcessorInput(
            files,
            bufferedImageArray);

         this.fileJDialog.setVisible(false);

         if (imageProcessorInputCompositeInterface != null)
         {
            imageProcessorInputCompositeInterface.setImageProcessorInput(
               this.imageProcessorInput);
         }
      }
      catch (Exception e)
      {
         LogUtil.put(LogFactory.getInstance("Exception", this, "onFiles", e));
      }
   }

    private void fileJMenuActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_fileJMenuActionPerformed
    {//GEN-HEADEREND:event_fileJMenuActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_fileJMenuActionPerformed

   private void analyzeJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_analyzeJMenuItemActionPerformed
   {//GEN-HEADEREND:event_analyzeJMenuItemActionPerformed
      try
      {
         LogUtil.put(LogFactory.getInstance("Starting", this, "analyzeJMenuItemActionPerformed"));
         this.analysisActionJDialog.setVisible(true);
      }
      catch (Exception e)
      {
         LogUtil.put(LogFactory.getInstance("Exception", this, "analyzeJMenuItemActionPerformed", e));
      }
   }//GEN-LAST:event_analyzeJMenuItemActionPerformed

   private void generateRotationSpriteJMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_generateRotationSpriteJMenuItemActionPerformed
   {//GEN-HEADEREND:event_generateRotationSpriteJMenuItemActionPerformed
      try
      {
         LogUtil.put(LogFactory.getInstance("Starting", this, "generateRotationSpriteJMenuItemActionPerformed"));

         RotationSpriteImageJPanel spriteImageJPanel =
            new RotationSpriteImageJPanel(
            this.imageProcessorInput);

         this.jPanel1.removeAll();
         this.jPanel1.add(spriteImageJPanel);
         this.jPanel1.updateUI();

         imageProcessorInputCompositeInterface = spriteImageJPanel;
      }
      catch (Exception e)
      {
         LogUtil.put(LogFactory.getInstance("Exception", this, "generateRotationSpriteJMenuItemActionPerformed", e));
      }
}//GEN-LAST:event_generateRotationSpriteJMenuItemActionPerformed

   private void scaleImagesJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleImagesJMenuItemActionPerformed
      try
      {
         LogUtil.put(LogFactory.getInstance("Start", this, "scaleImagesJMenuItemActionPerformed"));

         ResizeImageJPanel resizeImageJPanel =
            new ResizeImageJPanel(
            this.imageProcessorInput);

         this.jPanel1.removeAll();
         this.jPanel1.add(resizeImageJPanel);
         this.jPanel1.updateUI();

         imageProcessorInputCompositeInterface = resizeImageJPanel;
      }
      catch (Exception e)
      {
         LogUtil.put(LogFactory.getInstance("Exception", this, "scaleImagesJMenuItemActionPerformed", e));
      }
}//GEN-LAST:event_scaleImagesJMenuItemActionPerformed

private void generateMirrorSpriteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateMirrorSpriteMenuItemActionPerformed
   try
   {
      LogUtil.put(LogFactory.getInstance("Starting", this, "generateMirrorSpriteJMenuItemActionPerformed"));

      MirrorSpriteImageJPanel spriteImageJPanel =
         new MirrorSpriteImageJPanel(
         this.imageProcessorInput);

      this.jPanel1.removeAll();
      this.jPanel1.add(spriteImageJPanel);
      this.jPanel1.updateUI();

      imageProcessorInputCompositeInterface = spriteImageJPanel;
   }
   catch (Exception e)
   {
      LogUtil.put(LogFactory.getInstance("Exception", this, "generateMirrorSpriteJMenuItemActionPerformed", e));
   }
}//GEN-LAST:event_generateMirrorSpriteMenuItemActionPerformed

private void mirrorJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirrorJMenuItemActionPerformed
   try
   {
      LogUtil.put(LogFactory.getInstance("Starting", this, "generateMirrorJMenuItemActionPerformed"));

      MirrorImageJPanel mirrorImageJPanel =
         new MirrorImageJPanel(
         this.imageProcessorInput);

      this.jPanel1.removeAll();
      this.jPanel1.add(mirrorImageJPanel);
      this.jPanel1.updateUI();

      imageProcessorInputCompositeInterface = mirrorImageJPanel;
   }
   catch (Exception e)
   {
      LogUtil.put(LogFactory.getInstance("Exception", this, "generateMirrorJMenuItemActionPerformed", e));
   }
}//GEN-LAST:event_mirrorJMenuItemActionPerformed
   
   private ColorRangeInterface getColorRangeInterface()
   {
       ColorRangeInterface colorRangeInterface =
           (ColorRangeInterface) new ColorRange();
       
       colorRangeInterface.setMinRed(
           new Integer(this.getMinRedJTextField().getText()).intValue());
       colorRangeInterface.setMaxRed(
           new Integer(this.getMaxRedJTextField().getText()).intValue());
       
       colorRangeInterface.setMinGreen(
           new Integer(this.getMinGreenJTextField().getText()).intValue());
       colorRangeInterface.setMaxGreen(
           new Integer(this.getMaxGreenJTextField().getText()).intValue());
       
       colorRangeInterface.setMinBlue(
           new Integer(this.getMinBlueJTextField().getText()).intValue());
       colorRangeInterface.setMaxBlue(
           new Integer(this.getMaxBlueJTextField().getText()).intValue());
       
       return colorRangeInterface;
   }
   
   public javax.swing.JTextField getMaxBlueJTextField()
   {
       return maxBlueJTextField;
   }
   
   public void setMaxBlueJTextField(javax.swing.JTextField maxBlueJTextField)
   {
       this.maxBlueJTextField = maxBlueJTextField;
   }
   
   public javax.swing.JTextField getMaxGreenJTextField()
   {
       return maxGreenJTextField;
   }
   
   public void setMaxGreenJTextField(javax.swing.JTextField maxGreenJTextField)
   {
       this.maxGreenJTextField = maxGreenJTextField;
   }
   
   public javax.swing.JTextField getMaxRedJTextField()
   {
       return maxRedJTextField;
   }
   
   public void setMaxRedJTextField(javax.swing.JTextField maxRedJTextField)
   {
       this.maxRedJTextField = maxRedJTextField;
   }
   
   public javax.swing.JTextField getMinBlueJTextField()
   {
       return minBlueJTextField;
   }
   
   public void setMinBlueJTextField(javax.swing.JTextField minBlueJTextField)
   {
       this.minBlueJTextField = minBlueJTextField;
   }
   
   public javax.swing.JTextField getMinGreenJTextField()
   {
       return minGreenJTextField;
   }
   
   public void setMinGreenJTextField(javax.swing.JTextField minGreenJTextField)
   {
       this.minGreenJTextField = minGreenJTextField;
   }
   
   public javax.swing.JTextField getMinRedJTextField()
   {
       return minRedJTextField;
   }
   
   public void setMinRedJTextField(javax.swing.JTextField minRedJTextField)
   {
       this.minRedJTextField = minRedJTextField;
   }
   
   /*
   public void paint(Graphics graphics)
   {
      LogUtil.put(LogFactory.getInstance("Painting", this, "paint"));
   }
    */
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JDialog analysisActionJDialog;
   private javax.swing.JMenuItem analyzeJMenuItem;
   private javax.swing.JLabel blueJLabel;
   private javax.swing.JLabel colorRangeJLabel;
   private javax.swing.JMenuItem createStripImageJMenuItem;
   private javax.swing.JMenu fileJMenu;
   private javax.swing.JMenuItem generateMirrorSpriteMenuItem;
   private javax.swing.JMenuItem generateRotationSpriteJMenuItem;
   private javax.swing.JLabel greenJLabel;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JMenuBar mainJMenuBar;
   private javax.swing.JTextField maxBlueJTextField;
   private javax.swing.JTextField maxGreenJTextField;
   private javax.swing.JLabel maxJLabel;
   private javax.swing.JTextField maxRedJTextField;
   private javax.swing.JTextField minBlueJTextField;
   private javax.swing.JTextField minGreenJTextField;
   private javax.swing.JLabel minJLabel;
   private javax.swing.JTextField minRedJTextField;
   private javax.swing.JMenuItem mirrorJMenuItem;
   private javax.swing.JButton okJButton;
   private javax.swing.JMenuItem openImageJMenuItem;
   private javax.swing.JMenu processingJMenu;
   private javax.swing.JLabel redJLabel;
   private javax.swing.JMenuItem scaleImagesJMenuItem;
   private javax.swing.JLabel titleJLabel;
   // End of variables declaration//GEN-END:variables
    
}