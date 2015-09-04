/*
 Clase BadConsequence que contiene los malos rollos que aplican los
 monstruos al derrotar al jugador.
 */
package NapakalakiGame;

import static java.sql.DriverManager.println;
import java.util.ArrayList;

/**
 * @author Jes�s S�nchez de Castro
 * @author Diego Jos� Granados �lvarez
 */
public class BadConsequence {

    //Atributos privados
    private String text;//Mal rollo
    private int levels;//Niveles que se pierden
    private int nVisibleTreasures; //Tesoros visibles que se pierden
    private int nHiddenTreasures; //Tesoros ocultos perdidos
    private boolean death; //Mal rollo de tipo muerte
    //Para ver si es con o sin death.
    //public boolean thereisdeath;

    //Atributos de TreasureKind
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();

    //Constructor con arrays 4 argumentos
    BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden) {
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
        //this.thereisdeath=false;
    }

    /**
     * *********************************************************************
     */

    //Constructores de visibilidad p�blica
    //4 argumentos
    public BadConsequence(String text, int levels, int nVisible, int nHidden) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        //this.specificVisibleTreasures = null;
        //this.specificHiddenTreasures = null;
        //this.thereisdeath=false;
    }

    /**
     * *********************************************************************
     */
    //2 argumentos
    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
        //this.specificVisibleTreasures = null;
        //this.specificHiddenTreasures = null;
        this.nHiddenTreasures = 0;
        this.nVisibleTreasures = 0;
        //this.thereisdeath=true;
    }

    /**
     * *********************************************************************
     */

    //Consultores
    public String getText() {
        return this.text;
    }

    /**
     * *********************************************************************
     */

    public int getLevels() {
        return this.levels;
    }

    /**
     * *********************************************************************
     */
    public int getNVisibleTreasures() {
        return this.nVisibleTreasures;
    }

    /**
     * *********************************************************************
     */
    public int getNHiddenTreasures() {
        return this.nHiddenTreasures;
    }

    /**
     * *********************************************************************
     */
    public boolean getDeath() {
        return this.death;
    }

    /**
     * *********************************************************************
     */
    //Necesarios para el main de prueba
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return this.specificVisibleTreasures;
    }

    /**
     * *********************************************************************
     */
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return this.specificHiddenTreasures;
    }

    /**
     * *********************************************************************
     */
    public boolean isEmpty() {
        return (this.levels == 0
                && this.nVisibleTreasures == 0
                && this.nHiddenTreasures == 0
                && this.specificVisibleTreasures.isEmpty()
                && this.specificHiddenTreasures.isEmpty()
                && !death);
    }

    /**
     * *********************************************************************
     */
    //Sesion 3.1
    //Se llama cada vez que el jugador pierde contra un monster
    public void substractVisibleTreasure(Treasure t) {
        if(nVisibleTreasures == 0){
            TreasureKind type = t.getType();
            if (specificVisibleTreasures.contains(type)) {
                specificVisibleTreasures.remove(t.getType());
            }
        }
        else
            nVisibleTreasures--;

    }

    /**
     * *********************************************************************
     */
    public void substractHiddenTreasure(Treasure t) {
        if(nHiddenTreasures == 0){
            TreasureKind type = t.getType();
            if (specificHiddenTreasures.contains(type)) {
                specificHiddenTreasures.remove(t.getType());
            }
        }
        else
            nHiddenTreasures--;
    }

    /**
     * *********************************************************************
     */
    //Entradas: Tesoros visible y ocultos del jugador
    //Salida: Badconsecuence con los tesoros que el jugador PUEDE deshacerse
    /*public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v,
            ArrayList<Treasure> h) {


        //Para el segundo
        //Visible T and Hidden T
        ArrayList<TreasureKind> Vt = new ArrayList();
        ArrayList<TreasureKind> Ht = new ArrayList();
        

        //BadConsequence a devoler
        BadConsequence aux;
        //CASO 1
        
        if (nHiddenTreasures == 0 && nVisibleTreasures == 0) {
            //Vectores de TreasureKind
            ArrayList<TreasureKind> tkvisible = new ArrayList();
            ArrayList<TreasureKind> tkhidden = new ArrayList();
            //Inicializacion de los vectores
            for(Treasure visible:v){
                tkvisible.add(visible.getType());
            }
            
            for(Treasure hidden:h){
                tkhidden.add(hidden.getType());
            }
            
            for (Treasure visible : v) {
                for (TreasureKind svt : specificVisibleTreasures) {
                    if (visible.getType().equals(svt) && tkvisible.contains(svt)) {
                        Vt.add(svt);
                    }
                }
            }

            for (Treasure hidden : h) {
                for (TreasureKind sht : specificHiddenTreasures) {
                    if (hidden.getType().equals(sht) && tkhidden.contains(sht)) {
                        Ht.add(sht);
                    }
                }
            }

            aux = new BadConsequence("text", 0, Vt, Ht);
        }
        //Si tenemos que quitar n tesoros del tipo que sean
        else {
            //Significa que tenemos que devolver este badC
            aux = new BadConsequence("Pending BadConsequence", 0,
                    nVisibleTreasures, nHiddenTreasures);
        }
        

        return aux;
    }*/
    
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v,
            ArrayList<Treasure> h) {
        
        BadConsequence bs;
        
        if(nVisibleTreasures == 0 && nHiddenTreasures == 0){
        
            ArrayList<TreasureKind> tVisible = new ArrayList();
            ArrayList<TreasureKind> tHidden = new ArrayList(); 

            //Recorremos los tesoros
            //Si el vector fuera nulo significa que no hay que descartar tesoros
            if(specificVisibleTreasures != null){                
                for (Treasure t: v) {
                    //Si no contiene el TreasureKind lo agregamos
                    if (specificVisibleTreasures.contains(t.getType())) {
                        tVisible.add(t.getType());
                    }
                }
            }

            //Recorremos los tesoros
            if(specificHiddenTreasures != null){
                for (Treasure t: h) {
                    //Si no contiene el TreasureKind lo agregamos
                    if (specificHiddenTreasures.contains(t.getType())) {
                        tHidden.add(t.getType());
                    }
                }
            }
            bs = new BadConsequence(this.text, 0, tVisible, tHidden);
        }
        
        else{
            //Nuevos valores
            int newnVisible = nVisibleTreasures;
            int newnHidden = nHiddenTreasures;
            
            if(nVisibleTreasures > v.size())
                newnVisible = v.size();
            if(nHiddenTreasures > h.size())
                newnHidden = h.size();
            
            bs = new BadConsequence(this.text, 0,newnVisible, newnHidden);
            
        }      

        return bs;

    }
    

    /**
     * *********************************************************************
     */
    public boolean myBadConsequenceIsDeath() {
        return this.death;
    }

    /**
     * *********************************************************************
     */
    //M�todo toString ANTIGUO
    /*
     @Override
     public String toString(){
     if(this.thereisdeath){
     return "Bad consequence = " + text +"\n"
     + "\t\t levels = " + levels + "\n"
     + "\t\t visible treasures " + nVisibleTreasures + "\n"
     + "\t\t hidden treasures "+ nHiddenTreasures + "\n"; 
     }
     else {
     return "Bad consequence = " + text + "\n"
     + "\t\tIs dead? = " + death;
     }
     }
     */
    /**
     * *********************************************************************
     */
    @Override
    public String toString() {

        return "\n\t\tText: " + text
                + "\n\t\tLevels: " + Integer.toString(levels)
                + "\n\t\tVTreasures: " + Integer.toString(nVisibleTreasures)
                + "\n\t\tHTreasures: " + Integer.toString(nHiddenTreasures)
                + "\n\t\tDeath: " + Boolean.toString(death)
                + "\n\t\tSpecific Visible Treasures: " + specificVisibleTreasures
                + "\n\t\tSpecific Hidden Treasures: " + specificHiddenTreasures;
    }
    /**
     * *********************************************************************
     */
}
