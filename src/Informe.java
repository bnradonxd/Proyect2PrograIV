import java.util.List;

public class Informe {

public static void generarInformeVentas(List<Venta> ventas) {
        for (Venta venta : ventas) {
            System.out.println("ID de venta: " + venta.getIDVenta());
            System.out.println("Productos vendidos: " + venta.getProductosVendidos());
            System.out.println("Total de la venta: " + venta.getTotalVenta());
            System.out.println("Fecha y hora: " + venta.getFechaHora());
            System.out.println("--------------------");
        }
    }

    public static void generarInformeInventario(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getID());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Cantidad en stock: " + producto.getCantidadEnStock());
            System.out.println("--------------------");
        }
    }
}
