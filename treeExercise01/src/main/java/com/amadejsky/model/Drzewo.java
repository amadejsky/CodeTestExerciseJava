package com.amadejsky.model;

import com.amadejsky.enums.TypLisci;

abstract class Drzewo {
    //Pozwoliłem sobie na dodanie pola nazwa aby wiadomość przesyłana przez szczegóły w łatwiejszy sposób identyfikowała naszą Encję
    protected String nazwa;
    protected String pien;
    protected String galezie;
    protected TypLisci liscie;

    abstract void rosnij();

    public void szczegoly(){
                System.out.println(
                        "Opisywanym drzewem jest: " +this.nazwa+"\n"+
                                "drzewo to jest: "+this.liscie.toString().toLowerCase()+
                                " oraz posiada: \n"+this.pien+" i "+this.galezie+
                "\n-----------------------------------------------------");

    };

    public Drzewo(String nazwa, String pien, String galezie, TypLisci liscie) {
        this.nazwa = nazwa;
        this.pien = pien;
        this.galezie = galezie;
        this.liscie = liscie;
    }
}
