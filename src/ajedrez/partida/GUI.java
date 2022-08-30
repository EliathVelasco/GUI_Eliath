package ajedrez.partida;

import ajedrez.excepciones.*;
import ajedrez.piezas.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GUI implements ActionListener {
    private final JFrame frameInicio = new JFrame("Chess");
    private final JFrame framePartida = new JFrame("Partida");

    private final JButton iniciarPartida = new JButton("Iniciar partida");
    private final JButton cargarPartida = new JButton("Cargar partida");
    private final JCheckBox darkMode = new JCheckBox("◑");
    private final JLabel labelTablero;
    private final ImageIcon imagenTablero = new ImageIcon("img/tablero.png");
    private final ImageIcon tablero_dark = new ImageIcon("img/tablero_dark.png");

    //Botón prueba
    private Partida partida = new Partida();
    private Movimiento movimientoActualBlanco = new Movimiento(partida.getJugadorBlanco());

    private Movimiento movimientoActualNegro = new Movimiento(partida.getJugadorNegro());
    private JButton[][] botonesEnTablero = new JButton[8][8];
    private final Icon point = new ImageIcon("img/point.png");
    private final JPanel panelPartida = new JPanel();

    public GUI() throws SintaxisInvalida {

        //Paneles
        JPanel panelInicio = new JPanel();

        //Imágenes misceláneas
        ImageIcon imagenInicio = new ImageIcon("img/inicio.png");

        //Imágenes de piezas blancas
        Icon torreBlanca = new ImageIcon("img/torreBlanca.png");
        Icon peonBlanco = new ImageIcon("img/peonBlanco.png");
        Icon alfilBlanco = new ImageIcon("img/alfilBlanco.png");
        Icon caballoBlanco = new ImageIcon("img/caballoBlanco.png");
        Icon damaBlanca = new ImageIcon("img/damaBlanca.png");
        Icon reyBlanco = new ImageIcon("img/reyBlanco.png");

        //Imágenes de piezas negras
        Icon torreNegra = new ImageIcon("img/torreNegra.png");
        Icon alfilNegro = new ImageIcon("img/alfilNegro.png");
        Icon caballoNegro = new ImageIcon("img/caballoNegro.png");
        Icon peonNegro = new ImageIcon("img/peonNegro.png");
        Icon reyNegro = new ImageIcon("img/reyNegro.png");
        Icon damaNegra = new ImageIcon("img/damaNegra.png");

        panelInicio.setLayout(new FlowLayout());
        panelPartida.setLayout(null);

        frameInicio.add(panelInicio, BorderLayout.CENTER);
        framePartida.add(panelPartida, BorderLayout.CENTER);

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
        darkMode.addActionListener(this);
        cargarPartida.addActionListener(this);

        //BufferedImage, Icon, ImageIcon
        //Icon va en botones
        //ImageIcon se agrega a una etiqueta y luego la etiqueta va al panel.

        panelInicio.add(iniciarPartida);
        panelInicio.add(cargarPartida);
        JLabel label = new JLabel(imagenInicio);
        labelTablero = new JLabel(imagenTablero);
        labelTablero.setBounds(10, 30, 528, 660);

        //BotonesConImagenInicialVacia
        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 6; j++) {
                botonesEnTablero[i][j] = new JButton();
                panelPartida.add(botonesEnTablero[i][j]);
                botonesEnTablero[i][j].setBounds((33 + 60 * i), 120 + 60 * j, 60, 60);
                botonesEnTablero[i][j].addActionListener(this);
                //ocultarBotonDePieza( botonesEnTablero[i][j]);
            }
        }

        //Piezas y botones Blancos
        botonesEnTablero[0][0] = new JButton(torreBlanca);
        botonesEnTablero[0][1] = new JButton(caballoBlanco);
        botonesEnTablero[0][2] = new JButton(alfilBlanco);
        botonesEnTablero[0][3] = new JButton(reyBlanco);
        botonesEnTablero[0][4] = new JButton(damaBlanca);
        botonesEnTablero[0][5] = new JButton(alfilBlanco);
        botonesEnTablero[0][6] = new JButton(caballoBlanco);
        botonesEnTablero[0][7] = new JButton(torreBlanca);

        //Piezas y botones negros
        botonesEnTablero[7][0] = new JButton(torreNegra);
        botonesEnTablero[7][1] = new JButton(caballoNegro);
        botonesEnTablero[7][2] = new JButton(alfilNegro);
        botonesEnTablero[7][3] = new JButton(reyNegro);
        botonesEnTablero[7][4] = new JButton(damaNegra);
        botonesEnTablero[7][5] = new JButton(alfilNegro);
        botonesEnTablero[7][6] = new JButton(caballoNegro);
        botonesEnTablero[7][7] = new JButton(torreNegra);


        for (int i = 0; i < 8; i++) {
            botonesEnTablero[0][i].setBounds((33 + 60 * i), 120, 60, 60);
            panelPartida.add(botonesEnTablero[0][i]);
            botonesEnTablero[0][i].addActionListener(this);

            botonesEnTablero[7][i].setBounds((33 + 60 * i), 540, 60, 60);
            panelPartida.add(botonesEnTablero[7][i]);
            botonesEnTablero[7][i].addActionListener(this);

            botonesEnTablero[1][i] = new JButton(peonBlanco);
            botonesEnTablero[1][i].setBounds((33 + 60 * i), 180, 60, 60);
            panelPartida.add(botonesEnTablero[1][i]);
            botonesEnTablero[1][i].addActionListener(this);

            botonesEnTablero[6][i] = new JButton(peonNegro);
            botonesEnTablero[6][i].setBounds((33 + 60 * i), 480, 60, 60);
            panelPartida.add(botonesEnTablero[6][i]);
            botonesEnTablero[6][i].addActionListener(this);

        }

        //Paneles y frames
        panelPartida.add(labelTablero);
        panelInicio.add(label);
        frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInicio.pack();
        //framePartida.pack();

        frameInicio.setVisible(true);
    }

    public static void main(String[] args) throws SintaxisInvalida {
        new GUI();
    }

    public void ocultarBotonDePieza(JButton botonDePieza) {
        botonDePieza.setOpaque(false);
        botonDePieza.setContentAreaFilled(false);
        botonDePieza.setBorderPainted(false);
    }

    public boolean verificarQueEsBotonDeCasilla(Object aux) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (aux == botonesEnTablero[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == iniciarPartida) {
            frameInicio.setVisible(false);
            framePartida.setVisible(true);

        } else if (e.getSource() == cargarPartida) {
            frameInicio.setVisible(false);
            new FrameCargarPartida();


        } else if (e.getSource() == darkMode) {
            if (labelTablero.getIcon() == imagenTablero) {
                labelTablero.setIcon(tablero_dark);
            } else {
                labelTablero.setIcon(imagenTablero);
            }
        }
        if (verificarQueEsBotonDeCasilla(e.getSource())) {
            try {
                if (partida.getColorTurnoActual() == ColorPiezas.BLANCAS) {

                    if (movimientoActualBlanco.getCoordenadasIniciales() == null) {
                        crearPuntosDeMovimiento(preguntarCoordenadasIniciales(obtenerCoordenadasDeBoton(e.getSource()), movimientoActualBlanco));
                        System.out.println(movimientoActualBlanco + "antes" + "B");
                    } else {
                        if (validarMovimiento(preguntarCordenadasFinales(obtenerCoordenadasDeBoton(e.getSource()), movimientoActualBlanco))) {

                        }
                        moverPiezaEnPantalla(movimientoActualBlanco);

                        /*if(partida.getTablero().hacerMovimientoEnLaLogica(preguntarCordenadasFinales(obtenerCoordenadasDeBoton(e.getSource()), movimientoActualBlanco))){
                            //partida.getTablero().getCasillas()[movimientoActualBlanco.getFilaInicial()][movimientoActualBlanco.getColumnaInicial()].getPieza();
                            //labelsDePiezasBlancas.setBounds(,,60,60);
                            //Mover Label
                        }*/
                        System.out.println(movimientoActualBlanco + "despuessss" + "B");
                        partida.setTurnoActual(ColorPiezas.NEGRAS);
                        System.out.println("Turno sig:" + partida.getColorTurnoActual());

                        movimientoActualBlanco = null;
                        movimientoActualBlanco = new Movimiento(partida.getJugadorBlanco());
                    }

                } else if (partida.getColorTurnoActual() == ColorPiezas.NEGRAS) {
                    if (movimientoActualNegro.getCoordenadasIniciales() == null) {
                        crearPuntosDeMovimiento(preguntarCoordenadasIniciales(obtenerCoordenadasDeBoton(e.getSource()), movimientoActualNegro));
                        System.out.println(movimientoActualNegro + "antes" + "N");
                    } else {
                        crearPuntosDeMovimiento(preguntarCordenadasFinales(obtenerCoordenadasDeBoton(e.getSource()), movimientoActualNegro));
                        System.out.println(movimientoActualNegro + "despuessss" + "N");
                        partida.setTurnoActual(ColorPiezas.BLANCAS);
                        System.out.println("Turno sig:" + partida.getColorTurnoActual());
                        movimientoActualNegro = null;
                        movimientoActualNegro = new Movimiento(partida.getJugadorNegro());
                    }
                }

            } catch (SintaxisInvalida | MovimientoInvalido | CoronacionAvanzando | CoronacionCapturando | EnroqueCorto |
                     EnroqueLargo ex) {
                System.out.println(ex.getMessage());
               // throw new RuntimeException(ex);
            }
        }
    }

    private boolean validarMovimiento(Movimiento movimiento) throws MovimientoInvalido {
        partida.getTablero().hacerMovimientoEnLaLogica(movimiento);
        return true;
    }

    private void moverPiezaEnPantalla(Movimiento movimiento) {
    }

    public String obtenerCoordenadasDeBoton(Object botonFuente) {

        for (int i = 0; i < botonesEnTablero.length; i++) {
            for (int j = 0; j < botonesEnTablero[i].length; j++) {
                if (botonesEnTablero[i][j] == botonFuente) {
                    return "" + i + j;
                }
            }
        }
        return "0";
    }

    private Movimiento preguntarCordenadasFinales(String coordenadasFinales, Movimiento movimiento) {
        movimiento.setCoordenadasFinales(coordenadasFinales);
        return movimiento;
    }

    private Movimiento preguntarCoordenadasIniciales(String coordenadasIniciales, Movimiento movimiento) {
        movimiento.setCoordenadasIniciales(coordenadasIniciales);
        return movimiento;
    }

    public Movimiento preguntarJugada(String s, Jugador jugador) throws SintaxisInvalida {

        return new Movimiento(s, jugador);

    }

    private void crearPuntosDeMovimiento(Movimiento movimiento) throws SintaxisInvalida, CoronacionAvanzando, EnroqueLargo, EnroqueCorto, CoronacionCapturando, MovimientoInvalido {
       /* ArrayList<JLabel> arrayListDePuntos = new ArrayList<>();
        for (int i = 0; i < obtenerCantidadTotalMovimientos(movimiento); i++) {
            arrayListDePuntos.add(new JLabel(point));
        }
        for (JLabel labelDePunto : arrayListDePuntos) {
            panelPartida.add(labelDePunto);
        }
        ArrayList<ArrayList<int[]>> listaDeCoordenadas;
        listaDeCoordenadas = partida.getTablero().getCasillas()[movimiento.getFilaInicial()][movimiento.getColumnaInicial()].getPieza().obtenerListaDeCoordenadasPosibles(movimiento);*/
        int aux2 = 0;
        for (int i = 0; i < listaDeCoordenadas(movimiento).size(); i++) {
            for (int j = 0; j < listaDeCoordenadas(movimiento).get(i).size(); j++) {
                if (partida.getTablero().getCasillas()[listaDeCoordenadas(movimiento).get(i).get(j)[0]][listaDeCoordenadas(movimiento).get(i).get(j)[1]].hayPieza()) {
                    partida.getTablero().quitarMovimientosNoAlcanzables(listaDeCoordenadas(movimiento).get(i), j);
                }
                if (partida.getTablero().getCasillas()[movimiento.getFilaInicial()][movimiento.getColumnaInicial()].getPieza() instanceof Peon) {
                    if (listaDeCoordenadas(movimiento).get(i).size() != 0 && listaDeCoordenadas(movimiento).get(i).get(j)[1] != movimiento.getColumnaInicial()) {
                        if (!(partida.getTablero().getCasillas()[listaDeCoordenadas(movimiento).get(i).get(j)[0]][listaDeCoordenadas(movimiento).get(i).get(j)[1]].hayPieza())) {
                            listaDeCoordenadas(movimiento).get(i).clear();
                        }
                    }
                }
            }
        }

        if (!(partida.getTablero().listaDeCoordenadasTieneAlMenosUna(listaDeCoordenadas(movimiento)))) {
            throw new MovimientoInvalido("Esa pieza no se puede mover a ningun lado pendejo");
        }
        partida.getTablero().mostrarCasillasALasQueSePuedeMover(movimiento);


        /*
        * peon 3
        * */
        int xd = 0;
        for (int i =0; i<xd ; i++){
            System.out.println("ENTRE");
        }

        for (int j = 0; j < listaDeCoordenadas(movimiento).size(); j++) {
            for (int aux = 0; aux < listaDeCoordenadas(movimiento).get(j).size(); aux++) {
                System.out.println("ENTRE");
                //botonesEnTablero[listaDeCoordenadas(movimiento).get(j).get(aux)[0]][listaDeCoordenadas(movimiento).get(j).get(aux)[1]].setIcon(point);
                //arrayListDePuntos.get(aux2).setBounds(34 + 60 * ((listaDeCoordenadas.get(j).get(aux)[1])), 120 + 60 * (listaDeCoordenadas.get(j).get(aux)[0]), 60, 60);
                aux2++;
            }
        }

        for (int i = 0; i < listaDeCoordenadas(movimiento).size(); i++) {
            for (int j = 0; j < listaDeCoordenadas(movimiento).get(i).size(); j++) {
                partida.getTablero().getCasillas()[listaDeCoordenadas(movimiento).get(i).get(j)[0]][listaDeCoordenadas(movimiento).get(i).get(j)[1]].subrayar();
            }
        }

    }

    private double obtenerCantidadTotalMovimientos(Movimiento movimiento) throws CoronacionAvanzando, EnroqueLargo, EnroqueCorto, CoronacionCapturando, MovimientoInvalido {

        double cantidadTotal = 0;
        for (int i = 0; i < listaDeCoordenadas(movimiento).size(); i++) {
            for (int j = 0; j < listaDeCoordenadas(movimiento).get(i).size(); j++) {
                cantidadTotal++;
            }
        }

        return cantidadTotal;
    }

    private ArrayList<ArrayList<int[]>> listaDeCoordenadas(Movimiento movimiento) throws CoronacionAvanzando, EnroqueLargo, EnroqueCorto, CoronacionCapturando, MovimientoInvalido {
        return partida.getTablero().getCasillas()[movimiento.getFilaInicial()][movimiento.getColumnaInicial()].getPieza().obtenerListaDeCoordenadasPosibles(movimiento);
    }
}