package ajedrez.partida;
import javax.swing.*;

public class BotonConImagen extends JButton{
    private final JButton boton;
    private final JLabel labelDeImagen;

    public BotonConImagen(JButton boton, JLabel labelDeImagen) {

        this.boton = boton;
        this.labelDeImagen = labelDeImagen;
    }
}
