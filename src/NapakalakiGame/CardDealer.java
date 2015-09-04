package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
	Clase CardDealer
	
*/
/*
@author Jesus Sanchez de Castro
@author Diego Jose Granados Álvarez
*/

class CardDealer{
	
	/****************************************************************/
	//Clase con singleton
	private static final CardDealer instance = new CardDealer();

	private CardDealer(){}
	/****************************************************************/
	//Mazos
        
        ArrayList<Monster> unusedMonsters = new ArrayList();
        ArrayList<Monster> usedMonsters = new ArrayList();
        ArrayList<Treasure> unusedTreasures = new ArrayList();
        ArrayList<Treasure> usedTreasures = new ArrayList();
        
        /************************************************************************/
        /*
        Se ha añadido una asociación de CardDealer a Cultist, con rol
        unusedCultist. Se han añadido además los métodos nextCultist(), de
        visibilidad pública, y shuffleCultists() e initCultistCardDeck(), privado.
        */
        ArrayList<Cultist> unusedCultist = new ArrayList();
        ArrayList<Cultist> usedCultist = new ArrayList();

        //Comportamiento copiado de nextMonster por ejemplo
        public Cultist nextCultist(){
         
            //Mazo de cartas vacio -> coger mazo de cartas usadas y barajar
            if(unusedTreasures.isEmpty()){
                ArrayList<Cultist> array_aux = new ArrayList<Cultist>(usedCultist);
                unusedCultist = array_aux;                
                usedCultist.clear();
                shuffleCultist();
            }
           
            //Coger el primer cultist y eliminarlo del mazo
            Cultist next_cultist = unusedCultist.get(0);
            usedCultist.add(next_cultist);
            unusedCultist.remove(0);
            return next_cultist;
        }
        
        //Copiado de shuffleTreasures
        private void shuffleCultist(){
            Collections.shuffle(unusedCultist);
        }
        
        /************************************************************************/
        private void initCultistCardDeck(){
            /*
            Implementa el método initCultistCardDeck de la clase CardDealer para que se
            añadan al mazo de sectarios las 6 cartas de sectarios que aparecen en el
            documento cartasSectarios.pdf.
            */
            
            //Cultist1
            Cultist aux = new Cultist("Sectario 1: Teemo", 1);
            unusedCultist.add(aux);
            //Cultist2
            aux = new Cultist("Sectario 2: Nerf Irelia", 2);
            unusedCultist.add(aux);
            //Cultist3
            aux = new Cultist("Sectario 3: Nraiker", 1);
            unusedCultist.add(aux);
            //Cultist4
            aux = new Cultist("Sectario 4: Kusafqe", 2);
            unusedCultist.add(aux);
            //Cultist5
            aux = new Cultist("Sectario 5: Jorge Manrique", 1);
            unusedCultist.add(aux);
            //Cultist6
            aux = new Cultist("Sectario 6: Ty DFG", 1);
            unusedCultist.add(aux);


        }
        
