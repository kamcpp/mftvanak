package com.mftvanak.javaee.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="xyz")
public class HelloWorldBean {
    public String sayHello() {
        return "HELLO WORLD";
    }
}
