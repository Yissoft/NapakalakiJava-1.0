/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import NapakalakiGame.Player;
/**
 *
 * @author Jesús & Diego
 */
public class CultistPlayer extends Player{
    
    //Variable privada y statica (variable de clase)
    private static int totalCultistPlayer = 0;
    
    /*
    Se ha añadido una asociación de CultistPlayer a Cultist, cuyo rol es
    myCultistCard.
    */
    Cultist myCultistCard;
    Player aux;

    //Constructor
    public CultistPlayer(Player p, Cultist c){
        super(p);
        aux = p;
        myCultistCard = c;
        totalCultistPlayer++;
    }
    
    /*************************************************************************/
    //Métodos
    /*
    El método getCombatLevel() se redefine en la clase CultistPlayer para calcular su
    nivel de combate sumando el getCombatLevel() de Player más lo que devuelve el
    método getSpecialValue() de su carta de sectario (Cultist).
    */
    @Override
    public int getCombatLevel(){
        
        return super.getCombatLevel() + myCultistCard.getSpecialValue();
    } 
          
    /*************************************************************************/
    /*
    Se han añadido los métodos getOponentLevel y shouldConvert en Player y
    son sobreescritos en CultistPlayer.
    */
    @Override
    //Método sobreescrito
    protected boolean shouldConvert(){
        //Siempre se devuelve falso.
        return false;
    }
    @Override
    //Método sobreescrito
    protected int getOponentLevel(Monster m){
    
        return 1;
    }
    /*************************************************************************/
    protected float computeGoldCoinsValue(Treasure t){
        
        return computeGoldCoinsValue(t)*2;
    }
    /*************************************************************************/
    public static int getTotalCultistPlayers(){
    
        return totalCultistPlayer;
        
    }
    /*************************************************************************/
    public Cultist getCultist(){
        return myCultistCard;
    }
}
