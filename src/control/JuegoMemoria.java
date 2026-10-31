package control;

import java.util.Random;
import modelo.Carta;
import modelo.CartaEspecial;
import modelo.CartaNormal;
import modelo.Jugador;

public class JuegoMemoria extends Partida {

    private String[] nombres = {
        "Pikachu", "Bulbasaur", "Charmander", "Squirtle", "Eevee", "Jigglypuff",
        "Meowth", "Psyduck", "Snorlax", "Gengar", "Magikarp", "Ditto",
        "Vulpix", "Oddish", "Poliwag", "Cubone", "Mew", "Mewtwo"
    };
    private Random azar = new Random();

    @Override
    public void iniciar(String nombre1, String nombre2) {
        Jugador.validarNombres(nombre1, nombre2);
        crearTablero();
        jugadores[0] = new Jugador(nombre1);
        jugadores[1] = new Jugador(nombre2);
        turno = 0;
        primera = -1;
        segunda = -1;
        bloqueada = false;
        terminada = false;
    }

    private void crearTablero() {
        Carta[] nuevas = new Carta[TOTAL_CARTAS];
        int posicion = 0;
        for (int i = 0; i < nombres.length; i++) {
            Carta carta;
            if (i < 16) {
                carta = new CartaNormal(i, nombres[i]);
            } else {
                carta = new CartaEspecial(i, nombres[i]);
            }
            nuevas[posicion] = carta;
            try {
                nuevas[posicion + 1] = carta.clone();
            } catch (Exception e) {
                throw new IllegalStateException("No se pudo copiar la carta " + nombres[i], e);
            }
            posicion += 2;
        }
        cartas = nuevas;
    }

    private void mezclar(int posicion) {
        throw new UnsupportedOperationException();
    }

    private int contarEmparejadas(int posicion) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void seleccionarCarta(int posicion) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean verificarPareja() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void resolverFallo() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void cambiarTurno() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean finalizar() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getResultado() {
        throw new UnsupportedOperationException();
    }
}
