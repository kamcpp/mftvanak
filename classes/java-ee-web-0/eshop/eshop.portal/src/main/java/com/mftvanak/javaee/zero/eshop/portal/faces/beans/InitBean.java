package com.mftvanak.javaee.zero.eshop.portal.faces.beans;

import com.mftvanak.javaee.zero.eshop.domain.Role;
import com.mftvanak.javaee.zero.eshop.domain.User;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

@ManagedBean
public class InitBean {

    @PersistenceContext(unitName = "eshop")
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    public String doInit() {

        try {
            userTransaction.begin();

            entityManager.createNativeQuery("DELETE FROM user_role").executeUpdate();
            entityManager.createQuery("DELETE FROM Role").executeUpdate();
            entityManager.createQuery("DELETE FROM User").executeUpdate();

            Role roleAdmin = new Role("ROLE_ADMIN");
            entityManager.persist(roleAdmin);
            entityManager.persist(new Role("ROLE_MEMBER"));

            User adminUser = new User();
            adminUser.setName("Admin");
            adminUser.setFamily("Admin");
            adminUser.setUsername("admin");
            adminUser.setPassword("12345");
            adminUser.getRoles().add(roleAdmin);

            entityManager.persist(adminUser);
            userTransaction.commit();

            return "index";
        } catch (NotSupportedException | SystemException |HeuristicRollbackException | RollbackException |HeuristicMixedException e ) {
            e.printStackTrace();
            return "init";
        }
    }
}
