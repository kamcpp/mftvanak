package com.mftvanak.javaee.zero.eshop.portal.faces.beans;

import com.mftvanak.javaee.zero.eshop.domain.Role;
import com.mftvanak.javaee.zero.eshop.domain.User;

import javax.annotation.Resource;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@ManagedBean
public class SignupBean {

    @PersistenceContext(unitName = "eshop")
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    private String name;
    private String family;
    private String username;
    private String password;
    private String passwordConfirmation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

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

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String processSignup() {
        try {
            userTransaction.begin();

            User user = new User();
            user.setFamily(family);
            user.setName(name);
            user.setPassword(password);
            user.setUsername(username);

            Role memberRole = (Role) entityManager.createQuery("FROM Role role WHERE role.name = 'ROLE_MEMBER'").getSingleResult();
            user.getRoles().add(memberRole);

            entityManager.persist(user);
            userTransaction.commit();
            return "login";
        } catch (Exception e) {
            try {
                userTransaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return "signup";
        }
    }
}
