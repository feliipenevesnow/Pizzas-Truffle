package br.ifsp.edu.pep.view.main;

import br.ifsp.edu.pep.dao.CaixaDAO;
import br.ifsp.edu.pep.dao.UsuarioDAO;
import br.ifsp.edu.pep.model.Caixa;
import br.ifsp.edu.pep.model.Usuario;
import br.ifsp.edu.pep.view.event.EventMenuSelected;
import br.ifsp.edu.pep.view.form.Sale;
import br.ifsp.edu.pep.view.form.Buy;
import br.ifsp.edu.pep.view.form.BuyReport;
import br.ifsp.edu.pep.view.form.CashRegister;
import br.ifsp.edu.pep.view.form.CashRegisterReport;
import br.ifsp.edu.pep.view.form.Client;
import br.ifsp.edu.pep.view.form.DeliveryMan;
import br.ifsp.edu.pep.view.form.DeliveryReport;
import br.ifsp.edu.pep.view.form.Drink;
import br.ifsp.edu.pep.view.form.Expense;
import br.ifsp.edu.pep.view.form.FormDontFound;
import br.ifsp.edu.pep.view.form.Form_Home;
import br.ifsp.edu.pep.view.form.Ingredient;
import br.ifsp.edu.pep.view.form.PizzaMaker;
import br.ifsp.edu.pep.view.form.Pizzas;
import br.ifsp.edu.pep.view.form.Profile;
import br.ifsp.edu.pep.view.form.Report;
import br.ifsp.edu.pep.view.form.SaleReport;
import br.ifsp.edu.pep.view.form.Supplier;
import br.ifsp.edu.pep.view.form.User;
import br.ifsp.edu.pep.view.jdialog.Login;
import br.ifsp.edu.pep.view.jdialog.OpenCashRegister;
import br.ifsp.edu.pep.view.util.Controller;
import java.awt.Color;
import java.util.List;
import javax.swing.JComponent;

public class Main extends javax.swing.JFrame {

    private Form_Home home;
    private Sale saleView;
    private Buy buyView;
    private CashRegister cashRegisterView;
    private Report reportView;
    private Supplier suplierView;
    private Client clienteView;
    private Pizzas pizza = new Pizzas();
    private Drink drinkView;
    private DeliveryMan deliveryManView;
    private User userView;
    private Profile profileView;
    private FormDontFound notFoundView;
    private BuyReport buyReportView;
    private DeliveryReport deliveryReportView;
    private SaleReport sellReportView;
    private CashRegisterReport cashRegisterReportView;
    private Ingredient ingredienteView;
    private PizzaMaker pizzaMakerView;
    private Expense expenseView;

    private Login login;

    private String notFoundFormTxt;

    public void setNotFoundForm(String notFoundForm) {
        this.notFoundFormTxt = notFoundForm;
    }

