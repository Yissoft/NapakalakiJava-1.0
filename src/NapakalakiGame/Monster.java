/*
    Clase Monster que contiene los monstruos del juego.
 */
package NapakalakiGame;

/**
 * @author Jesús Sánchez de Castro
 * @author Diego José Granados Álvarez
 */

public class Monster implements Card{

    //Atributos privados
    private String name;
    private int combatLevel;
    private Prize price;
    private BadConsequence bc;
    
     /*  P5
    Se ha añadido un nuevo atributo en la clase Monster para indicar un
    incremento/decremento de su nivel cuando combate con un sectario
    (levelChangeAgainstCultistPlayer) y por tanto debes modificar el constructor.    
    */    
    
    //Atributo para cultist
    int levelChangeAgainstCultistPlayer;

    //Constructor
    public Monster(String name, int combatLevel, BadConsequence bc, Prize price,
    int levelagainstC){
        this.name = name;
        this.combatLevel = combatLevel;
        this.bc = bc;
        this.price = price;
        this.levelChangeAgainstCultistPlayer = levelagainstC;
    }
    /************************************************************************/
    //Consultores
    public String getName(){
        return this.name;
    }
    /************************************************************************/
    public int getCombatLevel(){
        return this.combatLevel;
    }
    /************************************************************************/
    //Necesarios para obtener todos los datos de un monstruo.
    public BadConsequence getBC(){
        return this.bc;
    }
    /************************************************************************/
    
    public Prize getPrice(){
        return this.price;
    }
    /************************************************************************/


    public int getLevelsGained(){
        return this.price.getLevel();
    }
    /************************************************************************/
    public int getTreasuresGained(){
        return this.price.getTreasures();
    }
    /************************************************************************/
    public boolean kills(){
        return this.bc.getDeath();
    }
    /************************************************************************/
    //Sobreescritura del metodo to_string
    @Override
    public String toString(){
        return "Name: " + name +
               "\n\tCombatLevel: " + Integer.toString(combatLevel) +
               "\n\t" + bc.toString() +
               "\n\t" + price.toString();
    }

    /************************************************************************/

    //Métodos de la interfaz Card
    /*
    Monster: getBasicValue() llama al método getCombatLevel() y getSpecialValue()
    devuelve el getLevel() + levelChangeAgainstCultistPlayer
    */
    @Override
    public int getBasicValue() {
        return getCombatLevel();
    }

    @Override
    public int getSpecialValue() {
        return getCombatLevel() + levelChangeAgainstCultistPlayer;
    }

    /************************************************************************/
}
