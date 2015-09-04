/*
	Clase Napakalaki
	
*/
package NapakalakiGame;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Random;

public class Napakalaki{
	
	/*************************************************************/
	//Singleton
	private static final Napakalaki instance = new Napakalaki();
	
	//Constructor singleton
	private  Napakalaki(){}
	/*************************************************************/
	//Atributos de relacion
	private Monster currentMonster;
	private CardDealer dealer = CardDealer.getInstance();
	private Player currentPlayer;
	private ArrayList <Player> players = new ArrayList();
        //VARIABLE NUEVA PARA LA INTERFAZ
        private Player nextPlayerGUI = new Player("No Name");
        //VARIABLE NUEVA PARA LA INTERFAZ
        
        Cultist lastCard;

	/********************************************************************/
	//Metodos
	private void initPlayers( ArrayList <String> names){
            for(String one_name : names){
                Player my_player = new Player(one_name);
                this.players.add(my_player);
                my_player.initTreasures();
            }
	}
        /********************************************************************/
       
        
	/********************************************************************/
	private Player nextPlayer(){
            
            Player nextPlayer;
            Player GUI;
            Random rand = new Random();
            if(this.currentPlayer == null){//Si es la primera vez => aleatorio
                nextPlayer = players.get(rand.nextInt(players.size()));
                currentPlayer = new Player(nextPlayer.getName());
                
                //CODIGO PARA SIGUIENTE JUGADOR
                //Buscamos el índice del currentPlayer inicial en el array de players
                //para asignarle indice+1 al futuro siguiente jugador.
                
                //INICIALIZACIÓN DE nextPlayerGUI
                GUI = players.get((players.indexOf(currentPlayer)+1)%players.size());
                nextPlayerGUI = GUI;
            }
            else{//nextPlayer = currentPlayer_index+1 % size.tamaño
                nextPlayer = players.get((players.indexOf(currentPlayer)+1)%players.size());
                GUI = players.get((players.indexOf(currentPlayer)+2)%players.size());
                currentPlayer = nextPlayer;
                nextPlayerGUI = GUI;
            }
         
            return nextPlayer;
	
	}
        
        /********************************************************************/
        public Player getNextGUI(){
            if(this.nextPlayerGUI!= null)
                return this.nextPlayerGUI;
            else return new Player("No Name");
            
            
        }
	/********************************************************************/
	private boolean nextTurnAllowed(){
            //return currentPlayer.validState();
            if(currentPlayer==null)
                return true;
            else
               return currentPlayer.validState();
            
	}
	/********************************************************************/
	public static Napakalaki getInstance(){
		return instance;
	}
	/********************************************************************/
	public CombatResult developCombat(){
            CombatResult combatResult = currentPlayer.combat(currentMonster);
            
            //Práctica 5
            if(combatResult == CombatResult.LoseAndConvert){
                
                Cultist aux = dealer.nextCultist();
                lastCard = aux;
                //Se crea un nuevo jugador sectario que reemplaza al currentP
                CultistPlayer cultistPlayer = new CultistPlayer(currentPlayer, aux);
                //Reemplazamos con el current
                //Depuracion
                System.out.print(currentPlayer);
                int indice =  players.indexOf(currentPlayer);
                currentPlayer = cultistPlayer;
                //Depuracion
                //System.out.print(cultistPlayer);
                
                players.set(indice,cultistPlayer);
            }
            dealer.giveMonsterBack(currentMonster);
            return combatResult;
	
	}
	/********************************************************************/
        //3.2 diagrama
	public void discardVisibleTreasures(ArrayList <Treasure> treasures){
            for (Treasure one_treasure : treasures){
                currentPlayer.discardVisibleTreasure(one_treasure);
                dealer.giveTreasureBack(one_treasure);
            }
	}
	/********************************************************************/
        //3.2 diagrama
	public void discardHiddenTreasures(ArrayList <Treasure> treasures){
            for (Treasure one_treasure : treasures){
                currentPlayer.discardHiddenTreasure(one_treasure);
                dealer.giveTreasureBack(one_treasure);
            }
	}
        /********************************************************************/
	//3.2 diagrama
	public void makeTreasuresVisible(ArrayList <Treasure> treasures){
            for (Treasure t : treasures) {
                currentPlayer.makeTreasureVisible(t);
            }
	}
	/********************************************************************/
	public boolean buyLevels(ArrayList <Treasure> visible, ArrayList <Treasure> hidden){
            return currentPlayer.buyLevels(visible, hidden);
	}
	/********************************************************************/
	public void initGame(ArrayList <String> players){
          
            dealer.initCards();
            this.initPlayers(players);            
            this.nextTurn();
            
	}
	/********************************************************************/
	public Player getCurrentPlayer(){
            if(this.currentPlayer!= null)
                return this.currentPlayer;
            else 
                System.err.println("current Player nulo");
                return null;
	}
	/********************************************************************/
	public Monster getCurrentMonster(){
            return this.currentMonster;
	
	}
	/********************************************************************/
	public boolean nextTurn(){
            boolean stateOK=false;
            if(currentPlayer == null)
                stateOK = true;
            else if(currentPlayer != null)
                stateOK = this.nextTurnAllowed();
            
            if(stateOK){
                currentMonster = dealer.nextMonster();
                currentPlayer = this.nextPlayer();
                if(currentPlayer.isDead()){
                    currentPlayer.initTreasures();
                }
            }
            return stateOK;
	
	}
	/********************************************************************/
	public  boolean endOfGame( CombatResult result){
            return (result == CombatResult.WinAndWinGame);
	}
	/********************************************************************/
	public Cultist getLastCultist(){
            return lastCard;
        }
}