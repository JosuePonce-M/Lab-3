package excepciones;

public class NombreInvalidoException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public NombreInvalidoException(String mensaje) {
        super(mensaje);
    }
}
