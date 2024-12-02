/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Conta;
import Model.Lancamento;
import Model.Despesa;
import Model.Receita;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 * Classe que representa a interface gráfica para exibição e manipulação do
 * extrato de uma conta. A classe permite visualizar lançamentos,
 * importar/exportar dados de lançamentos, filtrar por categoria ou período,
 * além de exibir um balanço geral das receitas e despesas.
 *
 * Funcionalidades principais:
 * - Exibição de receitas e despesas.
 * - Filtros por tipo de lançamento (Receitas, Despesas ou Todos).
 * - Filtros por período de datas.
 * - Importação e exportação de lançamentos em arquivos CSV.
 * - Exibição de balanço geral das finanças.
 *
 */
public class FConta extends javax.swing.JFrame {

    private ArrayList<Lancamento> lancamentos;
    private Conta conta = new Conta(null);

    /**
     * Creates new form FLancamento
     */
    public FConta(ArrayList<Lancamento> lancamentos) {
        this.lancamentos = conta.getLancamentos();
        initComponents();

        if (conta.getTitular() == null) {
            lbNomeTitular.setVisible(false);
            lbIconeTitular.setVisible(false);
        }
    }

    /**
     * Atualiza as informações do extrato com base em uma conta específica.
     *
     * @param conta Conta cujas informações serão exibidas no extrato.
     */
    public void acessarConta(Conta conta) {
        this.conta = conta;
        this.lancamentos = conta.getLancamentos();
        lbNomeTitular.setText(conta.getTitular().getNome());
        lbNomeTitular.setVisible(true);
        lbIconeTitular.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btExtrato = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbTotal = new javax.swing.JTable();
        lbValorBalancoGeral = new javax.swing.JLabel();
        lbTotBalandoGeral = new javax.swing.JLabel();
        btFechar = new javax.swing.JButton();
        lbTotReceita = new javax.swing.JLabel();
        lbValorReceita = new javax.swing.JLabel();
        lbValorDespesa = new javax.swing.JLabel();
        lbTotDespesa = new javax.swing.JLabel();
        btRemoverLancamento = new javax.swing.JButton();
        btExportaCSV = new javax.swing.JButton();
        btLancamento = new javax.swing.JButton();
        btImportaCSV = new javax.swing.JButton();
        lbNomeTitular = new javax.swing.JLabel();
        lbIconeTitular = new javax.swing.JLabel();
        cbTabelaTipo = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        lbTotReceita1 = new javax.swing.JLabel();
        lbTotReceita2 = new javax.swing.JLabel();
        cbTabelaPeriodo = new javax.swing.JComboBox<>();
        edDataInicio = new javax.swing.JFormattedTextField();
        lbData = new javax.swing.JLabel();
        lbData1 = new javax.swing.JLabel();
        edDataFinal = new javax.swing.JFormattedTextField();

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        btExtrato.setBackground(new java.awt.Color(102, 102, 102));
        btExtrato.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btExtrato.setForeground(new java.awt.Color(255, 255, 255));
        btExtrato.setText("Extrato");
        btExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExtratoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("BALANÇO GERAL");

        tbTotal.setBackground(new java.awt.Color(102, 102, 102));
        tbTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tbTotal.setForeground(new java.awt.Color(255, 255, 255));
        tbTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Valor", "Data", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbTotal.setEnabled(false);
        jScrollPane3.setViewportView(tbTotal);

        lbValorBalancoGeral.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbValorBalancoGeral.setForeground(new java.awt.Color(255, 255, 255));
        lbValorBalancoGeral.setText("R$ 0,00");

        lbTotBalandoGeral.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTotBalandoGeral.setForeground(new java.awt.Color(255, 255, 255));
        lbTotBalandoGeral.setText("Total Balanço Geral:");

        btFechar.setBackground(new java.awt.Color(102, 102, 102));
        btFechar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btFechar.setForeground(new java.awt.Color(255, 255, 255));
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        lbTotReceita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTotReceita.setForeground(new java.awt.Color(255, 255, 255));
        lbTotReceita.setText("Total Receita:");

        lbValorReceita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbValorReceita.setForeground(new java.awt.Color(51, 231, 39));
        lbValorReceita.setText("R$ 0,00");

        lbValorDespesa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbValorDespesa.setForeground(new java.awt.Color(185, 27, 11));
        lbValorDespesa.setText("R$ 0,00");

        lbTotDespesa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTotDespesa.setForeground(new java.awt.Color(255, 255, 255));
        lbTotDespesa.setText("Total Despesa:");

        btRemoverLancamento.setBackground(new java.awt.Color(102, 102, 102));
        btRemoverLancamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btRemoverLancamento.setForeground(new java.awt.Color(255, 255, 255));
        btRemoverLancamento.setText("Excluir");
        btRemoverLancamento.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btRemoverLancamento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btRemoverLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverLancamentoActionPerformed(evt);
            }
        });

        btExportaCSV.setBackground(new java.awt.Color(102, 102, 102));
        btExportaCSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btExportaCSV.setForeground(new java.awt.Color(255, 255, 255));
        btExportaCSV.setText("Exportar");
        btExportaCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportaCSVActionPerformed(evt);
            }
        });

        btLancamento.setBackground(new java.awt.Color(102, 102, 102));
        btLancamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btLancamento.setForeground(new java.awt.Color(255, 255, 255));
        btLancamento.setText("Gravar");
        btLancamento.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLancamentoActionPerformed(evt);
            }
        });

        btImportaCSV.setBackground(new java.awt.Color(102, 102, 102));
        btImportaCSV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btImportaCSV.setForeground(new java.awt.Color(255, 255, 255));
        btImportaCSV.setText("Importar");
        btImportaCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImportaCSVActionPerformed(evt);
            }
        });

        lbNomeTitular.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNomeTitular.setForeground(new java.awt.Color(255, 255, 255));
        lbNomeTitular.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNomeTitular.setToolTipText("");

        lbIconeTitular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icones/iconeTitular.png"))); // NOI18N

        cbTabelaTipo.setBackground(new java.awt.Color(255, 255, 255));
        cbTabelaTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbTabelaTipo.setForeground(new java.awt.Color(0, 0, 0));
        cbTabelaTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Receita", "Despesa" }));
        cbTabelaTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTabelaTipoActionPerformed(evt);
            }
        });

        lbTotReceita1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTotReceita1.setForeground(new java.awt.Color(255, 255, 255));
        lbTotReceita1.setText("Categoria :");

        lbTotReceita2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTotReceita2.setForeground(new java.awt.Color(255, 255, 255));
        lbTotReceita2.setText("Periodo :");

        cbTabelaPeriodo.setBackground(new java.awt.Color(255, 255, 255));
        cbTabelaPeriodo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbTabelaPeriodo.setForeground(new java.awt.Color(0, 0, 0));
        cbTabelaPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Periodo", "Data Atual", "Por Data" }));
        cbTabelaPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTabelaPeriodoActionPerformed(evt);
            }
        });

        edDataInicio.setBackground(new java.awt.Color(255, 255, 255));
        edDataInicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 5));
        edDataInicio.setForeground(new java.awt.Color(0, 0, 0));
        try {
            edDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edDataInicio.setAlignmentX(0.0F);
        edDataInicio.setMinimumSize(new java.awt.Dimension(66, 22));
        edDataInicio.setPreferredSize(new java.awt.Dimension(66, 22));

        lbData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbData.setForeground(new java.awt.Color(255, 255, 255));
        lbData.setText("até");

        lbData1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbData1.setForeground(new java.awt.Color(255, 255, 255));
        lbData1.setText("Inicio :");

        edDataFinal.setBackground(new java.awt.Color(255, 255, 255));
        edDataFinal.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 5));
        edDataFinal.setForeground(new java.awt.Color(0, 0, 0));
        try {
            edDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edDataFinal.setAlignmentX(0.0F);
        edDataFinal.setMinimumSize(new java.awt.Dimension(66, 22));
        edDataFinal.setPreferredSize(new java.awt.Dimension(66, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbTotReceita1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbTotReceita2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbData1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(edDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbTabelaPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbTabelaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNomeTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbIconeTitular))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(39, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbTotDespesa)
                                .addGap(53, 53, 53)
                                .addComponent(lbValorDespesa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btImportaCSV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btExportaCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRemoverLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbTotBalandoGeral)
                                        .addGap(26, 26, 26)
                                        .addComponent(lbValorBalancoGeral)
                                        .addGap(6, 6, 6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbTotReceita)
                                        .addGap(57, 57, 57)
                                        .addComponent(lbValorReceita)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(305, 305, 305))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIconeTitular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTotReceita1)
                        .addComponent(cbTabelaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbNomeTitular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotReceita2)
                    .addComponent(cbTabelaPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbData)
                    .addComponent(lbData1)
                    .addComponent(edDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbValorReceita)
                            .addComponent(lbTotReceita))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbValorDespesa)
                            .addComponent(lbTotDespesa)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExportaCSV)
                        .addComponent(btImportaCSV)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValorBalancoGeral)
                    .addComponent(lbTotBalandoGeral)
                    .addComponent(btExtrato))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btFechar)
                    .addComponent(btRemoverLancamento)
                    .addComponent(btLancamento))
                .addGap(71, 71, 71))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTabelaPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTabelaPeriodoActionPerformed
        atualizarTabela(lancamentos);
    }//GEN-LAST:event_cbTabelaPeriodoActionPerformed

