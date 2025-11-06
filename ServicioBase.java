public class ServicioBase implements Servicio {
    private String tipo;

    public ServicioBase(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String descripcion() {
        return "Servicio base: " + tipo;
    }
}

