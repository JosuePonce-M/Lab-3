package vista;
import control.Partida;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.Partida;
import javax.swing.JFrame;
import javax.swing.JButton;
import modelo.Jugador;


public class VentanaJuego extends JFrame {
 // atributos
    private Partida partida;
    private Color fondo = new Color(255, 222, 89);
    private BotonCarta[] botones = new BotonCarta[Partida.TOTAL_CARTAS];
    private Color colorTurno = new Color(133, 183, 235);   // color para quien le toque el turno
      // paneles para informacion
    private JPanel[] panelesJugador = new JPanel[2];
    private JLabel[] lblNombres = new JLabel[2];
    private JLabel[] lblAciertos = new JLabel[2];
        private JLabel[] lblPuntos = new JLabel[2];

    
   
   public VentanaJuego(Partida partida) {
        this.partida = partida;
         setTitle("Memoria Pokémon");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel principal = new JPanel(new BorderLayout(15, 15));
        principal.setBackground(fondo);
        principal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        
         // Paneles de los jugadores a los lados
        principal.add(crearPanelJugador(0), BorderLayout.WEST);
        principal.add(crearPanelJugador(1), BorderLayout.EAST);

        // Centro: tablero de 6 x 6 cartas
        JPanel tablero = new JPanel(new GridLayout(Partida.FILAS, Partida.COLUMNAS, 5, 5));
        tablero.setBackground(fondo);
        for (int i = 0; i < botones.length; i++) {
            final int posicion = i;
            botones[i] = new BotonCarta();
            botones[i].addActionListener(e -> seleccionar(posicion));
            tablero.add(botones[i]);
        }
        principal.add(tablero, BorderLayout.CENTER);
        
         //  botón de nueva partida
        JPanel abajo = new JPanel();
        abajo.setBackground(fondo);
        JButton btnNueva = new JButton("Nueva partida");
        btnNueva.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnNueva.addActionListener(e -> nuevaPartida());
        abajo.add(btnNueva);
        principal.add(abajo, BorderLayout.SOUTH);
        
         add(principal);
         actualizar();

}
   // Crea el panel de un jugador (
    private JPanel crearPanelJugador(int i) {
        JPanel panel = new JPanel(new GridLayout(4, 1, 0, 8));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        

        JLabel lblTitulo = new JLabel("Jugador " + (i + 1));
        lblNombres[i] = new JLabel("Nombre");
        lblAciertos[i] = new JLabel("Aciertos: 0");
        lblPuntos[i] = new JLabel("Puntos: 0");
        lblNombres[i].setFont(new Font("SansSerif", Font.BOLD, 18));

        panel.add(lblTitulo);
        panel.add(lblNombres[i]);
        panel.add(lblAciertos[i]);
        panel.add(lblPuntos[i]);
        panelesJugador[i] = panel;
        

        
        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setBackground(fondo);
        contenedor.setPreferredSize(new Dimension(140, 0));
        contenedor.add(panel, BorderLayout.NORTH);
        return contenedor;
    }
    // Se ejecuta cuando dan clic en una carta
    private void seleccionar(int posicion) {
    }
     // Reinicia la partida (
    private void nuevaPartida() {
    }

    // Refresca los paneles de los jugadores c
    private void actualizar() {
        if (partida == null) {
            return;   
        }
        for (int i = 0; i < 2; i++) {
            Jugador jugador = partida.getJugador(i);
            lblNombres[i].setText(jugador.getNombre());
            lblAciertos[i].setText("Aciertos: " + jugador.getAciertos());
            lblPuntos[i].setText("Puntos: " + jugador.getPuntos());

            // pintar el panel del jugador en turno
            if (i == partida.getTurno()) {
                panelesJugador[i].setBackground(colorTurno);
            } else {
                panelesJugador[i].setBackground(Color.WHITE);
            }
        }
        for (int i = 0; i < botones.length; i++) {
            botones[i].setCarta(partida.getCarta(i));
        }
    }
}