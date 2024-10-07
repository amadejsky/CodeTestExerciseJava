package com.amadejsky.model;

import com.amadejsky.enums.TypLisci;

public class DrzewoIglaste extends Drzewo {
    public DrzewoIglaste(String nazwa, String pien, String galezie) {
        super(nazwa, pien, galezie, TypLisci.IGLASTE);
    }

    //Oczywiście można by wprowadzić jakiś licznik typu wzrost inkrementujący się przy wywołaniu metody rosnij()
    @Override
    public void rosnij() {
        System.out.println(
                this.nazwa+", drzewo Iglaste rośnie!"
        );
    }

}
