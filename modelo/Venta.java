package modelo;

public class Venta {
    private int id;
    private int idCliente;
    private int idProducto;
    private double monto;

    public Venta(int id, int idCliente, int idProducto, double monto) {
        this.id = id;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public double getMonto() {
        return monto;

    }

}
