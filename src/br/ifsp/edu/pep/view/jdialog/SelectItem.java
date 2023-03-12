package br.ifsp.edu.pep.view.jdialog;

import br.ifsp.edu.pep.dao.BebidaDAO;
import br.ifsp.edu.pep.dao.PizzaDAO;
import br.ifsp.edu.pep.model.Bebida;
import br.ifsp.edu.pep.model.BebidaVenda;
import br.ifsp.edu.pep.model.Pizza;
import br.ifsp.edu.pep.model.PizzaVenda;
import br.ifsp.edu.pep.view.swing.ScrollBar;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class SelectItem extends javax.swing.JDialog {

    private Point point = new Point();

    private BebidaDAO drinkDAO = new BebidaDAO();
    private PizzaDAO pizzaDAO = new PizzaDAO();

    private List<Bebida> listDrink = new ArrayList<>();
    private List<Pizza> listPizza = new ArrayList<>();

    private List<BebidaVenda> drinks = new ArrayList<>();
    private List<PizzaVenda> pizzas = new ArrayList<>();

    private Color cleanTextColor = new Color(153, 153, 153);

    public SelectItem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        clear.setVisible(false);
        setBackground(new Color(0, 0, 0, 0));
        initTable();
        initList();
        moveView();
        listDrink = drinkDAO.findAll(Bebida.class);
        listPizza = pizzaDAO.findAll(Pizza.class);
        updateTables();
    }

    public void setDrinks(List<BebidaVenda> drinks) {
        this.drinks = drinks;
    }

    public void setPizzas(List<PizzaVenda> pizzas) {
        this.pizzas = pizzas;
    }

    private void updateTables() {
        DefaultTableModel drinksModel = (DefaultTableModel) tabDrinks.getModel();
        DefaultTableModel pizzasModel = (DefaultTableModel) tabPizzas.getModel();

        drinksModel.setNumRows(0);
        pizzasModel.setNumRows(0);

        for (Bebida b : listDrink) {
            Object obj[] = {b.getNome(), b.getPreco(), "Bebida", b.getQuantidade()};
            drinksModel.addRow(obj);
        }
        for (Pizza p : listPizza) {
            Object obj[] = {p.getNome(), "Pizza"};
            pizzasModel.addRow(obj);
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

    private void initList() {
        spIngredients.setVerticalScrollBar(new ScrollBar());
        spIngredients.getVerticalScrollBar().setBackground(Color.WHITE);
        spIngredients.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spIngredients.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }

    private void moveView() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (!e.isMetaDown()) {
                    point.x = e.getX();
                    point.y = e.getY();
                }
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (!e.isMetaDown() && point.y <= 17) {
                    Point p = getLocation();
                    setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
                }
            }
        });
    }

    private int countSelectedIngredient() {
        int[] selectedRows = tabDrinks.getSelectedRows();
        int cont = 0;
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                cont++;
            }
        }
        return cont;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorderGradient1 = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        panelBorder1 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder4 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder2 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        clear = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        panelBorder5 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder6 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        confirmarValor = new javax.swing.JLabel();
        number = new javax.swing.JLabel();
        confirm = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel9 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tabDrinks = new br.ifsp.edu.pep.view.swing.Table();
        jLabel2 = new javax.swing.JLabel();
        panelBorder3 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder7 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        spIngredients = new javax.swing.JScrollPane();
        itens = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        spTable1 = new javax.swing.JScrollPane();
        tabPizzas = new br.ifsp.edu.pep.view.swing.Table();
        panelBorder8 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        panelBorder4.setBackground(new java.awt.Color(204, 204, 204));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        search.setForeground(new java.awt.Color(153, 153, 153));
        search.setText("Pesquise itens por nome ...");
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

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(clear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBorder4Layout = new javax.swing.GroupLayout(panelBorder4);
        panelBorder4.setLayout(panelBorder4Layout);
        panelBorder4Layout.setHorizontalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder4Layout.setVerticalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 78, 146));
        jLabel3.setText("Selecionar");

        panelBorder5.setBackground(new java.awt.Color(153, 153, 153));

        panelBorder6.setBackground(new java.awt.Color(255, 255, 255));

        confirmarValor.setBackground(new java.awt.Color(255, 255, 255));
        confirmarValor.setForeground(new java.awt.Color(153, 153, 153));
        confirmarValor.setText("Itens Selecionados");

        number.setForeground(new java.awt.Color(153, 153, 153));
        number.setText("0");

        javax.swing.GroupLayout panelBorder6Layout = new javax.swing.GroupLayout(panelBorder6);
        panelBorder6.setLayout(panelBorder6Layout);
        panelBorder6Layout.setHorizontalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(number)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmarValor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder6Layout.setVerticalGroup(
            panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(confirmarValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelBorder5Layout = new javax.swing.GroupLayout(panelBorder5);
        panelBorder5.setLayout(panelBorder5Layout);
        panelBorder5Layout.setHorizontalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        panelBorder5Layout.setVerticalGroup(
            panelBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panelBorder6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Confirmar");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout confirmLayout = new javax.swing.GroupLayout(confirm);
        confirm.setLayout(confirmLayout);
        confirmLayout.setHorizontalGroup(
            confirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );
        confirmLayout.setVerticalGroup(
            confirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        tabDrinks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Preço", "Tipo", "Estoque"
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
        tabDrinks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabDrinksMouseClicked(evt);
            }
        });
        spTable.setViewportView(tabDrinks);
        if (tabDrinks.getColumnModel().getColumnCount() > 0) {
            tabDrinks.getColumnModel().getColumn(3).setHeaderValue("Estoque");
        }

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Pizzas");

        panelBorder3.setBackground(new java.awt.Color(153, 153, 153));

        panelBorder7.setBackground(new java.awt.Color(255, 255, 255));

        spIngredients.setBorder(null);

        itens.setForeground(new java.awt.Color(102, 102, 102));
        spIngredients.setViewportView(itens);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(127, 127, 127));
        jLabel4.setText("Escolhidos");

        javax.swing.GroupLayout panelBorder7Layout = new javax.swing.GroupLayout(panelBorder7);
        panelBorder7.setLayout(panelBorder7Layout);
        panelBorder7Layout.setHorizontalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spIngredients)
                    .addGroup(panelBorder7Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder7Layout.setVerticalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                .addComponent(panelBorder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(panelBorder7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        spTable1.setBackground(new java.awt.Color(255, 255, 255));
        spTable1.setBorder(null);

        tabPizzas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabPizzas.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tabPizzas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPizzasMouseClicked(evt);
            }
        });
        spTable1.setViewportView(tabPizzas);

        panelBorder8.setBackground(new java.awt.Color(153, 153, 153));
        panelBorder8.setPreferredSize(new java.awt.Dimension(2, 149));

        javax.swing.GroupLayout panelBorder8Layout = new javax.swing.GroupLayout(panelBorder8);
        panelBorder8.setLayout(panelBorder8Layout);
        panelBorder8Layout.setHorizontalGroup(
            panelBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        panelBorder8Layout.setVerticalGroup(
            panelBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(127, 127, 127));
        jLabel5.setText("Bebidas");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(panelBorder3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder1Layout.createSequentialGroup()
                                    .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorder1Layout.createSequentialGroup()
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(panelBorder1Layout.createSequentialGroup()
                                            .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(panelBorder8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(spTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder8, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(spTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(spTable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout panelBorderGradient1Layout = new javax.swing.GroupLayout(panelBorderGradient1);
        panelBorderGradient1.setLayout(panelBorderGradient1Layout);
        panelBorderGradient1Layout.setHorizontalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderGradient1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        panelBorderGradient1Layout.setVerticalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorderGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        if (search.getText().equals("Pesquise itens por nome ...")) {
            clear.setVisible(true);
            search.setText("");
            search.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        if (search.getText().equals("")) {
            clear.setVisible(false);
            search.setText("Pesquise itens por nome ...");
            search.setForeground(cleanTextColor);
        }
    }//GEN-LAST:event_searchFocusLost

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed

        if (!search.getText().equals("Pesquise itens por nome ...")) {
            listDrink = drinkDAO.findByName(search.getText());
            listPizza = pizzaDAO.findByName(search.getText());
            updateTables();
        }

    }//GEN-LAST:event_searchKeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        listDrink = drinkDAO.findAll(Bebida.class);
        listPizza = pizzaDAO.findAll(Pizza.class);
        updateTables();
        search.setText("Pesquise itens por nome ...");
        search.setForeground(new Color(153, 153, 153));
        clear.requestFocus();
    }//GEN-LAST:event_clearMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void updateList() {
        DefaultListModel model = new DefaultListModel();

        if (!this.drinks.isEmpty()) {
            for (BebidaVenda b : this.drinks) {
                model.addElement(b.getBebida().getNome() + " " + b.getQuantidade() + " Uni.");
            }
        }

        if (!this.pizzas.isEmpty()) {
            for (PizzaVenda p : this.pizzas) {
                model.addElement(p.getPizza().getNome() + " " + p.getQuantidade() + " Uni.");
            }
        }

        this.itens.setModel(model);
    }

    private void tabDrinksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDrinksMouseClicked
        Bebida bebida = this.listDrink.get(tabDrinks.getSelectedRow());

        BebidaVenda itemBebida = null;

        for (BebidaVenda bv : this.drinks) {
            if (bv.getBebida().equals(bebida)) {
                itemBebida = bv;
            }
        }

        if (itemBebida != null) {
            IndicateQuantityDrink view = new IndicateQuantityDrink(null, true);
            view.setDrink(bebida);
            view.setItemQuantity(itemBebida.getQuantidade());
            view.setVisible(true);
            if (!view.isCancel()) {
                itemBebida.setQuantidade(itemBebida.getQuantidade() + view.getSelectedQuantity());
            }
        } else {
            IndicateQuantityDrink view = new IndicateQuantityDrink(null, true);
            view.setDrink(bebida);
            view.setVisible(true);

            if (!view.isCancel()) {
                BebidaVenda bv = new BebidaVenda(bebida, view.getSelectedQuantity(), view.getSelectedQuantity() * bebida.getPreco());
                this.drinks.add(bv);
            }

        }

        updateList();

    }//GEN-LAST:event_tabDrinksMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void tabPizzasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPizzasMouseClicked
        Pizza pizza = this.listPizza.get(tabPizzas.getSelectedRow());

        PizzaVenda itemPizza = null;

        for (PizzaVenda bv : this.pizzas) {
            if (bv.getPizza().equals(pizza)) {
                itemPizza = bv;
            }
        }

        if (itemPizza != null) {
            IndicateQuantityPizza view = new IndicateQuantityPizza(null, true);
            view.setPizza(pizza);
            view.setItemQuantity(itemPizza.getQuantidade());
            view.setVisible(true);

            if (!view.isCancel()) {
                itemPizza.setQuantidade(itemPizza.getQuantidade() + view.getSelectedQuantity());
            }
        } else {
            IndicateQuantityPizza view = new IndicateQuantityPizza(null, true);
            view.setPizza(pizza);
            view.setVisible(true);

            if (!view.isCancel()) {
                PizzaVenda bv = new PizzaVenda(pizza, view.getBorda(), view.getSelectedQuantity(), view.getSelectedQuantity() * pizza.getPreco(), view.getDescricao());
                this.pizzas.add(bv);
            }
        }

        updateList();
    }//GEN-LAST:event_tabPizzasMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectItem dialog = new SelectItem(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clear;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient confirm;
    private javax.swing.JLabel confirmarValor;
    private javax.swing.JList<String> itens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel number;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder1;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder2;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder3;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder4;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder5;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder6;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder7;
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder8;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient panelBorderGradient1;
    private javax.swing.JTextField search;
    private javax.swing.JScrollPane spIngredients;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable1;
    private br.ifsp.edu.pep.view.swing.Table tabDrinks;
    private br.ifsp.edu.pep.view.swing.Table tabPizzas;
    // End of variables declaration//GEN-END:variables

}
