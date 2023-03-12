package br.ifsp.edu.pep.view.form;

import br.ifsp.edu.pep.dao.CaixaDAO;
import br.ifsp.edu.pep.dao.DespesaDAO;
import br.ifsp.edu.pep.dao.PagamentoDespesaDAO;
import br.ifsp.edu.pep.model.Caixa;
import br.ifsp.edu.pep.model.Despesa;
import br.ifsp.edu.pep.model.PagamentoDespesa;
import br.ifsp.edu.pep.view.jdialog.ConfirmWithPassword;
import br.ifsp.edu.pep.view.jdialog.CrudExpense;
import br.ifsp.edu.pep.view.jdialog.Notification;
import br.ifsp.edu.pep.view.swing.ScrollBar;
import br.ifsp.edu.pep.view.util.Controller;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Expense extends javax.swing.JPanel {

    private DespesaDAO control = new DespesaDAO();
    private List<Despesa> list = new ArrayList<>();
    private Color cleanTextColor = new Color(153, 153, 153);

    public Expense() {
        initComponents();
        initTable();
        defineButtonsColors();
        updateTable();
        clear.setVisible(false);
    }

    private void updateTable() {
        list = control.findAll(Despesa.class);
        insertTable();
    }

    private void insertTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setNumRows(0);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        for (Despesa obj : list) {
            Object objTable[] = {obj.getNome(), "R$ " + obj.getValor(), format.format(obj.getDataVencimento()), obj.getStatus()};
            model.addRow(objTable);
        }
    }

    private void defineButtonsColors() {
        insert.setFirstColor(Color.decode("#8e8efa"));
        insert.setSecondColor(Color.decode("#7b7bf5"));
        update.setFirstColor(Color.decode("#8e8efa"));
        update.setSecondColor(Color.decode("#7b7bf5"));
        delete.setFirstColor(Color.decode("#8e8efa"));
        delete.setSecondColor(Color.decode("#7b7bf5"));
        view.setFirstColor(Color.decode("#8e8efa"));
        view.setSecondColor(Color.decode("#7b7bf5"));
        btnPagar.setFirstColor(Color.decode("#8e8efa"));
        btnPagar.setSecondColor(Color.decode("#7b7bf5"));
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

        view = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel7 = new javax.swing.JLabel();
        update = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel6 = new javax.swing.JLabel();
        insert = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel8 = new javax.swing.JLabel();
        delete = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel9 = new javax.swing.JLabel();
        panelBorder1 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        clear = new javax.swing.JLabel();
        panelBorder2 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new br.ifsp.edu.pep.view.swing.Table();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnPagar = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(239, 239, 239));

        view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Visualizar");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout viewLayout = new javax.swing.GroupLayout(view);
        view.setLayout(viewLayout);
        viewLayout.setHorizontalGroup(
            viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(32, 32, 32))
        );
        viewLayout.setVerticalGroup(
            viewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Editar");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout updateLayout = new javax.swing.GroupLayout(update);
        update.setLayout(updateLayout);
        updateLayout.setHorizontalGroup(
            updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(32, 32, 32))
        );
        updateLayout.setVerticalGroup(
            updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cadastrar");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout insertLayout = new javax.swing.GroupLayout(insert);
        insert.setLayout(insertLayout);
        insertLayout.setHorizontalGroup(
            insertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(32, 32, 32))
        );
        insertLayout.setVerticalGroup(
            insertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Exclur");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout deleteLayout = new javax.swing.GroupLayout(delete);
        delete.setLayout(deleteLayout);
        deleteLayout.setHorizontalGroup(
            deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );
        deleteLayout.setVerticalGroup(
            deleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        search.setForeground(new java.awt.Color(153, 153, 153));
        search.setText("Pesquise usuário por nome ...");
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/search.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/x.png"))); // NOI18N
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Despesas");

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Valor", "Data Vencimento", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        spTable.setViewportView(table);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spTable)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPagarMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pagar despesa");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnPagarLayout = new javax.swing.GroupLayout(btnPagar);
        btnPagar.setLayout(btnPagarLayout);
        btnPagarLayout.setHorizontalGroup(
            btnPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPagarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        btnPagarLayout.setVerticalGroup(
            btnPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        if (search.getText().equals("Pesquise usuário por nome ...")) {
            clear.setVisible(true);
            search.setText("");
            search.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        if (search.getText().equals("")) {
            clear.setVisible(false);
            search.setText("Pesquise usuário por nome ...");
            search.setForeground(cleanTextColor);
        }
    }//GEN-LAST:event_searchFocusLost

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        clear.setVisible(false);
        search.setText("Pesquise usuário por nome ...");
        search.setForeground(cleanTextColor);
        jLabel1.requestFocus();
        updateTable();
    }//GEN-LAST:event_clearMouseClicked

    private void insertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertMouseClicked
        CrudExpense view = new CrudExpense(null, true);
        view.setVisible(true);
        updateTable();
    }//GEN-LAST:event_insertMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        CrudExpense view = new CrudExpense(null, true);
        view.setVisible(true);
        updateTable();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if (table.getSelectedRow() != -1) {
            if (!list.get(table.getSelectedRow()).getStatus().equals("Paga")) {
                CrudExpense view = new CrudExpense(null, true);
                view.setExpense(list.get(table.getSelectedRow()));
                view.setUpdate(true);
                view.setVisible(true);
                updateTable();
            } else {
                Notification notification = new Notification(null, true, "Despesa Paga", "Você não pode editar uma despesa paga.", false);
                notification.setVisible(true);
            }
        } else {
            Notification notification = new Notification(null, true, "Selecione uma pizza", "Você deve selecionar uma pizza para concluir a ação.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        if (table.getSelectedRow() != -1) {
            if (!list.get(table.getSelectedRow()).getStatus().equals("Paga")) {
                CrudExpense view = new CrudExpense(null, true);
                view.setExpense(list.get(table.getSelectedRow()));
                view.setUpdate(true);
                view.setVisible(true);
                updateTable();
            } else {
                Notification notification = new Notification(null, true, "Despesa Paga", "Você não pode editar uma despesa paga.", false);
                notification.setVisible(true);
            }
        } else {
            Notification notification = new Notification(null, true, "Selecione uma despesa", "Você deve selecionar uma despesa para concluir a ação.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_updateMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        if (table.getSelectedRow() != -1) {
            CrudExpense view = new CrudExpense(null, true);
            view.setExpense(list.get(table.getSelectedRow()));
            view.inactivateFields();
            view.setVisible(true);
        } else {
            Notification notification = new Notification(null, true, "Selecione uma despesa", "Você deve selecionar uma despesa para concluir a ação.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseClicked
        if (table.getSelectedRow() != -1) {
            CrudExpense view = new CrudExpense(null, true);
            view.setExpense(list.get(table.getSelectedRow()));
            view.inactivateFields();
            view.setVisible(true);
        } else {
            Notification notification = new Notification(null, true, "Selecione uma pizza", "Você deve selecionar uma pizza para concluir a ação.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_viewMouseClicked

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed

    }//GEN-LAST:event_searchKeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        ConfirmWithPassword view = new ConfirmWithPassword(null, true);
        view.setVisible(true);
        if (view.isAnswer()) {
            if (table.getSelectedRow() == -1) {
                Notification notification = new Notification(null, true, "Selecione uma despesa", "Você deve selecionar um despesa para concluir a ação.", false);
                notification.setVisible(true);
            } else {
                if (!list.get(table.getSelectedRow()).getStatus().equals("Paga")) {
                    Notification notification = new Notification(null, true, "Excluir", "Realmente dejesa excluir", true);
                    notification.setVisible(true);
                    if (notification.isAnswer()) {
                        control.remove(list.get(table.getSelectedRow()));
                        updateTable();
                    }
                } else {
                    Notification notification = new Notification(null, true, "Despesa Paga", "Você não pode excluir uma despesa paga.", false);
                    notification.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        if (table.getSelectedRow() == -1) {
            Notification notification = new Notification(null, true, "Selecione uma despesa", "Você deve selecionar um despesa para concluir a ação.", false);
            notification.setVisible(true);
        } else {
            if (!list.get(table.getSelectedRow()).getStatus().equals("Paga")) {
                Notification notification = new Notification(null, true, "Excluir", "Realmente dejesa excluir", true);
                notification.setVisible(true);
                if (notification.isAnswer()) {
                    control.remove(list.get(table.getSelectedRow()));
                    updateTable();
                }
            } else {
                Notification notification = new Notification(null, true, "Despesa Paga", "Você não pode excluir uma despesa paga.", false);
                notification.setVisible(true);
            }
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (table.getSelectedRow() != -1) {
            Despesa d = list.get(table.getSelectedRow());
            jTextArea1.setText(d.getDescricao());
        }
    }//GEN-LAST:event_tableMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        if (table.getSelectedRow() == -1) {
            Notification notification = new Notification(null, true, "Selecione uma despesa", "Você deve selecionar um despesa para concluir a ação.", false);
            notification.setVisible(true);
        } else {
            ConfirmWithPassword view = new ConfirmWithPassword(null, true);
            view.setVisible(true);
            if (view.isAnswer()) {
                Notification notification = new Notification(null, true, "Pagar", "Realmente dejesa marcar como paga esta despesa?", true);
                notification.setVisible(true);
                if (notification.isAnswer()) {
                    Despesa d = list.get(table.getSelectedRow());

                    PagamentoDespesa pd = new PagamentoDespesa(d, CaixaDAO.caixa, new Date());

                    PagamentoDespesaDAO controlPD = new PagamentoDespesaDAO();

                    controlPD.insert(pd);

                    d.setStatus("Paga");

                    control.update(d);

                    Caixa caixa = CaixaDAO.caixa;

                    caixa.setValorFinal(caixa.getValorFinal() - d.getValor());

                    CaixaDAO controlCash = new CaixaDAO();

                    controlCash.update(caixa);

                    Controller.cash.updateTable();
                    Controller.dashboard.updateCards();

                    Notification n = new Notification(null, true, "Despesa paga", "A despesa foi paga com sucesso!", true);
                    n.setVisible(true);

                    updateTable();
                }
            }
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void btnPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPagarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient btnPagar;
    private javax.swing.JLabel clear;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient delete;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder1;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder2;
    private javax.swing.JTextField search;
    private javax.swing.JScrollPane spTable;
    private br.ifsp.edu.pep.view.swing.Table table;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient update;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient view;
    // End of variables declaration//GEN-END:variables
}
