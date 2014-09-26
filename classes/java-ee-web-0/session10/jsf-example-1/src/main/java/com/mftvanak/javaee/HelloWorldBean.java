package com.mftvanak.javaee;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloWorldBean {
    public String sayHello() {
        return "HELLO WORLD";
    }
}
