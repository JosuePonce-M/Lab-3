package vista;

import javax.swing.JButton;
import modelo.Carta;
import java.awt.Color;
import javax.swing.JButton;

public class BotonCarta extends JButton {

    private Color reversoCarta = new Color(83, 74, 183);   // morado

    public BotonCarta() {
        setBackground(reversoCarta);
        setOpaque(true);
        setBorderPainted(false);
        setFocusPainted(false);
    }
}