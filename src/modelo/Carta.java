package modelo;

public abstract class Carta implements Cloneable {

    private int id;
    private String nombre;
    private boolean descubierta;
    private boolean emparejada;

    public Carta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.descubierta = false;
        this.emparejada = false;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaDescubierta() {
        return descubierta;
    }

    public boolean estaEmparejada() {
        return emparejada;
    }

    public void mostrar() {
        if (!emparejada) {
            this.descubierta = true;
        }
    }

    public void ocultar() {
        if (!emparejada) {
            this.descubierta = false;
        }
    }

    public void marcarEmparejada() {
        this.emparejada = true;
        this.descubierta = true;
    }

    public abstract int getPuntos();

    @Override
    public Carta clone() {
        try {

            return (Carta) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("La clonación no es compatible", e);
        }
    }
}


