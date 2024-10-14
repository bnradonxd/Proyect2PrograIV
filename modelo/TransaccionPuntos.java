package modelo;

public class TransaccionPuntos {
    private int idCliente;
    private int puntos;
    private String tipo;
    private String fecha;

    public TransaccionPuntos(int idCliente, int puntos, String tipo, String fecha) {
        this.idCliente = idCliente;
        this.puntos = puntos;
        this.tipo = tipo;
        this.fecha = fecha;
    }
    public int getIdCliente() {
        return idCliente;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFecha() {
        return fecha;
    }


    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    @Override
    public String toString() {
        return "TransaccionPuntos{" +
                "idCliente=" + idCliente +
                ", puntos=" + puntos +
                ", tipo='" + tipo + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}


