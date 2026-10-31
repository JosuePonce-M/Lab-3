package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import modelo.Carta;

public class DibujosPokemon {

    
    private static Color[] colores = {
        new Color(240, 200, 40),  new Color(80, 170, 90),   new Color(235, 120, 50),
        new Color(70, 140, 220),  new Color(170, 120, 80),  new Color(240, 150, 190),
        new Color(220, 190, 130), new Color(240, 210, 90),  new Color(60, 90, 110),
        new Color(110, 70, 150),  new Color(230, 90, 60),   new Color(190, 140, 210),
        new Color(220, 110, 70),  new Color(70, 110, 170),  new Color(80, 110, 200),
        new Color(160, 140, 110), new Color(250, 170, 200), new Color(170, 140, 200)
    };

    
    public static void dibujar(Graphics2D g, Carta carta, int ancho, int alto) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        
        int tam = Math.min(ancho, alto) / 2;
        int x = (ancho - tam) / 2;
        int y = (alto - tam) / 2 - 10;
        g.setColor(colores[carta.getId()]);
        g.fillOval(x, y, tam, tam);
        g.setColor(Color.DARK_GRAY);
        g.drawOval(x, y, tam, tam);

        
        String inicial = carta.getNombre().substring(0, 1);
        g.setFont(new Font("SansSerif", Font.BOLD, tam / 2));
        FontMetrics fm = g.getFontMetrics();
        g.setColor(Color.WHITE);
        g.drawString(inicial,
                x + (tam - fm.stringWidth(inicial)) / 2,
                y + (tam + fm.getAscent() - fm.getDescent()) / 2);

        
        String nombre = carta.getNombre();
        g.setFont(new Font("SansSerif", Font.BOLD, 11));
        fm = g.getFontMetrics();
        g.setColor(Color.BLACK);
        g.drawString(nombre, (ancho - fm.stringWidth(nombre)) / 2, alto - 10);
    }
}