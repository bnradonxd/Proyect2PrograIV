public class Producto {
    private int ID;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadEnStock;

    public Producto(int ID, String nombre, String descripcion, double precio, int cantidadEnStock) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock= cantidadEnStock;
    }

    public void actualizarCantidadEnStock(int cantidad) {
        this.cantidadEnStock += cantidad;
    }
}
