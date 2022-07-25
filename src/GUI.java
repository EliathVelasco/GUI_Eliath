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
    private final JFrame framePartida = new JFrame();
    private final JPanel panelPartida = new JPanel();
    private final BufferedImage imagenInicio = ImageIO.read(new File("img/inicio.png"));
    private final BufferedImage tablero = ImageIO.read(new File("img/tablero.png"));
    private final BufferedImage elementoDeFondo = ImageIO.read(new File("img/bgElement1.png"));
    //Imágenes de Piezas negras
    private final BufferedImage torreNegra = ImageIO.read(new File("img/torreNegra.png"));
    private final BufferedImage alfilNegro = ImageIO.read(new File("img/alfilNegro.png"));
    private final BufferedImage caballoNegro = ImageIO.read(new File("img/caballoNegro.png"));
    private final BufferedImage peonNegro = ImageIO.read(new File("img/peonNegro.png"));
    private final BufferedImage reyNegro = ImageIO.read(new File("img/reyNegro.png"));
    private final BufferedImage damaNegra = ImageIO.read(new File("img/damaNegra.png"));
    //Imagen punto de movimiento
    private final BufferedImage point = ImageIO.read(new File("img/point.png"));

    //Imágenes de Piezas blancas
    private final BufferedImage reyBlanco = ImageIO.read(new File("img/reyBlanco.png"));
    private final BufferedImage damaBlanca = ImageIO.read(new File("img/damaBlanca.png"));
    private final BufferedImage caballoBlanco = ImageIO.read(new File("img/caballoBlanco.png"));
    private final BufferedImage alfilBlanco = ImageIO.read(new File("img/alfilBlanco.png"));
    private final BufferedImage peonBlanco = ImageIO.read(new File("img/peonBlanco.png"));
    private final BufferedImage torreBlanca = ImageIO.read(new File("img/torreBlanca.png"));
    private final JLabel label;

    //Label para el tablero
    private final JLabel labelTablero;
    private final JLabel[][] labelsDePiezasNegras;
    private JLabel[][] labelsDePiezasBlancas;
    public GUI() throws IOException {

        panelInicio.setLayout(new FlowLayout());
        panelPartida.setLayout(null);

        frameInicio.add(panelInicio, BorderLayout.CENTER);
        framePartida.add(panelPartida, BorderLayout.CENTER);

        JLabel labelDeElementoDeFondo = new JLabel(new ImageIcon(elementoDeFondo));
        panelPartida.add(labelDeElementoDeFondo);
        labelDeElementoDeFondo.setBounds(500, 115, 390, 490);

        Graphics gDeFondo = elementoDeFondo.getGraphics();
        gDeFondo.setColor(Color.BLACK);
        gDeFondo.setFont(gDeFondo.getFont().deriveFont(20f));
        gDeFondo.drawString("Historial", 50, 40);
        gDeFondo.dispose();

        String[] objetoListaHistorial = {"1", "2"};
        JList listaHistorial = new JList(objetoListaHistorial);
        JPanel panelHistorial = new JPanel();

        /*JSplitPane splitPaneTablero = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listaHistorial,listaHistorial);
        splitPaneTablero.setDividerLocation(500);
        framePartida.add(splitPaneTablero);

        JSplitPane splitPaneHistorial = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listaHistorial,listaHistorial);
        splitPaneHistorial.add(listaHistorial);
        splitPaneTablero.setDividerLocation(700);
        framePartida.add(splitPaneHistorial);*/

        JButton iniciarPartida = new JButton("Iniciar partida");
        iniciarPartida.addActionListener(this);
        JButton cargarPartida = new JButton("Cargar partida");
        cargarPartida.addActionListener(this);

        panelInicio.add(iniciarPartida);
        panelInicio.add(cargarPartida);
        label = new JLabel(new ImageIcon(imagenInicio));
        labelTablero = new JLabel(new ImageIcon(tablero));
        labelTablero.setBounds(10, 50, 490, 620);

        //Display de las piezas
        this.labelsDePiezasNegras = new JLabel[2][8];

        labelsDePiezasNegras[0][0] = new JLabel(new ImageIcon(torreNegra));
        labelsDePiezasNegras[0][1] = new JLabel(new ImageIcon(caballoNegro));
        labelsDePiezasNegras[0][2] = new JLabel(new ImageIcon(alfilNegro));
        labelsDePiezasNegras[0][3] = new JLabel(new ImageIcon(damaNegra));
        labelsDePiezasNegras[0][4] = new JLabel(new ImageIcon(reyNegro));
        labelsDePiezasNegras[0][5] = new JLabel(new ImageIcon(alfilNegro));
        labelsDePiezasNegras[0][6] = new JLabel(new ImageIcon(caballoNegro));
        labelsDePiezasNegras[0][7] = new JLabel(new ImageIcon(torreNegra));

        this.labelsDePiezasBlancas = new JLabel[2][8];

        labelsDePiezasBlancas[0][0] = new JLabel(new ImageIcon(torreBlanca));
        labelsDePiezasBlancas[0][1] = new JLabel(new ImageIcon(caballoBlanco));
        labelsDePiezasBlancas[0][2] = new JLabel(new ImageIcon(alfilBlanco));
        labelsDePiezasBlancas[0][3] = new JLabel(new ImageIcon(damaBlanca));
        labelsDePiezasBlancas[0][4] = new JLabel(new ImageIcon(reyBlanco));
        labelsDePiezasBlancas[0][5] = new JLabel(new ImageIcon(alfilBlanco));
        labelsDePiezasBlancas[0][6] = new JLabel(new ImageIcon(caballoBlanco));
        labelsDePiezasBlancas[0][7] = new JLabel(new ImageIcon(torreBlanca));

        for (int i = 0; i < 8; i++) {
            labelsDePiezasNegras[0][i].setBounds((15 + 60 * i), 120, 60, 60);
            panelPartida.add(labelsDePiezasNegras[0][i]);

        }
        for (int i = 0; i < 8; i++) {
            labelsDePiezasNegras[1][i] = new JLabel(new ImageIcon(peonNegro));
            labelsDePiezasNegras[1][i].setBounds((15 + 60 * i), 180, 60, 60);
            panelPartida.add(labelsDePiezasNegras[1][i]);
        }

        for (int i = 0; i < 8; i++) {
            labelsDePiezasBlancas[0][i].setBounds((15 + 60 * i), 540, 60, 60);
            panelPartida.add(labelsDePiezasBlancas[0][i]);

        }
        for (int i = 0; i < 8; i++) {
            labelsDePiezasBlancas[1][i] = new JLabel(new ImageIcon(peonBlanco));
            labelsDePiezasBlancas[1][i].setBounds((15 + 60 * i), 480, 60, 60);
            panelPartida.add(labelsDePiezasBlancas[1][i]);
        }

        JLabel labelPoint = new JLabel(new ImageIcon(point));
        labelPoint.setBounds(75,240,60,60);
        panelPartida.add(labelPoint);


        //Paneles y frames
        panelPartida.add(labelTablero);
        panelInicio.add(label);
        frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInicio.pack();
        framePartida.pack();
        frameInicio.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameInicio.setVisible(false);
        framePartida.setVisible(true);
    }
}