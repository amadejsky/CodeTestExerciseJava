package com.amadejsky;

import com.amadejsky.enums.TypLisci;
import com.amadejsky.model.DrzewoIglaste;
import com.amadejsky.model.DrzewoLisciaste;

public class Main {
    public static void main(String[] args) {

        DrzewoLisciaste Buk = new DrzewoLisciaste("Buk","Gruby pień","długie szumiące gałęzie");
        DrzewoIglaste Sosna = new DrzewoIglaste("Sosna","Średniej grubości pień pachnący żywicą","rozłorzyste gałęzie");
        Buk.szczegoly();
        Sosna.szczegoly();
        Buk.rosnij();
        Sosna.rosnij();
    }
}