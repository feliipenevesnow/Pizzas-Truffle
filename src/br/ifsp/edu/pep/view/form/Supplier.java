package br.ifsp.edu.pep.view.form;

import br.ifsp.edu.pep.dao.FornecedorDAO;
import br.ifsp.edu.pep.model.Fornecedor;
import br.ifsp.edu.pep.view.jdialog.ConfirmWithPassword;
import br.ifsp.edu.pep.view.jdialog.CrudSupplier;
import br.ifsp.edu.pep.view.jdialog.Notification;
import br.ifsp.edu.pep.view.swing.ScrollBar;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Supplier extends javax.swing.JPanel {

    private Color cleanTextColor = new Color(153, 153, 153);
    private FornecedorDAO control = new FornecedorDAO();
    private List<Fornecedor> list = new ArrayList<>();

    public Supplier() {
        initComponents();
        defineButtonsColors();
        initTable();
        updateTable();
    }

    private void updateTable() {
        list = control.findAll(Fornecedor.class);
        insertTable();
    }

    private void insertTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setNumRows(0);

        for (Fornecedor obj : list) {
            Object objTable[] = {obj.getNome(), obj.getCnpj(), obj.getContato()};
            model.addRow(objTable);
        }
    }

    private void defineButtonsColors() {
        insert.setFirstColor(Color.decode("#8e8efa"));
        insert.setSecondColor(Color.decode("#7b7bf5"));
        update.setFirstColor(Color.decode("#8e8efa"));
        update.setSecondColor(Color.decode("#7b7bf5"));
        delete3.setFirstColor(Color.decode("#8e8efa"));
        delete3.setSecondColor(Color.decode("#7b7bf5"));
        view.setFirstColor(Color.decode("#8e8efa"));
        view.setSecondColor(Color.decode("#7b7bf5"));
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

        panelBorder1 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        clear = new javax.swing.JLabel();
        panelBorder2 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new br.ifsp.edu.pep.view.swing.Table();
        view = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel7 = new javax.swing.JLabel();
        update = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel6 = new javax.swing.JLabel();
        insert = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel8 = new javax.swing.JLabel();
        delete3 = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(239, 239, 239));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        search.setForeground(new java.awt.Color(153, 153, 153));
        search.setText("Pesquise fornecedor por nome ...");
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
        jLabel2.setText("Fornecedor");

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CNPJ", "Contato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spTable))
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

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

        delete3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete3MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Excluir");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout delete3Layout = new javax.swing.GroupLayout(delete3);
        delete3.setLayout(delete3Layout);
        delete3Layout.setHorizontalGroup(
            delete3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(delete3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );
        delete3Layout.setVerticalGroup(
            delete3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(delete3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(delete3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        if (search.getText().equals("Pesquise fornecedor por nome ...")) {
            clear.setVisible(true);
            search.setText("");
            search.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        if (search.getText().equals("")) {
            clear.setVisible(false);
            search.setText("Pesquise fornecedor por nome ...");
            search.setForeground(cleanTextColor);
        }
    }//GEN-LAST:event_searchFocusLost

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        clear.setVisible(false);
        search.setText("Pesquise fornecedor por nome ...");
        search.setForeground(cleanTextColor);
        jLabel1.requestFocus();
        updateTable();
    }//GEN-LAST:event_clearMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        CrudSupplier view = new CrudSupplier(null, true);
        view.setVisible(true);
        updateTable();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void insertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertMouseClicked
        CrudSupplier view = new CrudSupplier(null, true);
        view.setVisible(true);
        updateTable();
    }//GEN-LAST:event_insertMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if (table.getSelectedRow() == -1) {
            Notification notification = new Notification(null, true, "Selecione um fornecedor", "Você deve selecionar um fornecedor para concluir a ação.", false);
            notification.setVisible(true);
        } else {
            CrudSupplier view = new CrudSupplier(null, true);
            view.setClient(list.get(table.getSelectedRow()));
            view.setUpdate(true);
            view.setVisible(true);
            updateTable();

        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        if (table.getSelectedRow() == -1) {
            Notification notification = new Notification(null, true, "Selecione um fornecedor", "Você deve selecionar um fornecedor para concluir a ação.", false);
            notification.setVisible(true);
        } else {
            CrudSupplier view = new CrudSupplier(null, true);
            view.setClient(list.get(table.getSelectedRow()));
            view.setUpdate(true);
            view.setVisible(true);
            updateTable();

        }
    }//GEN-LAST:event_updateMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        if (table.getSelectedRow() == -1) {
            Notification notification = new Notification(null, true, "Selecione um fornecedor", "Você deve selecionar um fornecedor para concluir a ação.", false);
            notification.setVisible(true);
        } else {
            CrudSupplier view = new CrudSupplier(null, true);
            view.setClient(list.get(table.getSelectedRow()));
            view.inactivateFields();
            view.setVisible(true);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseClicked
        if (table.getSelectedRow() == -1) {
            Notification notification = new Notification(null, true, "Selecione um fornecedor", "Você deve selecionar um fornecedor para concluir a ação.", false);
            notification.setVisible(true);
        } else {
            CrudSupplier view = new CrudSupplier(null, true);
            view.setClient(list.get(table.getSelectedRow()));
            view.inactivateFields();
            view.setVisible(true);
        }
    }//GEN-LAST:event_viewMouseClicked

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            list = control.findByName(search.getText());
            insertTable();
        }
    }//GEN-LAST:event_searchKeyPressed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        ConfirmWithPassword view = new ConfirmWithPassword(null, true);
        view.setVisible(true);
        if (view.isAnswer()) {
            if (table.getSelectedRow() == -1) {
                Notification notification = new Notification(null, true, "Selecione um Fornecedor", "Você deve selecionar um fornecedor para concluir a ação.", false);
                notification.setVisible(true);
            } else {
                Notification notification = new Notification(null, true, "Excluir", "Realmente dejesa excluir", true);
                notification.setVisible(true);
                if (notification.isAnswer()) {
                    control.remove(list.get(table.getSelectedRow()));
                    updateTable();
                }
            }
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void delete3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete3MouseClicked
        ConfirmWithPassword view = new ConfirmWithPassword(null, true);
        view.setVisible(true);
        if (view.isAnswer()) {
            if (table.getSelectedRow() == -1) {
                Notification notification = new Notification(null, true, "Selecione um usuário", "Você deve selecionar um usuário para concluir a ação.", false);
                notification.setVisible(true);
            } else {
                Notification notification = new Notification(null, true, "Excluir", "Realmente dejesa excluir", true);
                notification.setVisible(true);
                if (notification.isAnswer()) {
                    control.remove(list.get(table.getSelectedRow()));
                    updateTable();
                }
            }
        }
    }//GEN-LAST:event_delete3MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clear;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient delete;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient delete1;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient delete3;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder1;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder2;
    private javax.swing.JTextField search;
    private javax.swing.JScrollPane spTable;
    private br.ifsp.edu.pep.view.swing.Table table;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient update;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient view;
    // End of variables declaration//GEN-END:variables
}
