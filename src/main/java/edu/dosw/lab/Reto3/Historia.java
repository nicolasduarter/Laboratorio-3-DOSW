package edu.dosw.lab.Reto3;

import java.util.ArrayList;

public  class Historia {
    private String Historia;
    private boolean estado;
    private ArrayList<Integer> votos;
    private int puntajeFinal;

    public Historia() {
        this.Historia = "";
        this.estado = false;
        this.votos = new ArrayList<>();

    }

    public void setHistoria(String Historia){
        this.Historia = Historia;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public void setVotos(ArrayList<Integer> votos){
        this.votos = votos;
    }

    public ArrayList<Integer> getVotos(){
        return this.votos;
    }

    public boolean getEstado(){
        return this.estado;
    }
    public String getHistoria(){
        return this.Historia;
    }

}
