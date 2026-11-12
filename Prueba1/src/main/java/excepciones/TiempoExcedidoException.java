package excepciones;

public class TiempoExcedidoException extends Exception {
    private double tiempoExcedido;

    public TiempoExcedidoException(String mensaje, double tiempoExcedido) {
        super(mensaje);
        this.tiempoExcedido = tiempoExcedido;
    }

    public double getTiempoExcedido() {
        return tiempoExcedido;
    }
}