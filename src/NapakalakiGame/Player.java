/*
    Clase Player
 */
package NapakalakiGame;

import java.util.ArrayList;
import javax.swing.UIManager;

/**
 * @author Jesús Sánchez de Castro
 * @author Diego José Granados Álvarez
 */

 public class Player{

    //Atributos de la clase
    private boolean dead;
    private String name;
    private int level;

    //Atributos de relaccion
    private ArrayList<Treasure> visibleTreasures = new ArrayList();;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();;
    private Dice dice = Dice.getInstance();
    private CardDealer cardDealer = CardDealer.getInstance();
    private BadConsequence pendingBadConsequence;
    
    
    //Métodos
    /*************************************************************************/

    public Player (String name){
        this.name = name;
        this.level=1;
        this.dead=false;
    
    }
    
   /*************************************************************************/
    public Player (Player otro){
        this.name = otro.name;
        this.level = otro.level;
        this.dead = otro.dead;
        this.visibleTreasures = (ArrayList<Treasure>) otro.visibleTreasures.clone();
        this.hiddenTreasures = (ArrayList<Treasure>) otro.hiddenTreasures.clone();
        this.pendingBadConsequence = otro.pendingBadConsequence;
                          
        
    }
    /*************************************************************************/
    public String getName(){
        return this.name;
        
    }
    /*************************************************************************/
    //3.2 
    public void setLevel(int level){
        
        this.level=level;
    }
    /*************************************************************************/
    public BadConsequence GetPendingBadConsequence(){
        return pendingBadConsequence;
    }
    /*************************************************************************/

    private void bringToLife(){
        this.dead = false;
        this.level = 1;
    }

    /*************************************************************************/
    
    public int getCombatLevel(){
	int total_level = 0;
        boolean t_power = false;
        
        for(Treasure a_treasure : visibleTreasures){
            if(a_treasure.getType() == TreasureKind.necklace)
                t_power = true;
        }
        
        if(t_power){
            for(Treasure one_treasure : visibleTreasures){
                total_level += one_treasure.getMaxBonus();
            }
        }
        else{
            for(Treasure one_treasure : visibleTreasures){
                total_level += one_treasure.getMinBonus();
            }
	}
	return this.level + total_level;
    }

    /*************************************************************************/
    
    private void incrementLevels(int l){
        if(this.level + l <= 10) level += l;
    }
    
    /*************************************************************************/

    private void decrementLevels(int l){
        if(this.level - l > 0) 
            level -= l;
    }
    
    /*************************************************************************/

    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequence = b;
    }
    
    /*************************************************************************/

    public void dieIfNoTreasures(){
        if(this.visibleTreasures.isEmpty() && this.hiddenTreasures.isEmpty())
            this.dead = true;
    }
    
    /*************************************************************************/

    //Si el jugador tiene equipado el tesoro tipo NECKLACE, se lo pasa al CardDealer y lo
    //elimina de sus tesoros visibles. 
  
    private void discardNecklaceIfVisible(){
        
        //Tipos de los objetos puestos
        
        for(Treasure t : visibleTreasures){
            if(t.getType()== TreasureKind.necklace){
                visibleTreasures.remove(t);
                cardDealer.giveTreasureBack(t);
            }
        }

    }
    
    /*************************************************************************/

    //3.2 (diagrama)
    private void die(){

        //1
        this.setLevel(1);
        //2
        CardDealer dealer = CardDealer.getInstance();
        //3
        for (Treasure t : visibleTreasures) {
            //4
            dealer.giveTreasureBack(t);  
        }
        //5
        visibleTreasures.clear();
        //6
        for (Treasure t : hiddenTreasures) {
            //7
            dealer.giveTreasureBack(t);  
        }
        //8
        hiddenTreasures.clear();
        //9
        this.dieIfNoTreasures();
    }
    
    /*************************************************************************/

    //Devuelve la suma de todos los valores de los tesoros
    private float computeGoldCoinsValue(ArrayList <Treasure> t){
        int oroTotal=0;
        
        //Bucle que suma cada valor del tesoro en oroTotal
        for(Treasure a_treasure : t){
            oroTotal+= a_treasure.getGoldCoins();
        }
        
        return oroTotal;
    }
    
    /*************************************************************************/

    private boolean canIBuyLevels(float l){
        return level + l < 10; //Puedes comprar niveles si no superas el maximo (10)
    }
    
    /*************************************************************************/
    //3.2 (diagrama)
    private void applyPrice(Monster currentMonster){
        //1 
        int nLevels = currentMonster.getLevelsGained();
        //2
        this.incrementLevels(nLevels);
        //3
        int nTreasures = currentMonster.getTreasuresGained();
        //4
        if(nTreasures>0){
            //5
            CardDealer dealer = CardDealer.getInstance();
            Treasure t;
            //6
            for(int i=0; i < nTreasures ; i++){
                t = dealer.nextTreasure();
                hiddenTreasures.add(t);
         
            }
        }
    }
    
    /*************************************************************************/
    //3.2 (diagrama)
    private void applyBadConsequence(BadConsequence bad){

        //1 Obtenemos niveles a decrementar
        int nLevels = bad.getLevels();
        //2 Decrementamos los niveles
        this.decrementLevels(nLevels);
        //3 Obtenemos el badConsequence
        BadConsequence aux = bad.adjustToFitTreasureList(visibleTreasures, hiddenTreasures);
        //4 Ajustamos el badConsequence
        this.setPendingBadConsequence(aux);
    }
    /*************************************************************************/
    //Metodo sesion 3.1
    private boolean canMakeTreasureVisible(Treasure t){
        boolean puede = false;
        
        //Para equipar un tesoro de una mano hay que comprobar primero que no tenemos
        //un tesoro de dos manos u dos tesoros de una mano
        if(t.getType() == TreasureKind.oneHand){
            if(howManyVisibleTreasures(TreasureKind.bothHand) == 0 &&
               howManyVisibleTreasures(TreasureKind.oneHand) == 0 || 
               howManyVisibleTreasures(TreasureKind.oneHand) == 1)
               puede = true;
        }
        //Para equipar un tesoro de dos manos hay que comprobar que no tenemos equpado
        //algun tesoro de una mano o uno de dos manos
        else if(t.getType() == TreasureKind.bothHand){
            if(howManyVisibleTreasures(TreasureKind.oneHand) == 0 &&
               howManyVisibleTreasures(TreasureKind.bothHand) == 0)
               puede = true;
        }
        //Si el tesoro no fuera uno de los anteriores hay que comprobar que no hay
        //uno del mismo tipo equipado
        else if(howManyVisibleTreasures(t.getType()) == 0){
            puede = true;
        }
        
        return puede;      
        
    }
    
    /*************************************************************************/

    public boolean isDead(){
        return dead;
    }

    /*************************************************************************/
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;

    }
    
    /*************************************************************************/
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;

    }
    
    /*************************************************************************/

    //3.2 diagrama
    public CombatResult combat (Monster m){
        int myLevel = this.getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        CombatResult combatResult;
        
        if( myLevel > monsterLevel ){
            this.applyPrice(m); //Completar aplyPrice
            //if(this.getLevels() >= 10) combatResult=CombatResult.WinAndWinGame;
            if(this.getLevels() >= 10) combatResult=CombatResult.LoseAndConvert;
            else combatResult=CombatResult.Win;
        }
         else{
            int escape = dice.nextNumber("¿Podrá escapar del combate?","5 ó 6 -> SI | 1-4 -> NO");
            if(escape < 5){
                boolean amIDead = m.kills();
                if(amIDead){
                    this.die(); 
                    //combatResult = CombatResult.LoseAndDie;
                    combatResult = CombatResult.LoseAndConvert;
                }
                else{
                    
                    // MODIFICACIOMN P5
                    //Si no escapamos pero no hemos muerto podemos convertirnos 
                    //a sectario con shouldConvert o en caso de que no nos
                    //convirtamos, simplemente perdemos.
                    if(this.shouldConvert())
                        combatResult = CombatResult.LoseAndConvert;
                    else {
                    this.applyBadConsequence(m.getBC());
                    
                    //combatResult = CombatResult.Lose;
                    combatResult = CombatResult.LoseAndConvert;
                    }
                }
                    
            
            }
            else
                //combatResult = CombatResult.LoseAndConvert;
                combatResult = CombatResult.LoseAndEscape;
        }
        this.discardNecklaceIfVisible();
        return combatResult;

    }
    
    /*************************************************************************/

    //3.2 (diagrama)
    public void makeTreasureVisible(Treasure t){
        boolean canI = false;
        //1.2.1
        canI = this.canMakeTreasureVisible(t);
        if(canI){
            //1.2.2
            visibleTreasures.add(t);
            //1.2.3
            hiddenTreasures.remove(t);
        }
    }
    /*************************************************************************/
    //3.2 diagrama
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if( (pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        this.dieIfNoTreasures();
       
    }
    
    /*************************************************************************/
    // 3.2 diagrama
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if( (pendingBadConsequence != null) && (!pendingBadConsequence.isEmpty()) )
            pendingBadConsequence.substractHiddenTreasure(t);
        this.dieIfNoTreasures();
    }
    
    /*************************************************************************/

    //3.2
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        float levelsMayBougth = this.computeGoldCoinsValue(visible);
        levelsMayBougth += this.computeGoldCoinsValue(hidden);
        
        float levels = levelsMayBougth/1000;
        boolean canI = this.canIBuyLevels(levels);
        
        if(canI){ //Comprobamos si tenemos oro suficiente
            this.incrementLevels((int) levels);//Despreciamos los decimales
        }
        
        //Aunque no tengas oro suficiente para comprar te borra los tesoros !!!
        visibleTreasures.removeAll(visible);
        hiddenTreasures.removeAll(hidden);
        
        CardDealer dealer = CardDealer.getInstance();
        
        for ( Treasure vTreasure : visible ){
            dealer.giveTreasureBack(vTreasure);
        }
        
        for ( Treasure hTreasure : hidden ){
            dealer.giveTreasureBack(hTreasure);
        }
        
        return canI;

    }
    
    /*************************************************************************/

    public boolean validState(){
        //return (this.pendingBadConsequence.isEmpty() && (this.hiddenTreasures.size() <= 4));
        return ((pendingBadConsequence == null || pendingBadConsequence.isEmpty()) && hiddenTreasures.size()<5);
    }
    
    /*************************************************************************/

    //3.2 diagrama
    public void initTreasures(){
        //1
        CardDealer dealer = CardDealer.getInstance();
        //2
        Dice dice = Dice.getInstance();
        //3
        this.bringToLife();
        //4
        Treasure treasure = dealer.nextTreasure();
        //5
        hiddenTreasures.add(treasure);
        //6
        
        int number = dice.nextNumber("Inicializar tersoros de "+name,"1 -> 1  | 2-5 -> 2 | 6 ->3");
        if(number >=2 && number <= 5){
            //7            
            treasure = dealer.nextTreasure();
            if(treasure == null) 
                System.err.println("Error: Tesoro nulo en initTreasures de Player");
            //8
            hiddenTreasures.add(treasure);
        }
        else if(number == 6){
            //9
            
            for(int i=0; i<2; i++){
                treasure = dealer.nextTreasure();
                if(treasure == null) 
                    System.err.println("Error: Tesoro nulo en initTreasures de Player");
                //10
                hiddenTreasures.add(treasure);
            }
        }
        
    }
    
    /*************************************************************************/

    public boolean hasVisibleTreasures(){
        return !this.visibleTreasures.isEmpty();
    }

    /*************************************************************************/
    
    public int getLevels(){
        return this.level;
    }
    
    /*************************************************************************/

    public int howManyVisibleTreasures(TreasureKind tKind){
        int cont = 0;
        for (Treasure one_treasure : this.visibleTreasures){
            if(one_treasure.getType() == tKind) cont++;
        }
        return cont;
    }
    
    /*************************************************************************/
    @Override
    public String toString(){
        
        return  name + "\n" +
                "Player's level: " + Integer.toString(level) + "\n" +
                "¿Dead?: " + Boolean.toString(dead) + "\n" +
                "Hidden Treasures: " + hiddenTreasures + "\n" +
                "Visible Treasures: " + visibleTreasures + "\n" + 
                "Pending BadConsequence: " + pendingBadConsequence;
      
    }
   
     /*************************************************************************/
    //Métodos para práctica 5
    /*
    Se han añadido los métodos getOponentLevel y shouldConvert en Player y
    son sobreescritos en CultistPlayer.
    */
    protected int getOponentLevel(Monster m){
        
        return 1;
    }
    
    /*
    En el método shouldConvert() de la clase Player se lanzará el dado y devolverá
    true si se obtiene un 6 y false en caso contrario. Su redefinición en CultistPlayer
    devolverá siempre false
    */
    protected boolean shouldConvert(){
        int n = dice.nextNumber("6 = convertirse en sectario","diferente de 6 no te conviertes");
        return n==6;
    }
    /*************************************************************************/

 }


