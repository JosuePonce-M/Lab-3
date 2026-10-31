package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class DibujosPokemon {

    public static void dibujar(Graphics2D g, int id, int ancho, int alto) {
        try {
          
            g.setColor(Color.WHITE);
            g.fillRect(0,0,ancho,alto);

            switch (id) {
                case 1: dibujarAmonita(g,ancho,alto); break;
                case 2: dibujarHootHoot(g,ancho,alto); break;
                case 3: dibujarBulbizarre(g,ancho,alto); break;
                case 4: dibujarSabelette(g,ancho,alto); break;
                case 5: dibujarPikachu(g,ancho,alto); break;
                case 6: dibujarHypotrempe(g,ancho,alto); break;
                case 7: dibujarCoconfort(g,ancho,alto); break;
                case 8: dibujarCharmander(g,ancho,alto); break;
                case 9: dibujarSquirtle(g,ancho,alto); break;
                case 10: dibujarJigglypuff(g,ancho,alto); break;
                case 11: dibujarMeowth(g,ancho,alto); break;
                case 12: dibujarPsyduck(g,ancho,alto); break;
                case 13: dibujarMachop(g,ancho,alto); break;
                case 14: dibujarGeodude(g,ancho,alto); break;
                case 15: dibujarGastly(g,ancho,alto); break;
                case 16: dibujarOnix(g,ancho,alto); break;
                case 17: dibujarSnorlax(g,ancho,alto); break;
                case 18: dibujarMew(g,ancho,alto); break;
                default: dibujarTextoAlternativo(g,"Pokémon"+id, ancho, alto); break;
            }
        } catch (Exception e) {
           
            dibujarTextoAlternativo(g,"Error P"+id, ancho, alto);
        }
    }

    private static void dibujarTextoAlternativo(Graphics2D g, String texto, int ancho, int alto) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, ancho, alto);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString(texto,10,alto/2);
    }

   
    private static void dibujarAmonita(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(210,180,140)); 
        g.fillOval(ancho/4, alto/4, ancho/2, alto/2);
        g.setColor(new Color(100, 180, 220)); 
        g.fillOval(ancho/3, alto/2, ancho/3, alto/3);
    }

    private static void dibujarHootHoot(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(150, 110, 80));
        g.fillRoundRect(ancho/4, alto/4, ancho/2, alto/2, 20, 20);
        g.setColor(Color.WHITE); 
        g.fillOval(ancho/6, alto/3, ancho/3, ancho/3);
        g.fillOval(ancho/2, alto/3, ancho/3, ancho/3);
    }

    private static void dibujarBulbizarre(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(120, 200, 150)); 
        g.fillOval(ancho/6, alto/3, (int)(ancho*0.6), (int)(alto*0.5));
        g.setColor(new Color(100, 140, 90)); 
        g.fillOval(ancho/3, alto/6, ancho/3, alto/3);
    }

    private static void dibujarSabelette(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(220, 190, 110));
        g.fillOval(ancho/4, alto/4, ancho/2, (int)(alto*0.6));
    }

    private static void dibujarPikachu(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(255, 220, 50));
        g.fillOval(ancho/4, alto/3, ancho/2, (int)(alto*0.55));
        g.setColor(Color.RED); 
        g.fillOval(ancho/5, alto/2, ancho/6, ancho/6);
        g.fillOval((int)(ancho*0.6), alto/2, ancho/6, ancho/6);
    }

    private static void dibujarHypotrempe(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(130, 190, 230));
        g.fillOval(ancho/3, alto/4, (int)(ancho*0.4), (int)(alto*0.6));
    }

    private static void dibujarCoconfort(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(220, 190, 90));
        g.fillRoundRect(ancho/3, alto/5, (int)(ancho*0.35), (int)(alto*0.65), 30, 30);
    }

    private static void dibujarCharmander(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(240, 120, 50));
        g.fillOval(ancho/4, alto/3, ancho/2, (int)(alto*0.55));
        g.setColor(Color.RED); 
        g.fillOval((int)(ancho*0.7), (int)(alto*0.6), ancho/5, ancho/5);
    }

    private static void dibujarSquirtle(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(80, 150, 210));
        g.fillOval(ancho/4, alto/3, ancho/2, (int)(alto*0.55));
        g.setColor(new Color(180, 140, 90)); 
        g.fillOval((int)(ancho*0.3), (int)(alto*0.4), (int)(ancho*0.4), (int)(alto*0.4));
    }

    private static void dibujarJigglypuff(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(240, 160, 200));
        g.fillOval(ancho/5, alto/4, (int)(ancho*0.6), (int)(alto*0.6));
    }

    private static void dibujarMeowth(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(210, 210, 210));
        g.fillOval(ancho/4, alto/3, ancho/2, (int)(alto*0.55));
    }

    private static void dibujarPsyduck(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(250, 220, 90));
        g.fillOval(ancho/4, alto/3, ancho/2, (int)(alto*0.55));
    }

    private static void dibujarMachop(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(140, 170, 210));
        g.fillOval(ancho/4, alto/3, ancho/2, (int)(alto*0.55));
    }

    private static void dibujarGeodude(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(160, 150, 140));
        g.fillOval(ancho/5, alto/4, (int)(ancho*0.6), (int)(alto*0.6));
    }

    private static void dibujarGastly(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(90, 60, 120));
        g.fillOval(ancho/4, alto/4, ancho/2, alto/2);
    }

    private static void dibujarOnix(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(120, 130, 140));
        g.fillRoundRect(ancho/3, alto/6, ancho/3, (int)(alto*0.7), 20, 20);
    }

    private static void dibujarSnorlax(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(50, 90, 130));
        g.fillOval(ancho/6, alto/4, (int)(ancho*0.66), (int)(alto*0.65));
    }

    private static void dibujarMew(Graphics2D g, int ancho, int alto) {
        g.setColor(new Color(250, 200, 220));
        g.fillOval(ancho/4, alto/3, ancho/2, (int)(alto*0.55));
    }
}
