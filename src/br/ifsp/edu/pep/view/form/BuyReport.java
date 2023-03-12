package br.ifsp.edu.pep.view.form;

import br.ifsp.edu.pep.dao.CaixaDAO;
import br.ifsp.edu.pep.dao.CompraDAO;
import br.ifsp.edu.pep.dao.FornecedorDAO;
import br.ifsp.edu.pep.model.Caixa;
import br.ifsp.edu.pep.model.Compra;
import br.ifsp.edu.pep.model.Fornecedor;
import br.ifsp.edu.pep.view.jdialog.ConfirmWithPassword;
import br.ifsp.edu.pep.view.jdialog.Notification;
import br.ifsp.edu.pep.view.jdialog.SelectPeriod;
import br.ifsp.edu.pep.view.jdialog.SelectSupplier;
import br.ifsp.edu.pep.view.swing.ScrollBar;
import br.ifsp.edu.pep.view.util.Controller;

import java.awt.Color;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
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

public class BuyReport extends javax.swing.JPanel {

    private CompraDAO control = new CompraDAO();
    private List<Compra> list = new ArrayList<>();

    private Date first = null;
    private Date secound = null;

    private Fornecedor supplier = null;
    private FornecedorDAO fornecedorDAO = new FornecedorDAO();
    private CompraDAO compraDAO = new CompraDAO();

    private double value = 0;

    private int status = 0;

    public BuyReport() {
        initComponents();
        initTable();
        list = control.findAll(Compra.class);
        updateTable();
    }

    public void updateTableFromAnotherView() {
        list = control.findAll(Compra.class);
        updateTable();
    }

    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setNumRows(0);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");

