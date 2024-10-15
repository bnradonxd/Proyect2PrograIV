package servicios;

import modelo.TransaccionPuntos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioPuntosFidelidad {
    private Map<Integer, Integer> puntosPorCliente = new HashMap<>();
    private List<TransaccionPuntos> transacciones = new ArrayList<>();

    public boolean agregarPuntos(int idCliente, int puntos) {
        puntosPorCliente.put(idCliente, puntosPorCliente.getOrDefault(idCliente, 0) + puntos);
        registrarTransaccion(idCliente, puntos, "Asignar");
        return true;
    }

    public boolean redimirPuntos(int idCliente, int puntos) {
        int puntosActuales = puntosPorCliente.getOrDefault(idCliente, 0);
        if (puntosActuales >= puntos) {
            puntosPorCliente.put(idCliente, puntosActuales - puntos);
            registrarTransaccion(idCliente, puntos, "Canjear");
            return true;
        }
        return false;
    }

    public int consultarPuntos(int idCliente) {
        return puntosPorCliente.getOrDefault(idCliente, 0);
    }

    private void registrarTransaccion(int idCliente, int puntos, String tipo) {
        String fecha = java.time.LocalDate.now().toString();
        TransaccionPuntos transaccion = new TransaccionPuntos(idCliente, puntos, tipo, fecha);
        transacciones.add(transaccion);
    }
}
