package vista;

import control.JuegoMemoria;
import control.Partida;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class VentanaInicio extends JFrame {

    // atributos
    private Partida partida;
    private JTextField txtJugador1;
    private JTextField txtJugador2;

    public VentanaInicio() {
        partida = new JuegoMemoria();

        setTitle("Memoria Pokémon");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        Color fondo = new Color(255, 222, 89);   // amarillo
        Color azul = new Color(42, 117, 187);    // azul Pokémon

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout(10, 20));
        panel.setBackground(fondo);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Título
        JLabel titulo = new JLabel("Memoria Pokémon", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setForeground(azul);
        panel.add(titulo, BorderLayout.NORTH);
        
          // Campos de los jugadores 
        JPanel datos = new JPanel(new GridLayout(2, 2, 10, 20));
        datos.setBackground(fondo);

        JLabel lblJugador1 = new JLabel("Jugador 1:");
        JLabel lblJugador2 = new JLabel("Jugador 2:");
        lblJugador1.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblJugador2.setFont(new Font("SansSerif", Font.BOLD, 16));

        txtJugador1 = new JTextField();
        txtJugador2 = new JTextField();

        datos.add(lblJugador1);
        datos.add(txtJugador1);
        datos.add(lblJugador2);
        datos.add(txtJugador2);
        panel.add(datos, BorderLayout.CENTER);

        add(panel);
        
        
    }
}