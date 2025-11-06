public abstract class ServicioDecorador implements Servicio {
    protected Servicio servicioDecorado;

    public ServicioDecorador(Servicio servicioDecorado) {
        this.servicioDecorado = servicioDecorado;
    }

    @Override
    public String descripcion() {
        return servicioDecorado.descripcion();
    }
}
