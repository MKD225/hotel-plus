/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gsoft.controller;

import com.gsoft.dao.RolesFacade;
import com.gsoft.dao.UsersFacade;
import com.gsoft.model.Users;
import com.gsoft.util.Encryption;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author vgladky
 */
@Named("user")
@SessionScoped
public class UserBean implements Serializable {

    private String login;
    private String pass;
    private boolean loggedIn = false;
    private boolean admin = false;
    private Users user;
    @EJB
    private UsersFacade usersDao;
    @EJB
    private RolesFacade rolesDao;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getRole() {
        return user.getRoleId().getRolename();
    }

    public String getRights() {
        return user.getRoleId().getDescription();
    }
    
    public String logIn() throws Exception {
        String passHash;
        passHash = Encryption.getHash(pass);
        user = usersDao.find(login);
        if (user != null && user.getPasshash().equals(passHash)) {
            loggedIn = true;
        } else {
            FacesMessage message = com.gsoft.util.Messages.getMessage("com.gsoft.messages", "loginCombNotFound", null);
            message.setSeverity(FacesMessage.SEVERITY_WARN);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, message);
            return null;
        }
        return "/index?faces-redirect=true";
    }

    public String logOut() {
        loggedIn = false;
        login = "";
        pass = "";
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        return "/login?faces-redirect=true";
    }

    public void beforeListener() throws IOException {
        if (!loggedIn) {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/faces/login.xhtml");
        }
    }
}
