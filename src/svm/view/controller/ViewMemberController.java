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
                    panelMembers.getTfSearchLastName().getText());//,chosenDepartment,panelMembers.getCbxSearchFee().isSelected());
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
           // panelMembers.getTfFirstName().setText(tmp.getFirstName());
           // panelMembers.getTfLastName().setText(tmp.getLastName());
              showMemberDetails(tmp);        
            
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
          //  ITransferMember member = (ITransferMember) panelMembers.getListboxShowMembers().getSelectedValue();
         //   this.memberController = this.factory.getRMIMemberController(ApplicationController.user, member);
            this.memberController.setFirstName(panelMembers.getTfFirstName().getText());
            this.memberController.setLastName(panelMembers.getTfLastName().getText());
            this.memberController.setBirthDate(panelMembers.getDcBirthDate().getDate());
            this.memberController.setEntryDate(panelMembers.getDcEntryDate().getDate());
            this.memberController.setGender(panelMembers.getCmbGender().getSelectedItem().toString());
            this.memberController.setSocialNumber(panelMembers.getTfSocialNumber().getText());
            this.memberController.setTitle(" ");
            this.memberController.setEmail1(panelMembers.getTfMail1().getText());
            this.memberController.setEmail2(panelMembers.getTfMail2().getText());
            this.memberController.setPhone1(panelMembers.getTfPhone1().getText());
            this.memberController.setPhone2(panelMembers.getTfPhone2().getText());
            //this.memberController.setFax(" ");
            //this.memberController.setLat("47");
            //this.memberController.setLong("9");
            if(panelMembers.getCheckMemberFee().isEnabled() && panelMembers.getCheckMemberFee().isSelected()){
                try {
                    this.memberController.setPaidCurrentYear();
                } catch (        RemoteException | DomainAttributeException | NoSessionFoundException | IllegalAccessException | InstantiationException ex) {
                    Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);  
                }
            }
            this.memberController.setStreet(panelMembers.getTfStreet().getText());
            this.memberController.setStreetNumber(panelMembers.getTfStreetNumber().getText());
            this.memberController.setUsername(panelMembers.getTfUserName().getText());
            //this.memberController.setUsername("1234");

           this.memberController.commit();
          // this.memberController.start();

        } catch (RemoteException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DomainParameterCheckException ex) {            
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DomainAttributeException ex) {
            javax.swing.JOptionPane.showMessageDialog(panelMembers, "Bitte alle Felder ausfüllen!");
        } catch (ExistingTransactionException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoTransactionException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSessionFoundException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    

    public void createNewMember() {
        try {
            
            clearMemberFields();
            
            if (this.memberController != null) {
                this.memberController.abort();
            }
        } catch (ExistingTransactionException | NoSessionFoundException | NoTransactionException | RemoteException ex) {
        }

        try {
            this.memberController = this.factory.getRMIMemberController(ApplicationController.user);
            this.memberController.start();
            ITransferMember tmp = this.memberController.getMember();            
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
        try {
            panelMembers.getTfFirstName().setText(tmp.getFirstName());
            panelMembers.getTfLastName().setText(tmp.getLastName());
            if (tmp.getGender().equalsIgnoreCase("m")) {
                 panelMembers.getCmbGender().setSelectedIndex(0);
            }else{
                panelMembers.getCmbGender().setSelectedIndex(1);
            }
            panelMembers.getTfUserName().setText(tmp.getUsername());
            panelMembers.getTfMail1().setText(tmp.getEmail1());
            panelMembers.getTfMail2().setText(tmp.getEmail2());
            panelMembers.getTfPhone1().setText(tmp.getPhone1());
            panelMembers.getTfSocialNumber().setText(tmp.getSocialNumber());
            panelMembers.getTfStreet().setText(tmp.getStreet());
            panelMembers.getTfStreetNumber().setText(tmp.getStreetNumber());
            panelMembers.getDcBirthDate().setDate(tmp.getBirthDate());
            panelMembers.getDcEntryDate().setDate(tmp.getEntryDate());
            panelMembers.getCheckMemberFee().setSelected(tmp.getPaid());
            if(tmp.getPaid()){
                panelMembers.getCheckMemberFee().setEnabled(false);
            }
        } catch (DomainParameterCheckException ex) {
            Logger.getLogger(ViewMemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearMemberFields() {
        
            panelMembers.getTfFirstName().setText("");
            panelMembers.getTfLastName().setText("");
            panelMembers.getTfUserName().setText("");
            panelMembers.getTfMail1().setText("");
            panelMembers.getTfMail2().setText("");
            panelMembers.getTfPhone1().setText("");
            panelMembers.getTfSocialNumber().setText("");
            panelMembers.getTfStreet().setText("");
            panelMembers.getTfStreetNumber().setText("");
            panelMembers.getDcBirthDate().setDate(new Date());
            panelMembers.getDcEntryDate().setDate(new Date());
            panelMembers.getCheckMemberFee().setSelected(false);       
    }
    
    
}
