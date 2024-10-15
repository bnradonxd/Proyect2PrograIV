package servicios;

///importar producto
import modelo.Proveedor;
import java.util.ArrayList;
import java.util.List;

public class ServicioProveedor {
    private List<Proveedor> proveedores = new ArrayList<>();

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public void eliminarProveedor(int idProveedor) {
        proveedores.removeIf(proveedor -> proveedor.getId() == idProveedor);
    }

    public Proveedor buscarProveedor(int idProveedor) {
        return proveedores.stream().filter(proveedor -> proveedor.getId() == idProveedor).findFirst().orElse(null);
    }

    public void modificarProveedor(Proveedor proveedorModificado) {
        for (int i = 0; i < proveedores.size(); i++) {
            Proveedor proveedor = proveedores.get(i);
            if (proveedor.getId() == proveedorModificado.getId()) {
                proveedores.set(i, proveedorModificado);
                break;
            }
        }
    }

    public String generarInformeProveedores() {
        StringBuilder informe = new StringBuilder("Informe de Proveedores:\n");
        for (Proveedor proveedor : proveedores) {
            informe.append("ID: ").append(proveedor.getId())
                    .append(", Nombre: ").append(proveedor.getNombre())
                    .append(", Productos Asociados: ").append(proveedor.getProductos().size()).append("\n");
            for (Producto producto : proveedor.getProductos()) {
                informe.append("\t- ").append(producto.getNombre()).append(" (ID: ").append(producto.getId()).append(")\n");
            }
        }
        return informe.toString();
    }
}
