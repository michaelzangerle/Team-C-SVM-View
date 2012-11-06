/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svm.view.controller;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import svm.domain.abstraction.exception.DomainAttributeException;
import svm.domain.abstraction.exception.DomainException;
import svm.domain.abstraction.exception.DomainParameterCheckException;
import svm.logic.abstraction.exception.IllegalGetInstanceException;
import svm.logic.abstraction.transferobjects.*;
import svm.persistence.abstraction.exceptions.ExistingTransactionException;
import svm.persistence.abstraction.exceptions.NoSessionFoundException;
import svm.persistence.abstraction.exceptions.NoTransactionException;
import svm.rmi.abstraction.controller.IRMIContestController;
import svm.rmi.abstraction.controller.IRMIMemberController;
import svm.rmi.abstraction.controller.IRMISearchController;
import svm.rmi.abstraction.factory.IRMIControllerFactory;
import svm.view.forms.PanelContests;
import svm.view.forms.PanelMembers;

/**
 *
 * @author Patrick
 */
public class ViewContestController {

    private IRMIControllerFactory factory = ApplicationController.factory;
    private IRMIContestController contestController;
    private IRMISearchController searchController;
    private PanelContests panelContests;
    private DefaultListModel<ITransferTeam> participatingTeams = new DefaultListModel<>();
    private DefaultListModel<ITransferContest> model = new DefaultListModel<>();
    private DefaultListModel<ITransferMember> completeTeam = new DefaultListModel<>();
    private DefaultListModel<ITransferMember> subTeam = new DefaultListModel<>();

