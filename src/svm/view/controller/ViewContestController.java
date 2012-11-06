/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svm.view.controller;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import svm.domain.abstraction.exception.DomainAttributeException;
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
            DefaultListModel<ITransferContest> model = new DefaultListModel<>();
            for (ITransferContest c : searchController.getContests()) {
                model.addElement(c);
            }
            this.panelContests.getListboxShowContests().setModel(model);
            this.panelContests.getListboxShowContests().setSelectedIndex(0);
            this.searchController.commit();


        } catch (ExistingTransactionException | NoTransactionException | NoSessionFoundException | IllegalGetInstanceException | RemoteException ex) {
            Logger.getLogger(PanelMembers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void showMatchOverview(){
        try {
            this.contestController = factory.getRMIContestController((ITransferContest)this.panelContests.getListboxShowContests().getSelectedValue(), ApplicationController.user);
            this.contestController.start();
            int i = 0;
            for(ITransferMatch m : contestController.getMatches()){
                this.panelContests.getTableMatchesOverview().setValueAt(m.getStart(), i, 0);
                this.panelContests.getTableMatchesOverview().setValueAt(m.getStart(), i, 1);
                this.panelContests.getTableMatchesOverview().setValueAt(m.getStart(), i, 2);
                this.panelContests.getTableMatchesOverview().setValueAt(m.getStart(), i, 3);
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
    }

    public void removeTeamFromContest() {
    }

    public void showAllTeams() {
        /*try {
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
        }*/
    }

    public void showAllLocations() {
        try {
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
