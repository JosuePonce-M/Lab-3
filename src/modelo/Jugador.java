package modelo;

public class Jugador {

    private String nombre;
    private int aciertos;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre=nombre;
        this.aciertos=0;
        this.puntos=0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void sumarPareja(int puntosPareja) {
        this.aciertos++;
        this.puntos+=puntosPareja;
    }

    public void reiniciar() {
        this.aciertos=0;
        this.puntos = 0;
    }

    public static void validarNombres(String nombre1, String nombre2) throws NombreInvalidoException {
        if (nombre1==null ||nombre1.trim().isEmpty()|| 
            nombre2==null||nombre2.trim().isEmpty()) {
            throw new NombreInvalidoException("Los nombres de los jugadores no pueden estar vacios o contener solo espacios");
        }
        
        String n1=nombre1.trim();
        String n2=nombre2.trim();

        if (n1.equalsIgnoreCase(n2)) {
            throw new NombreInvalidoException("Los nombres de los jugadores no pueden ser identicos");
        }

        if (n1.length() > 20 || n2.length() > 20) {
            throw new NombreInvalidoException("Los nombres no deben exceder los 20 caracteres");
        }
    }
}
