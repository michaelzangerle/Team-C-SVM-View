/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svm.view.forms;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Patrick
 */
public class MainForm extends javax.swing.JFrame {

    // The one and only instance of the sample application    
    private static MainForm mainForm = null;

    /**
     * Creates new form LoginForm
     */
    public MainForm() {
        initComponents();       
        this.setIconImage(new ImageIcon(getClass().getResource("../resources/svm_icon_neg.png")).getImage());
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMainFrame = new javax.swing.JPanel();
        panelMainTop = new javax.swing.JPanel();
        panelMainTopItems = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPrivileges = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelMainCenter = new javax.swing.JPanel();
        tabPanelMainCenter = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sportvereinmanager - Team C - 2012");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setMaximumSize(null);
        setMinimumSize(null);
        setName("frameMain"); // NOI18N
        setPreferredSize(new java.awt.Dimension(995, 700));

        panelMainFrame.setBackground(new java.awt.Color(242, 242, 242));
        panelMainFrame.setMinimumSize(new java.awt.Dimension(995, 700));
        panelMainFrame.setPreferredSize(new java.awt.Dimension(995, 706));

        panelMainTopItems.setBackground(new java.awt.Color(229, 229, 229));
        panelMainTopItems.setMinimumSize(new java.awt.Dimension(300, 55));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/svm/view/resources/svm_lg_140.png"))); // NOI18N
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBackground(new java.awt.Color(229, 229, 229));

        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Angemeldet als:");

        lblUser.setForeground(new java.awt.Color(51, 51, 51));
        lblUser.setText("Barack Hussein Obama II");

        lblPrivileges.setForeground(new java.awt.Color(51, 51, 51));
        lblPrivileges.setText("[Präsident] - Stufe");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel26)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(lblPrivileges, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 119, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblUser)
                    .add(lblPrivileges)))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/svm/view/resources/svm_headline_smallest.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout panelMainTopItemsLayout = new org.jdesktop.layout.GroupLayout(panelMainTopItems);
        panelMainTopItems.setLayout(panelMainTopItemsLayout);
        panelMainTopItemsLayout.setHorizontalGroup(
            panelMainTopItemsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelMainTopItemsLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel10)
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 390, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        panelMainTopItemsLayout.setVerticalGroup(
            panelMainTopItemsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(panelMainTopItemsLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout panelMainTopLayout = new org.jdesktop.layout.GroupLayout(panelMainTop);
        panelMainTop.setLayout(panelMainTopLayout);
        panelMainTopLayout.setHorizontalGroup(
            panelMainTopLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMainTopItems, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMainTopLayout.setVerticalGroup(
            panelMainTopLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMainTopLayout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(panelMainTopItems, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        panelMainCenter.setBackground(new java.awt.Color(255, 255, 255));
        panelMainCenter.setPreferredSize(new java.awt.Dimension(995, 620));

        tabPanelMainCenter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabPanelMainCenter.setDoubleBuffered(true);
        tabPanelMainCenter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabPanelMainCenter.setPreferredSize(new java.awt.Dimension(995, 600));
        tabPanelMainCenter.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPanelMainCenterStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelMainCenterLayout = new org.jdesktop.layout.GroupLayout(panelMainCenter);
        panelMainCenter.setLayout(panelMainCenterLayout);
        panelMainCenterLayout.setHorizontalGroup(
            panelMainCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tabPanelMainCenter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMainCenterLayout.setVerticalGroup(
            panelMainCenterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tabPanelMainCenter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );

        tabPanelMainCenter.getAccessibleContext().setAccessibleName("tabPanelMainCenter");

        org.jdesktop.layout.GroupLayout panelMainFrameLayout = new org.jdesktop.layout.GroupLayout(panelMainFrame);
        panelMainFrame.setLayout(panelMainFrameLayout);
        panelMainFrameLayout.setHorizontalGroup(
            panelMainFrameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMainCenter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(panelMainTop, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMainFrameLayout.setVerticalGroup(
            panelMainFrameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMainFrameLayout.createSequentialGroup()
                .add(panelMainTop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelMainCenter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMainFrame, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelMainFrame, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        panelMainFrame.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleName("formMain");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabPanelMainCenterStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPanelMainCenterStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tabPanelMainCenterStateChanged


   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPrivileges;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panelMainCenter;
    private javax.swing.JPanel panelMainFrame;
    private javax.swing.JPanel panelMainTop;
    private javax.swing.JPanel panelMainTopItems;
    private javax.swing.JTabbedPane tabPanelMainCenter;
    // End of variables declaration//GEN-END:variables

    public JLabel getLblPrivileges() {
        return lblPrivileges;
    }

    public void setLblPrivileges(String lblPrivileges) {
        this.lblPrivileges.setText(lblPrivileges);
    }

    public JLabel getLblUser() {
        return lblUser;
    }

    public void setLblUser(String lblUser) {
        this.lblUser.setText(lblUser);
    }

    public JTabbedPane getTabPanelMainCenter() {
        return tabPanelMainCenter;
    }

    public void setTabPanelMainCenter(JTabbedPane tabPanelMainCenter) {
        this.tabPanelMainCenter = tabPanelMainCenter;
    }

}
