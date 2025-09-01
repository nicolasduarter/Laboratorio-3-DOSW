package edu.dosw.lab.Reto3.Estados;

import edu.dosw.lab.Reto3.ContextoVotacion;
import edu.dosw.lab.Reto3.Historia;
import edu.dosw.lab.Reto3.verficarFibo;

import java.util.ArrayList;
import java.util.Objects;

public class VotacionPendiente implements EstadoHistoria {
    private ContextoVotacion contexto;
    private Historia historia;
    private EstadoHistoria nuevoEstado;


    public VotacionPendiente(Historia historia, ContextoVotacion contexto) {
        this.contexto = contexto;
        this.historia = historia;
    }

    public void iniciarVotacion(){
        this.contexto.recibirVotos();
    }


    public void recibirVotos(ArrayList<Integer> votos){
        historia.setVotos(votos);
    }

    private boolean manejarVotos(Historia historia){
        verficarFibo fibo =  new verficarFibo();
        ArrayList<Integer> votos = historia.getVotos();
        Boolean todos = !votos.isEmpty() && votos.stream().allMatch(x -> Objects.equals(x, votos.get(0)));

        Boolean fibo2 = fibo.verificacion(votos);
        return todos && fibo2;
    }

    @Override
    public void CambiarEstado(){
        if(manejarVotos(this.historia)){
            this.nuevoEstado = new VotacionAceptada(historia,contexto);
            this.contexto.setEstado(this.nuevoEstado);
            System.out.println("Votacion Aceptada");
        }else{
            this.nuevoEstado = new VotacionDivergente(historia,contexto);
            this.contexto.setEstado(this.nuevoEstado);
            System.out.println("Votacion Divergente");
            this.contexto.volverAvotar();
        }


    }
    @Override
    public void estadoDeHistoria() {
            if(manejarVotos(this.historia)){
                this.historia.setEstado(true);
            }else{
                this.historia.setEstado(false);
            }
    }



}
