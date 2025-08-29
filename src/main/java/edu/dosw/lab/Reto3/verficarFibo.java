package edu.dosw.lab.Reto3;

import java.util.ArrayList;

public class verficarFibo implements Verificacion {

    public static boolean esCuadradoPerfecto(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }

    private  boolean esFibonacci(int n){
        return esCuadradoPerfecto(5 * n * n + 4) || esCuadradoPerfecto(5 * n * n - 4);
    }

    @Override
    public boolean verificacion(ArrayList<Integer> lista){
        boolean res = lista.stream().allMatch(x -> esFibonacci(x));
        boolean todosIguales = lista.stream()
                .allMatch(e -> e.equals(lista.get(0)));

        return res && todosIguales;
    }
}
