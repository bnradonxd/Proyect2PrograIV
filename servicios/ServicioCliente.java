package servicios;

import modelo.Cliente;
import modelo.Venta;
import java.util.ArrayList;
import java.util.List;

public class ServicioCliente {
    private List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(int idCliente) {
        clientes.removeIf(cliente -> cliente.getId() == idCliente);
    }

    public Cliente buscarCliente(int idCliente) {
        return clientes.stream().filter(cliente -> cliente.getId() == idCliente).findFirst().orElse(null);
    }

    public void modificarCliente(Cliente clienteModificado) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getId() == clienteModificado.getId()) {
                clientes.set(i, clienteModificado);
                break;
            }
        }
    }

    public void asociarVentaACliente(int idCliente, Venta venta) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente != null) {
            cliente.agregarVenta(venta);
        }
    }

    public String generarInformeClientes() {
        StringBuilder informe = new StringBuilder("Informe de Clientes:\n");
        for (Cliente cliente : clientes) {
            informe.append("ID: ").append(cliente.getId())
                    .append(", Nombre: ").append(cliente.getNombre())
                    .append(", Email: ").append(cliente.getEmail())
                    .append(", Ventas Asociadas: ").append(cliente.getVentasAsociadas().size()).append("\n");
            for (Venta venta : cliente.getVentasAsociadas()) {
                informe.append("\t- ").append(venta.toString()).append("\n");
            }
        }
        return informe.toString();
    }
}
