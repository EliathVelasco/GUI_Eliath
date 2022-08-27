package ajedrez.piezas;

import ajedrez.partida.*;

import java.util.ArrayList;

import static ajedrez.partida.Tablero.ANCHO_TABLERO;

public class Torre extends Pieza {
    private boolean primerMovimiento;

    public Torre(ColorPiezas color) {
        super(color, 5, ANCHO_TABLERO);
        this.primerMovimiento = true;
    }

    @Override
    public String toString() {
        if (color == ColorPiezas.BLANCAS) {
            return "T";
        } else {
            return "t";
        }
    }

    public ArrayList<ArrayList<int[]>> obtenerListaDeCoordenadasPosibles(Movimiento movimiento) {
        listaPadreDeCoordenadasPosibles.clear();
        obtenerCoordenadasPosiblesDeManeraDiagonalSegunElAlcanceDeLaPiezas(movimiento);
        return listaPadreDeCoordenadasPosibles;
    }

    public boolean esSuPrimerMovimiento() {
        return primerMovimiento;
    }

    public void quitarPrimerMovimiento() {
        primerMovimiento = false;
    }
}