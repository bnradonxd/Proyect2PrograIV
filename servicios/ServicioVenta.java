package servicios;

import modelo.Venta;
import java.util.ArrayList;
import java.util.List;

public class ServicioVenta {
    private List<Venta> ventas = new ArrayList<>();


    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }


    public void eliminarVenta(int idVenta) {
        ventas.removeIf(venta -> venta.getId() == idVenta);
    }


    public Venta buscarVenta(int idVenta) {
        return ventas.stream().filter(venta -> venta.getId() == idVenta).findFirst().orElse(null);
    }


}
