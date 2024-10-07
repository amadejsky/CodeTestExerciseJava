package com.amadejsky.model;

import com.amadejsky.enums.TypLisci;

public class DrzewoLisciaste extends Drzewo{
    public DrzewoLisciaste(String pien, String galezie, TypLisci liscie) {
        super(pien, galezie, liscie);
    }

    @Override
    void rosnij() {
        System.out.println("Drzewo Lisciaste rośnie!");
    }
}
