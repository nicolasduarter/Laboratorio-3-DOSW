package edu.dosw.lab.Reto4;
import java.util.Map;

public class ValidadorCuenta {

    private final Map<String, String> bancos;

    public ValidadorCuenta(Map<String, String> bancos) {
        this.bancos = bancos;
    }

    public boolean esCuentaValida(String numeroCuenta) {
        if (numeroCuenta == null || numeroCuenta.length() != 10) {
            return false;
        }

        boolean soloDigitos = numeroCuenta.chars()
                .allMatch(Character::isDigit);
        if (!soloDigitos) {
            return false;
        }

        String codigoBanco = numeroCuenta.substring(0, 2);

        return bancos.containsKey(codigoBanco);
    }
}


