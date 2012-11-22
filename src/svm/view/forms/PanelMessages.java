/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svm.view.forms;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import svm.view.controller.ViewMessagesController;

/**
 *
 * @author Patrick
 */
public class PanelMessages extends javax.swing.JPanel {
     
    private ViewMessagesController viewMessagesController;

    public ViewMessagesController getViewMessagesController() {
        return viewMessagesController;
    }

    /**
     * Creates new Form Panel for Member UseCases
     */  
    
    public PanelMessages() {       
            initComponents();
            this.viewMessagesController = new ViewMessagesController(this);
             }
    
    /* Getters and Setters for Panel Components */

    public JButton getBtnAcceptContest() {
        return btnAcceptContest;
    }

    public JButton getBtnAssignNewMemberToTeam() {
        return btnAssignNewMemberToTeam;
    }

    public JButton getBtnDenyContest() {
        return btnDenyContest;
    }

    public JButton getBtnRemoveNewMemberFromTeam() {
        return btnRemoveNewMemberFromTeam;
    }

    public JButton getBtnSaveAssignment() {
        return btnSaveAssignment;
    }

    public JComboBox getCmbSelectSport() {
        return cmbSelectSport;
    }

    public JComboBox getCmbSelectTeam() {
        return cmbSelectTeam;
    }

    public JList getListboxAssignedContests() {
        return listboxAssignedContests;
    }

    public JList getListboxMembersOfSelectedTeam() {
        return listboxMembersOfSelectedTeam;
    }

    public JList getListboxNewMembersToAssign() {
        return listboxNewMembersToAssign;
    }


    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPanelMembers = new javax.swing.JSplitPane();
        panelMembersLeft = new javax.swing.JPanel();
        splitPanelMembersLeft = new javax.swing.JSplitPane();
        panelMembersSearch = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSaveAssignment = new javax.swing.JButton();
        panelMessagesList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listboxNewMembersToAssign = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listboxMembersOfSelectedTeam = new javax.swing.JList();
        btnAssignNewMemberToTeam = new javax.swing.JButton();
        btnRemoveNewMemberFromTeam = new javax.swing.JButton();
        cmbSelectTeam = new javax.swing.JComboBox();
        cmbSelectSport = new javax.swing.JComboBox();
        splitPanelMembersRight = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listboxAssignedContests = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        btnDenyContest = new javax.swing.JButton();
        btnAcceptContest = new javax.swing.JButton();

        splitPanelMembers.setBackground(new java.awt.Color(252, 252, 252));
        splitPanelMembers.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        splitPanelMembers.setDividerLocation(600);
        splitPanelMembers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        splitPanelMembers.setDoubleBuffered(true);

        panelMembersLeft.setBackground(new java.awt.Color(252, 252, 252));
        panelMembersLeft.setPreferredSize(new java.awt.Dimension(362, 550));

        splitPanelMembersLeft.setDividerLocation(60);
        splitPanelMembersLeft.setDividerSize(4);
        splitPanelMembersLeft.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        splitPanelMembersLeft.setDoubleBuffered(true);
        splitPanelMembersLeft.setPreferredSize(new java.awt.Dimension(362, 540));

        panelMembersSearch.setPreferredSize(new java.awt.Dimension(350, 70));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Nachricht - Neue Sportler einem Team zuordnen");
        jLabel1.setToolTipText("");

        btnSaveAssignment.setText("Save");
        btnSaveAssignment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAssignmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMembersSearchLayout = new javax.swing.GroupLayout(panelMembersSearch);
        panelMembersSearch.setLayout(panelMembersSearchLayout);
        panelMembersSearchLayout.setHorizontalGroup(
            panelMembersSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMembersSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelMembersSearchLayout.setVerticalGroup(
            panelMembersSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMembersSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMembersSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveAssignment, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        splitPanelMembersLeft.setTopComponent(panelMembersSearch);

        panelMessagesList.setBackground(new java.awt.Color(252, 252, 252));

        jScrollPane1.setBorder(null);
        jScrollPane1.setDoubleBuffered(true);

        listboxNewMembersToAssign.setBackground(new java.awt.Color(249, 249, 249));
        listboxNewMembersToAssign.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listboxNewMembersToAssign.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "-" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listboxNewMembersToAssign.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listboxNewMembersToAssign.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listboxNewMembersToAssign.setDoubleBuffered(true);
        listboxNewMembersToAssign.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listboxNewMembersToAssignValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listboxNewMembersToAssign);

        jScrollPane2.setBorder(null);
        jScrollPane2.setDoubleBuffered(true);

        listboxMembersOfSelectedTeam.setBackground(new java.awt.Color(249, 249, 249));
        listboxMembersOfSelectedTeam.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listboxMembersOfSelectedTeam.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "-" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listboxMembersOfSelectedTeam.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listboxMembersOfSelectedTeam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listboxMembersOfSelectedTeam.setDoubleBuffered(true);
        listboxMembersOfSelectedTeam.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listboxMembersOfSelectedTeamValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listboxMembersOfSelectedTeam);

        btnAssignNewMemberToTeam.setText(">>");

        btnRemoveNewMemberFromTeam.setText("<<");

