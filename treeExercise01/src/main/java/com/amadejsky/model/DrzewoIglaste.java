package com.amadejsky.model;

import com.amadejsky.enums.TypLisci;

public class DrzewoIglaste extends Drzewo {
    public DrzewoIglaste(String pien, String galezie, TypLisci liscie) {
        super(pien, galezie, liscie);
    }

    @Override
    void rosnij() {
        System.out.println("Drzewo Iglaste rośnie!");
    }

}
