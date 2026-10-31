package control;

import modelo.Carta;
import modelo.Jugador;

public abstract class Partida {

    public static final int FILAS = 6;
    public static final int COLUMNAS = 6;
    public static final int TOTAL_CARTAS = 36;

    protected Carta[] cartas;
    protected Jugador[] jugadores;
    protected int turno;
    protected int primera;
    protected int segunda;
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
        throw new UnsupportedOperationException();
    }

    public Jugador getJugador(int posicion) {
        throw new UnsupportedOperationException();
    }

    public int getTurno() {
        throw new UnsupportedOperationException();
    }

    public int getPrimera() {
        throw new UnsupportedOperationException();
    }

    public int getSegunda() {
        throw new UnsupportedOperationException();
    }

    public boolean estaBloqueada() {
        throw new UnsupportedOperationException();
    }

    public boolean estaTerminada() {
        throw new UnsupportedOperationException();
    }
}
