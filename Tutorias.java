public class Tutorias extends ServicioDecorador {
    private String tema;

    public Tutorias(Servicio servicioDecorado, String tema) {
        super(servicioDecorado);
        this.tema = tema;
    }

    @Override
    public String descripcion() {
        return servicioDecorado.descripcion() + " - Tutorías (" + tema + ")";
    }
}

