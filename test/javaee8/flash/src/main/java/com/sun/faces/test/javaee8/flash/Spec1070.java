package com.sun.faces.test.javaee8.flash;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.context.ExternalContext;
import javax.faces.context.FlashWrapper;

@Model
public class Spec1070 {

    public String getMyFlashIsSet() {

        System.err.println("getMyFlashIsSet: ...");

        FacesContext fc = FacesContext.getCurrentInstance();

        Flash flash = fc.getExternalContext().getFlash();
        ExternalContext ec = fc.getExternalContext();
        Flash myFlash = new MyFlash(flash);
        ec.setFlash(myFlash);
        flash = ec.getFlash();

        if (flash instanceof MyFlash) {
            return "setSpec1070";
        } else {
            return "";
        }
    }

    private class MyFlash extends FlashWrapper {
        public MyFlash(Flash flash) {
            super(flash);
        }
    }
}