        /************************************************************************/
	private void shuffleTreasures(){
            Collections.shuffle(unusedTreasures);
	}
        /************************************************************************/
	private void shuffleMonsters(){
            Collections.shuffle(unusedMonsters);
	}
        /*********************************************************************/
	public static CardDealer getInstance(){
            return instance;
	}
        /************************************************************************/
	//M�todos 
	/************************************************************************/
	private  void initTreasureCardDeck(){
		
            //Tesoro
            Treasure treasure;

            //Si mi amo
            treasure=new Treasure("Si mi amo!",0,4,7,TreasureKind.helmet);
            unusedTreasures.add(treasure);
            //Botas de investigacion
            treasure=new Treasure("Botas de investigacion", 600, 3, 4, TreasureKind.shoe);
            unusedTreasures.add(treasure);
            //Capucha de Cthulhu
            treasure=new Treasure("Capucha de Cthulhu", 500, 3, 5, TreasureKind.helmet);
            unusedTreasures.add(treasure);
            //A prueba de babas
            treasure=new Treasure("A prueba de babas", 400, 2, 5, TreasureKind.armor);
            unusedTreasures.add(treasure);
            //Botas de lluvia acida
            treasure=new Treasure("Botas de lluvia acida", 800, 1, 1, TreasureKind.bothHand);
            unusedTreasures.add(treasure);
            //Casco minero
            treasure=new Treasure("Casco minero", 400, 2, 4, TreasureKind.helmet);
            unusedTreasures.add(treasure);
            //Ametralladora Thompson
            treasure=new Treasure("Ametralladora Thompson", 600, 4, 8, TreasureKind.bothHand);
            unusedTreasures.add(treasure);
            //Camiseta de la UGR
            treasure=new Treasure("Camiseta de la UGR", 100, 1, 7, TreasureKind.armor);
            unusedTreasures.add(treasure);
            //Clavo de rail ferroviario
            treasure=new Treasure("Clavo de rail ferroviario", 400, 3, 6, TreasureKind.oneHand);
            unusedTreasures.add(treasure);
            //Cuchillo de sushi arcano
            treasure=new Treasure("Cuchillo de sushi arcano", 300, 2, 3, TreasureKind.oneHand);
            unusedTreasures.add(treasure);
            //Fez alopodo
            treasure=new Treasure("Fez alopodo", 700, 3, 5, TreasureKind.helmet);
            unusedTreasures.add(treasure);
            //Hacha prehistorica
            treasure=new Treasure("Hacha prehistorica", 500, 1, 5, TreasureKind.oneHand);
            unusedTreasures.add(treasure);
            //El aparato del Prof. Tesla
            treasure=new Treasure("El aparato del Prof. Tesla", 900, 4, 8, TreasureKind.oneHand);
            unusedTreasures.add(treasure);
            //Gaita
            treasure=new Treasure("Gaita", 500, 4, 5, TreasureKind.bothHand);
            unusedTreasures.add(treasure);
            //Insecticida
            treasure=new Treasure("Insecticida", 300, 2, 3, TreasureKind.oneHand);
            unusedTreasures.add(treasure);
            //Escopeta de 3 cañones
            treasure=new Treasure("Escopeta de 3 cañones", 700, 4, 6, TreasureKind.bothHand);
            unusedTreasures.add(treasure);
            //Garabato místico
            treasure=new Treasure("Garabato mistico", 300, 2, 2, TreasureKind.oneHand);
            unusedTreasures.add(treasure);
            //La fuerza de Mr. T
            treasure=new Treasure("La fuerza de Mr. T", 1000, 0, 0, TreasureKind.necklace);
            unusedTreasures.add(treasure);
            //La rebeca metalica
            treasure=new Treasure("La rebeca metalica", 400, 2, 3, TreasureKind.armor);
            unusedTreasures.add(treasure);
            //Mazo de los antiguos
            treasure=new Treasure("Mazo de los antiguos" , 200, 3, 4, TreasureKind.oneHand);
            unusedTreasures.add(treasure);
            //Necro-playboycon
            treasure=new Treasure("Necro-playboycon", 300, 3, 5, TreasureKind.oneHand);
            unusedTreasures.add(treasure);
            //Lanzallamas
            treasure=new Treasure("Lanzallamas", 800, 4, 8, TreasureKind.bothHand);
            unusedTreasures.add(treasure);
            //Necro-comicon
            treasure=new Treasure("Necro-comicon", 100, 1, 1, TreasureKind.oneHand);
            unusedTreasures.add(treasure);
            //Necronomicon
            treasure=new Treasure("Necronomicon", 800, 5, 7, TreasureKind.bothHand);
            unusedTreasures.add(treasure);
            //Linterna a 2 manos
            treasure=new Treasure("Linterna a 2  manos", 400, 3, 6, TreasureKind.bothHand);
            unusedTreasures.add(treasure);
            //Necro-gnomicon
            treasure=new Treasure("Necro-gnomicon", 200, 2, 4, TreasureKind.oneHand);
            unusedTreasures.add(treasure);
            //Necrotelecom
            treasure=new Treasure("Necrotelecom", 300, 2, 3, TreasureKind.helmet);
            unusedTreasures.add(treasure);
            //Porra preternatural
            treasure=new Treasure("Porra preternatural", 200, 2, 3, TreasureKind.oneHand);
            unusedTreasures.add(treasure);
            //Tentaculo de pega
            treasure=new Treasure("Tentaculo de pega", 200, 0, 1, TreasureKind.helmet);
            unusedTreasures.add(treasure);
            //Zapato dja-amigos
            treasure=new Treasure("Zapato deja-amigos", 500, 0, 1, TreasureKind.shoe);
            unusedTreasures.add(treasure);
            //Shogulador
            treasure=new Treasure("Shogulador", 600, 1, 1, TreasureKind.bothHand);
            unusedTreasures.add(treasure);
            //Varita de atizamiento
            treasure=new Treasure("Varita de atizamiento", 400, 3, 4, TreasureKind.oneHand);
            unusedTreasures.add(treasure);

            this.shuffleTreasures();
	}
	/************************************************************************/
	//Modificado para meter 6 monstruos más para la parte de cultists
	private void initMonsterCardDeck(){
            
            BadConsequence badConsequences;
            Prize prizes;
            Monster monster;
            
            //1.Byakhees de bonanza
            badConsequences = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, 
                    new ArrayList(Arrays.asList(TreasureKind.armor)), 
                    new ArrayList(Arrays.asList(TreasureKind.armor)));
            prizes = new Prize(2, 1);
            monster = new Monster("3 Byakhees de bonanza", 8, badConsequences, prizes,0);
            unusedMonsters.add(monster);

