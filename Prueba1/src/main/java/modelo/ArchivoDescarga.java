package modelo;

import excepciones.TiempoExcedidoException;

public class ArchivoDescarga {
    private String nombre;
    private double tiempoLimite;

    public ArchivoDescarga(String nombre, double tiempoLimite) {
        this.nombre = nombre;
        this.tiempoLimite = tiempoLimite;
    }

    public void descargar(double tiempoReal) throws TiempoExcedidoException {
        if (tiempoReal > tiempoLimite) {
            throw new TiempoExcedidoException("Tiempo limite excedido", tiempoReal - tiempoLimite);
        }
    }

    public String getNombre() {
        return nombre;
    }

    // Clase interna del Hilo
    public static class ProcesoDescargaHilo implements Runnable {
        private ArchivoDescarga archivo;
        private double tiempoReal;

        public ProcesoDescargaHilo(ArchivoDescarga archivo, double tiempoReal) {
            this.archivo = archivo;
            this.tiempoReal = tiempoReal;
        }

        @Override
        public void run() {
            try {
                System.out.println("Iniciando descarga de " + archivo.getNombre());
                Thread.sleep(1000);

                archivo.descargar(tiempoReal);
                System.out.println("Descarga completada con exito.");

            } catch (TiempoExcedidoException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Tiempo excedido por: " + e.getTiempoExcedido());
            } catch (InterruptedException e) {
                System.out.println("Error en el hilo.");
            }
        }
    }
}