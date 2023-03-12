package br.ifsp.edu.pep.view.form;

import br.ifsp.edu.pep.dao.CaixaDAO;
import br.ifsp.edu.pep.dao.CompraDAO;
import br.ifsp.edu.pep.dao.MovimentacaoDAO;
import br.ifsp.edu.pep.dao.PagarEntregadorDAO;
import br.ifsp.edu.pep.dao.VendaDAO;
import br.ifsp.edu.pep.model.Caixa;
import br.ifsp.edu.pep.model.Movimentacao;
import br.ifsp.edu.pep.model.PagarEntregador;
import br.ifsp.edu.pep.model.Venda;
import br.ifsp.edu.pep.view.jdialog.ConfirmWithPassword;
import br.ifsp.edu.pep.view.jdialog.Movement;
import br.ifsp.edu.pep.view.jdialog.Notification;
import br.ifsp.edu.pep.view.jdialog.ViewPagarEntregador;
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

public class CashRegister extends javax.swing.JPanel {

    private CaixaDAO controlCaixa = new CaixaDAO();
    private MovimentacaoDAO controlMovimentacao = new MovimentacaoDAO();

    public CashRegister() {
        initComponents();
        initTable();
    }

    public void updateTable() {
        if (CaixaDAO.caixa != null) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            model.setNumRows(0);

            double allBloodletting = 0, allSupplementation = 0;
            int qtdBloodletting = 0, qtdSupplementation = 0;

            for (Movimentacao m : controlMovimentacao.findByCash(CaixaDAO.caixa)) {
                if (m.getTipo() == 0) {
                    Object obj[] = {m.getMotivo(), "R$ " + m.getValor(), "Sangria"};
                    model.addRow(obj);

                    allBloodletting = allBloodletting + m.getValor();
                    qtdBloodletting = qtdBloodletting + 1;
                } else {
                    Object obj[] = {m.getMotivo(), "R$ " + m.getValor(), "Suplementação"};
                    model.addRow(obj);

                    allSupplementation = allSupplementation + m.getValor();
                    qtdSupplementation = qtdSupplementation + 1;
                }
            }

            this.allBloodletting.setValue(allBloodletting);
            this.qtdBloodletting.setValue(qtdBloodletting);

            this.allSupplementation.setValue(allSupplementation);
            this.qtdSupplementation.setValue(qtdSupplementation);

            uploadFields();
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

    public void uploadFields() {
        if (CaixaDAO.caixa != null) {
            CompraDAO controlCompra = new CompraDAO();

            VendaDAO controlVenda = new VendaDAO();

            int qtd_sell, qtd_buy;

            qtd_sell = (int) controlVenda.countSell(CaixaDAO.caixa.getDataAbertura());
            qtd_buy = (int) controlCompra.countBuy(CaixaDAO.caixa.getDataAbertura());

            this.jSpinner2.setValue(qtd_sell);
            this.jSpinner4.setValue(qtd_buy);

            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

            SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm:ss");

            this.dateOpen.setText(formatDate.format(CaixaDAO.caixa.getDataAbertura()));
            this.timeOpen.setText(formatTime.format(CaixaDAO.caixa.getHorarioAbertura()));

            if (CaixaDAO.caixa.getValorFinal() != null) {
                this.amount.setValue(CaixaDAO.caixa.getValorFinal());
            }

            this.initialValue.setValue(CaixaDAO.caixa.getValorInicial());

            this.amount.setValue(CaixaDAO.caixa.getValorFinal());

            if (CaixaDAO.caixa.getValorFinal() < 0) {
                this.amount.setForeground(new Color(255, 0, 0));
            } else if (CaixaDAO.caixa.getValorFinal() > 0) {
                this.amount.setForeground(new Color(0, 153, 51));
            } else {
                this.amount.setForeground(new Color(0, 0, 0));
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder1 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder3 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        movimentacao = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        allSupplementation = new javax.swing.JFormattedTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        allBloodletting = new javax.swing.JFormattedTextField();
        jSeparator19 = new javax.swing.JSeparator();
        qtdBloodletting = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        qtdSupplementation = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        finalizar1 = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel24 = new javax.swing.JLabel();
        dateOpen = new javax.swing.JTextField();
        timeOpen = new javax.swing.JTextField();
        initialValue = new javax.swing.JFormattedTextField();
        jLabel35 = new javax.swing.JLabel();
        amount = new javax.swing.JFormattedTextField();
        jLabel36 = new javax.swing.JLabel();
        panelBorder5 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        spTable = new javax.swing.JScrollPane();
        table = new br.ifsp.edu.pep.view.swing.Table();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0));

        panelBorder2.setBackground(new java.awt.Color(239, 239, 239));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(127, 127, 127));
        jLabel7.setText("Detalhes do Caixa");

        jLabel11.setText("Data de Abertura");

        jLabel14.setText("Valor Inicial");

        movimentacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                movimentacaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                movimentacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                movimentacaoMouseExited(evt);
            }
        });
        movimentacao.setLayout(new java.awt.FlowLayout());

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Movimentações do Caixa");
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
        movimentacao.add(jLabel10);

        jLabel12.setText("Horário de Abertura");

        jLabel17.setText("Valor Total");

        jLabel22.setText("Quantidade de Vendas");

        jLabel26.setText("Quantidade de Compras");

        jLabel28.setText("Quantidade de Movimentações Suplementação");

        jLabel25.setText("Quantidade de Movimentações Sangria");

        jLabel31.setText("Valor Suplementação");

        jLabel32.setText("R$");

        allSupplementation.setBorder(null);
        allSupplementation.setForeground(new java.awt.Color(0, 153, 51));
        allSupplementation.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        allSupplementation.setText("0");
        allSupplementation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allSupplementationActionPerformed(evt);
            }
        });

        jLabel33.setText("Valor Sangria");

        jLabel34.setText("R$");

        allBloodletting.setBorder(null);
        allBloodletting.setForeground(new java.awt.Color(255, 0, 0));
        allBloodletting.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        allBloodletting.setText("0");
        allBloodletting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allBloodlettingActionPerformed(evt);
            }
        });

        qtdBloodletting.setModel(new javax.swing.SpinnerNumberModel());
        qtdBloodletting.setBorder(null);

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel());
        jSpinner2.setBorder(null);

        qtdSupplementation.setModel(new javax.swing.SpinnerNumberModel());
        qtdSupplementation.setBorder(null);

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel());
        jSpinner4.setBorder(null);

        finalizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finalizar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finalizar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                finalizar1MouseExited(evt);
            }
        });
        finalizar1.setLayout(new java.awt.FlowLayout());

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Fechar Caixa");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });
        finalizar1.add(jLabel24);

        dateOpen.setBorder(null);

        timeOpen.setBorder(null);

        initialValue.setBorder(null);
        initialValue.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        initialValue.setText("0");
        initialValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initialValueActionPerformed(evt);
            }
        });

        jLabel35.setText("R$");

        amount.setBorder(null);
        amount.setForeground(new java.awt.Color(0, 153, 51));
        amount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        amount.setText("0");
        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });

        jLabel36.setText("R$");

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(333, 333, 333))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                .addComponent(dateOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initialValue, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timeOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator15)
                                    .addComponent(jSpinner2)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorder3Layout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator14)
                                            .addComponent(jSpinner4)))
                                    .addGroup(panelBorder3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(29, 29, 29))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder3Layout.createSequentialGroup()
                                    .addComponent(qtdBloodletting, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(qtdSupplementation))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder3Layout.createSequentialGroup()
                                    .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder3Layout.createSequentialGroup()
                                    .addComponent(jLabel25)
                                    .addGap(106, 106, 106)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(139, 139, 139)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(allBloodletting, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(allSupplementation, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(finalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(movimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateOpen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeOpen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addGap(12, 12, 12)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(initialValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(2, 2, 2)
                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator10)
                            .addComponent(jSeparator15))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator11)
                            .addComponent(jSeparator14))))
                .addGap(13, 13, 13)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qtdBloodletting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtdSupplementation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator17)
                            .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel31))
                        .addGap(6, 6, 6)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(allBloodletting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34))
                            .addComponent(jLabel32)
                            .addComponent(allSupplementation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(movimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(finalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator19)
                    .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        panelBorder5.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor", "Tipo"
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

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(127, 127, 127));
        jLabel8.setText("Movimentações");

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                    .addGroup(panelBorder5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(panelBorder2);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        if (CaixaDAO.caixa.getDataFechamento() == null) {
            Movement view = new Movement(null, true);
            view.setVisible(true);
        } else {
            Notification notification = new Notification(null, true, "Atenção", "O caixa deve estar aberto.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered

    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited

    }//GEN-LAST:event_jLabel10MouseExited

    private void movimentacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movimentacaoMouseClicked
        if (CaixaDAO.caixa.getDataFechamento() == null) {
            Movement view = new Movement(null, true);
            view.setVisible(true);
        } else {
            Notification notification = new Notification(null, true, "Atenção", "O caixa deve estar aberto.", false);
            notification.setVisible(true);
        }
    }//GEN-LAST:event_movimentacaoMouseClicked

    private void movimentacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movimentacaoMouseEntered

    }//GEN-LAST:event_movimentacaoMouseEntered

    private void movimentacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_movimentacaoMouseExited

    }//GEN-LAST:event_movimentacaoMouseExited

    private void allBloodlettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allBloodlettingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allBloodlettingActionPerformed

    private void allSupplementationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allSupplementationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allSupplementationActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        ConfirmWithPassword viewConfirm = new ConfirmWithPassword(null, true);
        viewConfirm.setVisible(true);
        if (viewConfirm.isAnswer()) {
            VendaDAO controlSale = new VendaDAO();
            if (controlSale.findInDelivering().isEmpty()) {
                if (CaixaDAO.caixa.getDataFechamento() == null) {
                    List<PagarEntregador> list = new ArrayList();
                    PagarEntregadorDAO control = new PagarEntregadorDAO();
                    list = control.findAll();
                    if (!list.isEmpty()) {
                        ViewPagarEntregador view = new ViewPagarEntregador(null, true);
                        view.setVisible(true);
                    }
                    Caixa caixa = CaixaDAO.caixa;
                    caixa.setDataFechamento(new Date());
                    caixa.setHorarioFechamento(new Date());
                    CaixaDAO controleCaixa = new CaixaDAO();
                    caixa.setValorFinal(caixa.getValorFinal() + caixa.getValorInicial());
                    controleCaixa.update(caixa);
                    Controller.cash.uploadFields();
                    Controller.dashboard.updateCards();
                    Controller.menu.depoisFecharCaixa();
                    Controller.menu.repaint();
                    Controller.cashReport.updateTableFromAnotherView();
                } else {
                    Notification notification = new Notification(null, true, "Atenção", "O caixa deve estar aberto.", false);
                    notification.setVisible(true);
                }
            } else {
                Notification notification = new Notification(null, true, "Atenção", "É necessário encerrar todas as entregas para finalizar o caixa.", false);
                notification.setVisible(true);
            }
        }
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseExited

    private void finalizar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizar1MouseClicked
        ConfirmWithPassword viewConfirm = new ConfirmWithPassword(null, true);
        viewConfirm.setVisible(true);
        if (viewConfirm.isAnswer()) {
            VendaDAO controlSale = new VendaDAO();
            if (controlSale.findInDelivering().isEmpty()) {
                if (CaixaDAO.caixa.getDataFechamento() == null) {
                    List<PagarEntregador> list = new ArrayList();
                    PagarEntregadorDAO control = new PagarEntregadorDAO();
                    list = control.findAll();
                    if (!list.isEmpty()) {
                        ViewPagarEntregador view = new ViewPagarEntregador(null, true);
                        view.setVisible(true);
                    }
                    Caixa caixa = CaixaDAO.caixa;
                    caixa.setDataFechamento(new Date());
                    caixa.setHorarioFechamento(new Date());
                    CaixaDAO controleCaixa = new CaixaDAO();
                    caixa.setValorFinal(caixa.getValorFinal() + caixa.getValorInicial());
                    controleCaixa.update(caixa);
                    Controller.cash.uploadFields();
                    Controller.dashboard.updateCards();
                    Controller.menu.depoisFecharCaixa();
                    Controller.menu.repaint();
                    Controller.cashReport.updateTableFromAnotherView();
                } else {
                    Notification notification = new Notification(null, true, "Atenção", "O caixa deve estar aberto.", false);
                    notification.setVisible(true);
                }
            } else {
                Notification notification = new Notification(null, true, "Atenção", "É necessário encerrar todas as entregas para finalizar o caixa.", false);
                notification.setVisible(true);
            }
        }
    }//GEN-LAST:event_finalizar1MouseClicked

    private void finalizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_finalizar1MouseEntered

    private void finalizar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_finalizar1MouseExited

    private void initialValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initialValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initialValueActionPerformed

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField allBloodletting;
    private javax.swing.JFormattedTextField allSupplementation;
    private javax.swing.JFormattedTextField amount;
    private javax.swing.JTextField dateOpen;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient finalizar1;
    private javax.swing.JFormattedTextField initialValue;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner4;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient movimentacao;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder1;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder2;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder3;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder5;
    private javax.swing.JSpinner qtdBloodletting;
    private javax.swing.JSpinner qtdSupplementation;
    private javax.swing.JScrollPane spTable;
    private br.ifsp.edu.pep.view.swing.Table table;
    private javax.swing.JTextField timeOpen;
    // End of variables declaration//GEN-END:variables
}
