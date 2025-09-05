package edu.dosw.lab.Reto3;

import java.util.ArrayList;
import java.util.List;

public class Reto3 {

    public static void main(String[] args) {
        PlanningPoker poker = new PlanningPoker();

        Historia h1 = new Historia();
        h1.setHistoria("Historia 1");
        Historia h2 = new Historia();
        h2.setHistoria("Historia 2");

        poker.ponerHistoria(h1);
        poker.ponerHistoria(h2);

        poker.setHistoriaActual();


    }
}

