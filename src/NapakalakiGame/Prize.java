/*
    Clase Prize que contiene los tesoros y niveles ganados al derrotar a 
    un monstruo
 */
package NapakalakiGame;

/**
 * @author Jesús Sánchez de Castro
 * @author Diego José Granados Álvarez
 */

public class Prize {
    
    //Variables privadas
    private int treasures;
    private int level;
    
    //Métodos
    public Prize(int treasures, int level){
        this.treasures = treasures;
        this.level = level;
    }
    /************************************************************************/
    public int getTreasures(){
        return this.treasures;
    }
    /************************************************************************/
    public int getLevel(){
        return this.level;
    }
    /************************************************************************/
    @Override
    public String toString(){
        return "Prize: " + 
                "\n\t\tTreasures: " + Integer.toString(level) + 
                "\n\t\tLevel: " + Integer.toString(level) + "\n";
    }
    /************************************************************************/
}
