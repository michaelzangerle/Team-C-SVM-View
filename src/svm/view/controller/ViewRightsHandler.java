/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svm.view.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import svm.logic.abstraction.transferobjects.ITransferAuth;
import svm.view.forms.PanelContests;
import svm.view.forms.PanelMembers;

/**
 *
 * @author Patrick
 */
public class ViewRightsHandler {
    private final ITransferAuth user;
    private final ApplicationController appController;
    private static JFrame mainForm;
    private PanelContests panelContests;
    private PanelMembers panelMembers;

    public ViewRightsHandler(ITransferAuth user, ApplicationController appController) {
        this.appController = appController;        
        this.user = user;
        this.mainForm = appController.getMainForm();
        this.panelContests = appController.getPanelContests();
        this.panelMembers = appController.getPanelMembers();
    }
    
    public void setRights()
    {
        
      
    }
}
