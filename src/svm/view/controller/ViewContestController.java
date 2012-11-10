/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svm.view.controller;

import java.awt.HeadlessException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import svm.domain.abstraction.exception.DomainAttributeException;
import svm.domain.abstraction.exception.DomainException;
import svm.domain.abstraction.exception.DomainParameterCheckException;
import svm.logic.abstraction.exception.IllegalGetInstanceException;
import svm.logic.abstraction.exception.LogicException;
import svm.logic.abstraction.exception.NotAllowException;
import svm.logic.abstraction.transferobjects.*;
import svm.persistence.abstraction.exceptions.ExistingTransactionException;
import svm.persistence.abstraction.exceptions.NoSessionFoundException;
import svm.persistence.abstraction.exceptions.NoTransactionException;
import svm.persistence.abstraction.exceptions.NotSupportedException;
import svm.rmi.abstraction.controller.IRMIContestController;
import svm.rmi.abstraction.controller.IRMIMemberController;
import svm.rmi.abstraction.controller.IRMISearchController;
import svm.rmi.abstraction.controller.IRMISubTeamController;
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
    private DefaultListModel<ITransferTeam> contestTeams = new DefaultListModel<>();
    private DefaultListModel<ITransferContest> showContests = new DefaultListModel<>();
    private DefaultListModel<ITransferMember> allTeamMembers = new DefaultListModel<>();
    private DefaultListModel<ITransferMember> contestTeamMembers = new DefaultListModel<>();
    private DefaultListModel<ITransferTeam> allContestTeams = new DefaultListModel<>();
    private DefaultListModel<ITransferTeam> teamA = new DefaultListModel<>();
    private DefaultListModel<ITransferTeam> teamB = new DefaultListModel<>();
    private DefaultComboBoxModel<ITransferLocation> showAllLocations = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<ITransferTeam> comboContestTeams = new DefaultComboBoxModel<>();
    private DefaultListModel<ITransferTeam> allTeamsInSport = new DefaultListModel<>();
    private DefaultTableModel tableMatchOverview = new DefaultTableModel();
    private HashMap<ITransferTeam, LinkedList<ITransferMember>> participatingMembers;
    private IRMISubTeamController subTeamController;

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
            showContests.clear();
            for (ITransferContest c : searchController.getContests()) {
                showContests.addElement(c);
            }
            this.panelContests.getListboxShowContests().setModel(showContests);
            //this.panelContests.getListboxShowContests().setSelectedIndex(0);

            ITransferContest selectedContest = (ITransferContest) this.showContests.get(0);

            this.contestController = this.factory.getRMIContestController(selectedContest, ApplicationController.user);
            this.contestController.start();

            this.panelContests.getTfContestName().setText(selectedContest.getName());
            this.panelContests.getDcContestStartDate().setDate(selectedContest.getStart());
            this.panelContests.getDcContestEndDate().setDate(selectedContest.getEnd());
            this.panelContests.getTfContestFee().setText(Float.toString(selectedContest.getFee()));

            this.searchController.commit();


        } catch (NotAllowException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelMembers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showMatchOverview() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy - hh.mm");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -100);
        sdf.set2DigitYearStart(cal.getTime());
        this.panelContests.getTableMatchesOverview().setModel(tableMatchOverview);

        if (tableMatchOverview.getColumnCount() == 0) {
            this.tableMatchOverview.addColumn("Date");
            this.tableMatchOverview.addColumn("TeamA");
            this.tableMatchOverview.addColumn("TeamB");
            this.tableMatchOverview.addColumn("ScoreA");
            this.tableMatchOverview.addColumn("ScoreB");
        }

        if (tableMatchOverview.getRowCount() == 0) {

            Vector vector;

            try {
                for (ITransferMatch m : contestController.getMatches()) {
                    vector = new Vector();
                    vector.add(sdf.format(m.getStart()));
                    vector.add(m.getHomeTeam());
                    vector.add(m.getAwayTeam());
                    vector.add(m.getResultHome());
                    vector.add(m.getResultAway());
                    this.tableMatchOverview.addRow(vector);
                }
            } catch (IllegalGetInstanceException | RemoteException ex) {
                Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void saveContest() {
        try {
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
        } catch (NotAllowException | DomainParameterCheckException | ExistingTransactionException | NoSessionFoundException | NoTransactionException | DomainAttributeException | RemoteException ex) {
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
            this.clearForNewContest();
            this.contestController = this.factory.getRMIContestController(ApplicationController.user);
            this.contestController.start();
            ITransferContest tmp = this.contestController.getTransferContest();
            panelContests.getTfContestName().setText(tmp.getName());

        } catch (NoSessionFoundException | IllegalGetInstanceException | RemoteException | InstantiationException | IllegalAccessException | NotSupportedException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addTeamToContest() {
        try {
            ITransferTeam team = (ITransferTeam) this.panelContests.getListboxAllTeamsInSport().getSelectedValue();

            if (team != null && !this.contestTeams.contains(team)) {
                this.contestController.addTeam(team);
                this.contestTeams.addElement(team);
                this.panelContests.getListboxContestTeams().updateUI();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Team ist bereits in Auswahl vorhanden");
            }
        } catch (RemoteException | NoSessionFoundException | DomainException | InstantiationException | IllegalAccessException | NotAllowException | HeadlessException e) {
            javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Bitte eine Auswahl treffen");
        }
    }

    public void removeTeamFromContest() {
        try {
            ITransferTeam team = (ITransferTeam) this.panelContests.getListboxContestTeams().getSelectedValue();
            if (team != null) {
                this.contestController.removeTeam(team);
                this.contestTeams.removeElement(team);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Bitte eine Auswahl treffen");
        }
    }

    public void showAllTeams() {
        try {
            this.panelContests.getListboxAllTeamsInSport().setModel(allTeamsInSport);
            if (allTeamsInSport.isEmpty()) {
                searchController.start();
                for (ITransferTeam team : searchController.getTeams()) {
                    allTeamsInSport.addElement(team);
                }
                searchController.commit();
            }
            if (contestTeams.isEmpty()) {
                for (ITransferTeam team : contestController.getTeams()) {
                    System.out.println(team.getName());
                    contestTeams.addElement(team);
                }
            }
        } catch (InstantiationException | IllegalAccessException | NotSupportedException | NotAllowException | ExistingTransactionException | NoTransactionException | NoSessionFoundException | RemoteException | IllegalGetInstanceException ex) {
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

                /*
                 * this.searchController.start(); for (ITransferLocation team :
                 * searchController.getLocations()) {
                 * showAllLocations.addElement(team); }
                 * panelContests.getCmbContestContactDetails().setModel(showAllLocations);
                 * this.searchController.commit();
                 *
                 */
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

            //this.contestController = factory.getRMIContestController((ITransferContest) this.panelContests.getListboxShowContests().getSelectedValue(), ApplicationController.user);

            int entriesIterator = 0;

            for (ITransferMatch t : this.contestController.getMatches()) {
                String dateString;
                try {
                    dateString = (String) this.panelContests.getTableMatchesOverview().getValueAt(entriesIterator, 0);
                    this.contestController.setDateForMatch(t, sdf.parse(dateString));
                } catch (NotAllowException ex) {
                    Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(PanelContests.class.getName()).log(Level.SEVERE, null, ex);
                    javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Error while parsing Date, corrupted cell: " + entriesIterator + ",0\nCorrect Format is dd.MM.yyyy - hh.mm");
                    dates.clear();
                    break;
                }

                try {
                    try {
                        this.contestController.setResult(t,
                                Integer.valueOf(this.panelContests.getTableMatchesOverview().getValueAt(entriesIterator, 3).toString()),
                                Integer.valueOf(this.panelContests.getTableMatchesOverview().getValueAt(entriesIterator, 4).toString()));
                    } catch (NoSessionFoundException | DomainException | InstantiationException | IllegalAccessException | NotAllowException ex) {
                        Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassCastException ex) {
                    Logger.getLogger(PanelContests.class.getName()).log(Level.SEVERE, null, ex);
                    javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Error while parsing result, corrupted resultrow: " + entriesIterator);
                    dates.clear();
                    break;
                }
                entriesIterator++;
            }
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            contestController.commit();
            contestController.start();
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExistingTransactionException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoTransactionException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void assignContestTeamModel() {
        this.panelContests.getListboxContestTeams().setModel(contestTeams);
    }

    public void manageSubteams() {
        this.panelContests.getListboxAllTeamMembers().setModel(allTeamMembers);
        this.panelContests.getListboxContestTeamMembers().setModel(contestTeamMembers);
        this.panelContests.getCmbContestTeams().setModel(comboContestTeams);

        if (this.panelContests.getCmbContestTeams().getModel().getSize() == 0) {
            try {
                List<ITransferTeam> teams = contestController.getTeams();
                for (ITransferTeam c : teams) {
                    this.comboContestTeams.addElement(c);
                }
            } catch (RemoteException ex) {
                Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalGetInstanceException ex) {
                Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addToSubTeam() {
        if (this.panelContests.getListboxAllTeamMembers().getSelectedValue() != null) {
            this.contestTeamMembers.addElement((ITransferMember) this.panelContests.getListboxAllTeamMembers().getSelectedValue());
            this.allTeamMembers.removeElement(this.panelContests.getListboxAllTeamMembers().getSelectedValue());
        } else {
            javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Bitte eine Auswahl treffen");
        }
    }

    public void removeFromSubTeam() {
        if (this.panelContests.getListboxContestTeamMembers().getSelectedValue() != null) {
            try {
                this.subTeamController.removeMember((ITransferMember) this.panelContests.getListboxContestTeamMembers().getSelectedValue());
                this.allTeamMembers.addElement((ITransferMember) this.panelContests.getListboxContestTeamMembers().getSelectedValue());
                this.contestTeamMembers.removeElement(this.panelContests.getListboxContestTeamMembers().getSelectedValue());
            } catch (RemoteException ex) {
                Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this.panelContests, "Bitte eine Auswahl treffen");
        }
    }

    public void manageContestTeams() {
        try {
            this.panelContests.getListboxAllContestTeams().setModel(allContestTeams);
            this.panelContests.getListboxTeamA().setModel(teamA);
            this.panelContests.getListboxTeamB().setModel(teamB);

            ITransferContest selectedContest = (ITransferContest) this.panelContests.getListboxContestTeams().getSelectedValue();

            if (allContestTeams.isEmpty()) {
                for (ITransferTeam t : contestController.getTeams()) {
                    this.allContestTeams.addElement(t);
                }
            }
        } catch (RemoteException | IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeFromTeam() {
        if (this.panelContests.getListboxTeamA().getSelectedValue() != null) {
            teamA.removeElement(this.panelContests.getListboxTeamA().getSelectedValue());
        }
        if (this.panelContests.getListboxTeamB().getSelectedValue() != null) {
            teamB.removeElement(this.panelContests.getListboxTeamB().getSelectedValue());
        }
    }

    public void addToTeamB() {
        teamB.addElement((ITransferTeam) this.panelContests.getListboxAllContestTeams().getSelectedValue());
    }

    public void addToTeamA() {
        teamA.addElement((ITransferTeam) this.panelContests.getListboxAllContestTeams().getSelectedValue());
    }

    public void contestChange() {
        contestTeams.clear();
        allTeamMembers.clear();
        contestTeamMembers.clear();
        allContestTeams.clear();
        teamA.clear();
        teamB.clear();
        showAllLocations = new DefaultComboBoxModel<>();
        comboContestTeams = new DefaultComboBoxModel<>();
    }

    public void updateContests() {
        try {
            if (this.panelContests.getListboxShowContests().getSelectedIndex() == -1) {
                return;
            }
            ITransferContest selectedContest = (ITransferContest) this.showContests.get(this.panelContests.getListboxShowContests().getSelectedIndex());
            this.contestController = factory.getRMIContestController(selectedContest, ApplicationController.user);
            this.contestController.start();

            this.panelContests.getTfContestName().setText(selectedContest.getName());
            this.panelContests.getDcContestStartDate().setDate(selectedContest.getStart());
            this.panelContests.getDcContestEndDate().setDate(selectedContest.getEnd());
            this.panelContests.getTfContestFee().setText(Float.toString(selectedContest.getFee()));
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearForNewContest() {
        this.panelContests.getTfContestName().setText("");
        this.panelContests.getDcContestStartDate().setDate(null);
        this.panelContests.getDcContestEndDate().setDate(null);
        this.panelContests.getTfContestFee().setText("");
    }

    public void saveContestTeams() {
        try {
            int i = 0;
            while (i < this.panelContests.getListboxContestTeams().getModel().getSize()) {
                try {
                    contestController.addTeam((ITransferTeam) this.panelContests.getListboxContestTeams().getSelectedValue());
                    i++;
                } catch (DomainException | NotAllowException ex) {
                    Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.contestController.commit();
            this.contestController.start();
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExistingTransactionException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoTransactionException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveTeamComposition() {
        try {
            int entryIterator = 0;
            while ((entryIterator < teamB.getSize()) && (entryIterator < teamA.getSize())) {
                try {
                    try {
                        this.contestController.addMatch(teamA.get(entryIterator), teamB.get(entryIterator), new Date(), new Date());
                        entryIterator++;
                    } catch (NotSupportedException | NotAllowException ex) {
                        Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (LogicException | DomainException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.contestController.commit();
            this.contestController.start();
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExistingTransactionException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoTransactionException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changeContestTeamSelection() {

        this.allTeamMembers.clear();
        this.contestTeamMembers.clear();
        ITransferTeam selectedTeam = (ITransferTeam) this.panelContests.getCmbContestTeams().getSelectedItem();

        try {
            this.subTeamController = factory.getRMISubTeamController(selectedTeam, contestController.getTransferContest(), ApplicationController.user);
            this.subTeamController.start();

            for (ITransferMember member : subTeamController.getMembersOfSubTeam()) {
                this.contestTeamMembers.addElement(member);
            }

            for (ITransferMember member : subTeamController.getMemberOfTeam()) {
                int i = 0;
                boolean contains = false;
                while ((i < contestTeamMembers.getSize()) && (contains == false)){
                    if ((member.getFirstName().equalsIgnoreCase(contestTeamMembers.get(i).getFirstName())) &&
                            member.getLastName().equalsIgnoreCase(contestTeamMembers.get(i).getLastName())){
                        contains = true;
                    }
                    i++;
                }
                if (contains == false) {
                    this.allTeamMembers.addElement(member);
                }
            }

            this.panelContests.getListboxAllTeamMembers().setModel(allTeamMembers);


            this.panelContests.getListboxContestTeamMembers().setModel(contestTeamMembers);
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveSubteam() {
        try {
            this.subTeamController.commit();
            this.subTeamController.start();
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExistingTransactionException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoTransactionException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewContestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
