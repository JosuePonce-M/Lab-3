package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import modelo.Carta;

public class BotonCarta extends JButton {

    private Carta carta;
    private Color reverso = new Color(83, 74, 183);           // morado
    private Color colorEmparejada = new Color(192, 221, 151); // verde claro
    private Color dorado = new Color(212, 175, 55);

    public BotonCarta() {
        setBackground(reverso);
        setOpaque(true);
        setBorderPainted(false);
        setFocusPainted(false);
    }

    // Cambia cómo se ve el botón según el estado de la carta
    public void setCarta(Carta carta) {
        this.carta = carta;
        if (carta == null) {
            return;
        }

        if (carta.estaEmparejada()) {
            setBackground(colorEmparejada);
        } else if (carta.estaDescubierta()) {
            setBackground(Color.WHITE);
        } else {
            setBackground(reverso);
        }

        // borde dorado solo si es especial y está volteada
        if (carta.getPuntos() == 2 && carta.estaDescubierta()) {
            setBorder(BorderFactory.createLineBorder(dorado, 4));
            setBorderPainted(true);
        } else {
            setBorderPainted(false);
        }

        repaint();  
    }

    // Dibuja la cara de la carta encima del fondo del botón
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);   
        if (carta == null) {
            return;
        }
        if (carta.estaDescubierta()) {
            try {
                DibujosPokemon.dibujar((Graphics2D) g, carta, getWidth(), getHeight());
            } catch (Exception e) {
               
                g.setColor(Color.BLACK);
                g.setFont(new Font("SansSerif", Font.BOLD, 12));
                g.drawString(carta.getNombre(), 8, getHeight() / 2);
            }
        }
    }
}