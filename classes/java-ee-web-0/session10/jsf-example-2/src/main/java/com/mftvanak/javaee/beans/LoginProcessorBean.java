package com.mftvanak.javaee.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginProcessorBean {
    public String processLogin() {
        return "home";
    }
}
