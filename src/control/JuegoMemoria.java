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
        if (posicion >= cartas.length) {
            return 0;
        }
        int cantidad = 0;
        if (cartas[posicion] != null && cartas[posicion].estaEmparejada()) {
            cantidad = 1;
        }
        return cantidad + contarEmparejadas(posicion + 1);
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
        if (primera == -1 || segunda == -1) {
            throw new IllegalStateException("Seleccione dos cartas");
        }
        if (cartas[primera].getId() == cartas[segunda].getId()) {
            jugadores[turno].sumarPareja(cartas[primera].getPuntos());
            cartas[primera].marcarEmparejada();
            cartas[segunda].marcarEmparejada();
            primera = -1;
            segunda = -1;
            bloqueada = false;
            finalizar();
            return true;
        }
        return false;
    }

    @Override
    public void resolverFallo() {
        if (primera == -1 || segunda == -1) {
            throw new IllegalStateException("No hay una jugada pendiente");
        }
        if (cartas[primera].getId() == cartas[segunda].getId()) {
            throw new IllegalStateException("Las cartas forman una pareja");
        }
        cartas[primera].ocultar();
        cartas[segunda].ocultar();
        primera = -1;
        segunda = -1;
        cambiarTurno();
        bloqueada = false;
    }

    @Override
    public void cambiarTurno() {
        if (terminada) {
            throw new IllegalStateException("La partida ya termino");
        }
        if (turno == 0) {
            turno = 1;
        } else {
            turno = 0;
        }
    }

    @Override
    public boolean finalizar() {
        terminada = contarEmparejadas(0) == TOTAL_CARTAS;
        return terminada;
    }

    @Override
    public String getResultado() {
        if (!terminada) {
            throw new IllegalStateException("La partida no ha terminado");
        }
        int puntos1 = jugadores[0].getPuntos();
        int puntos2 = jugadores[1].getPuntos();
        if (puntos1 > puntos2) {
            return "Ganador: " + jugadores[0].getNombre() + " con " + puntos1 + " puntos";
        } else if (puntos2 > puntos1) {
            return "Ganador: " + jugadores[1].getNombre() + " con " + puntos2 + " puntos";
        }
        return "Empate: ambos jugadores tienen " + puntos1 + " puntos";
    }
}