// ---------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Filtra os lançamentos exibidos na tabela com base no tipo selecionado 
     * (Todos, Receita ou Despesa).
     *
     */
    private void cbTabelaTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTabelaTipoActionPerformed
        atualizarTabela(lancamentos);
    }//GEN-LAST:event_cbTabelaTipoActionPerformed

// ---------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Botão para importar lançamentos de um arquivo CSV.
     *
     * @throws IOException se ocorrer um erro ao ler o arquivo.
     */
    private void btImportaCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImportaCSVActionPerformed
        String arquivo = conta.getTitular().getNome().toLowerCase() + ".txt";
        
        try {
            int totalImportados = conta.importarLancamentosParaTXT(arquivo);
            JOptionPane.showMessageDialog(this, "<html><b>" + totalImportados + " lançamentos importados com sucesso!<b><html>", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (IOException ex) {            
            JOptionPane.showMessageDialog(this, "<html><b>Erro ao importar lançamentos:<br>" + ex.getMessage() + "<b><html>", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        }         
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "<html><b>Erro inesperado ao importar:<br>" + ex.getMessage() + "<b><html>", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        }             
        atualizarTabela(lancamentos);
    }//GEN-LAST:event_btImportaCSVActionPerformed

// ---------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Exporta os lançamentos da conta para um arquivo CSV.
     *
     * @throws IOException se ocorrer um erro durante a exportação.
     * @throws IllegalStateException se não houver lançamentos para exportar.
     */
    private void btLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLancamentoActionPerformed
        FLancamento telaLancamento = new FLancamento(lancamentos, conta, this, true);
        telaLancamento.setVisible(true);
    }//GEN-LAST:event_btLancamentoActionPerformed

