public class Deportivo extends ServicioDecorador {
    private String disciplina;

    public Deportivo(Servicio servicioDecorado, String disciplina) {
        super(servicioDecorado);
        this.disciplina = disciplina;
    }

    @Override
    public String descripcion() {
        return servicioDecorado.descripcion() + " - Deportivo (" + disciplina + ")";
    }
}
