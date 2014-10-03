package com.mftvanak.javaee.zero.eshop.portal.faces.beans;

import com.mftvanak.javaee.zero.eshop.domain.User;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

@ManagedBean
public class UsersBean {

    public enum UsersPageMode {
        LIST,
        EDIT
    }

    @PersistenceContext(unitName = "eshop")
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    private User editingUser;

    private UsersPageMode mode;

    public UsersPageMode getMode() {
        return mode;
    }

    public void setMode(UsersPageMode mode) {
        this.mode = mode;
    }

    public User getEditingUser() {
        return editingUser;
    }

    public void setEditingUser(User editingUser) {
        this.editingUser = editingUser;
    }

    @PostConstruct
    public void init() {
        mode = UsersPageMode.LIST;
        editingUser = new User();
    }

    public List<User> getUsers() {
        return (List<User>) entityManager.createQuery("From User").getResultList();
    }

    public void changeToEditMode(long id) {
        mode = UsersPageMode.EDIT;
        editingUser = (User) entityManager.createQuery("FROM User u WHERE u.id = ?").setParameter(1, id).getSingleResult();
    }

    public void updateUser() {
        try {
            userTransaction.begin();
            System.out.println("===> " + editingUser.getId());
            entityManager.persist(editingUser);
            userTransaction.commit();
            mode = UsersPageMode.LIST;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
