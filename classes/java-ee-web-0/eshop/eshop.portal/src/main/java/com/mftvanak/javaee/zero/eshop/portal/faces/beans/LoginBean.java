package com.mftvanak.javaee.zero.eshop.portal.faces.beans;

import com.mftvanak.javaee.zero.eshop.domain.Role;
import com.mftvanak.javaee.zero.eshop.domain.User;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.io.IOException;

@ManagedBean
public class LoginBean {

    @PersistenceContext(unitName = "eshop")
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    private String username;
    private String password;
    private String errorMessage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String processLogin() {
        try {
            User user = (User)entityManager.createQuery("FROM User user WHERE user.username = ? AND user.password = ?").setParameter(1, username).setParameter(2, password).getSingleResult();
            for(Role role : user.getRoles()) {
                System.out.println("---> " + role.getName());
            }
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            errorMessage = "Wrong username or password";
            return "login";
        }
    }

    public void logout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
