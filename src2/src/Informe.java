import java.util.List;

public class Informe {
    public static void generarInformePedidos(List<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            System.out.println("ID de Pedido: " + pedido.getIDPedido());
            System.out.println("Productos solicitados:");
            for (Producto producto : pedido.getProductosSolicitados()) {
                System.out.println("- " + producto.getNombre() + " (x" + producto.getCantidadEnStock() + ")");
            }
            System.out.println("Estado del pedido: " + pedido.getEstadoPedido());
            System.out.println("Fecha y hora: " + pedido.getFechaHora());
            System.out.println("----------------------");
        }
    }

    public static void generarInformeInventario(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getID());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Descripción: " + producto.getDescripcion()); System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad en stock: " + producto.getCantidadEnStock());
            System.out.println("----------------------");

        }
    }
}
