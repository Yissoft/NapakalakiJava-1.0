/*
    Clase para el main del programa probando la impresión de monstruos para
    probar las clases y métodos.
 */
package NapakalakiGame;

/**
 * @author Jesús Sánchez de Castro
 * @author Diego José Granados Álvarez
 */

import GUI.NapakalakiView;
import GUI.PlayersNameCapture;
import java.util.ArrayList;

public class PruebaNapakalaki {

    public static void main(String[] args) {
        
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        
        NapakalakiView napakalakiView = new NapakalakiView();
        
        Dice.createInstance(napakalakiView);
        
        //Leer nombbres
        ArrayList<String> names = new ArrayList<String>();
        PlayersNameCapture namesCapture = new PlayersNameCapture(napakalakiView, true);
        names = namesCapture.getNames();
        
        napakalakiModel.initGame(names);
        
        napakalakiView.setNapakalaki(napakalakiModel);
        
        napakalakiView.showView();
    }
}

