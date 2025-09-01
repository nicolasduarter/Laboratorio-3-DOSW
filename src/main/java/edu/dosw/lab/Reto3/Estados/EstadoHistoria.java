package edu.dosw.lab.Reto3.Estados;

import edu.dosw.lab.Reto3.Historia;
import edu.dosw.lab.Reto3.PlanningPoker;

import java.util.ArrayList;

public interface EstadoHistoria {
    void CambiarEstado();
    void estadoDeHistoria();
    void recibirVotos(ArrayList<Integer> votos);
}
