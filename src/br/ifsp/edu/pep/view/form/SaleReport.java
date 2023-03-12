package br.ifsp.edu.pep.view.form;

import br.ifsp.edu.pep.dao.VendaDAO;
import br.ifsp.edu.pep.model.Cliente;
import br.ifsp.edu.pep.model.Venda;
import br.ifsp.edu.pep.view.jdialog.SelectClient;
import br.ifsp.edu.pep.view.jdialog.SelectPeriod;
import br.ifsp.edu.pep.view.swing.ScrollBar;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class SaleReport extends javax.swing.JPanel {

    private VendaDAO control = new VendaDAO();
    private List<Venda> list = new ArrayList<>();

    private Date first = null;
    private Date secound = null;

    private Cliente client;

    private double value;

    public SaleReport() {
        initComponents();
        initTable();
        list = control.findAll(Venda.class);
        updateTable();
    }

    public void updateTableFromAnotherView() {
        list = control.findAll(Venda.class);
        updateTable();
    }

    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setNumRows(0);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");

        for (Venda obj : list) {
            if (!obj.getStatus().equals("ONLINE")) {
                if (obj.getEntrega().getCliente() != null) {
                    Object ob[] = {obj.getEntrega().getCliente().getNome(), format.format(obj.getData()), "R$ " + obj.getDesconto(), "R$ " + obj.getTotal()};
                    model.addRow(ob);
                } else {
                    Object ob[] = {"Não cadastrado.", format.format(obj.getData()), "R$ " + obj.getDesconto(), "R$ " + obj.getTotal()};
                    model.addRow(ob);
                }
            }
        }
    }

    private void initTable() {
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        txtCliente = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        checkCliente = new javax.swing.JCheckBox();
        panelBorder4 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        checkPreco = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jfPreco = new javax.swing.JFormattedTextField();
        jSeparator8 = new javax.swing.JSeparator();
        comboPreco = new javax.swing.JComboBox<>();
        panelBorder1 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new br.ifsp.edu.pep.view.swing.Table();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        insert3 = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel11 = new javax.swing.JLabel();
        panelBorder3 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        txtPeriodo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        checkPeriodo = new javax.swing.JCheckBox();
        insert2 = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(239, 239, 239));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        txtCliente.setText("Clique para escolher");
        txtCliente.setBorder(null);
        txtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtClienteMouseClicked(evt);
            }
        });

        checkCliente.setText("Cliente");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkCliente)
                    .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkCliente)
                .addGap(3, 3, 3)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        panelBorder4.setBackground(new java.awt.Color(255, 255, 255));

        checkPreco.setText("Preço");
        checkPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPrecoActionPerformed(evt);
            }
        });

        jLabel2.setText("R$");

        jfPreco.setBorder(null);
        jfPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        comboPreco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A cima", "A baixo", "Igual" }));

        javax.swing.GroupLayout panelBorder4Layout = new javax.swing.GroupLayout(panelBorder4);
        panelBorder4.setLayout(panelBorder4Layout);
        panelBorder4Layout.setHorizontalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator8)
                    .addGroup(panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(checkPreco)
                        .addGroup(panelBorder4Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPreco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder4Layout.setVerticalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBorder4Layout.createSequentialGroup()
                        .addGroup(panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboPreco))
                .addContainerGap())
        );

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Data", "Desconto", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 127, 127));
        jLabel3.setText("Relatório de Venda");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Filtros");

        insert3.setFirstColor(new java.awt.Color(142, 142, 250));
        insert3.setSecondColor(new java.awt.Color(123, 123, 245));
        insert3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insert3MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Filtrar");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout insert3Layout = new javax.swing.GroupLayout(insert3);
        insert3.setLayout(insert3Layout);
        insert3Layout.setHorizontalGroup(
            insert3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insert3Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        insert3Layout.setVerticalGroup(
            insert3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        txtPeriodo.setText("Clique para escolher");
        txtPeriodo.setBorder(null);
        txtPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPeriodoMouseClicked(evt);
            }
        });

        checkPeriodo.setText("Periodo");

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkPeriodo)
                    .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPeriodo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkPeriodo)
                .addGap(3, 3, 3)
                .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        insert2.setFirstColor(new java.awt.Color(142, 142, 250));
        insert2.setSecondColor(new java.awt.Color(123, 123, 245));
        insert2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insert2MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Imprimir");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout insert2Layout = new javax.swing.GroupLayout(insert2);
        insert2.setLayout(insert2Layout);
        insert2Layout.setHorizontalGroup(
            insert2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insert2Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        insert2Layout.setVerticalGroup(
            insert2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insert2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insert3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insert3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(insert2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkPrecoActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        String query = "SELECT v FROM Venda v";

        int qtd = query.length();

        Map<String, Object> map = new HashMap<String, Object>();

        if (this.checkPeriodo.isSelected()) {
            if (query.length() == qtd) {
                query = query + " WHERE v.data BETWEEN :firstDate AND :secoundDate";
            } else {
                query = query + " AND v.data BETWEEN :firstDate AND :secoundDate";
            }
            map.put("firstDate", this.first);
            map.put("secoundDate", this.secound);
        }

        if (this.checkCliente.isSelected()) {
            if (query.length() == qtd) {
                query = query + " WHERE v.entrega.cliente = :client";
            } else {
                query = query + " AND v.entrega.cliente = :client";
            }
            map.put("client", this.client);
        }

        if (this.checkPreco.isSelected()) {

            switch (this.comboPreco.getSelectedIndex()) {
                case 0:
                    if (query.length() == qtd) {
                        query = query + " WHERE v.total > :total";
                    } else {
                        query = query + " AND v.total > :total";
                    }
                    break;
                case 1:
                    if (query.length() == qtd) {
                        query = query + " WHERE v.total < :total";
                    } else {
                        query = query + " AND v.total < :total";
                    }
                    break;
                case 2:
                    if (query.length() == qtd) {
                        query = query + " WHERE v.total = :total";
                    } else {
                        query = query + " AND v.total = :total";
                    }
                    break;
            }

            map.put("total", ((Number) jfPreco.getValue()).doubleValue());

        }

        list = control.filter(query, map);
        System.out.println(list);
        updateTable();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void insert3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insert3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_insert3MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        try {
            JasperReport relatorioCompilado = JasperCompileManager
                    .compileReport("src/br/ifsp/edu/pep/relatorio/RelatorioVenda.jrxml");
            
            JasperPrint relatorio = JasperFillManager.fillReport(relatorioCompilado, null, new JRBeanCollectionDataSource(list));
            
            JDialog tela = new JDialog();
            tela.setSize(1000,500);
            
            JRViewer painelRelatorio = new JRViewer(relatorio);
            
            tela.getContentPane().add(painelRelatorio);
            
            tela.setVisible(true);

        } catch (Exception ex) {
            //  Logger.getLogger(BuyReport.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("oi");
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void insert2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insert2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_insert2MouseClicked

    private void txtPeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPeriodoMouseClicked
        SelectPeriod view = new SelectPeriod(null, true);
        view.setVisible(true);
        if (view.getFirstDate() != null && view.getSecoundDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            this.txtPeriodo.setText("De " + format.format(view.getFirstDate()) + " Até " + format.format(view.getSecoundDate()));
            this.first = view.getFirstDate();
            this.secound = view.getSecoundDate();
        }
    }//GEN-LAST:event_txtPeriodoMouseClicked

    private void txtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClienteMouseClicked
        SelectClient view = new SelectClient(null, true);
        view.setVisible(true);
        if (view.getClient() != null) {
            this.client = view.getClient();
            this.txtCliente.setText(this.client.getNome());
        }
    }//GEN-LAST:event_txtClienteMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkCliente;
    private javax.swing.JCheckBox checkPeriodo;
    private javax.swing.JCheckBox checkPreco;
    private javax.swing.JComboBox<String> comboPreco;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient insert2;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient insert3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JFormattedTextField jfPreco;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder1;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder2;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder3;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder4;
    private javax.swing.JScrollPane spTable;
    private br.ifsp.edu.pep.view.swing.Table table;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables
}