            //2. Chibithulhu
            badConsequences = new BadConsequence("Embobados con el lindo primigenio te descartas "
                    + "de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.helmet)), null);
            prizes = new Prize(1,1);
            monster = new Monster("Chibithulhu", 2, badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //3.El sopor de Dunwich
            badConsequences = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible",
                    0,new ArrayList(Arrays.asList(TreasureKind.shoe)),null);
            prizes = new Prize(1,1);
            monster = new Monster("El sopor de Dunwich", 2, badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //4.�ngeles de la noche ibicenca
            badConsequences = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer "
                    + "en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,
                    new  ArrayList(Arrays.asList(TreasureKind.oneHand)),
                    new  ArrayList(Arrays.asList(TreasureKind.oneHand)));
            prizes = new Prize(4,1);
            monster = new Monster("Angeles de la noche ibicenca", 14,badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //5. El gorr�n en el umbral
            badConsequences = new BadConsequence("Pierdes todos tus tesoros visibles",0,10,0);
            prizes = new Prize(3,1);
            monster = new Monster("El gorr�n en el umbral", 10, badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //6. H.P.Munchcraft
            badConsequences = new BadConsequence("Pierdes la armadura visible", 0, 
                    new ArrayList(Arrays.asList(TreasureKind.armor)),null);
            prizes = new Prize(2,1);
            monster = new Monster("H.P.Munchcraft", 6, badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //7. Bichgooth
            badConsequences = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible",0,
                    new ArrayList(Arrays.asList(TreasureKind.armor)),null);
            prizes = new Prize(1,1);
            monster = new Monster("Bichgooth", 2, badConsequences, prizes,0);
            unusedMonsters.add(monster);

            //8. El rey de rosa
            badConsequences = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 
                    5, 3, 0);
            prizes = new Prize(4,2);
            monster = new Monster("El rey de rosa", 13, badConsequences, prizes,0);
            unusedMonsters.add(monster);

            //9. La que redacta en las tinieblas
            badConsequences = new BadConsequence("Toses los pulmones y pierdes 2 niveles",
                    2,0,0);
            prizes = new Prize(1,1);
            monster = new Monster("La que redacta en las tinieblas", 2, badConsequences, prizes,0);
            unusedMonsters.add(monster);

            //Los hondos 10
            badConsequences = new BadConsequence("Estos monstruos resultan"
                + "bastante superficiales y te aburren mortalmente, estas muerto",true);
            prizes = new Prize(2,1); //2 tesoros 1 nivel

            monster = new Monster("Los hondos", 8, badConsequences, prizes,0);
            unusedMonsters.add(monster);

            //Semillas Cthulhu 11
            badConsequences = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos"
                    ,2,0,2);
            prizes = new Prize(2,1);
            monster = new Monster("Semillas Cthulhu",4,badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //Dameargo 12
            badConsequences = new BadConsequence("Te intenta saquear, pierdes una mano visible"
                    ,0,new ArrayList(Arrays.asList(TreasureKind.oneHand)),null);
            prizes = new Prize(2,1);
            monster = new Monster("Dameargo",1,badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //Pollipolipo Volante 13
            badConsequences = new BadConsequence("Da mucho asquito, pierdes 3 niveles"
                    ,3,0,0);
            prizes = new Prize(1,1);
            monster = new Monster("Pollipolipo",3,badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //YskhtihyssgGoth 14
            badConsequences = new BadConsequence("No le hace gracia que pronuncien mal su nombre, estas muerto"
                    ,true);
            prizes = new Prize(3,1);
            monster = new Monster("YskhtihyssgGoth",12,badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //Familia feliz 15
            badConsequences = new BadConsequence("La familia te atrapa estas muerto"
                    ,true);
            prizes = new Prize(4,1);
            monster = new Monster("Familia Feliz",1,badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //Roboggoth 16
            badConsequences = new BadConsequence("La quinta directiva primaria te obliga "
                    + "a perder 2 niveles y un tesoro de a 2 manos visible"
                    ,2,new ArrayList(Arrays.asList(TreasureKind.bothHand)),null);
            prizes = new Prize(2,1);
            monster = new Monster("Roboggoth",8,badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //El espia 17
            badConsequences = new BadConsequence("Te asusta en la noche, pierdes un casco visible"
                    ,0,new ArrayList(Arrays.asList(TreasureKind.helmet)),null);
            prizes = new Prize(1,1);
            monster = new Monster("El espia",5,badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //El lenguas 18
            badConsequences = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles "
                    + "y 5 tesoros visibles"
                    ,2,5,0);
            prizes = new Prize(1,1);
            monster = new Monster("El lenguas",20,badConsequences,prizes,0);
            unusedMonsters.add(monster);

            //Bicefalo 19
            badConsequences = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles"
                    + " y tus tesoros visibles de las manos"
                    ,3,new ArrayList(Arrays.asList(TreasureKind.bothHand)),null);
            prizes = new Prize(1,1);
            monster = new Monster("Bicefalo",20,badConsequences,prizes,0);
            unusedMonsters.add(monster);
            
            //Último parámetro pasado al constructor de monster es el cambio de nivel
            //contra sectarios
            //DLC 
            
            //Cultists - El mal indecible impronunciable
            badConsequences = new BadConsequence("Pierdes una mano visible"
                    ,0,new ArrayList(Arrays.asList(TreasureKind.oneHand)),null);
            prizes = new Prize(3,1);
            monster = new Monster("El mal indecible impronunciable",10 ,badConsequences,prizes,-2);
            unusedMonsters.add(monster);
            
            //Cultist - Testigos Oculares
            badConsequences = new BadConsequence("Pierdes tus tesoros visibles, jajaja nuub"
                    ,0,null,new ArrayList(Arrays.asList(TreasureKind.oneHand)));
            prizes = new Prize(2,1);
            monster = new Monster("Testigos Oculares",6 ,badConsequences,prizes,2);
            unusedMonsters.add(monster);
            
            //Cultist - El gran cthulhu
            //Tipo muerte
            badConsequences = new BadConsequence("Hoy no es tu día de suerte, mueres :("
                    ,true);
            prizes = new Prize(2,5);
            monster = new Monster("El gran cthulhu",20,badConsequences,prizes,4);
            unusedMonsters.add(monster);
            
            //Cultist - Serpiente Político
           
            badConsequences = new BadConsequence("El PP te recorta 2 niveles :("
                    ,2,0,0);
            prizes = new Prize(2,1);
            monster = new Monster("Serpiente del PP",8,badConsequences,prizes,-2);
            unusedMonsters.add(monster);
            
            //Cultist - Felpuggoth
            //Se pierde casco y armadura visible
            ArrayList<TreasureKind> aux = new ArrayList();
            aux.add(TreasureKind.helmet);
            aux.add(TreasureKind.armor);
            //Se pierden manos ocultas
            ArrayList<TreasureKind> aux1 = new ArrayList();
            aux.add(TreasureKind.bothHand);
            aux.add(TreasureKind.oneHand);
            
            badConsequences = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas"
                    ,0,aux,aux1);
            prizes = new Prize(1,1);
            monster = new Monster("Felpuggoth",2,badConsequences,prizes,5);
            unusedMonsters.add(monster);
            
            //Cultist - Shoggoth
            badConsequences = new BadConsequence("Noveah que coza mah feah, pierdes 2 niveles"
                    ,2,0,0);
            prizes = new Prize(4,2);
            monster = new Monster("Shoggoth",16,badConsequences,prizes,-4);
            unusedMonsters.add(monster);
            
            //Cultist - Lolitagooth
            badConsequences = new BadConsequence("Pintalabios negros. Pierdes dos niveles",2,0,0);
            prizes = new Prize(1,1);
            monster = new Monster("Lolitagooth",2,badConsequences,prizes,3);
            unusedMonsters.add(monster);
            
            
        this.shuffleMonsters();
	}
	
        
        /*********************************************************************/
	//3.1
	public Treasure nextTreasure(){
            //Mazo de cartas vacio -> coger mazo de cartas usadas y barajar
            if(unusedTreasures.isEmpty()){
                ArrayList<Treasure> array_aux = new ArrayList<Treasure>(usedTreasures);
                unusedTreasures = array_aux;                
                usedTreasures.clear();
                shuffleTreasures();
            }
            
            //Coger el primer monstruo y eliminarlo del mazo
            Treasure next_treasure = unusedTreasures.get(0);
            usedTreasures.add(next_treasure);
            unusedTreasures.remove(0);
            return next_treasure;
	
	}
	/*********************************************************************/
        //3.1 
	public Monster nextMonster(){
            //Mazo de cartas vacio -> coger mazo de cartas usadas y barajar
            if(unusedMonsters.isEmpty()){
                //ArrayList<Monster> array_aux = new ArrayList<Monster>(usedMonsters);
                //unusedMonsters = array_aux;
                unusedMonsters = new ArrayList(usedMonsters);
                usedMonsters.clear();
                shuffleMonsters();
            }
            
            //Coger el primer monstruo y eliminarlo del mazo
            Monster next_monster = unusedMonsters.get(0);
            usedMonsters.add(next_monster);
            unusedMonsters.remove(next_monster);
            return next_monster;
	
	}
	/*********************************************************************/
	public void giveTreasureBack(Treasure t){
            this.usedTreasures.add(t);
	}
	/*********************************************************************/
	public void giveMonsterBack(Monster m){
            this.usedMonsters.add(m);
	}
	/*********************************************************************/
	public void initCards(){
            
            //Añadidos init y shuffle cultist
            this.initMonsterCardDeck();
            this.initTreasureCardDeck();
            this.initCultistCardDeck();
            this.shuffleMonsters();
            this.shuffleTreasures();
            this.shuffleCultist();
            
	}
        /*********************************************************************/
}