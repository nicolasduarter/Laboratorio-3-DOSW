package edu.dosw.lab.Reto3;

import edu.dosw.lab.Reto3.Estados.EstadoHistoria;
import edu.dosw.lab.Reto3.Estados.VotacionPendiente;

import java.util.ArrayList;

public class ContextoVotacion {
    private Historia historia;
    private PlanningPoker planningPoker;
    private EstadoHistoria estado;

    public ContextoVotacion(Historia h, PlanningPoker p, EstadoHistoria estado){
        this.historia = h;
        this.planningPoker = p;
        VotacionPendiente votacion = new VotacionPendiente(historia, this);
        this.estado = votacion;
        votacion.iniciarVotacion();
    }

    public void setEstado(EstadoHistoria estado){
        this.estado = estado;
    }


    public void volverAvotar(){
        VotacionPendiente votacion = new VotacionPendiente(historia, this);
        this.estado = votacion;
        votacion.iniciarVotacion();
    }

    public void cambiarHistoria(){
        this.planningPoker.setHistoriaActual();
        this.historia = this.planningPoker.getHistoriaActual();
    }

    public void recibirVotos() {
        ArrayList<Integer> votos = this.planningPoker.votacion();
        estado.recibirVotos(votos);
        estado.CambiarEstado();
    }

    public EstadoHistoria getEstado() {
        return estado;
    }




}
