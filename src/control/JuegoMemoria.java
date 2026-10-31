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
        mezclar(cartas.length - 1);
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
        if (posicion <= 0) {
            return;
        }
        int otra = azar.nextInt(posicion + 1);
        Carta aux = cartas[posicion];
        cartas[posicion] = cartas[otra];
        cartas[otra] = aux;
        mezclar(posicion - 1);
    }

    private int contarEmparejadas(int posicion) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void seleccionarCarta(int posicion) {
        if (posicion < 0 || posicion >= cartas.length) {
            throw new IndexOutOfBoundsException("Posicion fuera del tablero");
        }
        if (terminada) {
            throw new IllegalStateException("La partida ya termino");
        }
        if (bloqueada) {
            throw new IllegalStateException("Espere a que termine la jugada");
        }
        if (cartas[posicion] == null) {
            throw new IllegalStateException("Primero inicie la partida");
        }
        if (posicion == primera) {
            throw new IllegalArgumentException("No puede elegir dos veces la misma carta");
        }
        if (cartas[posicion].estaDescubierta() || cartas[posicion].estaEmparejada()) {
            throw new IllegalArgumentException("Esa carta ya esta descubierta");
        }
        cartas[posicion].mostrar();
        if (primera == -1) {
            primera = posicion;
        } else {
            segunda = posicion;
            bloqueada = true;
        }
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
