import java.io.IOException;
import java.util.Scanner;

import generators.GenerateFile;
import generators.GeneratePDF;
import models.Empleado;

public class Cliente {
    public final Scanner sc = new Scanner(System.in);

    private GeneratePDF pdfGen;
    private GenerateFile fileGen;

    public void printFileOptions() {
        System.out.println("Elija las opciones");
        System.out.println("1- Generar PDF");
        System.out.println("2- Generar  DB");
    }

    public int scanOption() {
        String option = sc.nextLine();
        try {
            Integer numOption = Integer.valueOf(option);
            return numOption;
        } catch (Exception e) {
            return -1;
        }

    }

    public Empleado scanDataEmpleado() {
        System.out.println("Ingrese nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese apellido");
        String apellido = sc.nextLine();
        System.out.println("Ingrese pago");
        String pago = sc.nextLine();
        float new_pago;

        try {
            new_pago = Float.valueOf(pago);
        } catch (Exception e) {
            return null;
        }

        Empleado emp = new Empleado(nombre, apellido);
        emp.setPago(new_pago);

        return emp;
    }

    public String handlePath() {
        System.out.println("Ingrese el path");
        String path = sc.nextLine();
        return path;
    }

    public void handleOption() throws IOException {
        int option = scanOption();

        switch (option) {
            case 1:
                pdfGen.generate();
                break;
            case 2:
                fileGen.generate();
                break;

            default:
                System.out.println("Opcion no valida");
        }
    }

    public void UI() {

        while (true) {
            Empleado empleado = scanDataEmpleado();
            String path = handlePath();
            pdfGen = new GeneratePDF(empleado, path);
            fileGen = new GenerateFile(empleado, path);
            printFileOptions();
            try {
                handleOption();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
