/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svm.view.controller;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Properties;
import javax.swing.UIManager;
import svm.rmi.abstraction.controller.IRMISearchController;
import svm.rmi.implementation.rmiControllerFactory.RMIControllerFactory;
import svm.view.forms.LoginForm;
import svm.view.forms.MainForm;
import svm.view.forms.PanelContests;
import svm.view.forms.PanelMembers;

/**
 *
 * @author Patrick
 */
public class ApplicationController {

    /**
     * The two main forms
     * login and main applicationwindow
     * 
     */
    private static LoginForm loginForm;
    private static MainForm mainForm;
   
    /**
     * Panels according to the UseCases
     * 
     */
    private PanelContests panelContests;
    private PanelMembers panelMembers;
    
    
    /**
     * UseCase Controller
     * 
     */
    private ViewContestController viewContestCtrl;
    private ViewMemberController viewMemberCtrl;
    private ViewSearchController viewSearchCtrl;
    private ViewSubTeamController viewSubTeamCtrl;

    public ApplicationController() {
        this.panelContests = new PanelContests();
        this.panelMembers = new PanelMembers();
        this.viewContestCtrl = new ViewContestController();
        this.viewMemberCtrl = new ViewMemberController();
        this.viewSearchCtrl = new ViewSearchController();
        this.viewSubTeamCtrl = new ViewSubTeamController();
    }
    
    
    public static void main(String args[]) {

        try {
            // Setup the look and feel properties
            Properties props = new Properties();

            // This property sets the text which will be rendered on the left side of pop-up menus.
            props.put("logoString", "SVM");

            // To remove the bar painted in pop-up menus you have to put an empty string as the logo string
           // props.put("logoString", "");

            // To paint an empty bar just put a non breakeable space as logo string
            // props.put("logoString", "\u00A0");

            // Set theme
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setCurrentTheme(props);

            // select the look and feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            Image icon = Toolkit.getDefaultToolkit().getImage("../resources/svm_icon_neg.png");
            
            // Start the application
            startSVM();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    private static void startSVM() {                
            
            loginForm = new LoginForm();
            loginForm.pack();
            loginForm.setSize(640, 550);
            loginForm.setLocationRelativeTo(null);
            loginForm.setVisible(true);        
    }
    
    
    private void startMainForm(String username) {
            
            mainForm = new MainForm();
            mainForm.setLblUser(username);
            mainForm.setLblPrivileges("[Präsident] - Stufe");

            loadPrivileges("all rights - (it's the president)"); 
            
            mainForm.pack();
            mainForm.setSize(995,740);
            mainForm.setLocationRelativeTo(null);
            mainForm.setVisible(true); 

            mainForm.toFront(); 
            loginForm.setVisible(false);
            mainForm.setAutoRequestFocus(true);
       
            
    }
    
    public void login()
    {            
        startMainForm(loginForm.getTfUserName().getText());
    }
    
    public void loadPrivileges(String privileges)
    {  
        panelMembers.setName("Mitglieder");
        panelContests.setName("Wettbewerbe");
        mainForm.getTabPanelMainCenter().add(panelMembers);
        mainForm.getTabPanelMainCenter().add(panelContests);
    }
    
}
