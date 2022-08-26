package ajedrez.partida;
import ajedrez.excepciones.*;

import java.util.Arrays;

public class Movimiento {
    /*Revisar cambio porque esto esta mal pero no se como lo tienes*/
    protected int [] coordenadasIniciales;
    protected int [] coordenadasFinales;
    private Jugador jugadorQueRealizoLaJugada;

    public Movimiento(Jugador jugador){
        jugadorQueRealizoLaJugada = jugador;
        coordenadasIniciales = null;
        coordenadasFinales = null;
    }

    public Movimiento(String jugada, Jugador jugador) throws SintaxisInvalida {
        coordenadasIniciales[0] = transformarFilaIngresadaEnIndice(jugada.charAt(0));
        coordenadasIniciales[1] = transformarFilaIngresadaEnIndice(jugada.charAt(1));

        this.jugadorQueRealizoLaJugada = jugador;
    }

    private int transformarFilaIngresadaEnIndice(char fila){
        return Character.getNumericValue(fila);
    }
    public void setCoordenadasFinales(String jugada){
        coordenadasFinales = new int[2];
        coordenadasFinales[0] = Character.getNumericValue(jugada.charAt(0));
        coordenadasFinales[1] = Character.getNumericValue(jugada.charAt(1));
    }
    private int transformarColumnaIngresadaEnIndice(char columna) {
        String cadenaDeLetras = "abcdefgh";
        return cadenaDeLetras.indexOf(columna);
    }

    public int getColumnaInicial(){
        return coordenadasIniciales[1];
    }

    public int getFilaInicial(){
        return coordenadasIniciales[0];
    }

    public int[] getCoordenadasIniciales() {
        return coordenadasIniciales;
    }

    public int[] getCoordenadasFinales() {
        return coordenadasFinales;
    }

    public int getFilaFinal() {
        return coordenadasFinales[0];
    }

    public int getColumnaFinal() {
        return coordenadasFinales[1];
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "coordenadasIniciales=" + Arrays.toString(coordenadasIniciales) +
                ", coordenadasFinales=" + Arrays.toString(coordenadasFinales) +"}";

    }

    public ColorPiezas getColorDeJugador() {
        return jugadorQueRealizoLaJugada.getColor();
    }

    public void setCoordenadasIniciales(String coordenadasIniciales) {
        this.coordenadasIniciales = new int[2];
        this.coordenadasIniciales[0] = Character.getNumericValue(coordenadasIniciales.charAt(0));
        this.coordenadasIniciales[1] = Character.getNumericValue(coordenadasIniciales.charAt(1));
    }
}
