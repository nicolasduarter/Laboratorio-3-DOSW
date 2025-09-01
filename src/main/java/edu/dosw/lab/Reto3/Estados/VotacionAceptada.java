package edu.dosw.lab.Reto3.Estados;

import edu.dosw.lab.Reto3.ContextoVotacion;
import edu.dosw.lab.Reto3.Historia;

import java.util.ArrayList;

public class VotacionAceptada implements EstadoHistoria {
    private ContextoVotacion contexto;
    private Historia historia;

    public VotacionAceptada(Historia historia, ContextoVotacion contexto) {
        this.historia = historia;
        this.contexto = contexto;
        CambiarEstado();
    }

    @Override
    public void CambiarEstado() {
            estadoDeHistoria();
            this.contexto.cambiarHistoria();

    }

    @Override
    public void estadoDeHistoria() {
        this.historia.setEstado(true);
    }

    public void recibirVotos(ArrayList<Integer> votos){
        historia.setVotos(votos);
    }

}
