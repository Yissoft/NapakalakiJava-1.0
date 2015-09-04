package GUI;

import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Cultist;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Diego & Jesus
 */

public class PlayerView extends javax.swing.JPanel {

    //Valor por defecto
    int contador_turnos = 1;
    public String playerantiguo;
    boolean primert=true;

    public ArrayList <Cultist> cultist = new ArrayList();
    private Player playerModel;
    private Player nextGUIPlayer;
    private Napakalaki napakalakiModel;
  
    
    public void setPlayer(Player p, Player siguiente) {
     
        //Antes de hacer el código de las imágenes necesitamos sabes el currentP
        playerModel = p;
        
    
        //CODIGO PARA LAS IMÁGENES DE JUGADOR
        if(contador_turnos%3 == 1){
            if(primert){
                //TURNO 1 ponemos imagen 1 y aumentamos contador,
                //Se inicializa playerantiguo para siguientes turnos
                playerantiguo=p.getName();
                LabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.jpg")));
                contador_turnos++;
                primert=false;
            }
            else if(!primert){
            //Si no es primer turno
            //Como se hacen varios setPlayer durante la partida hay que vigilar
            //que los turnos pasen cuando cambie el nombre de jugador.
                if(!playerantiguo.equals(p.getName())){
                LabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.jpg")));
                contador_turnos++;
                //Primert boolean se queda a false.
                }
            }
        }
        else if(contador_turnos%3 == 2){
            //Turno 2 (el nombre del ultimo player ya está guardado)
            if(!p.getName().equals(playerantiguo)){
                
                //Si el nombre del jugador actual es diferente al del turno pasado
                //osea, el playerantiguo, estamos en otro turno y aumentamos el contador
                //de turnos, el nuevo nombre antiguo y metemos la foto del player 2
                contador_turnos++;
                playerantiguo = p.getName();
                LabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2.jpg")));
            }
        }
        //Si estamos en player 3 que módulo 3 es 0.
        else if(contador_turnos%3 == 0){
       
            if(!p.getName().equals(playerantiguo)){
                contador_turnos++;
                playerantiguo = p.getName();
                LabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/3.jpg")));
            }
        }
        
        //FIN CODIGO PARA LAS IMÁGENES DE JUGADOR
        
        nextGUIPlayer = siguiente;
        if(playerModel instanceof CultistPlayer){
            cultistView2.setCultist(p);
        }
        LabelSigJugador.setText(nextGUIPlayer.getName());
        name.setText(playerModel.getName());
        level.setText(Integer.toString(playerModel.getLevels()));
        isDead.setText(Boolean.toString(playerModel.isDead()));
        combatLevel.setText(Integer.toString(playerModel.getCombatLevel()));
        if(playerModel.GetPendingBadConsequence() != null)
            badConsequenceView2.setBC(playerModel.GetPendingBadConsequence());
       
        fillTreasurePanel(visibleTreaures, playerModel.getVisibleTreasures());
        fillTreasurePanel(hiddenTreasures, playerModel.getHiddenTreasures());
        repaint();
        revalidate();
    }

    public void fillTreasurePanel(JPanel aPanel, ArrayList<Treasure> aList) {
        aPanel.removeAll();
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure(t);
            aTreasureView.setVisible(true);
            aPanel.add(aTreasureView);
        }
        aPanel.repaint();
        aPanel.revalidate();
    }
    
    public void setNapakalaki(Napakalaki n){
        napakalakiModel = n;
    }
    
    public ArrayList<Treasure> getSelectedTreasures(JPanel aPanel){
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for(Component c : aPanel.getComponents()){
            tv = (TreasureView) c;
            if(tv.isSelected())
                output.add(tv.getTreasure());
        }
        return output;
    }
    
    //Metodos que activa o desactiva todos los botones de esta vista
    public void setMakeVisibleButton(boolean enable){
        makeVisible.setEnabled(enable);
    }
    
    public void setDiscardButton(boolean enable){
        discardTreasures.setEnabled(enable);
    }
    
    public void setBuyLevelsButton(boolean enable){
        buyLevels.setEnabled(enable);
    }

    public PlayerView() {
        initComponents();
    }
  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        isDead = new javax.swing.JLabel();
        visibleTreaures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        buyLevels = new javax.swing.JToggleButton();
        makeVisible = new javax.swing.JToggleButton();
        discardTreasures = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        combatLevel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LabelIcono = new javax.swing.JLabel();
        LabelSigJugador = new javax.swing.JLabel();
        TextoSigJugador = new javax.swing.JLabel();
        badConsequenceView2 = new GUI.BadConsequenceView();
        jLabel4 = new javax.swing.JLabel();
        cultistView2 = new GUI.CultistView();

        name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        name.setText("Nombre del jugador actual");

        jLabel1.setText("Nivel jugador:");

        level.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        level.setText("n");

        jLabel3.setText("¿Esta muerto?");

        visibleTreaures.setBorder(javax.swing.BorderFactory.createTitledBorder("Tesoros Visibles"));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createTitledBorder("Tesoros ocultos"));

        buyLevels.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buyLevels.setText("Comprar niveles");
        buyLevels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyLevelsActionPerformed(evt);
            }
        });

        makeVisible.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        makeVisible.setText("Equipar Tesoro");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        discardTreasures.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discardTreasures.setText("Descartar Tesoro");
        discardTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardTreasuresActionPerformed(evt);
            }
        });

        jLabel2.setText("Nivel de combate:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Personaje"));

        LabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.jpg"))); // NOI18N
        LabelIcono.setText("Imagen");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelIcono)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LabelSigJugador.setText("no name");

        TextoSigJugador.setText("Siguiente jugador:");

        jLabel4.setText("Turno de jugador:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(visibleTreaures, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buyLevels, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(makeVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(discardTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(isDead, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combatLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextoSigJugador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelSigJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cultistView2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(badConsequenceView2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(isDead, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(level)
                            .addComponent(jLabel3))
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combatLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TextoSigJugador)
                        .addComponent(LabelSigJugador)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibleTreaures, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(discardTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(buyLevels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(makeVisible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(badConsequenceView2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cultistView2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer(),napakalakiModel.getNextGUI());
        repaint();
    }//GEN-LAST:event_makeVisibleActionPerformed

    private void discardTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardTreasuresActionPerformed
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreaures);
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.discardVisibleTreasures(selVisible);
        napakalakiModel.discardHiddenTreasures(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer(),napakalakiModel.getNextGUI());
        repaint();
    }//GEN-LAST:event_discardTreasuresActionPerformed

    private void buyLevelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyLevelsActionPerformed
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreaures);
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.buyLevels(selVisible, selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer(),napakalakiModel.getNextGUI());
        repaint();
    }//GEN-LAST:event_buyLevelsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelIcono;
    private javax.swing.JLabel LabelSigJugador;
    private javax.swing.JLabel TextoSigJugador;
    private GUI.BadConsequenceView badConsequenceView2;
    private javax.swing.JToggleButton buyLevels;
    private javax.swing.JLabel combatLevel;
    private GUI.CultistView cultistView2;
    private javax.swing.JToggleButton discardTreasures;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel isDead;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel level;
    private javax.swing.JToggleButton makeVisible;
    private javax.swing.JLabel name;
    private javax.swing.JPanel visibleTreaures;
    // End of variables declaration//GEN-END:variables
}
