/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.CategoriaDespesa;
import Model.CategoriaReceita;
import Model.Conta;
import Model.Lancamento;
import Model.Despesa;
import Model.Receita;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela interface gráfica de gerenciamento de lançamentos financeiros,
 * permitindo a adição ou exclusão de receitas e despesas em uma conta.
 * 
 * Funcionalidades principais:
 * - Adicionar receitas e despesas com validações de dados.
 * - Excluir lançamentos por ID.
 * - Exibir categorias de receitas e despesas dinamicamente.
 *
 */
public class FLancamento extends javax.swing.JFrame {

    ArrayList<Lancamento> lancamentos = new ArrayList<>();
    private FConta telaExtrato;
    private Conta conta;
    private boolean insere;

    /**
     * Construtor da classe FLancamento. Configura a interface gráfica com base no tipo de ação (inserir ou excluir).
     * 
     * @param lancamentos Lista de lançamentos financeiros associados à conta.
     * @param conta Objeto {@link Conta} que gerencia os lançamentos.
     * @param telaExtrato Tela de extrato a ser atualizada após as operações.
     * @param insere Indica se a ação é para inserir ou excluir lançamentos.
     */
    public FLancamento(ArrayList<Lancamento> lancamentos, Conta conta, FConta telaExtrato, boolean insere) {
        this.lancamentos = lancamentos;
        this.conta = conta;
        this.telaExtrato = telaExtrato;
        this.insere = insere;        
        initComponents();
        
        edData.setVisible(insere);
        edId.setEnabled(!insere);
        edValor.setVisible(insere);
        cbCategoria.setVisible(insere);
        cbTipo.setVisible(insere);
        lbData.setVisible(insere);
        lbTipo.setVisible(insere);
        lbValor.setVisible(insere);
        lbCategoria.setVisible(insere);               
        lbTitulo.setText(insere ? "ADICIONA LANCAMENTO" : "EXCLUI LANCAMENTO");
        
        
        DateTimeFormatter dataBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = LocalDate.now().format(dataBR);
        edData.setText(dataFormatada);
        for (CategoriaReceita receita : CategoriaReceita.values()) {
            cbCategoria.addItem(receita.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btGravar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        cbCategoria = new javax.swing.JComboBox<>();
        cbTipo = new javax.swing.JComboBox<>();
        edData = new javax.swing.JFormattedTextField();
        edValor = new javax.swing.JTextField();
        edId = new javax.swing.JTextField();
        lbID = new javax.swing.JLabel();
        lbValor = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        btGravar.setBackground(new java.awt.Color(102, 102, 102));
        btGravar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btGravar.setForeground(new java.awt.Color(255, 255, 255));
        btGravar.setText("Gravar");
        btGravar.setAlignmentX(0.5F);
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });
        jPanel1.add(btGravar);
        btGravar.setBounds(30, 250, 76, 27);

        btFechar.setBackground(new java.awt.Color(102, 102, 102));
        btFechar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btFechar.setForeground(new java.awt.Color(255, 255, 255));
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        jPanel1.add(btFechar);
        btFechar.setBounds(284, 250, 80, 27);

        cbCategoria.setBackground(new java.awt.Color(255, 255, 255));
        cbCategoria.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(cbCategoria);
        cbCategoria.setBounds(180, 190, 100, 22);

        cbTipo.setBackground(new java.awt.Color(255, 255, 255));
        cbTipo.setForeground(new java.awt.Color(0, 0, 0));
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RECEITA", "DESPESA" }));
        cbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoItemStateChanged(evt);
            }
        });
        jPanel1.add(cbTipo);
        cbTipo.setBounds(180, 160, 100, 22);

        edData.setBackground(new java.awt.Color(255, 255, 255));
        edData.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 5));
        edData.setForeground(new java.awt.Color(0, 0, 0));
        try {
            edData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edData.setAlignmentX(0.0F);
        edData.setMinimumSize(new java.awt.Dimension(66, 22));
        edData.setPreferredSize(new java.awt.Dimension(66, 22));
        edData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edDataActionPerformed(evt);
            }
        });
        jPanel1.add(edData);
        edData.setBounds(180, 130, 80, 22);
        edData.getAccessibleContext().setAccessibleName("");

        edValor.setBackground(new java.awt.Color(255, 255, 255));
        edValor.setForeground(new java.awt.Color(0, 0, 0));
        edValor.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 5));
        edValor.setPreferredSize(new java.awt.Dimension(66, 22));
        jPanel1.add(edValor);
        edValor.setBounds(180, 96, 80, 22);

        edId.setBackground(new java.awt.Color(255, 255, 255));
        edId.setForeground(new java.awt.Color(0, 0, 0));
        edId.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 2, 5));
        edId.setPreferredSize(new java.awt.Dimension(66, 22));
        jPanel1.add(edId);
        edId.setBounds(180, 60, 80, 22);

        lbID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbID.setForeground(new java.awt.Color(255, 255, 255));
        lbID.setText("ID :");
        jPanel1.add(lbID);
        lbID.setBounds(140, 60, 19, 16);

        lbValor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbValor.setForeground(new java.awt.Color(255, 255, 255));
        lbValor.setText("Valor :");
        jPanel1.add(lbValor);
        lbValor.setBounds(120, 100, 40, 16);

        lbData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbData.setForeground(new java.awt.Color(255, 255, 255));
        lbData.setText(" Data :");
        jPanel1.add(lbData);
        lbData.setBounds(120, 130, 40, 16);

        lbTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTipo.setForeground(new java.awt.Color(255, 255, 255));
        lbTipo.setText("Tipo:");
        jPanel1.add(lbTipo);
        lbTipo.setBounds(130, 160, 30, 16);

        lbCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lbCategoria.setText("Categoria:");
        jPanel1.add(lbCategoria);
        lbCategoria.setBounds(100, 190, 60, 16);

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbTitulo);
        lbTitulo.setBounds(120, 10, 180, 20);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

