package ajedrez.partida;

import ajedrez.excepciones.*;
import ajedrez.piezas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI implements ActionListener {
    private final JFrame frameInicio = new JFrame("Chess");
    private final JFrame framePartida = new JFrame("Partida");
    private final JFrame frameCargarPartida = new JFrame("Cargar Partida");
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
    private final ImageIcon point = new ImageIcon("img/point.png");
    private final JPanel panelPartida = new JPanel();

    public GUI() throws SintaxisInvalida {

        //Paneles
        JPanel panelInicio = new JPanel();
        JPanel panelCargarPartida = new JPanel();

        //Imágenes misceláneas
        ImageIcon imagenInicio = new ImageIcon("img/inicio.png");

        //Imágenes de piezas blancas
        ImageIcon torreBlanca = new ImageIcon("img/torreBlanca.png");
        ImageIcon peonBlanco = new ImageIcon("img/peonBlanco.png");
        ImageIcon alfilBlanco = new ImageIcon("img/alfilBlanco.png");
        ImageIcon caballoBlanco = new ImageIcon("img/caballoBlanco.png");
        ImageIcon damaBlanca = new ImageIcon("img/damaBlanca.png");
        ImageIcon reyBlanco = new ImageIcon("img/reyBlanco.png");

        //Imágenes de piezas negras
        ImageIcon torreNegra = new ImageIcon("img/torreNegra.png");
        ImageIcon alfilNegro = new ImageIcon("img/alfilNegro.png");
        ImageIcon caballoNegro = new ImageIcon("img/caballoNegro.png");
        ImageIcon peonNegro = new ImageIcon("img/peonNegro.png");
        ImageIcon reyNegro = new ImageIcon("img/reyNegro.png");
        ImageIcon damaNegra = new ImageIcon("img/damaNegra.png");

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
        darkMode.addActionListener(this);
        cargarPartida.addActionListener(this);

        panelInicio.add(iniciarPartida);
        panelInicio.add(cargarPartida);
        JLabel label = new JLabel(imagenInicio);
        labelTablero = new JLabel(imagenTablero);
        labelTablero.setBounds(10, 30, 528, 660);

        //Display de las piezas
        JLabel[][] labelsDePiezasNegras = new JLabel[2][8];

        labelsDePiezasNegras[0][0] = new JLabel(torreNegra);
        labelsDePiezasNegras[0][1] = new JLabel(caballoNegro);
        labelsDePiezasNegras[0][2] = new JLabel(alfilNegro);
        labelsDePiezasNegras[0][4] = new JLabel(damaNegra);
        labelsDePiezasNegras[0][3] = new JLabel(reyNegro);
        labelsDePiezasNegras[0][5] = new JLabel(alfilNegro);
        labelsDePiezasNegras[0][6] = new JLabel(caballoNegro);
        labelsDePiezasNegras[0][7] = new JLabel(torreNegra);

        /* Arrays para labels de piezas
        JLabel[][] labelsDePiezasBlancas = new JLabel[2][8];

       labelsDePiezasBlancas[0][0] = new JLabel(torreBlanca);
        labelsDePiezasBlancas[0][1] = new JLabel(caballoBlanco);
        labelsDePiezasBlancas[0][2] = new JLabel(alfilBlanco);
        labelsDePiezasBlancas[0][4] = new JLabel(damaBlanca);
        labelsDePiezasBlancas[0][3] = new JLabel(reyBlanco);
        labelsDePiezasBlancas[0][5] = new JLabel(alfilBlanco);
        labelsDePiezasBlancas[0][6] = new JLabel(caballoBlanco);
        labelsDePiezasBlancas[0][7] = new JLabel(torreBlanca);*/

        BotonConImagen[][] arrayDeBotonesConImg = new BotonConImagen[8][8];

        arrayDeBotonesConImg[0][0] = new BotonConImagen(new JButton("" + 0 + 0), new JLabel(torreBlanca));
        arrayDeBotonesConImg[0][1] = new BotonConImagen(new JButton("" + 0 + 1), new JLabel(caballoBlanco));
        arrayDeBotonesConImg[0][2] = new BotonConImagen(new JButton("" + 0 + 2), new JLabel(alfilBlanco));
        arrayDeBotonesConImg[0][4] = new BotonConImagen(new JButton("" + 0 + 4), new JLabel(damaBlanca));
        arrayDeBotonesConImg[0][3] = new BotonConImagen(new JButton("" + 0 + 3), new JLabel(reyBlanco));
        arrayDeBotonesConImg[0][5] = new BotonConImagen(new JButton("" + 0 + 5), new JLabel(alfilBlanco));
        arrayDeBotonesConImg[0][6] = new BotonConImagen(new JButton("" + 0 + 6), new JLabel(caballoBlanco));
        arrayDeBotonesConImg[0][7] = new BotonConImagen(new JButton("" + 0 + 7), new JLabel(caballoBlanco));

        //BotonesConImagenVacia
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                arrayDeBotonesConImg[i][j] = new BotonConImagen(new JButton("" + i + j), new JLabel());
                panelPartida.add(arrayDeBotonesConImg[i][j]);
                arrayDeBotonesConImg[i][j].addActionListener(this);
                arrayDeBotonesConImg[i][j].setBounds((33 + 60 * j), (120 + 60 * i), 60, 60);
                ocultarBotonDePieza(arrayDeBotonesConImg[i][j]);
            }
        }

        for (int i = 0; i < 8; i++) {

            labelsDePiezasNegras[0][i].setBounds((33 + 60 * i), 540, 60, 60);
            panelPartida.add(labelsDePiezasNegras[0][i]);
        }
        for (int i = 0; i < 8; i++) {
            labelsDePiezasNegras[1][i] = new JLabel(peonNegro);
            labelsDePiezasNegras[1][i].setBounds((33 + 60 * i), 480, 60, 60);
            panelPartida.add(labelsDePiezasNegras[1][i]);
        }

        for (int i = 0; i < 8; i++) {
            labelsDePiezasBlancas[0][i].setBounds((33 + 60 * i), 120, 60, 60);
            panelPartida.add(labelsDePiezasBlancas[0][i]);
        }
        for (int i = 0; i < 8; i++) {
            labelsDePiezasBlancas[1][i] = new JLabel((peonBlanco));
            panelPartida.add(labelsDePiezasBlancas[1][i]);
            labelsDePiezasBlancas[1][i].setBounds((33 + 60 * i), 180, 60, 60);
        }

        //Paneles y frames
        panelPartida.add(labelTablero);
        panelInicio.add(label);
        frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInicio.pack();
        framePartida.pack();
        frameCargarPartida.pack();
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
            frameCargarPartida.setVisible(true);
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

                    if(movimientoActualBlanco.getCoordenadasIniciales()==null){
                        crearPuntosDeMovimiento(preguntarCoordenadasIniciales(e.getActionCommand(), movimientoActualBlanco));
                        System.out.println(movimientoActualBlanco+"antes"+"B");
                    }else{
                        if(validarMovimiento(preguntarCordenadasFinales(e.getActionCommand(), movimientoActualBlanco)){

                        }
                        moverPiezaEnPantalla(movimientoActualBlanco);

                        if(partida.getTablero().hacerMovimientoEnLaLogica(preguntarCordenadasFinales(e.getActionCommand(), movimientoActualBlanco))){
                            //partida.getTablero().getCasillas()[movimientoActualBlanco.getFilaInicial()][movimientoActualBlanco.getColumnaInicial()].getPieza();
                            //labelsDePiezasBlancas.setBounds(,,60,60);
                            //Mover Label
                        }
                        System.out.println(movimientoActualBlanco+"despuessss"+"B");

                        partida.setTurnoActual(ColorPiezas.NEGRAS);
                        System.out.println("Turno sig:"+partida.getColorTurnoActual());

                        movimientoActualBlanco = null;
                        movimientoActualBlanco = new Movimiento(partida.getJugadorBlanco());
                    }

                } else if (partida.getColorTurnoActual() == ColorPiezas.NEGRAS) {
                    if(movimientoActualNegro.getCoordenadasIniciales()==null){
                        crearPuntosDeMovimiento(preguntarCoordenadasIniciales(e.getActionCommand(), movimientoActualNegro));
                        System.out.println(movimientoActualNegro+"antes"+"N");
                    }else{
                        crearPuntosDeMovimiento(preguntarCordenadasFinales(e.getActionCommand(), movimientoActualNegro));
                        System.out.println(movimientoActualNegro+"despuessss"+"N");
                        partida.setTurnoActual(ColorPiezas.BLANCAS);
                        System.out.println("Turno sig:"+partida.getColorTurnoActual());
                        movimientoActualNegro = null;
                        movimientoActualNegro = new Movimiento(partida.getJugadorNegro());
                    }
                }

            } catch (SintaxisInvalida | MovimientoInvalido | CoronacionAvanzando | CoronacionCapturando | EnroqueCorto |
                     EnroqueLargo ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException(ex);
            }
        }
    }

    private boolean validarMovimiento(Movimiento movimiento) throws MovimientoInvalido {
        partida.getTablero().hacerMovimientoEnLaLogica(movimiento);
        return true;
    }

    private void moverPiezaEnPantalla(Movimiento movimiento) {
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
        ArrayList<JLabel> arrayListDePuntos = new ArrayList<>();
        for (int i = 0; i < obtenerCantidadTotalMovimientos(movimiento); i++) {
            arrayListDePuntos.add(new JLabel(point));
        }

        for (JLabel labelDePunto : arrayListDePuntos) {
            panelPartida.add(labelDePunto);
        }

        int aux2 = 0;


        ArrayList<ArrayList<int[]>> listaDeCoordenadas;
        listaDeCoordenadas = partida.getTablero().getCasillas()[movimiento.getFilaInicial()][movimiento.getColumnaInicial()].getPieza().obtenerListaDeCoordenadasPosibles(movimiento);

        for (int i = 0; i < listaDeCoordenadas.size(); i++) {
            for (int j = 0; j < listaDeCoordenadas.get(i).size(); j++) {
                if (partida.getTablero().getCasillas()[listaDeCoordenadas.get(i).get(j)[0]][listaDeCoordenadas.get(i).get(j)[1]].hayPieza()) {
                    partida.getTablero().quitarMovimientosNoAlcanzables(listaDeCoordenadas.get(i), j);
                }
                if (partida.getTablero().getCasillas()[movimiento.getFilaInicial()][movimiento.getColumnaInicial()].getPieza() instanceof Peon){
                    if (listaDeCoordenadas.get(i).size() != 0 && listaDeCoordenadas.get(i).get(j)[1] != movimiento.getColumnaInicial()){
                        if (!(partida.getTablero().getCasillas()[listaDeCoordenadas.get(i).get(j)[0]][listaDeCoordenadas.get(i).get(j)[1]].hayPieza())){
                            listaDeCoordenadas.get(i).clear();
                        }
                    }
                }
            }
        }

        if (!(partida.getTablero().listaDeCoordenadasTieneAlMenosUna(listaDeCoordenadas))){
            throw new MovimientoInvalido("Esa pieza no se puede mover a ningun lado pendejo");
        }

        for (int j = 0; j < listaDeCoordenadas.size(); j++) {
            for (int aux = 0; aux < listaDeCoordenadas.get(j).size(); aux++) {

                arrayListDePuntos.get(aux2).setBounds(34 + 60 * ((listaDeCoordenadas.get(j).get(aux)[1])), 120 + 60 * (listaDeCoordenadas.get(j).get(aux)[0]), 60, 60);
                panelPartida.setComponentZOrder(arrayListDePuntos.get(aux2), 1);
                aux2++;
            }
        }

        for (int i = 0; i < listaDeCoordenadas.size(); i++) {
            for (int j = 0; j < listaDeCoordenadas.get(i).size(); j++) {
                partida.getTablero().getCasillas()[listaDeCoordenadas.get(i).get(j)[0]][listaDeCoordenadas.get(i).get(j)[1]].subrayar();
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