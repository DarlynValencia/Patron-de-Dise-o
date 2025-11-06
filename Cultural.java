public class Cultural extends ServicioDecorador {
    private String actividad;

    public Cultural(Servicio servicioDecorado, String actividad) {
        super(servicioDecorado);
        this.actividad = actividad;
    }

    @Override
    public String descripcion() {
        return servicioDecorado.descripcion() + " - Cultural (" + actividad + ")";
    }
}