// ---------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Método chamado ao clicar no botão "Fechar". Retorna à tela de extrato e atualiza a tabela.
     * 
     * @param evt Evento acionado pelo botão.
     */
    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        telaExtrato.atualizarTabela(lancamentos);
        this.dispose();
        telaExtrato.setVisible(true);
    }//GEN-LAST:event_btFecharActionPerformed

// --------------------------------------------------------------------------------------------------------------------------------------- 
    /**
     * Método chamado ao clicar no botão "Gravar". Realiza a ação de adicionar ou excluir lançamentos.
     * 
     * Para adicionar:
     * - Valida os dados fornecidos (valor, data, tipo e categoria).
     * - Insere o lançamento na conta.
     * 
     * Para excluir:
     * - Verifica se o ID informado existe.
     * - Remove o lançamento associado ao ID.
     * 
     */
    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        int Id = 0;        
        
        // se for pra adicionar
        if (this.insere){ 
            Id = conta.getMaiorId();
            edId.setText(String.valueOf(Id)); //revisar no front
            System.out.println("Id gerado: " + Id);
            String tipoSelecionado = (String) cbTipo.getSelectedItem();
            double valor;            
            String textoData = edData.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data;            
            try {   
                data = LocalDate.parse(textoData, formatter);   
                valor = Double.parseDouble(edValor.getText());
                if (valor <= 0) {
                    throw new IllegalArgumentException("<html><b>Valor do lançamento não pode ser igual a zero ou negativo<b><html>");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "<html><b>Erro: O valor deve ser um número válido.<b><html>", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, "<html><b>Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "<html><b>Data inválida! Use o formato dd/MM/yyyy.<b><html>", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if ("RECEITA".equals(tipoSelecionado)) {
                CategoriaReceita categoriaReceita = CategoriaReceita.valueOf(cbCategoria.getSelectedItem().toString());
                
                Receita novaReceita = new Receita(Id, categoriaReceita, valor, data);
                
                conta.incluirLancamento(novaReceita);
                JOptionPane.showMessageDialog(this, "<html><b>Receita registrada com sucesso!<b><html>", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else if ("DESPESA".equals(tipoSelecionado)) {
                CategoriaDespesa categoriaDespesa = CategoriaDespesa.valueOf(cbCategoria.getSelectedItem().toString());
                Despesa novaDespesa = new Despesa(Id, categoriaDespesa, valor, data);
                conta.incluirLancamento(novaDespesa);
                JOptionPane.showMessageDialog(this, "<html><b>Despesa registrada com sucesso!<b><html>", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        // se for pra excluir
        else{            
            try { 
                Id = Integer.parseInt(edId.getText());
                if (conta.lancamentoExiste(Id)) {
                    conta.excluirLancamentoPorId(Id);
                    String arquivo = "lancamentos.txt";
                    conta.exportarLancamentosParaTXT(arquivo);

                    JOptionPane.showMessageDialog(this, "<html><b>Lancamento ID: " + Id + " removido com sucesso!<b><html>", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "<html><b>Erro: Lançamento ID: " + Id + " não encontrado.<b><html>", "Erro", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "<html><b>Erro: ID inválido. Por favor, insira um número válido.<b><html>", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "<html><b>Erro ao exportar os lançamentos para o arquivo.<b><html>", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "<html><b>Erro inesperado: " + e.getMessage() + "<b><html>", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }    
    }//GEN-LAST:event_btGravarActionPerformed

// ---------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Atualiza as opções do combo box de categorias com base no tipo selecionado (Receita ou Despesa).
     * 
     */
    private void cbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoItemStateChanged
        cbCategoria.removeAllItems();
        String tipoSelecionado = (String) cbTipo.getSelectedItem();

        if ("RECEITA".equals(tipoSelecionado)) {
            for (CategoriaReceita receita : CategoriaReceita.values()) {
                cbCategoria.addItem(receita.toString());
            }
        } else if ("DESPESA".equals(tipoSelecionado)) {
            for (CategoriaDespesa despesa : CategoriaDespesa.values()) {
                cbCategoria.addItem(despesa.toString());
            }
        }
    }//GEN-LAST:event_cbTipoItemStateChanged

    private void edDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edDataActionPerformed

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
            java.util.logging.Logger.getLogger(FLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FLancamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btGravar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JFormattedTextField edData;
    private javax.swing.JTextField edId;
    private javax.swing.JTextField edValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbValor;
    // End of variables declaration//GEN-END:variables
}
//javax.swing.JComboBox<Categoria> cbCategoria = new javax.swing.JComboBox<>(new javax.swing.DefaultComboBoxModel<>(Categoria.values()));
