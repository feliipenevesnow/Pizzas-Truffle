package br.ifsp.edu.pep.view.jdialog;

import br.ifsp.edu.pep.dao.BebidaDAO;
import br.ifsp.edu.pep.dao.IngredienteDAO;
import br.ifsp.edu.pep.model.Bebida;
import br.ifsp.edu.pep.model.BebidaCompra;
import br.ifsp.edu.pep.model.Ingrediente;
import br.ifsp.edu.pep.model.IngredienteCompra;
import br.ifsp.edu.pep.view.jdialog.Notification;
import br.ifsp.edu.pep.view.swing.ScrollBar;
import br.ifsp.edu.pep.view.swing.Table;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class SelectBuy extends javax.swing.JDialog {

    private Point point = new Point();
    private IngredienteDAO controlIngrediente = new IngredienteDAO();
    private BebidaDAO controlBebida = new BebidaDAO();
    private List<Ingrediente> listIngrediente = new ArrayList<>();
    private List<Bebida> listBebida = new ArrayList<>();
    private Color cleanTextColor = new Color(153, 153, 153);
    private List<Ingrediente> selectedList = new ArrayList<>();

    private ArrayList<IngredienteCompra> ingredientes = new ArrayList<>();
    private ArrayList<BebidaCompra> bebidas = new ArrayList<>();

    public SelectBuy(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        updateTable();
        clear.setVisible(false);
        setBackground(new Color(0, 0, 0, 0));
        moveView();
        initTable();
    }

    public List<Ingrediente> getSelectedList() {
        return selectedList;
    }

    public Table getTabelaIngrediente() {
        return TabelaIngrediente;
    }

    public void setIngredientes(ArrayList<IngredienteCompra> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setBebidas(ArrayList<BebidaCompra> bebidas) {
        this.bebidas = bebidas;
    }

    private void updateTable() {
        listIngrediente = controlIngrediente.findAll(Ingrediente.class);
        listBebida = controlBebida.findAll(Bebida.class);
        insertTableIngredient();
        insertTableDrinks();
    }

    private void insertTableIngredient() {
        DefaultTableModel model = (DefaultTableModel) TabelaIngrediente.getModel();
        model.setNumRows(0);

        for (Ingrediente obj : listIngrediente) {
            Object objTable[] = {obj.getNome()};
            model.addRow(objTable);
        }
    }

    private void insertTableDrinks() {
        DefaultTableModel model = (DefaultTableModel) TabelaBebida.getModel();
        model.setNumRows(0);

        for (Bebida obj : listBebida) {
            Object objTable[] = {obj.getNome()};
            model.addRow(objTable);
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
        spTable1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

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
        int[] selectedRows = TabelaIngrediente.getSelectedRows();
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
        confirm1 = new br.ifsp.edu.pep.view.swing.PanelBorderGradient();
        jLabel10 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        TabelaIngrediente = new br.ifsp.edu.pep.view.swing.Table();
        jLabel2 = new javax.swing.JLabel();
        panelBorder8 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder9 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        spTable1 = new javax.swing.JScrollPane();
        TabelaBebida = new br.ifsp.edu.pep.view.swing.Table();
        jLabel6 = new javax.swing.JLabel();
        panelBorder3 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        panelBorder7 = new br.ifsp.edu.pep.view.swing.PanelBorder();
        itensCompra = new javax.swing.JLabel();

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
        search.setText("Pesquise ingrediente por nome ...");
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
        confirmarValor.setText("Ingredientes Selecionados");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        confirmLayout.setVerticalGroup(
            confirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cancelar");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout confirm1Layout = new javax.swing.GroupLayout(confirm1);
        confirm1.setLayout(confirm1Layout);
        confirm1Layout.setHorizontalGroup(
            confirm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirm1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        confirm1Layout.setVerticalGroup(
            confirm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        TabelaIngrediente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaIngrediente.setSelectionBackground(new java.awt.Color(255, 255, 255));
        TabelaIngrediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaIngredienteMouseClicked(evt);
            }
        });
        spTable.setViewportView(TabelaIngrediente);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Ingredientes");

        panelBorder8.setBackground(new java.awt.Color(153, 153, 153));
        panelBorder8.setPreferredSize(new java.awt.Dimension(2, 149));

        javax.swing.GroupLayout panelBorder8Layout = new javax.swing.GroupLayout(panelBorder8);
        panelBorder8.setLayout(panelBorder8Layout);
        panelBorder8Layout.setHorizontalGroup(
            panelBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBorder8Layout.setVerticalGroup(
            panelBorder8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );

        panelBorder9.setBackground(new java.awt.Color(153, 153, 153));
        panelBorder9.setPreferredSize(new java.awt.Dimension(1, 149));

        javax.swing.GroupLayout panelBorder9Layout = new javax.swing.GroupLayout(panelBorder9);
        panelBorder9.setLayout(panelBorder9Layout);
        panelBorder9Layout.setHorizontalGroup(
            panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        panelBorder9Layout.setVerticalGroup(
            panelBorder9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );

        spTable1.setBackground(new java.awt.Color(255, 255, 255));
        spTable1.setBorder(null);

        TabelaBebida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaBebida.setSelectionBackground(new java.awt.Color(255, 255, 255));
        TabelaBebida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaBebidaMouseClicked(evt);
            }
        });
        spTable1.setViewportView(TabelaBebida);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(127, 127, 127));
        jLabel6.setText("Bebidas");

        panelBorder3.setBackground(new java.awt.Color(153, 153, 153));

        panelBorder7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBorder7Layout = new javax.swing.GroupLayout(panelBorder7);
        panelBorder7.setLayout(panelBorder7Layout);
        panelBorder7Layout.setHorizontalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itensCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder7Layout.setVerticalGroup(
            panelBorder7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(itensCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(panelBorder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(panelBorder7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(confirm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2))
                                    .addGroup(panelBorder1Layout.createSequentialGroup()
                                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panelBorder9, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(spTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder1Layout.createSequentialGroup()
                    .addGap(399, 399, 399)
                    .addComponent(panelBorder8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(404, Short.MAX_VALUE)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBorder9, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(spTable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBorder1Layout.createSequentialGroup()
                    .addGap(166, 166, 166)
                    .addComponent(panelBorder8, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addGap(167, 167, 167)))
        );

        javax.swing.GroupLayout panelBorderGradient1Layout = new javax.swing.GroupLayout(panelBorderGradient1);
        panelBorderGradient1.setLayout(panelBorderGradient1Layout);
        panelBorderGradient1Layout.setHorizontalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        panelBorderGradient1Layout.setVerticalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Timer timer = new Timer(100, new Update());
        timer.start();
    }//GEN-LAST:event_formWindowOpened

    private void TabelaIngredienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaIngredienteMouseClicked
        Ingrediente ingredient = listIngrediente.get(TabelaIngrediente.getSelectedRow());

        IndicateQuantityBuy view = new IndicateQuantityBuy(null, true);

        view.setIngredient(ingredient.getNome());
        view.setIngredientes(ingredientes);
        IngredienteCompra ingr = new IngredienteCompra(ingredient, null, 0, 0);
        view.setIngrediente(ingr);
        view.verificarIngrediente();
        view.setVisible(true);

        if (!view.isCancel()) {
            if (this.itensCompra.getText().equals("")) {
                this.itensCompra.setText(ingredient.getNome() + " " + view.getSelectedQuantity() + " Uni");
            } else {
                this.itensCompra.setText(this.itensCompra.getText() + ", " + ingredient.getNome() + " " + view.getSelectedQuantity() + " Uni");
            }

            if (view.isPreco()) {

                IngredienteCompra ingrediente = new IngredienteCompra(ingredient, view.getSelectedQuantity(), 0);
                if (ingredientes.contains(ingrediente)) {
                    for (IngredienteCompra i : ingredientes) {
                        if (i.getIngrediente().equals(ingredient)) {
                            i.setQuantidade(i.getQuantidade() + view.getSelectedQuantity());
                        }
                    }
                } else {

                    ingredientes.add(ingrediente);
                }
            } else {
                String valor = view.getPreco();
                valor = valor.replaceAll(",", ".");
                IngredienteCompra ingrediente = new IngredienteCompra(ingredient, view.getSelectedQuantity(), Double.parseDouble(valor));
                if (ingredientes.contains(ingrediente)) {
                    for (IngredienteCompra i : ingredientes) {
                        if (i.getIngrediente().equals(ingredient)) {
                            i.setQuantidade(i.getQuantidade() + view.getSelectedQuantity());
                        }
                    }
                } else {

                    ingredientes.add(ingrediente);
                }
            }
        }
    }//GEN-LAST:event_TabelaIngredienteMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        if (TabelaIngrediente.getSelectedRow() == -1 && TabelaBebida.getSelectedRow() == -1) {
            Notification notification = new Notification(null, true, "Selecione um ou mais ingredientes ou bebidas", "Você deve selecionar um ou mais ingredientes ou bebidas para concluir a ação.", false);
            notification.setVisible(true);
        } else {
            dispose();
        }

    }//GEN-LAST:event_jLabel9MouseClicked

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked
        clear.setVisible(false);
        search.setText("Pesquise ingrediente por nome ...");
        search.setForeground(cleanTextColor);
        jLabel1.requestFocus();
        updateTable();
    }//GEN-LAST:event_clearMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (!search.getText().equals("Pesquise ingrediente por nome ...")) {
            listIngrediente = controlIngrediente.findByName(search.getText());
            listBebida = controlBebida.findByName(search.getText());
            insertTableIngredient();
            insertTableDrinks();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed

        listIngrediente = controlIngrediente.findByName(search.getText());
        listBebida = controlBebida.findByName(search.getText());
        System.out.println(listBebida);
        System.out.println(listIngrediente);
        insertTableIngredient();
        insertTableDrinks();
    }//GEN-LAST:event_searchKeyPressed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        if (search.getText().equals("")) {
            clear.setVisible(false);
            search.setText("Pesquise ingrediente por nome ...");
            search.setForeground(cleanTextColor);
        }
    }//GEN-LAST:event_searchFocusLost

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        if (search.getText().equals("Pesquise ingrediente por nome ...")) {
            clear.setVisible(true);
            search.setText("");
            search.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchFocusGained

    private void TabelaBebidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaBebidaMouseClicked

        Bebida drink = listBebida.get(TabelaBebida.getSelectedRow());

        IndicateQuantityBuy view = new IndicateQuantityBuy(null, true);
        view.setIngredient(drink.getNome());

        view.setBebidas(bebidas);
        BebidaCompra drin = new BebidaCompra(null, drink, 0, 0);
        view.setBebeida(drin);
        view.verificarBebidas();

        view.setVisible(true);

        if (!view.isCancel()) {

            if (this.itensCompra.getText().equals("")) {
                this.itensCompra.setText(drink.getNome() + " " + view.getSelectedQuantity() + " Uni");
            } else {
                this.itensCompra.setText(this.itensCompra.getText() + ", " + drink.getNome() + " " + view.getSelectedQuantity() + " Uni");
            }

            if (view.isPreco()) {

                BebidaCompra drinks = new BebidaCompra(drink, view.getSelectedQuantity(), 0);
                if (bebidas.contains(drinks)) {
                    for (BebidaCompra b : bebidas) {
                        b.setQuantidade(b.getQuantidade() + view.getSelectedQuantity());
                    }
                } else {
                    bebidas.add(drinks);
                }
            } else {
                String valor = view.getPreco();
                valor = valor.replaceAll(",", ".");
                BebidaCompra drinks = new BebidaCompra(drink, view.getSelectedQuantity(), Double.parseDouble(valor));
                if (bebidas.contains(drinks)) {
                    for (BebidaCompra b : bebidas) {
                        b.setQuantidade(b.getQuantidade() + view.getSelectedQuantity());
                    }
                } else {
                    bebidas.add(drinks);
                }
            }
        }
    }//GEN-LAST:event_TabelaBebidaMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectBuy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectBuy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectBuy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectBuy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectBuy dialog = new SelectBuy(new javax.swing.JFrame(), true);
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
    private br.ifsp.edu.pep.view.swing.Table TabelaBebida;
    private br.ifsp.edu.pep.view.swing.Table TabelaIngrediente;
    private javax.swing.JLabel clear;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient confirm;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient confirm1;
    private javax.swing.JLabel confirmarValor;
    private javax.swing.JLabel itensCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
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
    private br.ifsp.edu.pep.view.swing.PanelBorder panelBorder9;
    private br.ifsp.edu.pep.view.swing.PanelBorderGradient panelBorderGradient1;
    private javax.swing.JTextField search;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable1;
    // End of variables declaration//GEN-END:variables

    public class Update implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (selectedList == null) {
                number.setText("0");
            } else {
                number.setText(String.valueOf(selectedList.size()));
            }
        }

    }

}