    public ViewContestController(PanelContests panelContest) {
        try {
            this.searchController = factory.getRMISearchController(ApplicationController.user);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.panelContests = panelContest;
    }

    public void showContests() {

        try {

            this.searchController.start();
            for (ITransferContest c : searchController.getContests()) {
                model.addElement(c);
            }
            this.panelContests.getListboxShowContests().setModel(model);
            this.panelContests.getListboxShowContests().setSelectedIndex(0);
            ITransferContest selectedContest = (ITransferContest) this.panelContests.getListboxShowContests().getSelectedValue();

            this.panelContests.getTfContestName().setText(selectedContest.getName());
            this.panelContests.getDcContestStartDate().setDate(selectedContest.getStart());
            this.panelContests.getDcContestEndDate().setDate(selectedContest.getEnd());
            this.panelContests.getTfContestFee().setText(Float.toString(selectedContest.getFee()));


            this.searchController.commit();


        } catch (ExistingTransactionException | NoTransactionException | NoSessionFoundException | IllegalGetInstanceException | RemoteException ex) {
            Logger.getLogger(PanelMembers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showMatchOverview() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy - hh.mm");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -100);
        sdf.set2DigitYearStart(cal.getTime());

        try {
            this.contestController = factory.getRMIContestController((ITransferContest) this.panelContests.getListboxShowContests().getSelectedValue(), ApplicationController.user);
            this.contestController.start();
            int i = 0;
            for (ITransferMatch m : contestController.getMatches()) {
                this.panelContests.getTableMatchesOverview().setValueAt(sdf.format(m.getStart()), i, 0);
                this.panelContests.getTableMatchesOverview().setValueAt(m.getContestants().get(0), i, 1);
                this.panelContests.getTableMatchesOverview().setValueAt(m.getContestants().get(1), i, 2);
                this.panelContests.getTableMatchesOverview().setValueAt(m.getContestants().get(0).getResult(), i, 3);
                this.panelContests.getTableMatchesOverview().setValueAt(m.getContestants().get(1).getResult(), i, 4);
            }
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveContest() {
        try {

            this.contestController.start();
            this.contestController.setContestName(panelContests.getTfContestName().getText());
            this.contestController.setContestStartDate(panelContests.getDcContestStartDate().getDate());
            this.contestController.setContestEndDate(panelContests.getDcContestEndDate().getDate());
            this.contestController.setContestFee(Float.parseFloat(panelContests.getTfContestFee().getText()));
            this.contestController.setEmail1(panelContests.getTfContestMail1().getText());
            this.contestController.setEmail2(panelContests.getTfContestMail2().getText());
            this.contestController.setPhone1(panelContests.getTfContestPhone1().getText());
            this.contestController.setPhone2(panelContests.getTfContestPhone2().getText());
            this.contestController.setStreet(panelContests.getTfContestStreet().getText());
            this.contestController.setStreetNumber(panelContests.getTfContestStreetNumber().getText());
            this.contestController.commit();
        } catch (DomainParameterCheckException | ExistingTransactionException | NoTransactionException | DomainAttributeException | NoSessionFoundException | IllegalGetInstanceException | RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createNewContest() {

        try {
            if (this.contestController != null) {
                this.contestController.abort();
            }

        } catch (ExistingTransactionException | NoSessionFoundException | NoTransactionException | RemoteException ex) {
        }

        try {
            this.contestController = this.factory.getRMIContestController(ApplicationController.user);
            this.contestController.start();
            ITransferContest tmp = this.contestController.getTransferContest();
            panelContests.getTfContestName().setText(tmp.getName());

        } catch (NoSessionFoundException | IllegalGetInstanceException | RemoteException ex) {
            Logger.getLogger(PanelMembers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addTeamToContest() {
        try {
            ITransferTeam team = (ITransferTeam) this.panelContests.getListboxAllContestTeams().getSelectedValue();
            if (!this.participatingTeams.contains(team)) {
                this.participatingTeams.addElement(team);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Team ist bereits in Auswahl vorhanden");
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Bitte eine Auswahl treffen");
        }
    }

    public void removeTeamFromContest() {
        try {
            this.participatingTeams.removeElement((ITransferTeam) this.panelContests.getListboxContestTeams().getSelectedValue());
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Bitte eine Auswahl treffen");
        }
    }

    public void showAllTeams() {
        try {
            this.searchController.start();
            DefaultListModel<ITransferTeam> model = new DefaultListModel<>();
            for (ITransferTeam team : searchController.getTeams()) {
                model.addElement(team);
            }
            panelContests.getListboxAllTeamsInSport().setModel(model);
            this.searchController.commit();
        } catch (ExistingTransactionException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoTransactionException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showAllLocations() {

        if (this.panelContests.getListboxShowContests().getSelectedValue() != null) {
            try {
                ITransferContest selectedContest = (ITransferContest) this.panelContests.getListboxShowContests().getSelectedValue();
                this.panelContests.getTfContestPhone1().setText(selectedContest.getContactDetails().getPhone1());
                this.panelContests.getTfContestPhone2().setText(selectedContest.getContactDetails().getPhone2());
                this.panelContests.getTfContestMail1().setText(selectedContest.getContactDetails().getEmail1());
                this.panelContests.getTfContestStreet().setText(selectedContest.getContactDetails().getStreet());
                this.panelContests.getTfContestStreetNumber().setText(selectedContest.getContactDetails().getStreetNumber());

                DefaultComboBoxModel<ITransferLocation> model = new DefaultComboBoxModel<>();
                this.searchController.start();
                for (ITransferLocation team : searchController.getLocations()) {
                    model.addElement(team);
                }
                panelContests.getCmbContestContactDetails().setModel(model);
                this.searchController.commit();
            } catch (ExistingTransactionException ex) {
                Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSessionFoundException ex) {
                Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoTransactionException ex) {
                Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalGetInstanceException ex) {
                Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void saveMatchOverview() {
        try {
            int i = 0;
            LinkedList dates = new LinkedList();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy - hh.mm");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, -100);
            sdf.set2DigitYearStart(cal.getTime());

            this.contestController = factory.getRMIContestController((ITransferContest) this.panelContests.getListboxShowContests().getSelectedValue(), ApplicationController.user);

            int entriesIterator = 0;

            for (ITransferMatch t : this.contestController.getMatches()) {
                String dateString;
                try {
                    dateString = (String) this.panelContests.getTableMatchesOverview().getValueAt(entriesIterator, 0);
                    this.contestController.setDateForMatch(t, sdf.parse(dateString));
                } catch (ParseException ex) {
                    Logger.getLogger(PanelContests.class.getName()).log(Level.SEVERE, null, ex);
                    javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Error while parsing Date, corrupted cell: " + entriesIterator + ",0\nCorrect Format is dd.MM.yyyy - hh.mm");
                    dates.clear();
                    break;
                }

                try {
                    this.contestController.setResult(t,
                            (Float) this.panelContests.getTableMatchesOverview().getValueAt(entriesIterator, 3),
                            (Float) this.panelContests.getTableMatchesOverview().getValueAt(entriesIterator, 4));
                } catch (ClassCastException ex) {
                    Logger.getLogger(PanelContests.class.getName()).log(Level.SEVERE, null, ex);
                    javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Error while parsing result, corrupted resultrow: " + entriesIterator);
                    dates.clear();
                    break;
                }
                entriesIterator++;
            }
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DomainException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void assignContestTeamModel() {
        this.panelContests.getListboxContestTeams().setModel(participatingTeams);
    }

    public void manageSubteams() {
        try {
            this.contestController = factory.getRMIContestController((ITransferContest) this.panelContests.getListboxShowContests().getSelectedValue(), ApplicationController.user);
            this.contestController.start();

            this.panelContests.getListboxAllTeamMembers().setModel(completeTeam);
            this.panelContests.getListboxContestTeamMembers().setModel(subTeam);

            for (ITransferTeam c : contestController.getTeams()) {
                this.panelContests.getCmbContestTeams().addItem(c);
            }
        } catch (NoSessionFoundException | IllegalGetInstanceException | RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addToSubTeam() {
        if (this.panelContests.getListboxAllTeamMembers().getSelectedValue() != null) {
            this.subTeam.addElement((ITransferMember) this.panelContests.getListboxAllTeamMembers().getSelectedValue());
            this.completeTeam.removeElement(this.panelContests.getListboxAllTeamMembers().getSelectedValue());
        } else{
            javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Bitte eine Auswahl treffen");
        }
    }

    public void removeFromSubTeam() {
        if (this.panelContests.getListboxContestTeamMembers().getSelectedValue() != null) {
            this.completeTeam.addElement((ITransferMember) this.panelContests.getListboxContestTeamMembers().getSelectedValue());
            this.subTeam.removeElement(this.panelContests.getListboxContestTeamMembers().getSelectedValue());
        } else{
            javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Bitte eine Auswahl treffen");
        }
    }
}
