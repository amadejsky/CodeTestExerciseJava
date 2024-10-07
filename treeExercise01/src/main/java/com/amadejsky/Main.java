package com.amadejsky;

import com.amadejsky.enums.TypLisci;
import com.amadejsky.model.DrzewoLisciaste;

public class Main {
    public static void main(String[] args) {

        DrzewoLisciaste Buk = new DrzewoLisciaste("Gruby pień","dlugie szumiące galezie", TypLisci.LISCIASTE);
        Buk.szczegoly();
    }
}