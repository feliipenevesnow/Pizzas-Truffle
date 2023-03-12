package br.ifsp.edu.pep.view.component;

import br.ifsp.edu.pep.dao.UsuarioDAO;
import br.ifsp.edu.pep.model.Usuario;
import br.ifsp.edu.pep.view.event.EventMenuSelected;
import br.ifsp.edu.pep.view.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void setUser() {
        labelNameUser.setText(UsuarioDAO.user.getNome());
        labelPositionUser.setText(UsuarioDAO.user.getCargo());
    }

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected(event);
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
    }

    public void depoisFecharCaixa() {
        DefaultListModel modelo = new DefaultListModel();

        modelo.addElement(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
        modelo.addElement(new Model_Menu("4", "Caixa", Model_Menu.MenuType.MENU));
        modelo.addElement(new Model_Menu("5", "Relatórios", Model_Menu.MenuType.MENU));
        modelo.addElement(new Model_Menu("14", "Perfil", Model_Menu.MenuType.MENU));

        listMenu1.setModel(modelo);
    }

    public void init() {
        Usuario usuario = UsuarioDAO.user;
        if (!usuario.getCargo().equals("Pizzaiolo")) {
            listMenu1.addItem(new Model_Menu("1", "Dashboard", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("2", "Venda", Model_Menu.MenuType.MENU));
            if (!usuario.getCargo().equals("Atendente")) {
                listMenu1.addItem(new Model_Menu("3", "Compra", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("4", "Caixa", Model_Menu.MenuType.MENU));
                listMenu1.addItem(new Model_Menu("15", "Despesa", Model_Menu.MenuType.MENU));
            }
            listMenu1.addItem(new Model_Menu("5", "Relatórios", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("", "Externo", Model_Menu.MenuType.TITLE));
            if (!usuario.getCargo().equals("Atendente")) {
                listMenu1.addItem(new Model_Menu("6", "Fornecedor", Model_Menu.MenuType.MENU));
            }
            listMenu1.addItem(new Model_Menu("7", "Cliente", Model_Menu.MenuType.MENU));
        }
        listMenu1.addItem(new Model_Menu("", "Interno", Model_Menu.MenuType.TITLE));
        if (!usuario.getCargo().equals("Pizzaiolo")) {
            listMenu1.addItem(new Model_Menu("8", "Pizza", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("9", "Bebida", Model_Menu.MenuType.MENU));
            listMenu1.addItem(new Model_Menu("10", "Entregador", Model_Menu.MenuType.MENU));
            if (!usuario.getCargo().equals("Atendente")) {
                listMenu1.addItem(new Model_Menu("11", "Usuários", Model_Menu.MenuType.MENU));
            }
            listMenu1.addItem(new Model_Menu("12", "Ingredientes", Model_Menu.MenuType.MENU));
        }
        if (!usuario.getCargo().equals("Atendente")) {
            listMenu1.addItem(new Model_Menu("13", "Pizzaiolo", Model_Menu.MenuType.MENU));
        }
        listMenu1.addItem(new Model_Menu("", "Meus Dados", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("14", "Perfil", Model_Menu.MenuType.MENU));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        listMenu1 = new br.ifsp.edu.pep.view.swing.ListMenu<>();
        labelPositionUser = new javax.swing.JLabel();
        labelNameUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        panelMoving.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/logo.png"))); // NOI18N
        jLabel2.setText("Pizza's Truffle");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelPositionUser.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelPositionUser.setForeground(new java.awt.Color(255, 255, 255));
        labelPositionUser.setText("cargo");

        labelNameUser.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelNameUser.setForeground(new java.awt.Color(255, 255, 255));
        labelNameUser.setText("nome");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/icons8-sair-20.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNameUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPositionUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNameUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPositionUser)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //#267871 #136a8a +/-
        //#004e92 #000428 +
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#004e92"), 0, getHeight(), Color.decode("#000428"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs);
    }

    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelNameUser;
    private javax.swing.JLabel labelPositionUser;
    private br.ifsp.edu.pep.view.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
