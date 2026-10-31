package modelo;

public abstract class Carta implements Cloneable {

    private int id;
    private String nombre;
    private boolean descubierta;
    private boolean emparejada;

    public Carta(int id, String nombre) {
    }

    public int getId() {
        throw new UnsupportedOperationException();
    }

    public String getNombre() {
        throw new UnsupportedOperationException();
    }

    public boolean estaDescubierta() {
        throw new UnsupportedOperationException();
    }

    public boolean estaEmparejada() {
        throw new UnsupportedOperationException();
    }

    public void mostrar() {
        throw new UnsupportedOperationException();
    }

    public void ocultar() {
        throw new UnsupportedOperationException();
    }

    public void marcarEmparejada() {
        throw new UnsupportedOperationException();
    }

    public abstract int getPuntos();

    @Override
    public Carta clone() {
        throw new UnsupportedOperationException();
    }
}