    public Main() {

        initComponents();

        login = new Login(this, true);

        login.setVisible(true);

        if (UsuarioDAO.user != null) {

            initView();
            setBackground(new Color(0, 0, 0, 0));
            checkCashRegister();

            menu.init();
            Usuario usuario = UsuarioDAO.user;
            saleView.setUser();
            menu.setUser();
            menu.initMoving(Main.this);
            menu.addEventMenuSelected(new EventMenuSelected() {
                @Override
                public void selected(int index) {
                    switch (index) {
                        case 0:
                            setForm(home);
                            break;
                        case 1:
                            if (CaixaDAO.caixa.getDataFechamento() == null) {
                                if (!usuario.getCargo().equals("Pizzaiolo")) {
                                    setForm(saleView);
                                } else if (usuario.getCargo().equals("Gerente")) {
                                    setForm(pizzaMakerView);
                                }
                            } else {
                                setForm(cashRegisterView);
                            }
                            break;
                        case 2:
                            if (CaixaDAO.caixa.getDataFechamento() == null) {
                                if (!usuario.getCargo().equals("Atendente")) {
                                    setForm(buyView);
                                } else {
                                    setForm(reportView);
                                }
                            } else {
                                setForm(reportView);
                            }
                            break;
                        case 3:
                            if (CaixaDAO.caixa.getDataFechamento() == null) {
                                if (!usuario.getCargo().equals("Pizzaiolo")) {
                                    setForm(cashRegisterView);
                                } else if (usuario.getCargo().equals("Gerente")) {
                                    setForm(profileView);
                                }
                            } else {
                                setForm(profileView);
                            }
                            break;
                        case 4:
                            if (!usuario.getCargo().equals("Atendente")) {
                                setForm(expenseView);
                            } else {
                                setForm(clienteView);
                            }
                            break;
                        case 5:
                            setForm(reportView);
                            break;
                        case 6:
                            setForm(pizza);
                            break;
                        case 7:
                            if (!usuario.getCargo().equals("Atendente")) {
                                setForm(suplierView);
                            } else {
                                setForm(drinkView);
                            }
                            break;
                        case 8:
                            if (!usuario.getCargo().equals("Atendente")) {
                                setForm(clienteView);
                            } else {
                                setForm(deliveryManView);
                            }
                            break;
                        case 9:
                            setForm(ingredienteView);
                            break;
                        case 10:
                            setForm(pizza);
                            break;
                        case 11:
                            if (!usuario.getCargo().equals("Atendente")) {
                                setForm(drinkView);
                            } else {
                                setForm(profileView);
                            }
                            break;
                        case 12:
                            setForm(deliveryManView);
                            break;
                        case 13:
                            setForm(userView);
                            break;
                        case 14:
                            setForm(ingredienteView);
                            break;
                        case 15:
                            setForm(pizzaMakerView);
                            break;
                        case 17:
                            setForm(profileView);
                            break;
                    }
                }

            });

            search(0);

            header2.setMain(this);
            reportView.setMain(this);

            cashRegisterView.uploadFields();

            Controller controller = new Controller(home, pizzaMakerView, drinkView, cashRegisterView, menu, cashRegisterReportView, deliveryReportView, sellReportView, buyReportView);
            Controller.dashboard.updateTable();
            Controller.dashboard.updateCards();
            Controller.cash.updateTable();

            buyView.setTxtUser();

            deliveryReportView.updateTable();
            cashRegisterReportView.updateTable();
            sellReportView.updateTable();
            buyReportView.updateTable();
        }

    }

    private void checkCashRegister() {
        CaixaDAO control = new CaixaDAO();
        List<Caixa> caixa = control.findOpenCashRegister();
        if (caixa.isEmpty()) {
            OpenCashRegister view = new OpenCashRegister(this, true);
            view.setVisible(true);
        } else {

            control.setCaixa(caixa.get(0));

        }
    }

    public void search(int index) {
        switch (index) {
            case 0:
                setForm(home);
                break;
            case 1:
                setForm(saleView);
                break;
            case 2:
                setForm(buyView);
                break;
            case 3:
                setForm(cashRegisterView);
                break;
            case 4:
                setForm(expenseView);
                break;
            case 5:
                setForm(reportView);
                break;
            case 7:
                setForm(suplierView);
                break;
            case 8:
                setForm(clienteView);
                break;
            case 10:
                setForm(pizza);
                break;
            case 11:
                setForm(drinkView);
                break;
            case 12:
                setForm(deliveryManView);
                break;
            case 13:
                setForm(userView);
                break;
            case 14:
                setForm(ingredienteView);
                break;
            case 15:
                setForm(pizzaMakerView);
                break;
            case 17:
                setForm(profileView);
                break;
            case 18:
                setForm(buyReportView);
                break;
            case 19:
                setForm(deliveryReportView);
                break;
            case 20:
                setForm(sellReportView);
                break;
            case 21:
                setForm(cashRegisterReportView);
                break;
            case 22:
                notFoundView.getDontFound().setText(notFoundFormTxt);
                setForm(notFoundView);
                break;
        }
    }

    private void initView() {
        home = new Form_Home();
        saleView = new Sale();
        buyView = new Buy();
        cashRegisterView = new CashRegister();
        reportView = new Report();
        suplierView = new Supplier();
        clienteView = new Client();
        drinkView = new Drink();
        deliveryManView = new DeliveryMan();
        userView = new User();
        profileView = new Profile();
        notFoundView = new FormDontFound();
        buyReportView = new BuyReport();
        deliveryReportView = new DeliveryReport();
        sellReportView = new SaleReport();
        cashRegisterReportView = new CashRegisterReport();
        ingredienteView = new Ingredient();
        pizzaMakerView = new PizzaMaker();
        expenseView = new Expense();
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        menu = new br.ifsp.edu.pep.view.component.Menu();
        header2 = new br.ifsp.edu.pep.view.component.Header();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(239, 239, 239));

        header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.ifsp.edu.pep.view.component.Header header2;
    private javax.swing.JPanel mainPanel;
    private br.ifsp.edu.pep.view.component.Menu menu;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
