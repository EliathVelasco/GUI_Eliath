package ajedrez.piezas;
import ajedrez.excepciones.*;
import ajedrez.partida.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Rey extends Pieza {
    private boolean primerMovimiento;

    public Rey(ColorPiezas color) {
        super(color, 0,1);
        primerMovimiento = true;
    }

    @Override
    public String toString() {
        if (this.color == ColorPiezas.BLANCAS) {
            return "R";
        } else {
            return "r";
        }
    }
    /*
     * El rey tampoco clava las piezas, por lo que hay que ver que mismo hacemos aqui*/

    @Override
    public ArrayList<ArrayList<int[]>> obtenerListaDeCoordenadasPosibles(Movimiento movimiento) throws EnroqueCorto, EnroqueLargo{
        listaPadreDeCoordenadasPosibles.clear();
        if(movimiento.getCoordenadasFinales() != null){
            if(primerMovimiento){
                if(color == ColorPiezas.BLANCAS){
                    if(Arrays.equals(movimiento.getCoordenadasIniciales(), new int[]{0,4}) && Arrays.equals(movimiento.getCoordenadasFinales(), new int[]{0,7})){
                        throw new EnroqueLargo();
                    }
                    if (Arrays.equals(movimiento.getCoordenadasIniciales(), new int[]{0,4}) && Arrays.equals(movimiento.getCoordenadasFinales(), new int[]{0,0})){
                        throw new EnroqueCorto();
                    }
                }
                if(color == ColorPiezas.NEGRAS){
                    if(Arrays.equals(movimiento.getCoordenadasIniciales(), new int[]{7,4}) && Arrays.equals(movimiento.getCoordenadasFinales(), new int[]{7,7})){
                        throw new EnroqueLargo();
                    }
                    if (Arrays.equals(movimiento.getCoordenadasIniciales(), new int[]{7,4}) && Arrays.equals(movimiento.getCoordenadasFinales(), new int[]{7,0})){
                        throw new EnroqueCorto();
                    }
                }
            }
        }

        obtenerCoordenadasPosiblesDeManeraDiagonalSegunElAlcanceDeLaPiezas(movimiento);
        obtenerCoordenadasPosiblesDeManeraVerticalYHorizontalSegunElAlcanceDeLaPieza(movimiento);
        return listaPadreDeCoordenadasPosibles;
    }

    private void agregarALaLista(int[] coordenadas) {
        ArrayList<int []> aux = new ArrayList<>();
        aux.add(coordenadas);
        listaPadreDeCoordenadasPosibles.add((ArrayList<int[]>) aux.clone());
        aux.clear();
    }

    public boolean esSuPrimerMovimiento(){
        return primerMovimiento;
    }

    public void quitarPrimerMovimiento() {
        primerMovimiento = false;
    }
}