public class Notificador implements Observador {

    @Override
    public void actualizar(Estudiante e) {
        System.out.println("Notificación: El estudiante " + e.getNombre() +
                " ha completado las 80 horas de Bienestar Universitario.");
    }
}

