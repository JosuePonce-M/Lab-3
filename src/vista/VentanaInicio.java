package vista;

import control.JuegoMemoria;
import control.Partida;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
        JPanel datos = new JPanel(new GridLayout(2, 2, 10, 50));
        datos.setBackground(fondo);
        datos.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));

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
        
        // Botones 
        JPanel botones = new JPanel(new GridLayout(1, 2, 15, 0));
        botones.setBackground(fondo);

        JButton btnIniciar = new JButton("Iniciar");
        JButton btnSalir = new JButton("Salir");
        btnIniciar.setFont(new Font("SansSerif", Font.BOLD, 16));
        btnSalir.setFont(new Font("SansSerif", Font.BOLD, 16));

        btnIniciar.addActionListener(e -> iniciar());
        btnSalir.addActionListener(e -> System.exit(0));

        botones.add(btnIniciar);
        botones.add(btnSalir);
        panel.add(botones, BorderLayout.SOUTH);

        add(panel);
        
        
    }
    // Se ejecuta al dar clic en Iniciar
    private void iniciar() {
        try {
            partida.iniciar(txtJugador1.getText(), txtJugador2.getText());
            new VentanaJuego(partida).setVisible(true);
            dispose();   // cierra la ventana de inicio
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}