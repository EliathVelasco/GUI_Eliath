import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI implements ActionListener {
    private final JFrame frameInicio = new JFrame("Chess");
    private final JPanel panelInicio = new JPanel();
    private final JFrame framePartida = new JFrame("Partida");
    private final JFrame frameCargarPartida = new JFrame("Cargar Partida");
    private final JPanel panelCargarPartida = new JPanel();
    private final JPanel panelPartida = new JPanel();
    private final ImageIcon imagenInicio = new ImageIcon("img/inicio.png");
    private final ImageIcon tablero = new ImageIcon("img/tablero.png");
    //Imágenes de Piezas negras
    private final ImageIcon torreNegra = new ImageIcon("img/torreNegra.png");
    private final ImageIcon alfilNegro = new ImageIcon("img/alfilNegro.png");
    private final ImageIcon caballoNegro = new ImageIcon("img/caballoNegro.png");
    private final ImageIcon peonNegro = new ImageIcon("img/peonNegro.png");
    private final ImageIcon reyNegro = new ImageIcon("img/reyNegro.png");
    private final ImageIcon damaNegra = new ImageIcon("img/damaNegra.png");
    //Imagen punto de movimiento
    private final ImageIcon point = new ImageIcon("img/point.png");

    //Imágenes de Piezas blancas
    private final ImageIcon reyBlanco = new ImageIcon("img/reyBlanco.png");
    private final ImageIcon damaBlanca = new ImageIcon("img/damaBlanca.png");
    private final ImageIcon caballoBlanco = new ImageIcon("img/caballoBlanco.png");
    private final ImageIcon alfilBlanco = new ImageIcon("img/alfilBlanco.png");
    private final ImageIcon peonBlanco = new ImageIcon("img/peonBlanco.png");
    private final ImageIcon torreBlanca = new ImageIcon("img/torreBlanca.png");
    private final JLabel label;

    //Label para el tablero
    private final JLabel labelTablero;
    private final JLabel[][] labelsDePiezasNegras;
    private JLabel[][] labelsDePiezasBlancas;
    private JButton iniciarPartida = new JButton("Iniciar partida");
    private JButton cargarPartida = new JButton("Cargar partida");
    private JCheckBox darkMode = new JCheckBox("◑");

    public GUI() throws IOException {

        panelInicio.setLayout(new FlowLayout());
        panelPartida.setLayout(null);
        panelCargarPartida.setLayout(new FlowLayout());

        frameInicio.add(panelInicio, BorderLayout.CENTER);
        framePartida.add(panelPartida, BorderLayout.CENTER);
        frameCargarPartida.add(panelCargarPartida);

        String[] objetoListaHistorial = {"a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3", "a2a3"};
        JList listaHistorial = new JList(objetoListaHistorial);

        JScrollPane scrollHistorial = new JScrollPane();
        scrollHistorial.setViewportView(listaHistorial);
        listaHistorial.setLayoutOrientation(JList.VERTICAL);
        panelPartida.add(scrollHistorial);
        scrollHistorial.setBounds(590, 130, 290, 330);

        JLabel textoHistorial = new JLabel("Historial de Jugadas");
        textoHistorial.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        textoHistorial.setBounds(625, 85, 350, 40);
        panelPartida.add(textoHistorial);
        JButton guardarYSalir = new JButton("Guardar y salir");

        JLabel turnoActual = new JLabel("Turno actual: ");
        turnoActual.setBounds(590, 495, 290, 40);
        guardarYSalir.setBounds(590, 525, 290, 40);
        darkMode.setBounds(675, 585, 130, 40);
        panelPartida.add(guardarYSalir);
        panelPartida.add(darkMode);
        panelPartida.add(turnoActual);

        iniciarPartida.addActionListener(this);

        cargarPartida.addActionListener(this);

        panelInicio.add(iniciarPartida);
        panelInicio.add(cargarPartida);
        label = new JLabel(imagenInicio);
        labelTablero = new JLabel(tablero);
        labelTablero.setBounds(10, 30, 528, 660);

        //Display de las piezas
        this.labelsDePiezasNegras = new JLabel[2][8];

        labelsDePiezasNegras[0][0] = new JLabel(torreNegra);
        labelsDePiezasNegras[0][1] = new JLabel(caballoNegro);
        labelsDePiezasNegras[0][2] = new JLabel(alfilNegro);
        labelsDePiezasNegras[0][3] = new JLabel(damaNegra);
        labelsDePiezasNegras[0][4] = new JLabel(reyNegro);
        labelsDePiezasNegras[0][5] = new JLabel(alfilNegro);
        labelsDePiezasNegras[0][6] = new JLabel(caballoNegro);
        labelsDePiezasNegras[0][7] = new JLabel(torreNegra);

        this.labelsDePiezasBlancas = new JLabel[2][8];

        labelsDePiezasBlancas[0][0] = new JLabel(torreBlanca);
        labelsDePiezasBlancas[0][1] = new JLabel(caballoBlanco);
        labelsDePiezasBlancas[0][2] = new JLabel(alfilBlanco);
        labelsDePiezasBlancas[0][3] = new JLabel(damaBlanca);
        labelsDePiezasBlancas[0][4] = new JLabel(reyBlanco);
        labelsDePiezasBlancas[0][5] = new JLabel(alfilBlanco);
        labelsDePiezasBlancas[0][6] = new JLabel(caballoBlanco);
        labelsDePiezasBlancas[0][7] = new JLabel(torreBlanca);

        for (int i = 0; i < 8; i++) {
            labelsDePiezasNegras[0][i].setBounds((33 + 60 * i), 120, 60, 60);
            panelPartida.add(labelsDePiezasNegras[0][i]);

        }
        for (int i = 0; i < 8; i++) {
            labelsDePiezasNegras[1][i] = new JLabel(peonNegro);
            labelsDePiezasNegras[1][i].setBounds((33 + 60 * i), 180, 60, 60);
            panelPartida.add(labelsDePiezasNegras[1][i]);
        }

        for (int i = 0; i < 8; i++) {
            labelsDePiezasBlancas[0][i].setBounds((33 + 60 * i), 540, 60, 60);
            panelPartida.add(labelsDePiezasBlancas[0][i]);

        }
        for (int i = 0; i < 8; i++) {
            labelsDePiezasBlancas[1][i] = new JLabel((peonBlanco));
            labelsDePiezasBlancas[1][i].setBounds((33 + 60 * i), 480, 60, 60);
            panelPartida.add(labelsDePiezasBlancas[1][i]);
        }

        JLabel labelPoint = new JLabel(point);
        labelPoint.setBounds(93, 240, 60, 60);
        panelPartida.add(labelPoint);

        //Paneles y frames
        panelPartida.add(labelTablero);
        panelInicio.add(label);
        frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInicio.pack();
        framePartida.pack();
        frameCargarPartida.add(labelPoint);
        frameCargarPartida.pack();
        frameInicio.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == iniciarPartida) {
            frameInicio.setVisible(false);
            framePartida.setVisible(true);
        } else if (e.getSource() == cargarPartida) {
            frameInicio.setVisible(false);
            frameCargarPartida.setVisible(true);
        }else if(e.getSource()==darkMode){

        }
    }
}