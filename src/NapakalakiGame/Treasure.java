/*
	Clase Treasure

*/
/*
@author Jesús Sánchez de Castro
@author Diego José Granados Álvarez
*/
package NapakalakiGame;

public class Treasure implements Card{

    //Atributos
    private String name;
    private int goldCoins;
    private int minBonus;	
    private int maxBonus;
	
    //Atributos de relacion
    private TreasureKind type;
	
    //Métodos
	
    //Constructor
    public Treasure(String n, int g, int min, int max, TreasureKind type){
        this.name = n;
	this.goldCoins = g;
	this.minBonus = min;
	this.maxBonus = max;
        this.type = type;
    }
    /*********************************************************************/
    public String getName(){
	return name;
    }
    /*********************************************************************/
    public int getGoldCoins(){
        return goldCoins;
    }
    /*********************************************************************/
    public int getMinBonus(){
        return minBonus;
    }
    /*********************************************************************/
    public int getMaxBonus(){
        return maxBonus;
    }
    /*********************************************************************/
    public TreasureKind getType(){
        return type;
    }
        
    @Override
    public String toString(){
    return "Name: " + name +
        "\n\tGoldCoins: " + Integer.toString(goldCoins) +
        "\n\tMinBonus: " + Integer.toString(minBonus) +
        "\n\tMaxBonus: " + Integer.toString(maxBonus) + 
        "\n\tType: " + type + "\n";
    }
    /*********************************************************************/
    /*
    Treasure: devuelven el bonus mínimo para getBasicValue() y bonus máximo
    para getSpecialValue(), llamando a los correspondiente consultores.
    */    
        
    @Override
    public int getBasicValue() {
        return getMinBonus();
    }

    @Override
    public int getSpecialValue() {
        return getMaxBonus();
    }
    /*********************************************************************/
}