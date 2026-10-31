package modelo;

public class CartaNormal extends Carta {

    public CartaNormal(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public int getPuntos() {
        return 1;
    }
}
