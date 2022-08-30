package ajedrez.partida;

import ajedrez.excepciones.*;
import ajedrez.piezas.*;

import javax.swing.*;

import java.awt.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameCargarPartida implements ActionListener {
    public JButton[] arrayDeBotonesCargarPartida = new JButton[3];

    public FrameCargarPartida() {
        JPanel panelCargarPartida = new JPanel();
        JFrame frameCargarPartida = new JFrame("Cargar Partida");

        panelCargarPartida.setLayout(new FlowLayout());

        frameCargarPartida.setVisible(true);
        frameCargarPartida.add(panelCargarPartida);
        frameCargarPartida.pack();

        JLabel textoCargarPartida = new JLabel("Elija la partida que desea cargar");
        panelCargarPartida.add(textoCargarPartida);

        JButton[] arrayDeBotonesCargarPartida = {new JButton("Partida 1 " + new Date()), new JButton("Partida 2 " + new Date()), new JButton("Partida 3 " + new Date())};
        for (int i = 0; i < 3; i++) {

            panelCargarPartida.add(arrayDeBotonesCargarPartida[i]);
            arrayDeBotonesCargarPartida[i].addActionListener(this);
        }
    }

    public boolean verificarQueEsBotonDeCargarPartida(Object aux) {
        for (int i = 0; i < 8; i++) {
            if (aux == arrayDeBotonesCargarPartida[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(verificarQueEsBotonDeCargarPartida(e.getSource())){

        }
    }
}
