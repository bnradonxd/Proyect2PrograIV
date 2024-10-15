import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int IDPedido;
    private List<Producto> productosSolicitados;
    private String estadoPedido; // pendiente, enviado, entregado
    private String fechaHora;

    public Pedido(int IDPedido, String fechaHora) {
        this.IDPedido = IDPedido;
        this.productosSolicitados = new ArrayList<>();
        this.estadoPedido = "pendiente"; // Estado inicial del pedido
        this.fechaHora = fechaHora;
    }

    // Getters y setters para los atributos
    public int getIDPedido() {
        return IDPedido;
    }

    public void setIDPedido(int IDPedido) {
        this.IDPedido = IDPedido;
    }

    public List<Producto> getProductosSolicitados()
    {
        return productosSolicitados;
    }

    public void setProductosSolicitados(List<Producto> productosSolicitados) {
        this.productosSolicitados = productosSolicitados;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void agregarProducto(Producto producto) {
        this.productosSolicitados.add(producto);
    }

    public void cambiarEstadoPedido(String nuevoEstado) {
        this.estadoPedido = nuevoEstado;
    }

}