        cmbSelectTeam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Team wählen", "Item 2", "Item 3", "Item 4" }));
        cmbSelectTeam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbSelectTeam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSelectTeamItemStateChanged(evt);
            }
        });

        cmbSelectSport.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sport wählen", "Item 2", "Item 3", "Item 4" }));
        cmbSelectSport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbSelectSport.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSelectSportItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelMessagesListLayout = new javax.swing.GroupLayout(panelMessagesList);
        panelMessagesList.setLayout(panelMessagesListLayout);
        panelMessagesListLayout.setHorizontalGroup(
            panelMessagesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMessagesListLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelMessagesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMessagesListLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMessagesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAssignNewMemberToTeam, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addComponent(btnRemoveNewMemberFromTeam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMessagesListLayout.createSequentialGroup()
                        .addComponent(cmbSelectSport, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbSelectTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMessagesListLayout.setVerticalGroup(
            panelMessagesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMessagesListLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelMessagesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSelectTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSelectSport, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMessagesListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMessagesListLayout.createSequentialGroup()
                        .addComponent(btnAssignNewMemberToTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveNewMemberFromTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(344, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)))
        );

        splitPanelMembersLeft.setRightComponent(panelMessagesList);

        javax.swing.GroupLayout panelMembersLeftLayout = new javax.swing.GroupLayout(panelMembersLeft);
        panelMembersLeft.setLayout(panelMembersLeftLayout);
        panelMembersLeftLayout.setHorizontalGroup(
            panelMembersLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPanelMembersLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );
        panelMembersLeftLayout.setVerticalGroup(
            panelMembersLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMembersLeftLayout.createSequentialGroup()
                .addComponent(splitPanelMembersLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addContainerGap())
        );

        splitPanelMembers.setLeftComponent(panelMembersLeft);

        splitPanelMembersRight.setBackground(new java.awt.Color(252, 252, 252));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Nachricht - Bestätigung von Wettkampfzuteilung");
        jLabel2.setToolTipText("");

        jScrollPane3.setBorder(null);
        jScrollPane3.setDoubleBuffered(true);

        listboxAssignedContests.setBackground(new java.awt.Color(249, 249, 249));
        listboxAssignedContests.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listboxAssignedContests.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        listboxAssignedContests.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "-" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listboxAssignedContests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listboxAssignedContests.setDoubleBuffered(true);
        listboxAssignedContests.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listboxAssignedContestsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listboxAssignedContests);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Bitte Wettkämpfe auswählen und zusagen oder absagen");
        jLabel3.setToolTipText("");

        btnDenyContest.setText("zusagen");
        btnDenyContest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDenyContest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDenyContestActionPerformed(evt);
            }
        });

        btnAcceptContest.setText("absagen");
        btnAcceptContest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAcceptContest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptContestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout splitPanelMembersRightLayout = new javax.swing.GroupLayout(splitPanelMembersRight);
        splitPanelMembersRight.setLayout(splitPanelMembersRightLayout);
        splitPanelMembersRightLayout.setHorizontalGroup(
            splitPanelMembersRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splitPanelMembersRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(splitPanelMembersRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(splitPanelMembersRightLayout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(splitPanelMembersRightLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(splitPanelMembersRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDenyContest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAcceptContest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        splitPanelMembersRightLayout.setVerticalGroup(
            splitPanelMembersRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, splitPanelMembersRightLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(splitPanelMembersRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addGroup(splitPanelMembersRightLayout.createSequentialGroup()
                        .addComponent(btnDenyContest, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAcceptContest, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        splitPanelMembers.setRightComponent(splitPanelMembersRight);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPanelMembers, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPanelMembers)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listboxNewMembersToAssignValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listboxNewMembersToAssignValueChanged
 
        
    }//GEN-LAST:event_listboxNewMembersToAssignValueChanged

    private void cmbSelectSportItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSelectSportItemStateChanged
         viewMessagesController.showMembersToAssign();
    }//GEN-LAST:event_cmbSelectSportItemStateChanged

    private void listboxMembersOfSelectedTeamValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listboxMembersOfSelectedTeamValueChanged
        
    }//GEN-LAST:event_listboxMembersOfSelectedTeamValueChanged

    private void cmbSelectTeamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSelectTeamItemStateChanged
        viewMessagesController.showTeamMembers();
    }//GEN-LAST:event_cmbSelectTeamItemStateChanged

    private void listboxAssignedContestsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listboxAssignedContestsValueChanged
        
    }//GEN-LAST:event_listboxAssignedContestsValueChanged

    private void btnSaveAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAssignmentActionPerformed

        viewMessagesController.saveTeamMembers();
    }//GEN-LAST:event_btnSaveAssignmentActionPerformed

    private void btnDenyContestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDenyContestActionPerformed
         viewMessagesController.denySelectedContests();
    }//GEN-LAST:event_btnDenyContestActionPerformed

    private void btnAcceptContestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptContestActionPerformed
         viewMessagesController.acceptSelectedContests();
    }//GEN-LAST:event_btnAcceptContestActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceptContest;
    private javax.swing.JButton btnAssignNewMemberToTeam;
    private javax.swing.JButton btnDenyContest;
    private javax.swing.JButton btnRemoveNewMemberFromTeam;
    private javax.swing.JButton btnSaveAssignment;
    private javax.swing.JComboBox cmbSelectSport;
    private javax.swing.JComboBox cmbSelectTeam;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listboxAssignedContests;
    private javax.swing.JList listboxMembersOfSelectedTeam;
    private javax.swing.JList listboxNewMembersToAssign;
    private javax.swing.JPanel panelMembersLeft;
    private javax.swing.JPanel panelMembersSearch;
    private javax.swing.JPanel panelMessagesList;
    private javax.swing.JSplitPane splitPanelMembers;
    private javax.swing.JSplitPane splitPanelMembersLeft;
    private javax.swing.JPanel splitPanelMembersRight;
    // End of variables declaration//GEN-END:variables
}
