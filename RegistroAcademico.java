import java.util.Scanner;

public class RegistroAcademico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BienestarUniversitario bienestar = new BienestarUniversitario();
        bienestar.agregarObservador(new Notificador());

        int opcion = 0;
        do {
            System.out.println("\n===== MENÚ BIENESTAR UNIVERSITARIO =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar horas");
            System.out.println("3. Ver estudiante por cédula");
            System.out.println("4. Ver todos los estudiantes");
            System.out.println("5. Verificar cumplimiento de horas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    bienestar.registrarEstudiante(sc);
                    break;

                case 2:
                    bienestar.registrarHoras(sc);
                    break;

                case 3:
                    System.out.print("Ingrese la cédula del estudiante: ");
                    String cc = sc.nextLine().trim();
                    Estudiante encontrado = bienestar.buscarEstudiante(cc);
                    if (encontrado != null) {
                        System.out.println("\n--- Información del estudiante ---");
                        System.out.println("Nombre: " + encontrado.getNombre());
                        System.out.println("Facultad: " + encontrado.getFacultad());
                        System.out.println("Carrera: " + encontrado.getCarrera());
                        System.out.println("Correo: " + encontrado.getCorreo());
                        System.out.println("Servicio: " + encontrado.getServicio());
                        System.out.println("Horas: " + encontrado.getHorasTotales() + "/80");
                        System.out.println("----------------------------------\n");
                    } else {
                        System.out.println("Estudiante no encontrado.\n");
                    }
                    break;

                case 4:
                    bienestar.mostrarEstudiantes();
                    break;

                case 5:
                    bienestar.verificarCumplimientoHoras();
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.\n");
            }

        } while (opcion != 6);

        sc.close();
    }
}
