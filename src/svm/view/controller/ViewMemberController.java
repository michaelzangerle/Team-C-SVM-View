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
import javax.swing.JPanel;
import svm.domain.abstraction.exception.DomainAttributeException;
import svm.domain.abstraction.exception.DomainParameterCheckException;
import svm.logic.abstraction.exception.IllegalGetInstanceException;
import svm.logic.abstraction.transferobjects.ITransferDepartment;
import svm.logic.abstraction.transferobjects.ITransferLocation;
import svm.logic.abstraction.transferobjects.ITransferMember;
import svm.persistence.abstraction.exceptions.ExistingTransactionException;
import svm.persistence.abstraction.exceptions.NoSessionFoundException;
import svm.persistence.abstraction.exceptions.NoTransactionException;
import svm.rmi.abstraction.controller.IRMIMemberController;
import svm.rmi.abstraction.controller.IRMISearchController;
import svm.rmi.abstraction.factory.IRMIControllerFactory;
import svm.view.forms.PanelMembers;

/**
 *
 * @author Patrick
 */
public class ViewMemberController {

    private IRMIControllerFactory factory = ApplicationController.factory;
    private IRMIMemberController memberController;
    private IRMISearchController searchController;
    private PanelMembers panelMembers;

    public ViewMemberController(PanelMembers panelMembers) {
        try {
            this.panelMembers = panelMembers;
            this.searchController = factory.getRMISearchController(ApplicationController.user);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchMembers() {
        try {
            
            ITransferDepartment chosenDepartment = (ITransferDepartment) panelMembers.getCmbSearchDepartment().getSelectedItem();
            this.searchController.start();
            List<ITransferMember> members = this.searchController.getMembers(
                    panelMembers.getTfSearchFirstName().getText(),
                    panelMembers.getTfSearchLastName().getText(),
                    chosenDepartment, panelMembers.getCbxSearchFee().isSelected());
            DefaultListModel<ITransferMember> model = new DefaultListModel<>();
            for (ITransferMember m : members) {
                model.addElement(m);
            }
            panelMembers.getListboxShowMembers().setModel(model);
            this.searchController.commit();

        } catch (ExistingTransactionException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoTransactionException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DomainParameterCheckException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void showMembers() {
        ITransferMember member = (ITransferMember) panelMembers.getListboxShowMembers().getSelectedValue();
        if (member == null) {
            return;
        }
        try {
            if (this.memberController != null) {
                this.memberController.abort();
            }
        } catch (ExistingTransactionException | NoSessionFoundException | NoTransactionException | RemoteException ex) {
        }
        try {
            this.memberController = this.factory.getRMIMemberController(ApplicationController.user, member);
            this.memberController.start();
            ITransferMember tmp = this.memberController.getMember();
            panelMembers.getTfFirstName().setText(tmp.getFirstName());
            panelMembers.getTfLastName().setText(tmp.getLastName());
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalGetInstanceException ex) {
            Logger.getLogger(PanelMembers.class.getName()).log(Level.SEVERE, null, ex);
        }catch (RemoteException ex) {
            Logger.getLogger(PanelMembers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveMember() {
        try {
            this.memberController.setFirstName(panelMembers.getTfFirstName().getText());
            this.memberController.setLastName(panelMembers.getTfLastName().getText());
            this.memberController.setBirthDate(new Date());
            this.memberController.setEntryDate(new Date());
            this.memberController.setGender("M");
            this.memberController.setSocialNumber("   ");
            this.memberController.setTitle(" ");
            this.memberController.setEmail1(" ");
            this.memberController.setEmail2(" ");
            this.memberController.setPhone1(" ");
            this.memberController.setPhone2(" ");
            this.memberController.setFax(" ");
            this.memberController.setLat("47");
            this.memberController.setLong("9");
            this.memberController.setStreet(" ");
            this.memberController.setStreetNumber("1");
            this.memberController.setUsername("1234");

            this.memberController.commit();
        } catch (ExistingTransactionException | NoSessionFoundException | NoTransactionException | DomainParameterCheckException | DomainAttributeException | RemoteException ex) {
            Logger.getLogger(PanelMembers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createNewMember() {
        try {
            if (this.memberController != null) {
                this.memberController.abort();
            }
        } catch (ExistingTransactionException | NoSessionFoundException | NoTransactionException | RemoteException ex) {
        }

        try {
            this.memberController = this.factory.getRMIMemberController(ApplicationController.user);
            this.memberController.start();
            ITransferMember tmp = this.memberController.getMember();
            
            showMemberDetails(tmp);         
            
            
        } catch (NoSessionFoundException | IllegalGetInstanceException | RemoteException ex) {
            Logger.getLogger(PanelMembers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showDepartments() {
        try {
           
            DefaultComboBoxModel<ITransferDepartment> model = new DefaultComboBoxModel<>();
            this.searchController.start();
            for (ITransferDepartment department : searchController.getDepartments()) {
                model.addElement(department);
            }
            panelMembers.getCmbSearchDepartment().setModel(model);
            this.searchController.commit();
        } catch (ExistingTransactionException | NoTransactionException | NoSessionFoundException | IllegalGetInstanceException | RemoteException ex) {

            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showMemberDetails(ITransferMember tmp) {
        
         panelMembers.getTfFirstName().setText(tmp.getFirstName());
         panelMembers.getTfLastName().setText(tmp.getLastName());
    }
    
    
}
