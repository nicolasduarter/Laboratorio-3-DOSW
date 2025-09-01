package edu.dosw.lab.Reto3;



import edu.dosw.lab.Reto3.Estados.VotacionPendiente;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class PlanningPoker {
    private ArrayList<Historia> historias;
    private Historia historiaActual;
    private ContextoVotacion contextoVotacion;

    public PlanningPoker(){
        historias = new ArrayList<>();
    }

    public void ponerHistoria(Historia historia){
        historias.add(historia);
    }

    public void setHistoriaActual() {
        Optional<Historia> actu = historias.stream().filter(h -> !h.getEstado()).findFirst();
        this.historiaActual = actu.orElse(null);
        if (this.historiaActual == null) {
            finalizar();
        } else {
            System.out.println(this.historiaActual.getHistoria());
            comenzarContexto();
        }
    }

    public void setPrimeraHistoria(){
        if(!historias.isEmpty()){
            this.historiaActual = historias.get(0);
        }
    }

    public void comenzarContexto(){
        contextoVotacion = new ContextoVotacion(this.historiaActual,this, null);
    }



    public void finalizar() {
        System.out.println("\n Sesión finalizada. Resumen:");
        for (Historia h : historias) {
            String status = h.getEstado() ? "Aceptada" : "Rechazada";
            System.out.println(status + " " + h.getHistoria());
        }
        System.exit(0);
    }

    public Historia getHistoriaActual(){
        return historiaActual;
    }


    public ArrayList<Integer> votacion() {
        ArrayList<Integer> votos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa el numero de persinas: ");
        int cantidadPersonas = sc.nextInt();
        System.out.print("=============== \n");

        for (int i = 1; i <= cantidadPersonas; i++) {
            System.out.print("voto" + i + ": ");
            while (!sc.hasNextInt()) {
                System.out.println("No vale");
                sc.next();
            }
            int voto = sc.nextInt();
            votos.add(voto);
        }

        return votos;
    }
}
