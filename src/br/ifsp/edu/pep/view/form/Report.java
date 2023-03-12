package br.ifsp.edu.pep.view.form;

import br.ifsp.edu.pep.dao.UsuarioDAO;
import br.ifsp.edu.pep.view.jdialog.Notification;
import br.ifsp.edu.pep.view.main.Main;
import br.ifsp.edu.pep.view.model.Model_Card;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

public class Report extends javax.swing.JPanel {

    private Main main;

    public Report() {
        initComponents();
        init();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    private void init() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        entrega.setData(new Model_Card(new ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/10.png")), "Relatório de", "Entregas", format.format(new Date())));
        compra.setData(new Model_Card(new ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/3.png")), "Relatório de", "Compras", format.format(new Date())));
        venda.setData(new Model_Card(new ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/2.png")), "Relatório de", "Vendas", format.format(new Date())));
        caixa.setData(new Model_Card(new ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/4.png")), "Relatório de", "Caixa", format.format(new Date())));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card3 = new br.ifsp.edu.pep.view.component.Card();
        entrega = new br.ifsp.edu.pep.view.component.Card();
        compra = new br.ifsp.edu.pep.view.component.Card();
        venda = new br.ifsp.edu.pep.view.component.Card();
        caixa = new br.ifsp.edu.pep.view.component.Card();

        card3.setColor2(new java.awt.Color(102, 255, 255));

        setBackground(new java.awt.Color(239, 239, 239));

        entrega.setColor1(new java.awt.Color(241, 208, 62));
        entrega.setColor2(new java.awt.Color(211, 184, 61));
        entrega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entregaMouseClicked(evt);
            }
        });

        compra.setColor1(new java.awt.Color(186, 123, 247));
        compra.setColor2(new java.awt.Color(167, 94, 236));
        compra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compraMouseClicked(evt);
            }
        });

        venda.setColor1(new java.awt.Color(142, 142, 250));
        venda.setColor2(new java.awt.Color(123, 123, 245));
        venda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vendaMouseClicked(evt);
            }
        });

        caixa.setColor1(new java.awt.Color(0, 182, 182));
        caixa.setColor2(new java.awt.Color(103, 185, 185));
        caixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caixaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(compra, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(caixa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(venda, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(caixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void compraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compraMouseClicked
        main.search(18);
    }//GEN-LAST:event_compraMouseClicked

    private void entregaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entregaMouseClicked
        if (UsuarioDAO.user.getCargo().equals("Gerente")) {
            main.search(19);
        } else {
            Notification notification = new Notification(null, true, "Atenção", "Você  não tem permissão para acessar.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_entregaMouseClicked

    private void vendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vendaMouseClicked
        if (UsuarioDAO.user.getCargo().equals("Gerente")) {
            main.search(20);
        } else {
            Notification notification = new Notification(null, true, "Atenção", "Você  não tem permissão para acessar.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_vendaMouseClicked

    private void caixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caixaMouseClicked
        if (UsuarioDAO.user.getCargo().equals("Gerente")) {
            main.search(21);
        } else {
            Notification notification = new Notification(null, true, "Atenção", "Você  não tem permissão para acessar.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_caixaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.ifsp.edu.pep.view.component.Card caixa;
    private br.ifsp.edu.pep.view.component.Card card3;
    private br.ifsp.edu.pep.view.component.Card compra;
    private br.ifsp.edu.pep.view.component.Card entrega;
    private br.ifsp.edu.pep.view.component.Card venda;
    // End of variables declaration//GEN-END:variables
}