// --------------------------------------------------------------------------------------------------------------------------------------- 
    /**
     * Botão para exportar lançamentos para um arquivo CSV.
     *
     * @param evt Evento acionado pelo botão.
     */
    private void btExportaCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportaCSVActionPerformed
        String arquivo = conta.getTitular().getNome().toLowerCase() + ".txt";
        
        try {             
            if (conta.getLancamentos().isEmpty()) {
                JOptionPane.showMessageDialog(this, "<html><b>Não há lançamentos para exportar!<b><html>", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                conta.exportarLancamentosParaTXT(arquivo);
                JOptionPane.showMessageDialog(this, "<html><b>Todos os dados exportados com sucesso!<b><html>", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        catch (IOException ex) {            
            JOptionPane.showMessageDialog(this, "<html><b>Erro ao exportar os dados para o arquivo!<b><html>", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btExportaCSVActionPerformed

// --------------------------------------------------------------------------------------------------------------------------------------- 
    /**
     * Abre a tela de exclusão de lançamento financeiro.
     *
     */
    private void btRemoverLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverLancamentoActionPerformed
        FLancamento telaLancamento = new FLancamento(lancamentos, conta, this, false);
        telaLancamento.setVisible(true);
    }//GEN-LAST:event_btRemoverLancamentoActionPerformed

// --------------------------------------------------------------------------------------------------------------------------------------- 
    /**
     * Ação acionada ao clicar no botão "Fechar". Fecha a janela atual de forma
     * segura e libera os recursos.
     *
     */
    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

// --------------------------------------------------------------------------------------------------------------------------------------- 
    /**
     * Ação para abrir a tela de relatório.
     *
     */
    private void btExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExtratoActionPerformed
        FExtrato relatorio = new FExtrato(this, true);
        relatorio.exportarRelatorio(conta);
        relatorio.setVisible(true);
    }//GEN-LAST:event_btExtratoActionPerformed

// ---------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Atualiza a tabela de lançamentos com base nos filtros aplicados (tipo e
     * período).
     *
     * @param lancamentos Lista de lançamentos para exibir na tabela.
     */
    public void atualizarTabela(ArrayList<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
        ArrayList<Lancamento> lancamentosFiltrados = new ArrayList<>();
        DefaultTableModel modelTotal = (DefaultTableModel) tbTotal.getModel();
        modelTotal.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        double totalDespesas = 0;
        double totalReceitas = 0;
        String tipoCategoria = (String) cbTabelaTipo.getSelectedItem();
        String tipoPeriodo = (String) cbTabelaPeriodo.getSelectedItem();
        LocalDate dataInicio = null;
        LocalDate dataFinal = null;

        if ("Sem Periodo".equals(tipoPeriodo)) {
            for (Lancamento lancamento : conta.getLancamentos()) {
                if ("Receita".equals(tipoCategoria) && lancamento instanceof Receita) {
                    lancamentosFiltrados.add(lancamento);
                } else if ("Despesa".equals(tipoCategoria) && lancamento instanceof Despesa) {
                    lancamentosFiltrados.add(lancamento);
                } else if ("Todos".equals(tipoCategoria)) {
                    lancamentosFiltrados.add(lancamento);
                }
            }
        }

        if ("Data Atual".equals(tipoPeriodo)) {
            for (Lancamento lancamento : conta.consultarSaldoDataAtual()) {
                if ("Receita".equals(tipoCategoria) && lancamento instanceof Receita) {
                    lancamentosFiltrados.add(lancamento);
                } else if ("Despesa".equals(tipoCategoria) && lancamento instanceof Despesa) {
                    lancamentosFiltrados.add(lancamento);
                } else if ("Todos".equals(tipoCategoria)) {
                    lancamentosFiltrados.add(lancamento);
                }
            }
        }

        if ("Por Data".equals(tipoPeriodo)) {
            try {
                dataInicio = LocalDate.parse(edDataInicio.getText(), formatter);
                dataFinal = LocalDate.parse(edDataFinal.getText(), formatter);
                if (dataFinal.isBefore(dataInicio)) {
                    JOptionPane.showMessageDialog(this, "<html><b>Data final não pode ser anterior à data inicial!<b><html>", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                for (Lancamento lancamento : conta.consultarSaldoPeriodoEspecifico(dataInicio, dataFinal)) {
                    if ("Receita".equals(tipoCategoria) && lancamento instanceof Receita) {
                        lancamentosFiltrados.add(lancamento);
                    } else if ("Despesa".equals(tipoCategoria) && lancamento instanceof Despesa) {
                        lancamentosFiltrados.add(lancamento);
                    } else if ("Todos".equals(tipoCategoria)) {
                        lancamentosFiltrados.add(lancamento);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "<html><b>Data inválida! Use o formato dd/MM/yyyy.<b><html>", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        for (Lancamento lancamento : lancamentosFiltrados) {
            Object[] rowData = {
                lancamento.getId(),
                lancamento.getValor(),
                lancamento.getData().format(formatter),
                lancamento instanceof Receita ? ((Receita) lancamento).getCategoria()
                : lancamento instanceof Despesa ? ((Despesa) lancamento).getCategoria()
                : null
            };

            modelTotal.addRow(rowData);

            if (lancamento instanceof Receita) {
                totalReceitas += lancamento.getValor();
            } else if (lancamento instanceof Despesa) {
                totalDespesas += lancamento.getValor();
            }
        }

        lbValorDespesa.setText(String.format("R$ %.2f", totalDespesas));
        lbValorReceita.setText(String.format("R$ %.2f", totalReceitas));
        lbValorBalancoGeral.setText(String.format("R$ %.2f", totalReceitas - totalDespesas));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExportaCSV;
    private javax.swing.JButton btExtrato;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btImportaCSV;
    private javax.swing.JButton btLancamento;
    private javax.swing.JButton btRemoverLancamento;
    private javax.swing.JComboBox<String> cbTabelaPeriodo;
    private javax.swing.JComboBox<String> cbTabelaTipo;
    private javax.swing.JFormattedTextField edDataFinal;
    private javax.swing.JFormattedTextField edDataInicio;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbData1;
    private javax.swing.JLabel lbIconeTitular;
    private javax.swing.JLabel lbNomeTitular;
    private javax.swing.JLabel lbTotBalandoGeral;
    private javax.swing.JLabel lbTotDespesa;
    private javax.swing.JLabel lbTotReceita;
    private javax.swing.JLabel lbTotReceita1;
    private javax.swing.JLabel lbTotReceita2;
    private javax.swing.JLabel lbValorBalancoGeral;
    private javax.swing.JLabel lbValorDespesa;
    private javax.swing.JLabel lbValorReceita;
    private javax.swing.JTable tbTotal;
    // End of variables declaration//GEN-END:variables
}
