package edu.dosw.lab.Reto4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

class CuentaTest {

    @Test
    void CuentaValida() {
        Map<String, String> bancos = Map.of(
                "01", "BANCOLOMBIA",
                "02", "DAVIVIENDA"
        );

        ValidadorCuenta validador = new  ValidadorCuenta(bancos);

        String cuentaValida = "0101234567";
        assertTrue(validador.esCuentaValida(cuentaValida));

        String cuentaInvalida = "9912345678";
        assertFalse(validador.esCuentaValida(cuentaInvalida));
    }

    @Test
    void SaldoDeposito() {
        Cuenta cuenta = new Cuenta("0100000000",20000);
        double extracto1 = cuenta.getSaldo();
        cuenta.ModificarSaldo(4000);
        double extracto2 = cuenta.getSaldo();
        cuenta.ModificarSaldo(-3000);
        double extracto3 = cuenta.getSaldo();
        assertNotEquals(extracto1, extracto2);
        assertNotEquals(extracto1, extracto3);
        assertNotEquals(extracto2, extracto3);
    }

    @Test
    void CrearCuenta() {
        Cuenta cuenta = new Cuenta("0100000000", 20000);

        assertNotNull(cuenta);
        assertEquals("0100000000", cuenta.getId());
        assertEquals(20000, cuenta.getSaldo());
    }


}

