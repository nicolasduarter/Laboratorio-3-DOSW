package edu.dosw.lab.Reto4;

public class Cuenta {
    private String id;
    private double saldo;

    public Cuenta(String id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ModificarSaldo(double saldo) {
        this.saldo += saldo;
    }

}
