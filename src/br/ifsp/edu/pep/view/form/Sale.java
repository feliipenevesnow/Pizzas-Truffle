package br.ifsp.edu.pep.view.form;

import br.ifsp.edu.pep.dao.BebidaDAO;
import br.ifsp.edu.pep.dao.CaixaDAO;

import br.ifsp.edu.pep.dao.PizzaDAO;
import br.ifsp.edu.pep.dao.UsuarioDAO;
import br.ifsp.edu.pep.dao.VendaDAO;

import br.ifsp.edu.pep.model.BebidaVenda;
import br.ifsp.edu.pep.model.Cliente;
import br.ifsp.edu.pep.model.Entrega;
import br.ifsp.edu.pep.model.Entregador;

import br.ifsp.edu.pep.model.IngredientePizza;

import br.ifsp.edu.pep.model.PizzaVenda;
import br.ifsp.edu.pep.model.Venda;
import br.ifsp.edu.pep.view.jdialog.Notification;

import br.ifsp.edu.pep.view.jdialog.SelectClient;
import br.ifsp.edu.pep.view.jdialog.SelectDeliveryMan;
import br.ifsp.edu.pep.view.jdialog.SelectItem;

import br.ifsp.edu.pep.view.swing.ScrollBar;
import br.ifsp.edu.pep.view.util.Controller;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Sale extends javax.swing.JPanel {

    private BebidaDAO controlDrink = new BebidaDAO();
    private PizzaDAO controlPizza = new PizzaDAO();
    private VendaDAO controleVenda = new VendaDAO();

    private List<BebidaVenda> drinks = new ArrayList<>();
    private List<PizzaVenda> pizzas = new ArrayList<>();

    private Entregador deliveryMan = null;
    private Cliente client = null;

    private double totalVenda = 0;

    public Sale() {
        initComponents();
        date.setDate(new Date());
        initTable();
        panelRemove.setVisible(false);
        total.setValue(0);
        taxa.setValue(0);
        desconto.setValue(0);
        totalDesconto.setValue(0);
        Timer timer = new Timer(500, new Update());
        timer.start();
        updateTables();
    }

    private void updateTables() {
        DefaultTableModel drinksModel = (DefaultTableModel) tabDrinks.getModel();
        DefaultTableModel pizzasModel = (DefaultTableModel) tabPizzas.getModel();

        drinksModel.setNumRows(0);
        pizzasModel.setNumRows(0);

        for (BebidaVenda bv : drinks) {
            Object obj[] = {bv.getBebida().getNome(), "R$ " + bv.getBebida().getPreco(), "Bebida", bv.getQuantidade() + " Unid."};
            drinksModel.addRow(obj);
        }
        for (PizzaVenda pv : pizzas) {
            Object obj[] = {pv.getPizza().getNome(), pv.getPizza().getTamanho(), "R$ " + pv.getPizza().getPreco(), pv.getQuantidade() + " Unid."};
            pizzasModel.addRow(obj);
        }
    }

    public void setUser() {
        txtUser.setText(UsuarioDAO.user.getNome());
    }

    public static double converte(String arg) throws ParseException {
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        double number = nf.parse(arg).doubleValue();
        return number;
    }

    private void calcularTotal() {
        this.totalVenda = 0;

        for (BebidaVenda bv : this.drinks) {
            this.totalVenda += bv.getSubtotal();
        }

        for (PizzaVenda pv : this.pizzas) {
            this.totalVenda += pv.getSubtotal();
        }

        this.labelTotal.setText(String.valueOf(this.totalVenda));
        this.total.setValue(this.totalVenda);
    }

    private void calcFields() {
        try {
            double desconto = 0, totalDesconto = 0, taxa = 0;

            desconto = ((Number) this.desconto.getValue()).doubleValue();

            taxa = ((Number) this.taxa.getValue()).doubleValue();

            if (typeDiscount.getSelectedIndex() == 0) {
                this.totalDesconto.setValue(totalVenda - (totalVenda * desconto / 100));
            } else {
                this.totalDesconto.setValue(totalVenda - desconto);
            }

            totalDesconto = converte(this.totalDesconto.getText());

            totalDescontoTaxa.setText(String.valueOf(totalDesconto + taxa));
        } catch (ParseException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }

    private void clearSelectedPizzasTable() {
        DefaultTableModel pizzasModel = (DefaultTableModel) tabPizzas.getModel();
        pizzasModel.setNumRows(0);
        for (PizzaVenda pv : pizzas) {
            Object obj[] = {pv.getPizza().getNome(), pv.getPizza().getTamanho(), "R$ " + pv.getPizza().getPreco(), pv.getQuantidade() + " Unid."};
            pizzasModel.addRow(obj);
        }

        DefaultListModel model = new DefaultListModel();
        ingredients.setModel(model);
    }

    private void clearSelectedDrinksTable() {
        DefaultTableModel drinksModel = (DefaultTableModel) tabDrinks.getModel();
        drinksModel.setNumRows(0);
        for (BebidaVenda bv : drinks) {
            Object obj[] = {bv.getBebida().getNome(), "R$ " + bv.getBebida().getPreco(), "Bebida", bv.getQuantidade() + " Unid."};
            drinksModel.addRow(obj);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtClient = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        labEntregador = new javax.swing.JLabel();
        txtDeliveryMan = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        labBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        panelBorder1 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder3 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        total = new javax.swing.JFormattedTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        taxa = new javax.swing.JFormattedTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        desconto = new javax.swing.JFormattedTextField();
        jSeparator10 = new javax.swing.JSeparator();
        typeDiscount = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        totalDesconto = new javax.swing.JFormattedTextField();
        jSeparator11 = new javax.swing.JSeparator();
        finalizar = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel10 = new javax.swing.JLabel();
        totalDescontoTaxa = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        labEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        panelBorder6 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder7 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        spIngredients = new javax.swing.JScrollPane();
        ingredients = new javax.swing.JList<>();
        panelBorder8 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder9 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        tabDrinks = new br.ifsp.edu.pep.view.swing.Table();
        spTable1 = new javax.swing.JScrollPane();
        tabPizzas = new br.ifsp.edu.pep.view.swing.Table();
        jLabel22 = new javax.swing.JLabel();
        panelRemove = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder13 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        confirmarValor2 = new javax.swing.JLabel();
        panelBorder14 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder15 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        confirmarValor3 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(239, 239, 239));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Itens do pedido");

        jLabel1.setText("Cliente");

        txtClient.setForeground(new java.awt.Color(127, 127, 127));
        txtClient.setText("Clique para selecionar");
        txtClient.setBorder(null);
        txtClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtClientMouseClicked(evt);
            }
        });

        labEntregador.setText("Entregador");

        txtDeliveryMan.setForeground(new java.awt.Color(127, 127, 127));
        txtDeliveryMan.setText("Clique para selecionar");
        txtDeliveryMan.setBorder(null);
        txtDeliveryMan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtDeliveryMan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDeliveryManMouseClicked(evt);
            }
        });

        jLabel5.setText("Data");

        labBairro.setText("Bairro");

        txtBairro.setForeground(new java.awt.Color(127, 127, 127));
        txtBairro.setText("Bairro");
        txtBairro.setBorder(null);
        txtBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBairroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBairroFocusLost(evt);
            }
        });

        panelBorder1.setBackground(new java.awt.Color(204, 204, 204));

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(127, 127, 127));
        jLabel7.setText("Detalhes do Pedido");

        jLabel11.setText("Valor Total dos ITENS");

        jLabel13.setText("R$");

        total.setBorder(null);
        total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabel14.setText("Taxa de entrega");

        jLabel15.setText("R$");

        taxa.setBorder(null);
        taxa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jLabel16.setText("Desconto");

        jLabel17.setText("%");

        desconto.setBorder(null);
        desconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        typeDiscount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Porcentagem", "Dinheiro" }));
        typeDiscount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        typeDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeDiscountActionPerformed(evt);
            }
        });

        jLabel18.setText("Valor dos Itens com Desconto");

        jLabel19.setText("R$");

        totalDesconto.setBorder(null);
        totalDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

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

        totalDescontoTaxa.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        totalDescontoTaxa.setForeground(new java.awt.Color(127, 127, 127));
        totalDescontoTaxa.setText("0.00");

        jLabel24.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(127, 127, 127));
        jLabel24.setText("R$");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ifsp/edu/pep/view/icon/icons8-pizza-100.png"))); // NOI18N

        jLabel26.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(127, 127, 127));
        jLabel26.setText("Valor Final");

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addGroup(panelBorder3Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(desconto)))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator11)
                                    .addGroup(panelBorder3Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(totalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel18)))
                            .addComponent(typeDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(finalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalDescontoTaxa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25)
                                .addGap(15, 15, 15))))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelBorder3Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(total))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder3Layout.createSequentialGroup()
                                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(taxa, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(taxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel26))
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(6, 6, 6)))))
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator9)
                                    .addComponent(jSeparator8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(desconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(totalDescontoTaxa))
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
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
                .addGap(1, 1, 1))
        );

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(127, 127, 127));
        jLabel3.setText("R$");

        labelTotal.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(127, 127, 127));
        labelTotal.setText("0.00");

        labEndereco.setText("Endereço");

        txtEndereco.setForeground(new java.awt.Color(127, 127, 127));
        txtEndereco.setText("Endereço");
        txtEndereco.setBorder(null);
        txtEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEnderecoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEnderecoFocusLost(evt);
            }
        });

        jLabel21.setText("Responsável");

        txtUser.setEditable(false);
        txtUser.setForeground(new java.awt.Color(127, 127, 127));
        txtUser.setText("nome");
        txtUser.setBorder(null);

        panelBorder6.setBackground(new java.awt.Color(204, 204, 204));

        panelBorder7.setBackground(new java.awt.Color(255, 255, 255));

        spIngredients.setBorder(null);

        ingredients.setForeground(new java.awt.Color(102, 102, 102));
        spIngredients.setViewportView(ingredients);

        javax.swing.GroupLayout panelBorder7Layout = new javax.swing.GroupLayout(panelBorder7);
        panelBorder7.setLayout(panelBorder7Layout);
        panelBorder7Layout.setHorizontalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(spIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder7Layout.setVerticalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(spIngredients)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout panelBorder6Layout = new javax.swing.GroupLayout(panelBorder6);
        panelBorder6.setLayout(panelBorder6Layout);
        panelBorder6Layout.setHorizontalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder6Layout.setVerticalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBorder8.setBackground(new java.awt.Color(204, 204, 204));

        panelBorder9.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        tabDrinks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Preço", "Tipo", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabDrinks.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tabDrinks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tabDrinks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabDrinksMouseClicked(evt);
            }
        });
        spTable.setViewportView(tabDrinks);

        spTable1.setBackground(new java.awt.Color(255, 255, 255));
        spTable1.setBorder(null);

        tabPizzas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Tamanho", "Preço", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabPizzas.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tabPizzas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tabPizzas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPizzasMouseClicked(evt);
            }
        });
        spTable1.setViewportView(tabPizzas);

        javax.swing.GroupLayout panelBorder9Layout = new javax.swing.GroupLayout(panelBorder9);
        panelBorder9.setLayout(panelBorder9Layout);
        panelBorder9Layout.setHorizontalGroup(
            panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(spTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBorder9Layout.setVerticalGroup(
            panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBorder8Layout = new javax.swing.GroupLayout(panelBorder8);
        panelBorder8.setLayout(panelBorder8Layout);
        panelBorder8Layout.setHorizontalGroup(
            panelBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        panelBorder8Layout.setVerticalGroup(
            panelBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder8Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        jLabel22.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(127, 127, 127));
        jLabel22.setText("Ingredientes");

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

        panelBorder14.setBackground(new java.awt.Color(153, 153, 153));

        panelBorder15.setBackground(new java.awt.Color(255, 255, 255));

        confirmarValor3.setBackground(new java.awt.Color(255, 255, 255));
        confirmarValor3.setText("Adicionar Item");
        confirmarValor3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmarValor3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmarValor3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder15Layout = new javax.swing.GroupLayout(panelBorder15);
        panelBorder15.setLayout(panelBorder15Layout);
        panelBorder15Layout.setHorizontalGroup(
            panelBorder15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(confirmarValor3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder15Layout.setVerticalGroup(
            panelBorder15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(confirmarValor3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder14Layout = new javax.swing.GroupLayout(panelBorder14);
        panelBorder14.setLayout(panelBorder14Layout);
        panelBorder14Layout.setHorizontalGroup(
            panelBorder14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        panelBorder14Layout.setVerticalGroup(
            panelBorder14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder14Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(labEntregador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDeliveryMan, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                        .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addComponent(labEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jSeparator4)))
                            .addGroup(panelBorder2Layout.createSequentialGroup()
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtClient, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                    .addComponent(jSeparator1))
                                .addGap(18, 18, 18)
                                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator3)
                                    .addGroup(panelBorder2Layout.createSequentialGroup()
                                        .addComponent(labBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtBairro)))))
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(panelBorder8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBorder6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotal)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(panelBorder14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labEndereco, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21))
                        .addGap(6, 6, 6)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addComponent(labEntregador)
                        .addGap(6, 6, 6)
                        .addComponent(txtDeliveryMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder2Layout.createSequentialGroup()
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panelRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelBorder14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        insertSell();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void clearView() {
        this.deliveryMan = null;
        this.client = null;
        this.drinks.clear();
        this.pizzas.clear();

        updateTables();

        this.labelTotal.setText("0.00");

        calcularTotal();

        calcFields();

        this.txtEndereco.setText("Endereço");
        this.txtEndereco.setForeground(new Color(127, 127, 127));

        this.txtBairro.setText("Bairro");
        this.txtBairro.setForeground(new Color(127, 127, 127));

        DefaultListModel model = new DefaultListModel();

        this.ingredients.setModel(model);

        this.panelRemove.setVisible(false);
    }

    private void insertSell() {
        if (this.deliveryMan != null) {
            if (!this.txtEndereco.getText().equals("Endereço")) {
                if (!this.txtBairro.getText().equals("Bairro")) {
                    if (!this.drinks.isEmpty() || !this.pizzas.isEmpty()) {
                        Entrega entrega = new Entrega(this.client, "EM PREPARO", this.txtEndereco.getText(), this.txtBairro.getText(), ((Number) this.taxa.getValue()).doubleValue(), this.deliveryMan);

                        Venda venda;

                        if (this.pizzas.isEmpty()) {
                            venda = new Venda(CaixaDAO.caixa, new Date(), totalVenda, ((Number) this.desconto.getValue()).doubleValue(), "EM ENTREGA");
                        } else {
                            venda = new Venda(CaixaDAO.caixa, new Date(), totalVenda, ((Number) this.desconto.getValue()).doubleValue(), "EM PREPARO");
                        }

                        venda.setPizzas(this.pizzas);
                        venda.setBebidas(this.drinks);
                        venda.setEntrega(entrega);

                        this.controleVenda.insert(venda);

                        if (this.pizzas.isEmpty()) {
                            Notification notification = new Notification(null, true, "Pedido Confirmado", "O pedido foi confirmado e encaminhado à entrega.", false);
                            notification.setVisible(true);
                        } else {
                            Notification notification = new Notification(null, true, "Pedido Confirmado", "O pedido foi confirmado e encaminhado ao Pizzaiolo.", false);
                            notification.setVisible(true);
                        }

                        txtDeliveryMan.setText("Clique para selecionar");
                        txtClient.setText("Clique para selecionar");
                        txtDeliveryMan.setForeground(new Color(127, 127, 127));
                        txtClient.setForeground(new Color(127, 127, 127));

                        clearView();

                        Controller.dashboard.updateTable();
                        Controller.pizzaMaker.updateTable();
                        Controller.drink.updateTable();

                        Controller.deliveryReport.updateTableFromAnotherView();

                    } else {
                        Notification notification = new Notification(null, true, "Selecione Itens", "Você deve inserir os itens deste pedido.", false);
                        notification.setVisible(true);
                    }
                } else {
                    Notification notification = new Notification(null, true, "Coloque o Bairro", "Você deve inserir o bairro para concluir a ação.", false);
                    notification.setVisible(true);
                    this.labBairro.setForeground(Color.red);
                }
            } else {
                Notification notification = new Notification(null, true, "Coloque o Endereço", "Você deve inserir o endereço para concluir a ação.", false);
                notification.setVisible(true);
                this.labEndereco.setForeground(Color.red);
            }
        } else {
            Notification notification = new Notification(null, true, "Selecione entregador", "Você deve selecionar um entregador para concluir a ação.", false);
            notification.setVisible(true);
            this.labEntregador.setForeground(Color.red);
        }
    }

    private void finalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarMouseClicked
        insertSell();
    }//GEN-LAST:event_finalizarMouseClicked

    private void confirmarValor2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarValor2MouseClicked
        if (this.tabPizzas.isFocusable()) {
            if (this.tabPizzas.getSelectedRow() != -1) {
                this.pizzas.remove(tabPizzas.getSelectedRow());
                DefaultListModel model = new DefaultListModel();
                this.ingredients.setModel(model);
            }
        } else {
            if (this.tabDrinks.getSelectedRow() != -1) {
                this.drinks.remove(this.tabDrinks.getSelectedRow());
            }
        }
        updateTables();
        calcFields();
    }//GEN-LAST:event_confirmarValor2MouseClicked

    private void confirmarValor3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarValor3MouseClicked
        SelectItem view = new SelectItem(null, true);
        view.setPizzas(pizzas);
        view.setDrinks(drinks);
        view.setVisible(true);
        updateTables();

        if (!pizzas.isEmpty() || !drinks.isEmpty()) {
            panelRemove.setVisible(true);
            panelBorder13.setVisible(true);
            confirmarValor2.setVisible(true);
            calcularTotal();
        }
    }//GEN-LAST:event_confirmarValor3MouseClicked

    private void tabDrinksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDrinksMouseClicked
        tabPizzas.setFocusable(false);
        tabDrinks.setFocusable(true);
        tabDrinks.requestFocus();
        clearSelectedPizzasTable();
    }//GEN-LAST:event_tabDrinksMouseClicked

    private void txtEnderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnderecoFocusGained
        this.labEndereco.setForeground(Color.black);
        if (txtEndereco.getText().equals("Endereço")) {
            txtEndereco.setText("");
            txtEndereco.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtEnderecoFocusGained

    private void txtEnderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnderecoFocusLost
        if (txtEndereco.getText().equals("")) {
            txtEndereco.setText("Endereço");
            txtEndereco.setForeground(new Color(127, 127, 127));
        }
    }//GEN-LAST:event_txtEnderecoFocusLost

    private void finalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_finalizarMouseEntered

    private void finalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_finalizarMouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel10MouseExited

    private void txtBairroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBairroFocusGained
        this.labBairro.setForeground(Color.black);
        if (txtBairro.getText().equals("Bairro")) {
            txtBairro.setText("");
            txtBairro.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtBairroFocusGained

    private void txtBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBairroFocusLost
        if (txtBairro.getText().equals("")) {
            txtBairro.setText("Bairro");
            txtBairro.setForeground(new Color(127, 127, 127));
        }
    }//GEN-LAST:event_txtBairroFocusLost

    private void txtDeliveryManMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDeliveryManMouseClicked
        SelectDeliveryMan view = new SelectDeliveryMan(null, true);
        view.setVisible(true);
        if (view.getDeliveryMan() != null) {
            deliveryMan = view.getDeliveryMan();
            txtDeliveryMan.setText(deliveryMan.getNome());
            this.txtDeliveryMan.setForeground(Color.black);
        }
        txtDeliveryMan.setFocusable(true);
    }//GEN-LAST:event_txtDeliveryManMouseClicked

    private void txtClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClientMouseClicked
        SelectClient view = new SelectClient(null, true);
        view.setVisible(true);
        if (view.getClient() != null) {
            client = view.getClient();
            txtClient.setText(client.getNome());
            this.txtClient.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtClientMouseClicked

    private void typeDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeDiscountActionPerformed
        if (typeDiscount.getSelectedIndex() == 0) {
            jLabel17.setText("%");
        } else {
            jLabel17.setText("R$");
        }
    }//GEN-LAST:event_typeDiscountActionPerformed

    private void tabPizzasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPizzasMouseClicked
        tabDrinks.setFocusable(false);
        tabPizzas.setFocusable(true);
        tabPizzas.requestFocus();

        clearSelectedDrinksTable();

        DefaultListModel model = new DefaultListModel();

        for (IngredientePizza i : pizzas.get(tabPizzas.getSelectedRow()).getPizza().getIngredientes()) {
            model.addElement(i.getIngrediente().getNome());
        }

        ingredients.setModel(model);
    }//GEN-LAST:event_tabPizzasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel confirmarValor2;
    private javax.swing.JLabel confirmarValor3;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JFormattedTextField desconto;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient finalizar;
    private javax.swing.JList<String> ingredients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel labBairro;
    private javax.swing.JLabel labEndereco;
    private javax.swing.JLabel labEntregador;
    private javax.swing.JLabel labelTotal;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder1;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder13;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder14;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder15;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder2;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder3;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder6;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder7;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder8;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder9;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelRemove;
    private javax.swing.JScrollPane spIngredients;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable1;
    private br.ifsp.edu.pep.view.swing.Table tabDrinks;
    private br.ifsp.edu.pep.view.swing.Table tabPizzas;
    private javax.swing.JFormattedTextField taxa;
    private javax.swing.JFormattedTextField total;
    private javax.swing.JFormattedTextField totalDesconto;
    private javax.swing.JLabel totalDescontoTaxa;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtClient;
    private javax.swing.JTextField txtDeliveryMan;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtUser;
    private javax.swing.JComboBox<String> typeDiscount;
    // End of variables declaration//GEN-END:variables
public class Update implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            calcFields();
        }

    }

}
