/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Step1.java
 *
 * Created on Dec 1, 2011, 2:29:35 AM
 */
package addictionmanager.wizard;

/**
 *
 * @author Deminem
 */
public class Step2 extends javax.swing.JPanel {

    /** Creates new form Step1 */
    public Step2() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        facebookOption = new javax.swing.JCheckBox();
        twitterOption = new javax.swing.JCheckBox();
        youtubeOption = new javax.swing.JCheckBox();
        amazaonOption = new javax.swing.JCheckBox();
        ebayOption = new javax.swing.JCheckBox();
        googlePlus = new javax.swing.JCheckBox();
        wowcOption = new javax.swing.JCheckBox();
        gumtreeOption = new javax.swing.JCheckBox();
        miniclipOption = new javax.swing.JCheckBox();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(addictionmanager.AddictionManagerApp.class).getContext().getResourceMap(Step2.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(670, 386));

        facebookOption.setFont(resourceMap.getFont("facebookOption.font")); // NOI18N
        facebookOption.setText(resourceMap.getString("facebookOption.text")); // NOI18N
        facebookOption.setName("facebookOption"); // NOI18N
        facebookOption.setText("<html><table cellpadding=0><tr><td><img src='facebook.png'" + "/></td><td width=" + 3 + "><td>"

            // Retrieve the current label text
            + "Facebook1" + "</td></tr></table></html>");
        facebookOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facebookOptionActionPerformed(evt);
            }
        });

        twitterOption.setFont(resourceMap.getFont("twitterOption.font")); // NOI18N
        twitterOption.setText(resourceMap.getString("twitterOption.text")); // NOI18N
        twitterOption.setName("twitterOption"); // NOI18N
        twitterOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twitterOptionActionPerformed(evt);
            }
        });

        youtubeOption.setFont(resourceMap.getFont("youtubeOption.font")); // NOI18N
        youtubeOption.setText(resourceMap.getString("youtubeOption.text")); // NOI18N
        youtubeOption.setName("youtubeOption"); // NOI18N
        youtubeOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youtubeOptionActionPerformed(evt);
            }
        });

        amazaonOption.setFont(resourceMap.getFont("amazaonOption.font")); // NOI18N
        amazaonOption.setText(resourceMap.getString("amazaonOption.text")); // NOI18N
        amazaonOption.setName("amazaonOption"); // NOI18N
        amazaonOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amazaonOptionActionPerformed(evt);
            }
        });

        ebayOption.setFont(resourceMap.getFont("ebayOption.font")); // NOI18N
        ebayOption.setText(resourceMap.getString("ebayOption.text")); // NOI18N
        ebayOption.setName("ebayOption"); // NOI18N
        ebayOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ebayOptionActionPerformed(evt);
            }
        });

        googlePlus.setFont(resourceMap.getFont("googlePlus.font")); // NOI18N
        googlePlus.setText(resourceMap.getString("googlePlus.text")); // NOI18N
        googlePlus.setName("googlePlus"); // NOI18N
        googlePlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                googlePlusActionPerformed(evt);
            }
        });

        wowcOption.setFont(resourceMap.getFont("wowcOption.font")); // NOI18N
        wowcOption.setText(resourceMap.getString("wowcOption.text")); // NOI18N
        wowcOption.setName("wowcOption"); // NOI18N
        wowcOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wowcOptionActionPerformed(evt);
            }
        });

        gumtreeOption.setFont(resourceMap.getFont("gumtreeOption.font")); // NOI18N
        gumtreeOption.setText(resourceMap.getString("gumtreeOption.text")); // NOI18N
        gumtreeOption.setName("gumtreeOption"); // NOI18N
        gumtreeOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gumtreeOptionActionPerformed(evt);
            }
        });

        miniclipOption.setFont(resourceMap.getFont("miniclipOption.font")); // NOI18N
        miniclipOption.setText(resourceMap.getString("miniclipOption.text")); // NOI18N
        miniclipOption.setName("miniclipOption"); // NOI18N
        miniclipOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miniclipOptionActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(81, 81, 81)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(facebookOption)
                    .add(googlePlus)
                    .add(gumtreeOption))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 94, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(3, 3, 3)
                        .add(twitterOption))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(wowcOption)
                        .add(ebayOption)))
                .add(51, 51, 51)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(youtubeOption)
                    .add(amazaonOption)
                    .add(miniclipOption))
                .add(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(youtubeOption)
                        .add(49, 49, 49)
                        .add(amazaonOption)
                        .add(51, 51, 51)
                        .add(miniclipOption))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(facebookOption)
                        .add(49, 49, 49)
                        .add(googlePlus)
                        .add(51, 51, 51)
                        .add(gumtreeOption))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(twitterOption)
                        .add(49, 49, 49)
                        .add(ebayOption)
                        .add(51, 51, 51)
                        .add(wowcOption)))
                .add(96, 96, 96))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void facebookOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facebookOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facebookOptionActionPerformed

    private void twitterOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twitterOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_twitterOptionActionPerformed

    private void youtubeOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_youtubeOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_youtubeOptionActionPerformed

    private void amazaonOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amazaonOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amazaonOptionActionPerformed

    private void ebayOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ebayOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ebayOptionActionPerformed

    private void googlePlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_googlePlusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_googlePlusActionPerformed

    private void wowcOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wowcOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wowcOptionActionPerformed

    private void gumtreeOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gumtreeOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gumtreeOptionActionPerformed

    private void miniclipOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miniclipOptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miniclipOptionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JCheckBox amazaonOption;
    public javax.swing.JCheckBox ebayOption;
    public javax.swing.JCheckBox facebookOption;
    public javax.swing.JCheckBox googlePlus;
    public javax.swing.JCheckBox gumtreeOption;
    public javax.swing.JCheckBox miniclipOption;
    public javax.swing.JCheckBox twitterOption;
    public javax.swing.JCheckBox wowcOption;
    public javax.swing.JCheckBox youtubeOption;
    // End of variables declaration//GEN-END:variables
}
