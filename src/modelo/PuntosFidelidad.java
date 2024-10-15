package modelo;

public class PuntosFidelidad {
    private Cliente cliente;
    private int puntos;
    private int puntosPorCompra;
    private int puntosNecesariosParaCanje;


    public PuntosFidelidad(Cliente cliente, int puntosPorCompra, int puntosNecesariosParaCanje) {
        this.cliente = cliente;
        this.puntos = 0;
        if (puntosPorCompra <= 0 || puntosNecesariosParaCanje <= 0) {
            throw new IllegalArgumentException("Los puntos por compra y los puntos necesarios para canje deben ser mayores a cero.");
        }
        this.puntosPorCompra = puntosPorCompra;
        this.puntosNecesariosParaCanje = puntosNecesariosParaCanje;
    }


    public void asignarPuntos(Venta venta) {
        if (venta.getMonto() <= 0) {
            throw new IllegalArgumentException("La venta debe tener un total mayor que cero para asignar puntos.");
        }
        int puntosGanados = (int) venta.getMonto() / puntosPorCompra;
        puntos += puntosGanados;
        System.out.println("Se han asignado " + puntosGanados + " puntos al cliente " + cliente.getNombre());
    }


    public boolean canjearPuntos() {
        if (puntos >= puntosNecesariosParaCanje) {
            puntos -= puntosNecesariosParaCanje;
            System.out.println("El cliente " + cliente.getNombre() + " ha canjeado sus puntos.");
            return true;
        } else {
            System.out.println("El cliente " + cliente.getNombre() + " no tiene suficientes puntos.");
            return false;
        }
    }


    public void mostrarPuntos() {
        System.out.println("El cliente " + cliente.getNombre() + " tiene " + puntos + " puntos.");
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntosPorCompra() {
        return puntosPorCompra;
    }

    public void setPuntosPorCompra(int puntosPorCompra) {
        if (puntosPorCompra <= 0) {
            throw new IllegalArgumentException("Los puntos no pueden ser menores a 0.");
        }
        this.puntosPorCompra = puntosPorCompra;
    }

    public int getPuntosNecesariosParaCanje() {
        return puntosNecesariosParaCanje;
    }

    public void setPuntosNecesariosParaCanje(int puntosNecesariosParaCanje) {
        if (puntosNecesariosParaCanje <= 0) {
            throw new IllegalArgumentException("Los puntos no pueden ser menores a 0.");
        }
        this.puntosNecesariosParaCanje = puntosNecesariosParaCanje;
    }
}
