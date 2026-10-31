package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import modelo.Carta;

public class BotonCarta extends JButton {

    private Color reverso = new Color(83, 74, 183);       // morado
    private Color colorEmparejada = new Color(192, 221, 151); // verde c
    private Color dorado = new Color(212, 175, 55);

    public BotonCarta() {
        setBackground(reverso);
        setOpaque(true);
        setBorderPainted(false);
        setFocusPainted(false);
        setFont(new Font("SansSerif", Font.BOLD, 12));
    }

    // Cambia el estado de la carta
    public void setCarta(Carta carta) {
        if (carta == null) {
            return;
        }

        if (carta.estaEmparejada()) {
            setBackground(colorEmparejada);
            setText(carta.getNombre());
        } else if (carta.estaDescubierta()) {
            setBackground(Color.WHITE);
            setText(carta.getNombre());
        } else {
            setBackground(reverso);
            setText("");
        }

        // borde
        if (carta.getPuntos() == 2 && carta.estaDescubierta()) {
            setBorder(BorderFactory.createLineBorder(dorado, 4));
            setBorderPainted(true);
        } else {
            setBorderPainted(false);
        }
    }
}