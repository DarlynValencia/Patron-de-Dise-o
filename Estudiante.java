public class Estudiante {
    private String nombre;
    private String cc;
    private String facultad;
    private String carrera;
    private String correo;
    private String servicio;
    private int horasTotales;

    public Estudiante(String nombre, String cc, String facultad, String carrera, String correo, String servicio) {
        this.nombre = nombre;
        this.cc = cc;
        this.facultad = facultad;
        this.carrera = carrera;
        this.correo = correo;
        this.servicio = servicio;
        this.horasTotales = 0;
    }

    public String getNombre() { return nombre; }
    public String getCc() { return cc; }
    public String getFacultad() { return facultad; }
    public String getCarrera() { return carrera; }
    public String getCorreo() { return correo; }
    public String getServicio() { return servicio; }
    public int getHorasTotales() { return horasTotales; }

    public void sumarHoras(int horas) {
        this.horasTotales += horas;
        if (this.horasTotales > 80) this.horasTotales = 80;
    }
}
