package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private int id;
    private String nombre;
    private String email;
    private List<Venta> ventasAsociadas;

    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.ventasAsociadas = new ArrayList<>();
    }

    public void agregarVenta(Venta venta) {
        ventasAsociadas.add(venta);
    }

    public void eliminarVenta(int idVenta) {
        ventasAsociadas.removeIf(venta -> venta.getId() == idVenta);
    }

    public void mostrarVentas() {
        System.out.println("Ventas asociadas al cliente " + nombre + ":");
        for (Venta venta : ventasAsociadas) {
            System.out.println(venta);
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public List<Venta> getVentasAsociadas() {
        return ventasAsociadas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVentasAsociadas(List<Venta> ventasAsociadas) {
        this.ventasAsociadas = ventasAsociadas;
    }
}
