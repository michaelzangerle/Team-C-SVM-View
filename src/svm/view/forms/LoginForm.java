/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package svm.view.forms;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import svm.logic.abstraction.exception.IllegalGetInstanceException;
import svm.logic.abstraction.transferobjects.ITransferAuth;
import svm.logic.abstraction.transferobjects.ITransferMember;
import svm.persistence.abstraction.exceptions.ExistingTransactionException;
import svm.persistence.abstraction.exceptions.NoSessionFoundException;
import svm.persistence.abstraction.exceptions.NoTransactionException;
import svm.persistence.abstraction.exceptions.NotSupportedException;
import svm.rmi.abstraction.controller.IRMILoginController;
import svm.rmi.abstraction.factory.IRMIControllerFactory;
import svm.view.controller.ApplicationController;

/**
 *
 * @author Patrick
 */
public class LoginForm extends javax.swing.JFrame {

    ApplicationController appController;
    
    // The one and only instance of the loginForm
    private static LoginForm loginForm = null;
    private static IRMIControllerFactory factory;

    /**
     * Creates new form LoginForm
     */
    public LoginForm(IRMIControllerFactory factory) {
        initComponents();
        //this.setIconImage(new ImageIcon(getClass().getResource("svm/view/resources/svm_icon_neg.png")).getImage());
        this.appController = new ApplicationController();
        this.factory=factory;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLoginFrame = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        panelLogin = new javax.swing.JPanel();
        tfUserName = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        btnLDAPLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SVM Login");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setMaximumSize(null);
        setMinimumSize(null);
        setName("frameLogin"); // NOI18N
        setPreferredSize(new java.awt.Dimension(640, 500));
        setResizable(false);

        panelLoginFrame.setBackground(new java.awt.Color(255, 255, 255));
        panelLoginFrame.setMinimumSize(new java.awt.Dimension(640, 500));
        panelLoginFrame.setName(""); // NOI18N

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/svm/view/resources/svm_lg_640.png"))); // NOI18N
        lblLogo.setToolTipText("");
        lblLogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblLogo.setAlignmentY(0.0F);
        lblLogo.setDoubleBuffered(true);
        lblLogo.setMaximumSize(new java.awt.Dimension(640, 200));
        lblLogo.setMinimumSize(new java.awt.Dimension(625, 200));
        lblLogo.setPreferredSize(new java.awt.Dimension(640, 200));
        lblLogo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255)), "Please enter username and password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N
        panelLogin.setForeground(new java.awt.Color(204, 204, 204));
        panelLogin.setToolTipText("");
        panelLogin.setAlignmentY(0.0F);
        panelLogin.setName("panelLogin"); // NOI18N

        tfUserName.setBackground(new java.awt.Color(229, 229, 229));
        tfUserName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfUserName.setText("tf-test");
        tfUserName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        tfUserName.setName(""); // NOI18N

        tfPassword.setBackground(new java.awt.Color(229, 229, 229));
        tfPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfPassword.setText("1234");
        tfPassword.setToolTipText("");
        tfPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        tfPassword.setName(""); // NOI18N

        btnLDAPLogin.setText("LDAP-Login");
        btnLDAPLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLDAPLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLDAPLoginActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelLoginLayout = new org.jdesktop.layout.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelLoginLayout.createSequentialGroup()
                        .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(249, 249, 249)
                        .add(btnLDAPLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(tfUserName)
                    .add(tfPassword))
                .addContainerGap())
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelLoginLayout.createSequentialGroup()
                .add(21, 21, 21)
                .add(tfUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(32, 32, 32)
                .add(tfPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 29, Short.MAX_VALUE)
                .add(panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnLDAPLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout panelLoginFrameLayout = new org.jdesktop.layout.GroupLayout(panelLoginFrame);
        panelLoginFrame.setLayout(panelLoginFrameLayout);
        panelLoginFrameLayout.setHorizontalGroup(
            panelLoginFrameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(lblLogo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(panelLoginFrameLayout.createSequentialGroup()
                .add(25, 25, 25)
                .add(panelLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelLoginFrameLayout.setVerticalGroup(
            panelLoginFrameLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelLoginFrameLayout.createSequentialGroup()
                .add(lblLogo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(panelLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 11, Short.MAX_VALUE))
        );

        lblLogo.getAccessibleContext().setAccessibleParent(this);
        panelLogin.getAccessibleContext().setAccessibleName("panelLogin");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelLoginFrame, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelLoginFrame, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelLoginFrame.getAccessibleContext().setAccessibleDescription("");

        getAccessibleContext().setAccessibleName("formLogin");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLDAPLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLDAPLoginActionPerformed
        try {
            IRMILoginController loginController=factory.getRMILoginController();
            loginController.start();
            if(loginController.login(this.tfUserName.getText(), String.valueOf(this.tfPassword.getPassword())))
            { ApplicationController.user=loginController.getMember();
              appController.login(ApplicationController.user.getFirstName()+ " " +ApplicationController.user.getLastName(),"no pass");
            }  else{
                System.out.println("Falsches Passwort oder Benutzer");
            }
            
            try {
                loginController.commit();
            } catch (    ExistingTransactionException | NoTransactionException ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NoSessionFoundException | IllegalGetInstanceException | InstantiationException | IllegalAccessException | NotSupportedException | RemoteException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_btnLDAPLoginActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        // appController.cancel();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            IRMILoginController loginController=factory.getRMILoginController();
            loginController.start();
          
            if(loginController.loginWithoutLdap(this.tfUserName.getText(), this.tfPassword.getPassword().toString()))
            { ApplicationController.user=loginController.getMember();
              appController.login(ApplicationController.user.getFirstName()+ " " +ApplicationController.user.getLastName(),"no pass");
            }
            
        System.out.println(ApplicationController.user.getFirstName()); 
        System.out.println(ApplicationController.user.getLastName());
        System.out.println(ApplicationController.user.getTitle());
        System.out.println(ApplicationController.user.getUsername());
        System.out.println("Contest adding : "+ ApplicationController.user.isAllowedForContestAdding());
        System.out.println("Contest Details changing: " + ApplicationController.user.isAllowedForContestDetailsChanging());
        System.out.println("Contest Teams changing: " + ApplicationController.user.isAllowedForContestTeamsChanging());
        System.out.println("Contest SubTeam changing: " + ApplicationController.user.isAllowedForContestSubTeamChanging());
        System.out.println("Contest Match changing: " + ApplicationController.user.isAllowedForContestMatchAdding());
        System.out.println("Contest Result changing: " + ApplicationController.user.isAllowedForContestResultChanging());
        System.out.println("Contest deleting: " + ApplicationController.user.isAllowedForContestDeleting());
        System.out.println("Contest viewing: " + ApplicationController.user.isAllowedForContestViewing());
        System.out.println("Member adding: " + ApplicationController.user.isAllowedForMemberAdding());
        System.out.println("Member changing: " + ApplicationController.user.isAllowedForMemberChanging());   
        System.out.println("Member deleting: " + ApplicationController.user.isAllowedForMemberDeleting());
        System.out.println("Member viewing: " + ApplicationController.user.isAllowedForMemberViewing());
        System.out.println("Searching: " + ApplicationController.user.isAllowedForSearching());
        System.out.println("Privileges editing: " + ApplicationController.user.isAllowedForMemberAddingPrivileges());

      
        loginController.commit();
       
    }   catch (ExistingTransactionException | NoTransactionException | NoSessionFoundException | IllegalGetInstanceException | NotSupportedException | InstantiationException | IllegalAccessException | RemoteException ex) {    
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_btnLoginActionPerformed
    
     public ITransferAuth getMember() {        
        return ApplicationController.user;
       
    }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnCancel;
    protected javax.swing.JButton btnLDAPLogin;
    protected javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelLoginFrame;
    protected javax.swing.JPasswordField tfPassword;
    protected javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables

    public JPasswordField getTfPassword() {
        return tfPassword;
    }

    public void setTfPassword(JPasswordField tfPassword) {
        this.tfPassword = tfPassword;
    }

    public JTextField getTfUserName() {
        return tfUserName;
    }

    public void setTfUserName(JTextField tfUserName) {
        this.tfUserName = tfUserName;
    }

    public void login() {
        
        loginForm.tfUserName.getText();
        
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnLogin() {
        return btnLDAPLogin;
    }

   
}
