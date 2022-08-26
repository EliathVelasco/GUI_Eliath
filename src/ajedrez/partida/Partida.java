package ajedrez.partida;

import ajedrez.excepciones.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Partida {
    private final Tablero tablero;

    private ColorPiezas colorTurnoActual;


    private Jugador jugadorBlanco;
    private Jugador jugadorNegro;



    public Partida() {
        jugadorBlanco = new Jugador(ColorPiezas.BLANCAS);
        jugadorNegro = new Jugador(ColorPiezas.NEGRAS);
        colorTurnoActual = ColorPiezas.BLANCAS;
        tablero = new Tablero();
    }

    public void jugarPartida() {
        for (; ; ) {
            while (colorTurnoActual == ColorPiezas.BLANCAS) {
                colorTurnoActual = ColorPiezas.NEGRAS;
            }
            while (colorTurnoActual == ColorPiezas.NEGRAS) {
                colorTurnoActual = ColorPiezas.BLANCAS;
            }
        }
    }

    public ColorPiezas getColorTurnoActual() {
        return colorTurnoActual;
    }
    public void setTurnoActual(ColorPiezas colorTurnoActual) {
        this.colorTurnoActual = colorTurnoActual;
    }

    public Jugador getJugadorBlanco() {
        return jugadorBlanco;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugadorNegro() {
        return jugadorNegro;
    }

    public void imprimirTablero() {
        System.out.println(tablero);
    }
}
