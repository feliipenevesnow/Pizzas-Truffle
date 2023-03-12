package br.ifsp.edu.pep.view.component;

import br.ifsp.edu.pep.view.main.Main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

public class Header extends javax.swing.JPanel {

    private Color cleanTextColor = new Color(153, 153, 153);
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public Header() {
        initComponents();
        setOpaque(false);
        clear.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        clear = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/search.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/menu.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        search.setForeground(new java.awt.Color(153, 153, 153));
        search.setText("Pesquise aqui ...");
        search.setBorder(null);
        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/x.png"))); // NOI18N
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(search)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        if (search.getText().equals("Pesquise aqui ...")) {
            clear.setVisible(true);
            search.setText("");
            search.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        if (search.getText().equals("")) {
            clear.setVisible(false);
            search.setText("Pesquise aqui ...");
            search.setForeground(cleanTextColor);
        }
    }//GEN-LAST:event_searchFocusLost

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        clear.setVisible(false);
        search.setText("Pesquise aqui ...");
        search.setForeground(cleanTextColor);
        jLabel1.requestFocus();
    }//GEN-LAST:event_clearMouseClicked

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String txt = search.getText();
            if (null != txt.toUpperCase()) {
                switch (txt.toUpperCase()) {
                    case "DASHBOARD":
                        main.search(0);
                        break;
                    case "VENDA":
                        main.search(1);
                        break;
                    case "COMPRA":
                        main.search(2);
                        break;
                    case "CAIXA":
                        main.search(3);
                        break;
                    case "RELATÓRIOS":
                    case "RELATORIOS":
                    case "RELATORIO":
                    case "RELATÓRIO":
                        main.search(4);
                        break;
                    case "FORNECEDOR":
                        main.search(6);
                        break;
                    case "CLIENTE":
                        main.search(7);
                        break;
                    case "PIZZA":
                        main.search(9);
                        break;
                    case "BEBIDA":
                        main.search(10);
                        break;
                    case "ENTREGADOR":
                        main.search(11);
                        break;
                    case "USUÁRIOS":
                    case "USUARIOS":
                        main.search(12);
                        break;
                    case "PERFIL":
                        main.search(14);
                        break;
                    case "RELATORIO DE COMPRA":
                    case "RELATORIO COMPRA":
                    case "RELATÓRIO DE COMPRA":
                    case "RELATÓRIO COMPRA":
                        main.search(16);
                        break;
                    case "RELATORIO DE ENTREGA":
                    case "RELATORIO ENTREGA":
                    case "RELATÓRIO DE entrega":
                    case "RELATÓRIO ENTREGA":
                        main.search(17);
                        break;
                    case "RELATORIO DE VENDA":
                    case "RELATORIO VENDA":
                    case "RELATÓRIO DE VENDA":
                    case "RELATÓRIO VENDA":
                        main.search(18);
                        break;
                    case "RELATORIO DE CAIXA":
                    case "RELATORIO CAIXA":
                    case "RELATÓRIO DE CAIXA":
                    case "RELATÓRIO CAIXA":
                        main.search(19);
                        break;
                    case "INGREDIENTE":
                        main.search(15);
                        break;
                    default:
                        main.setNotFoundForm(search.getText());
                        main.search(15);
                        break;
                }
            }
            clear.setVisible(false);
            search.setText("Pesquise aqui ...");
            search.setForeground(cleanTextColor);
            jLabel1.requestFocus();
        }
    }//GEN-LAST:event_searchKeyPressed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
