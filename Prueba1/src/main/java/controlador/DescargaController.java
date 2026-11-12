package controlador;

import modelo.ArchivoDescarga;
import vista.DescargaForm;

public class DescargaController {
    private DescargaForm vista;

    public DescargaController(DescargaForm vista) {
        this.vista = vista;
    }

    public void ejecutar() {
        System.out.print("Ingrese nombre del archivo: ");
        String nom = vista.sc.nextLine();

        System.out.print("Ingrese tiempo limite: ");
        double lim = Double.parseDouble(vista.sc.nextLine());

        System.out.print("Ingrese tiempo estimado: ");
        double tiempo = Double.parseDouble(vista.sc.nextLine());

        ArchivoDescarga archivo = new ArchivoDescarga(nom, lim);

   
        ArchivoDescarga.ProcesoDescargaHilo proceso = new ArchivoDescarga.ProcesoDescargaHilo(archivo, tiempo);
        Thread hilo = new Thread(proceso);
        hilo.start();
    }

    public static void main(String[] args) {
        DescargaForm vista = new DescargaForm();
        DescargaController control = new DescargaController(vista);
        control.ejecutar();
    }
}