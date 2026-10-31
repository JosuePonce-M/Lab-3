package modelo;

public class CartaEspecial extends Carta {

    public CartaEspecial(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public int getPuntos() {
        throw new UnsupportedOperationException();
    }
}
