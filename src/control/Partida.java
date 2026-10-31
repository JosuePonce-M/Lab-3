package control;

import modelo.Carta;
import modelo.Jugador;

public abstract class Partida {

    public static final int FILAS = 6;
    public static final int COLUMNAS = 6;
    public static final int TOTAL_CARTAS = 36;

    protected Carta[] cartas = new Carta[TOTAL_CARTAS];
    protected Jugador[] jugadores = new Jugador[2];
    protected int turno;
    protected int primera = -1;
    protected int segunda = -1;
    protected boolean bloqueada;
    protected boolean terminada;

    public abstract void iniciar(String nombre1, String nombre2);

    public abstract void seleccionarCarta(int posicion);

    public abstract boolean verificarPareja();

    public abstract void resolverFallo();

    public abstract void cambiarTurno();

    public abstract boolean finalizar();

    public abstract String getResultado();

    public Carta getCarta(int posicion) {
        return cartas[posicion];
    }

    public Jugador getJugador(int posicion) {
        return jugadores[posicion];
    }

    public int getTurno() {
        return turno;
    }

    public int getPrimera() {
        return primera;
    }

    public int getSegunda() {
        return segunda;
    }

    public boolean estaBloqueada() {
        return bloqueada;
    }

    public boolean estaTerminada() {
        return terminada;
    }
}
