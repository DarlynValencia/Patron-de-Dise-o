import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BienestarUniversitario {
    private List<Estudiante> estudiantes;
    private List<Observador> observadores;

    public BienestarUniversitario() {
        estudiantes = new ArrayList<>();
        observadores = new ArrayList<>();
    }
    public void agregarObservador(Observador o) {
        if (o != null && !observadores.contains(o)) observadores.add(o);
    }

    private void notificarObservadores(Estudiante e) {
        for (Observador o : observadores) {
            o.actualizar(e);
        }
    }
    public void registrarEstudiante(Scanner sc) {
        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Cédula: ");
        String cc = sc.nextLine().trim();

        if (buscarEstudiante(cc) != null) {
            System.out.println("El estudiante con cédula " + cc + " ya está registrado.");
            return;
        }

        System.out.print("Facultad: ");
        String facultad = sc.nextLine().trim();
        System.out.print("Carrera: ");
        String carrera = sc.nextLine().trim();
        System.out.print("Correo universitario: ");
        String correo = sc.nextLine().trim();

        System.out.println("Seleccione el tipo de servicio (1. Deportivo, 2. Cultural, 3. Tutorías): ");
        int tipo = leerEntero(sc, 1, 3);

        String servicio = "";
        switch (tipo) {
            case 1 -> {
                System.out.println("Servicios deportivos:");
                System.out.println("1. Fútbol\n2. Baloncesto\n3. Vóley playa\n4. Tenis de mesa\n5. Acondicionamiento físico");
                System.out.print("Seleccione la opción: ");
                int sub = leerEntero(sc, 1, 5);
                servicio = switch (sub) {
                    case 1 -> "Deportivo - Fútbol";
                    case 2 -> "Deportivo - Baloncesto";
                    case 3 -> "Deportivo - Vóley playa";
                    case 4 -> "Deportivo - Tenis de mesa";
                    default -> "Deportivo - Acondicionamiento físico";
                };
            }
            case 2 -> {
                System.out.println("Servicios culturales:");
                System.out.println("1. Pintura\n2. Relajación y cuerpo\n3. Guitarra\n4. Técnica vocal\n5. Expresión teatral\n6. Baile");
                System.out.print("Seleccione la opción: ");
                int sub = leerEntero(sc, 1, 6);
                servicio = switch (sub) {
                    case 1 -> "Cultural - Pintura";
                    case 2 -> "Cultural - Relajación y cuerpo";
                    case 3 -> "Cultural - Guitarra";
                    case 4 -> "Cultural - Técnica vocal";
                    case 5 -> "Cultural - Expresión teatral";
                    default -> "Cultural - Baile";
                };
            }
            case 3 -> {
                System.out.print("Tema de la tutoría: ");
                String tema = sc.nextLine().trim();
                servicio = "Tutorías - " + tema;
            }
            default -> servicio = "No especificado";
        }

        Estudiante e = new Estudiante(nombre, cc, facultad, carrera, correo, servicio);
        estudiantes.add(e);
        System.out.println("Estudiante registrado: " + nombre + " | " + servicio);
    }
    public void registrarHoras(Scanner sc) {
        System.out.print("Ingrese la cédula del estudiante: ");
        String cc = sc.nextLine().trim();

        Estudiante e = buscarEstudiante(cc);
        if (e == null) {
            System.out.println("Estudiante no encontrado. Regístrelo primero.");
            return;
        }

        System.out.println("Estudiante: " + e.getNombre() + " | Servicio: " + e.getServicio());
        System.out.print("Horas realizadas: ");
        int horas = leerEntero(sc, 1, 1000);

        System.out.print("Nombre del profesor encargado: ");
        String profesor = sc.nextLine().trim();

        e.sumarHoras(horas);

        if (e.getHorasTotales() >= 80) {
            notificarObservadores(e);
        }

        System.out.println("Registro guardado: +" + horas + " horas. Total actual: " + e.getHorasTotales() + "/80");
    }
    public Estudiante buscarEstudiante(String cc) {
        if (cc == null) return null;
        for (Estudiante e : estudiantes) {
            if (cc.equals(e.getCc())) return e;
        }
        return null;
    }
    public void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        System.out.println("\n--- LISTADO DE ESTUDIANTES ---");
        for (Estudiante e : estudiantes) {
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Cédula: " + e.getCc());
            System.out.println("Facultad: " + e.getFacultad());
            System.out.println("Carrera: " + e.getCarrera());
            System.out.println("Correo: " + e.getCorreo());
            System.out.println("Servicio: " + e.getServicio());
            System.out.println("Horas acumuladas: " + e.getHorasTotales() + "/80");
            System.out.println("-------------------------------");
        }
    }   
    public void verificarCumplimientoHoras() {
        boolean algunoPendiente = false;
        for (Estudiante e : estudiantes) {
            if (e.getHorasTotales() < 80) {
                algunoPendiente = true;
                System.out.println(e.getNombre() + " -> " + e.getHorasTotales() + "/80");
            }
        }
        if (!algunoPendiente) {
            System.out.println("Todos los estudiantes han completado las 80 horas.");
        }
    }
    private int leerEntero(Scanner sc, int min, int max) {
        int val;
        while (true) {
            if (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Entrada inválida. Ingrese un número: ");
                continue;
            }
            val = sc.nextInt();
            sc.nextLine();
            if (val < min || val > max) {
                System.out.print("Valor fuera de rango. Ingrese un número entre " + min + " y " + max + ": ");
                continue;
            }
            return val;
        }
    }
}
