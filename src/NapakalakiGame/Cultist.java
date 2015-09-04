/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Jesús
 */
import NapakalakiGame.CultistPlayer;
public class Cultist implements Card{
 
    
    private String name;
    private int gainedLevels;
    /**************************************************************************/
    //Constructor
    public Cultist(String n, int gL){
        this.name = n;
        this.gainedLevels = gL;
    }
    
    public String getName(){
        return name;                
    }
    
    public int getLevels(){
        return gainedLevels;
    }
    /**************************************************************************/
    /*
    Cultist: getBasicValue() devuelve gainedLevels y getSpecialValue() devuelve
    getBasicValue()*CultistPlayer.getTotalCultistPlayers().
    */
    @Override
    public int getBasicValue() {
        return gainedLevels;
    }

    @Override
    public int getSpecialValue() {
        return getBasicValue()*CultistPlayer.getTotalCultistPlayers();
    }
    /**************************************************************************/
}
