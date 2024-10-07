package com.amadejsky.model;

import com.amadejsky.enums.TypLisci;

abstract class Drzewo {
    protected String pien;
    protected String galezie;
    protected TypLisci liscie;

    abstract void rosnij();

    public void szczegoly(){
                System.out.println("Opisywane drzewo jest : \n" +
                this.liscie.toString().toLowerCase()+" oraz posiada: \n"+this.pien+" i "+this.galezie);
    };

    public Drzewo(String pien, String galezie, TypLisci liscie) {
        this.pien = pien;
        this.galezie = galezie;
        this.liscie = liscie;
    }
}
