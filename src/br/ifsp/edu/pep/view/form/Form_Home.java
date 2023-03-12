package br.ifsp.edu.pep.view.form;

import br.ifsp.edu.pep.dao.CaixaDAO;
import br.ifsp.edu.pep.dao.CompraDAO;
import br.ifsp.edu.pep.dao.DespesaDAO;
import br.ifsp.edu.pep.dao.MovimentacaoDAO;
import br.ifsp.edu.pep.dao.PagamentoEntregadorDAO;
import br.ifsp.edu.pep.dao.VendaDAO;
import br.ifsp.edu.pep.model.Venda;
import br.ifsp.edu.pep.view.jdialog.ConfirmDelivery;
import br.ifsp.edu.pep.view.jdialog.Notification;
import br.ifsp.edu.pep.view.jdialog.VendasOnline;
import br.ifsp.edu.pep.view.model.Model_Card;
import br.ifsp.edu.pep.view.model.StatusType;
import br.ifsp.edu.pep.view.swing.ScrollBar;
import br.ifsp.edu.pep.view.util.ThreadImage;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public final class Form_Home extends javax.swing.JPanel {

    private VendaDAO controlSale = new VendaDAO();
    private List<Venda> sales = new ArrayList<>();
    private PagamentoEntregadorDAO controlPayment = new PagamentoEntregadorDAO();
    private DespesaDAO controlExpense = new DespesaDAO();
    private CompraDAO controlBuy = new CompraDAO();
    private MovimentacaoDAO controlMovement = new MovimentacaoDAO();
    private Timer time = new Timer(1000, new updateOnline());
    private int qtdOnline = 0;

    private double sell = 0, buy = 0, expense = 0, profit = 0;

    public Form_Home() {
        initComponents();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/stock.png")), "Entradas", "R$0", format.format(new Date())));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/profit.png")), "Saidas", "R$0", format.format(new Date())));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/flag.png")), "Lucro", "R$0", format.format(new Date())));

        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        time.start();

        updateCards();
        updateTable();
    }

    public void updateCards() {
        double sell = 0, buy = 0, expense = 0, bloodletting = 0, supplementation = 0, paymentDelivery = 0;
        if (CaixaDAO.caixa != null) {
            Date date = CaixaDAO.caixa.getDataAbertura();

            sell = this.controlSale.sumSellByDate(date);
            paymentDelivery = this.controlPayment.sumPaymentDelivery(date);
            buy = this.controlBuy.sumBuyByDate(date);
            expense = this.controlExpense.sumExpenseByDate(date);
            bloodletting = this.controlMovement.sumBloodletting(date);
            supplementation = this.controlMovement.sumSupplementation(date);

            card1.setValues(sell + supplementation);
            card2.setValues(buy + expense + bloodletting + paymentDelivery);
            card3.setValues((sell + supplementation) - (buy + expense + bloodletting + paymentDelivery));
        }
    }

    public Date addMinutesToJavaUtilDate(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    public void updateTable() {
        int cont = 0;

        this.sales = this.controlSale.findInDelivering();

        DefaultTableModel model = (DefaultTableModel) this.table.getModel();

        model.setNumRows(0);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        for (Venda venda : this.sales) {
            cont++;
            if (venda.getEntrega().getCliente() != null) {
                Object obj[] = {cont, venda.getEntrega().getCliente().getNome(), format.format(addMinutesToJavaUtilDate(venda.getData(), 80)), venda.getEntrega().getEntregador().getNome(), StatusType.ENTREGANDO};
                model.addRow(obj);
            } else {
                Object obj[] = {cont, "Cliente não cadastrado", format.format(addMinutesToJavaUtilDate(venda.getData(), 80)), venda.getEntrega().getEntregador().getNome(), StatusType.ENTREGANDO};
                model.addRow(obj);
            }

        }

        this.table.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new br.ifsp.edu.pep.view.component.Card();
        card2 = new br.ifsp.edu.pep.view.component.Card();
        card3 = new br.ifsp.edu.pep.view.component.Card();
        panelBorder1 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new br.ifsp.edu.pep.view.swing.Table();
        panelBorder5 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(239, 239, 239));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Entregas em andamento");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Cliente", "Tempo Estimado", "Entregador", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        spTable.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        panelBorder5.setBackground(new java.awt.Color(255, 204, 0));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("0");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 204, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/sino.png"))); // NOI18N
        jLabel2.setText("Pedidos Online");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (this.table.getSelectedRow() != -1) {
            Venda venda = this.sales.get(this.table.getSelectedRow());
            ConfirmDelivery view = new ConfirmDelivery(null, true);
            view.setVenda(venda);
            view.setVisible(true);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if (CaixaDAO.caixa.getDataFechamento() == null) {
            VendasOnline view = new VendasOnline(null, true);
            view.setVisible(true);
        } else {
            Notification notification = new Notification(null, true, "Atenção", "O caixa deve estar aberto.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if (CaixaDAO.caixa.getDataFechamento() == null) {
            VendasOnline view = new VendasOnline(null, true);
            view.setVisible(true);
        } else {
            Notification notification = new Notification(null, true, "Atenção", "O caixa deve estar aberto.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.ifsp.edu.pep.view.component.Card card1;
    private br.ifsp.edu.pep.view.component.Card card2;
    private br.ifsp.edu.pep.view.component.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane panel;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder1;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder5;
    private javax.swing.JScrollPane spTable;
    private br.ifsp.edu.pep.view.swing.Table table;
    // End of variables declaration//GEN-END:variables

    public class updateOnline implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (controlSale.findOnline().size() > 0) {
                jLabel3.setText(String.valueOf(controlSale.findOnline().size()));
                if (qtdOnline != controlSale.findOnline().size()) {
                    if (qtdOnline > controlSale.findOnline().size()) {
                        try {
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/br/ifsp/edu/pep/view/util/sound/toque.wav").getAbsoluteFile());
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            clip.start();

                            ImageIcon img = new ImageIcon(getClass().getResource("../icon/sino.gif"));
                            jLabel2.setIcon(img);

                            ThreadImage th = new ThreadImage();
                            th.setLabel(jLabel2);

                            Thread t = new Thread(th);
                            t.start();

                        } catch (Exception ex) {
                            System.out.println("Erro ao executar SOM!");
                            ex.printStackTrace();
                        }
                    }
                }
                qtdOnline = controlSale.findOnline().size();
            }

        }

    }
}
