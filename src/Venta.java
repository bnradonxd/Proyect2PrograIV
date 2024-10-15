import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {

    private int IDVenta;
    private List<Producto> productosVendidos;
    private double totalVenta;
    private Date fechaHora;

    public Venta(int IDVenta) {
        this.IDVenta = IDVenta;
        this.productosVendidos = new ArrayList<>();
        this.totalVenta = 0;
        this.fechaHora = new Date();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productosVendidos.add(producto);
        totalVenta += producto.getPrecio() * cantidad;
        producto.actualizarCantidadEnStock(-cantidad);
    }

    public int getIDVenta() {
        return IDVenta;
    }

    public List<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

}
