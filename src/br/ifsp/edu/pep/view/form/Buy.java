package br.ifsp.edu.pep.view.form;

import br.ifsp.edu.pep.dao.CaixaDAO;
import br.ifsp.edu.pep.dao.CompraDAO;
import br.ifsp.edu.pep.dao.UsuarioDAO;
import br.ifsp.edu.pep.model.BebidaCompra;
import br.ifsp.edu.pep.model.Caixa;
import br.ifsp.edu.pep.model.Compra;
import br.ifsp.edu.pep.model.Fornecedor;
import br.ifsp.edu.pep.model.IngredienteCompra;
import br.ifsp.edu.pep.view.jdialog.Notification;
import br.ifsp.edu.pep.view.jdialog.SelectBuy;
import br.ifsp.edu.pep.view.jdialog.SelectSupplier;
import br.ifsp.edu.pep.view.swing.ScrollBar;
import br.ifsp.edu.pep.view.swing.Table;
import br.ifsp.edu.pep.view.util.Controller;
import java.awt.Color;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Buy extends javax.swing.JPanel {

    private Fornecedor supplier = new Fornecedor();
    private boolean update = false;
    private List<IngredienteCompra> ingredientes = new ArrayList<>();
    private List<BebidaCompra> bebidas = new ArrayList<>();
    private double total;
    private CompraDAO compraDAO = new CompraDAO();

    public Buy() {
        initComponents();
        date.setDate(new Date());
        initTable();
    }

    public List<IngredienteCompra> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteCompra> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<BebidaCompra> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<BebidaCompra> bebidas) {
        this.bebidas = bebidas;
    }

    public void setTxtUser() {
        txtUser.setText(UsuarioDAO.user.getNome());
    }

    private void calcularTotal() {
        this.total = 0;

        for (IngredienteCompra i : ingredientes) {
            total += i.getSubtotal() * i.getQuantidade();
        }

        for (BebidaCompra b : bebidas) {
            total += b.getSubtotal() * b.getQuantidade();
        }

        this.totalCompra.setText(String.valueOf(this.total));
    }

    private void initTable() {
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        spTable1.setVerticalScrollBar(new ScrollBar());
        spTable1.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable1.getViewport().setBackground(Color.WHITE);
        p.setBackground(Color.WHITE);
        spTable1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }

    public Table getTableIngrediente() {
        return tableIngrediente;
    }

    public void atualizarTabelaIngrediente() {
        DefaultTableModel modelIngrediente = (DefaultTableModel) tableIngrediente.getModel();
        modelIngrediente.setNumRows(0);
        for (IngredienteCompra i : ingredientes) {
            Object objTable[] = {i.getIngrediente().getNome(), i.getSubtotal(), i.getQuantidade(), i.getSubtotal() * i.getQuantidade()};
            modelIngrediente.addRow(objTable);
        }
    }

    public void atualizarTabelaBebida() {
        DefaultTableModel modelBebida = (DefaultTableModel) tableBebida.getModel();
        modelBebida.setNumRows(0);
        for (BebidaCompra b : bebidas) {
            Object objTable[] = {b.getBebida().getNome(), b.getSubtotal(), b.getQuantidade(), b.getSubtotal() * b.getQuantidade()};
            modelBebida.addRow(objTable);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBorder2 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        panelBorder1 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder3 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        jLabel7 = new javax.swing.JLabel();
        finalizar = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel10 = new javax.swing.JLabel();
        totalCompra = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        date2 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtSupplier = new javax.swing.JTextField();
        labelFornecedor = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        panelBorder8 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder9 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        tableIngrediente = new br.ifsp.edu.pep.view.swing.Table();
        jLabel1 = new javax.swing.JLabel();
        panelBorder10 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        spTable1 = new javax.swing.JScrollPane();
        tableBebida = new br.ifsp.edu.pep.view.swing.Table();
        jLabel3 = new javax.swing.JLabel();
        panelRemove = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder13 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        confirmarValor2 = new javax.swing.JLabel();
        panelBorder20 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder21 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        confirmarValor6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(951, 607));
        setLayout(new java.awt.GridLayout());

        jPanel1.setBackground(new java.awt.Color(239, 239, 239));
        jPanel1.setLayout(new java.awt.GridLayout());

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Itens da Compra");

        panelBorder1.setBackground(new java.awt.Color(204, 204, 204));

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(127, 127, 127));
        jLabel7.setText("Detalhes da Compra");

        finalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finalizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                finalizarMouseExited(evt);
            }
        });
        finalizar.setLayout(new java.awt.FlowLayout());

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Finalizar Pedido");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        finalizar.add(jLabel10);

        totalCompra.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        totalCompra.setForeground(new java.awt.Color(127, 127, 127));
        totalCompra.setText("0.00");

        jLabel24.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(127, 127, 127));
        jLabel24.setText("R$");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/icons8-pizza-100.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(127, 127, 127));
        jLabel26.setText("Valor Final");

        jLabel5.setText("Data da Compra");

        date.setEnabled(false);

        jLabel8.setText("Data do Vencimento");

        txtSupplier.setForeground(new java.awt.Color(127, 127, 127));
        txtSupplier.setText("Clique para selecionar");
        txtSupplier.setBorder(null);
        txtSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSupplierMouseClicked(evt);
            }
        });

        labelFornecedor.setText("Fornecedor");

        txtUser.setEditable(false);
        txtUser.setForeground(new java.awt.Color(127, 127, 127));
        txtUser.setText("nome");
        txtUser.setBorder(null);

        jLabel21.setText("Responsável");

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSupplier)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalCompra))
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addGap(31, 31, 31))
                    .addComponent(finalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelBorder3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(28, 28, 28))
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(labelFornecedor)
                                .addGap(6, 6, 6)
                                .addComponent(txtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addGroup(panelBorder3Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel24)
                                            .addComponent(totalCompra)))))
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBorder8.setBackground(new java.awt.Color(255, 255, 255));

        panelBorder9.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        tableIngrediente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Preço", "Quantidade", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableIngrediente.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tableIngrediente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableIngrediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableIngredienteMouseClicked(evt);
            }
        });
        spTable.setViewportView(tableIngrediente);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Ingredientes");

        javax.swing.GroupLayout panelBorder9Layout = new javax.swing.GroupLayout(panelBorder9);
        panelBorder9.setLayout(panelBorder9Layout);
        panelBorder9Layout.setHorizontalGroup(
            panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder9Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)))
        );
        panelBorder9Layout.setVerticalGroup(
            panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelBorder10.setBackground(new java.awt.Color(255, 255, 255));

        spTable1.setBackground(new java.awt.Color(255, 255, 255));
        spTable1.setBorder(null);

        tableBebida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Preço", "Quantidade", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBebida.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tableBebida.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableBebida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBebidaMouseClicked(evt);
            }
        });
        spTable1.setViewportView(tableBebida);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 127, 127));
        jLabel3.setText("Bebidas");

        javax.swing.GroupLayout panelBorder10Layout = new javax.swing.GroupLayout(panelBorder10);
        panelBorder10.setLayout(panelBorder10Layout);
        panelBorder10Layout.setHorizontalGroup(
            panelBorder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addGroup(panelBorder10Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder10Layout.setVerticalGroup(
            panelBorder10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBorder8Layout = new javax.swing.GroupLayout(panelBorder8);
        panelBorder8.setLayout(panelBorder8Layout);
        panelBorder8Layout.setHorizontalGroup(
            panelBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(panelBorder10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelBorder8Layout.setVerticalGroup(
            panelBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder8Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addComponent(panelBorder10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelRemove.setBackground(new java.awt.Color(153, 153, 153));

        panelBorder13.setBackground(new java.awt.Color(255, 255, 255));

        confirmarValor2.setBackground(new java.awt.Color(255, 255, 255));
        confirmarValor2.setText("Remover Item");
        confirmarValor2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmarValor2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmarValor2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder13Layout = new javax.swing.GroupLayout(panelBorder13);
        panelBorder13.setLayout(panelBorder13Layout);
        panelBorder13Layout.setHorizontalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(confirmarValor2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder13Layout.setVerticalGroup(
            panelBorder13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmarValor2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRemoveLayout = new javax.swing.GroupLayout(panelRemove);
        panelRemove.setLayout(panelRemoveLayout);
        panelRemoveLayout.setHorizontalGroup(
            panelRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRemoveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        panelRemoveLayout.setVerticalGroup(
            panelRemoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRemoveLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        panelBorder20.setBackground(new java.awt.Color(153, 153, 153));

        panelBorder21.setBackground(new java.awt.Color(255, 255, 255));

        confirmarValor6.setBackground(new java.awt.Color(255, 255, 255));
        confirmarValor6.setText("Adicionar Item");
        confirmarValor6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmarValor6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmarValor6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder21Layout = new javax.swing.GroupLayout(panelBorder21);
        panelBorder21.setLayout(panelBorder21Layout);
        panelBorder21Layout.setHorizontalGroup(
            panelBorder21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(confirmarValor6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder21Layout.setVerticalGroup(
            panelBorder21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmarValor6, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder20Layout = new javax.swing.GroupLayout(panelBorder20);
        panelBorder20.setLayout(panelBorder20Layout);
        panelBorder20Layout.setHorizontalGroup(
            panelBorder20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        panelBorder20Layout.setVerticalGroup(
            panelBorder20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder20Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(panelBorder20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(panelRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBorder20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel1.add(panelBorder2);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSupplierMouseClicked
        SelectSupplier view = new SelectSupplier(null, true);
        view.setVisible(true);
        if (view.getSupplier() != null) {
            supplier = view.getSupplier();
            txtSupplier.setText(supplier.getNome());
            this.txtSupplier.setForeground(Color.black);
        }
        txtSupplier.setFocusable(true);
    }//GEN-LAST:event_txtSupplierMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel10MouseExited

    private void finalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarMouseClicked
        if (!txtSupplier.getText().equals("Clique para selecionar")) {
            if (date2.getDate() != null) {
                if (!ingredientes.isEmpty() || !bebidas.isEmpty()) {

                    System.out.println(supplier.getNome());
                    Compra compra = new Compra(CaixaDAO.caixa, supplier, this.date.getDate(), null, this.date2.getDate(), total, bebidas, ingredientes);
                    compraDAO.insert(compra);

                    ingredientes.clear();
                    bebidas.clear();

                    Controller.buyReport.updateTable();

                    Controller.dashboard.updateCards();

                    Controller.buyReport.updateTableFromAnotherView();

                    this.txtSupplier.setText("Clique para selecionar");

                    this.txtSupplier.setForeground(new Color(127, 127, 127));

                    atualizarTabelaBebida();
                    atualizarTabelaIngrediente();
                    calcularTotal();

                    Notification notification = new Notification(null, true, "Compra realizada", "Compra realizada com sucesso", false);
                    notification.setVisible(true);

                } else {
                    Notification notification = new Notification(null, true, "compra sem itens", "Você deve selecionar pelo menos um item para concluir a venda.", false);
                    notification.setVisible(true);
                }
            } else {
                Notification notification = new Notification(null, true, "Sem data vencimento", "Você deve selecionar uma data de vencimento para concluir a venda.", false);
                notification.setVisible(true);
            }
        } else {
            Notification notification = new Notification(null, true, "Sem fornecedor", "Você deve selecionar um fornecedoro para concluir a venda.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_finalizarMouseClicked

    private void finalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_finalizarMouseEntered

    private void finalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_finalizarMouseExited

    private void tableIngredienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableIngredienteMouseClicked
        this.atualizarTabelaBebida();
    }//GEN-LAST:event_tableIngredienteMouseClicked

    private void confirmarValor2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarValor2MouseClicked
        if (this.tableBebida.getSelectedRow() != -1) {
            this.bebidas.remove(this.tableBebida.getSelectedRow());
            atualizarTabelaBebida();
        } else {
            this.ingredientes.remove(this.tableIngrediente.getSelectedRow());
            atualizarTabelaIngrediente();
        }
        calcularTotal();
    }//GEN-LAST:event_confirmarValor2MouseClicked

    private void confirmarValor6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarValor6MouseClicked
        SelectBuy view = new SelectBuy(null, true);
        view.setIngredientes((ArrayList<IngredienteCompra>) ingredientes);
        view.setBebidas((ArrayList<BebidaCompra>) bebidas);
        view.setVisible(true);

        this.atualizarTabelaIngrediente();
        this.atualizarTabelaBebida();
        calcularTotal();
    }//GEN-LAST:event_confirmarValor6MouseClicked

    private void tableBebidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBebidaMouseClicked
        this.atualizarTabelaIngrediente();
    }//GEN-LAST:event_tableBebidaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel confirmarValor2;
    private javax.swing.JLabel confirmarValor6;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser date2;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient finalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelFornecedor;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder1;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder10;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder13;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder2;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder20;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder21;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder3;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder8;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder9;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelRemove;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable1;
    private br.ifsp.edu.pep.view.swing.Table tableBebida;
    private br.ifsp.edu.pep.view.swing.Table tableIngrediente;
    private javax.swing.JLabel totalCompra;
    private javax.swing.JTextField txtSupplier;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
