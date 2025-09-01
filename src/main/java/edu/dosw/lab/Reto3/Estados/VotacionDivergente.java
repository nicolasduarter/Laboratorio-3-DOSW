package edu.dosw.lab.Reto3.Estados;

import edu.dosw.lab.Reto3.ContextoVotacion;
import edu.dosw.lab.Reto3.Historia;
import edu.dosw.lab.Reto3.verficarFibo;

import java.util.ArrayList;
import java.util.Objects;

public class VotacionDivergente implements EstadoHistoria{
    private ContextoVotacion contexto;
    private Historia historia;

    public VotacionDivergente(Historia historia, ContextoVotacion contexto) {
        this.historia = historia;
        this.contexto = contexto;
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
            this.contexto.setEstado(new VotacionAceptada(historia,contexto));
            this.contexto.getEstado().CambiarEstado();
        }else{
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