        for (Compra obj : list) {
            if (obj.getDataPagamento() == null) {
                Object ob[] = {obj.getFornecedor().getNome(), format.format(obj.getData()), "R$ " + obj.getTotal(), "A pagar"};
                model.addRow(ob);
            } else {
                Object ob[] = {obj.getFornecedor().getNome(), format.format(obj.getData()), "R$ " + obj.getTotal(), "Paga"};
                model.addRow(ob);
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

        insert2 = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel10 = new javax.swing.JLabel();
        panelBorder1 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new br.ifsp.edu.pep.view.swing.Table();
        jLabel3 = new javax.swing.JLabel();
        panelBorder2 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        txtFornecedor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        checkFornecedor = new javax.swing.JCheckBox();
        panelBorder3 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        txtPeriodo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        checkPeriodo = new javax.swing.JCheckBox();
        panelBorder4 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        checkPreco = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jfPreco = new javax.swing.JFormattedTextField();
        jSeparator8 = new javax.swing.JSeparator();
        comboPreco = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        panelBorder5 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        checkStatus = new javax.swing.JCheckBox();
        comboStatus = new javax.swing.JComboBox<>();
        insert3 = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel11 = new javax.swing.JLabel();
        insert5 = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(239, 239, 239));

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

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fornecedor", "Data", "Total", "Status"
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
        jLabel3.setText("Relatório de Compra");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
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
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        txtFornecedor.setText("Clique para escolher");
        txtFornecedor.setBorder(null);
        txtFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFornecedorMouseClicked(evt);
            }
        });

        checkFornecedor.setText("Fornecedor");
        checkFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkFornecedorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkFornecedor)
                    .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFornecedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkFornecedor)
                .addGap(3, 3, 3)
                .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        txtPeriodo.setText("Clique para escolher");
        txtPeriodo.setBorder(null);
        txtPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPeriodoMouseClicked(evt);
            }
        });
        txtPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeriodoActionPerformed(evt);
            }
        });

        checkPeriodo.setText("Periodo");
        checkPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkPeriodoMouseClicked(evt);
            }
        });
        checkPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPeriodoActionPerformed(evt);
            }
        });

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

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Filtros");

        panelBorder5.setBackground(new java.awt.Color(255, 255, 255));

        checkStatus.setText("Status");
        checkStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkStatusActionPerformed(evt);
            }
        });

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paga", "A pagar", "Todas" }));

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addComponent(checkStatus)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(comboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

        insert5.setFirstColor(new java.awt.Color(142, 142, 250));
        insert5.setSecondColor(new java.awt.Color(123, 123, 245));
        insert5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insert5MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Pagar Conta");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout insert5Layout = new javax.swing.GroupLayout(insert5);
        insert5.setLayout(insert5Layout);
        insert5Layout.setHorizontalGroup(
            insert5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insert5Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        insert5Layout.setVerticalGroup(
            insert5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
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
                    .addComponent(panelBorder5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insert2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insert5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insert3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insert5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(insert2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void insert3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insert3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_insert3MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        String query = "SELECT c FROM Compra c";

        int qtd = query.length();

        Map<String, Object> map = new HashMap<String, Object>();

        if (this.checkPeriodo.isSelected()) {
            if (query.length() == qtd) {
                query = query + " WHERE c.data BETWEEN :firstDate AND :secoundDate";
            } else {
                query = query + " AND c.data BETWEEN :firstDate AND :secoundDate";
            }
            map.put("firstDate", this.first);
            map.put("secoundDate", this.secound);
        }

        if (this.checkFornecedor.isSelected()) {
            if (query.length() == qtd) {
                query = query + " WHERE c.fornecedor = :fornecedor";
            } else {
                query = query + " AND c.fornecedor = :fornecedor";
            }
            map.put("fornecedor", this.supplier);
        }

        if (this.checkPreco.isSelected()) {

            switch (this.comboPreco.getSelectedIndex()) {
                case 0:
                    if (query.length() == qtd) {
                        query = query + " WHERE c.total > :total";
                    } else {
                        query = query + " AND c.total > :total";
                    }
                    break;
                case 1:
                    if (query.length() == qtd) {
                        query = query + " WHERE c.total < :total";
                    } else {
                        query = query + " AND c.total < :total";
                    }
                    break;
                case 2:
                    if (query.length() == qtd) {
                        query = query + " WHERE c.total = :total";
                    } else {
                        query = query + " AND c.total = :total";
                    }
                    break;
            }

            map.put("total", ((Number) jfPreco.getValue()).doubleValue());

        }

        if (this.checkStatus.isSelected()) {

            if (this.comboStatus.getSelectedIndex() == 0) {
                if (query.length() == qtd) {
                    query = query + " WHERE c.dataPagamento is not null";
                } else {
                    query = query + " AND c.dataPagamento is not null";
                }
            } else if (this.comboStatus.getSelectedIndex() == 1) {
                if (query.length() == qtd) {
                    query = query + " WHERE c.dataPagamento is null";
                } else {
                    query = query + " AND c.dataPagamento is null";
                }

            }
        }

        list = control.filter(query, map);
        updateTable();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void insert2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insert2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_insert2MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        try {
            
            JasperReport relatorioCompilado = JasperCompileManager
                    .compileReport("src/br/ifsp/edu/pep/relatorio/relatorio1.jrxml");
 
            JRBeanCollectionDataSource dataSource
                    = new JRBeanCollectionDataSource(list);

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    relatorioCompilado,
                    null,
                    dataSource);

            JasperViewer viewer
                    = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);

        } catch (Exception ex) {
            //  Logger.getLogger(BuyReport.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("oi");
        }

    }//GEN-LAST:event_jLabel10MouseClicked

    private void insert5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insert5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_insert5MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        if (CaixaDAO.caixa.getDataFechamento() == null) {
            if (table.getSelectedRow() != -1) {
                ConfirmWithPassword view = new ConfirmWithPassword(null, true);
                view.setVisible(true);
                if (view.isAnswer()) {
                    Notification notification = new Notification(null, true, "Pagar conta", "Realmente pagar esta conta?", true);
                    notification.setVisible(true);
                    if (notification.isAnswer()) {

                        Compra compra = list.get(table.getSelectedRow());

                        compra.setDataPagamento(new Date());

                        CompraDAO controlCompra = new CompraDAO();

                        controlCompra.update(compra);

                        updateTable();

                        Notification n = new Notification(null, true, "Conta paga", "A conta foi paga com sucesso.", false);
                        n.setVisible(true);

                        Caixa caixa = CaixaDAO.caixa;

                        caixa.setValorFinal(caixa.getValorFinal() - compra.getTotal());

                        CaixaDAO controlCaixa = new CaixaDAO();

                        controlCaixa.update(caixa);

                        Controller.dashboard.updateCards();
                        Controller.cash.updateTable();
                    }
                }
            }
        } else {
            Notification notification = new Notification(null, true, "Atenção", "O caixa deve estar aberto.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void checkPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkPrecoActionPerformed

    private void checkStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkStatusActionPerformed

    private void checkPeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkPeriodoMouseClicked
        SelectPeriod view = new SelectPeriod(null, true);
        view.setVisible(true);
        if (view.getFirstDate() != null && view.getSecoundDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            this.txtPeriodo.setText("De " + format.format(view.getFirstDate()) + " Até " + format.format(view.getSecoundDate()));
            this.first = view.getFirstDate();
            this.secound = view.getSecoundDate();
        } else {
            this.checkPeriodo.setSelected(false);
        }
    }//GEN-LAST:event_checkPeriodoMouseClicked

    private void txtPeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPeriodoMouseClicked
        SelectPeriod view = new SelectPeriod(null, true);
        view.setVisible(true);
        if (view.getFirstDate() != null && view.getSecoundDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            this.txtPeriodo.setText("De " + format.format(view.getFirstDate()) + " Até " + format.format(view.getSecoundDate()));
            this.first = view.getFirstDate();
            this.secound = view.getSecoundDate();
        } else {
            this.checkPeriodo.setSelected(false);
        }
    }//GEN-LAST:event_txtPeriodoMouseClicked

    private void txtFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFornecedorMouseClicked
        SelectSupplier view = new SelectSupplier(null, true);
        view.setVisible(true);
        if (view.getSupplier() != null) {
            supplier = view.getSupplier();
            txtFornecedor.setText(supplier.getNome());
        } else {
            this.checkFornecedor.setSelected(false);
        }
    }//GEN-LAST:event_txtFornecedorMouseClicked

    private void checkFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkFornecedorMouseClicked
        SelectSupplier view = new SelectSupplier(null, true);
        view.setVisible(true);
        if (view.getSupplier() != null) {
            supplier = view.getSupplier();
            txtFornecedor.setText(supplier.getNome());
        } else {
            this.checkFornecedor.setSelected(false);
        }
    }//GEN-LAST:event_checkFornecedorMouseClicked

    private void checkPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkPeriodoActionPerformed

    private void txtPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPeriodoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkFornecedor;
    private javax.swing.JCheckBox checkPeriodo;
    private javax.swing.JCheckBox checkPreco;
    private javax.swing.JCheckBox checkStatus;
    private javax.swing.JComboBox<String> comboPreco;
    private javax.swing.JComboBox<String> comboStatus;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient insert2;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient insert3;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient insert5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
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
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder5;
    private javax.swing.JScrollPane spTable;
    private br.ifsp.edu.pep.view.swing.Table table;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables
}
