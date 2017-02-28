/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.LocalizarProdutos;

import com.tcc.EntradaProduto.FormEntradaProduto;
import com.tcc.NovoProdutoEstoque.FormNovoProdEstoque;
import com.tcc.Produto.NovoProduto;
import com.tcc.SaidaProduto.SaidaProduto;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class FormLocalizarProdutos extends javax.swing.JFrame {

    // atributo que faz referencia aos produtos localizdos na pesquisa.
    NovoProduto produtoLocal = new NovoProduto();

    FormEntradaProduto cadNovo = new FormEntradaProduto();
    SaidaProduto saidaProd = new SaidaProduto();
    FormNovoProdEstoque novoProdEst = new FormNovoProdEstoque();

    /**
     * Creates new form LocalizarProdutos
     */
    public FormLocalizarProdutos() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        campoBuscProdNome = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLocalizar = new javax.swing.JTable();
        btnCadEntrada = new javax.swing.JButton();
        btnCadSaida = new javax.swing.JButton();
        btnNovoProdEstoq = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Localizar Produtos");
        setBackground(new java.awt.Color(247, 247, 247));

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));

        jLabel1.setText("Localizar produto:");

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));

        jtLocalizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIÇÃO", "COD. BARRAS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtLocalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLocalizarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtLocalizar);

        btnCadEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tcc/imagens/entrada_prod_localizar.png"))); // NOI18N
        btnCadEntrada.setText("Cadastrar entrada");
        btnCadEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadEntradaActionPerformed(evt);
            }
        });

        btnCadSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tcc/imagens/saida_prod_localizar.png"))); // NOI18N
        btnCadSaida.setText("Cadastrar Saida");
        btnCadSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadSaidaActionPerformed(evt);
            }
        });

        btnNovoProdEstoq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tcc/imagens/novo_prod_estoque.png"))); // NOI18N
        btnNovoProdEstoq.setText("Novo produto ao estoque");
        btnNovoProdEstoq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdEstoqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadEntrada)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadSaida)
                        .addGap(18, 18, 18)
                        .addComponent(btnNovoProdEstoq)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadSaida)
                    .addComponent(btnCadEntrada)
                    .addComponent(btnNovoProdEstoq))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tcc/imagens/success.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(campoBuscProdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoBuscProdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) jtLocalizar.getModel();
        modelo.setNumRows(0); // Utilizado para nao repetir as linhas ao clicarmos duas vezes em pesquisar.

        NovoProduto buscar = new NovoProduto();

        String produto = campoBuscProdNome.getText();

        for (NovoProduto prod : buscar.lerTabProduto()) {

            if (prod.getDescricao().contains(produto)) {
                modelo.addRow(new Object[]{
                    prod.getCod_produto(),
                    prod.getDescricao(),
                    prod.getCodigo_barra()
                });

            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jtLocalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLocalizarMouseClicked
        // capturanda os dados da linha que foi clicada

        int linha = jtLocalizar.getSelectedRow();

        produtoLocal.setCod_produto(Integer.parseInt(jtLocalizar.getModel().getValueAt(linha, 0).toString()));
        produtoLocal.setDescricao(jtLocalizar.getModel().getValueAt(linha, 1).toString());
        produtoLocal.setCodigo_barra(jtLocalizar.getModel().getValueAt(linha, 2).toString());


    }//GEN-LAST:event_jtLocalizarMouseClicked

    private void btnCadEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadEntradaActionPerformed
        // inserindo as informações localizdas nos campos codigo produto, descricao 
        // do formulario de entrada de produtos.

        cadNovo.campoCodProduto.setText(String.valueOf(produtoLocal.getCod_produto()));
        cadNovo.campoDescProd.setText(produtoLocal.getDescricao());
        cadNovo.campoCodBarras.setText(produtoLocal.getCodigo_barra());

        cadNovo.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadEntradaActionPerformed

    private void btnCadSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadSaidaActionPerformed
        // TODO add your handling code here:
        saidaProd.campoCodProduto1.setText(String.valueOf(produtoLocal.getCod_produto()));
        saidaProd.campoDescProd1.setText(produtoLocal.getDescricao());
        saidaProd.campoCodBarras1.setText(produtoLocal.getCodigo_barra());
        
        saidaProd.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadSaidaActionPerformed

    private void btnNovoProdEstoqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdEstoqActionPerformed
        // TODO add your handling code here:
        novoProdEst.campoCodProdNovo.setText(String.valueOf(produtoLocal.getCod_produto()));
        novoProdEst.campoCodBarrasNovo.setText(produtoLocal.getCodigo_barra());
        novoProdEst.campoDescProdNovo.setText(produtoLocal.getDescricao());
        
        novoProdEst.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNovoProdEstoqActionPerformed

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
            java.util.logging.Logger.getLogger(FormLocalizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLocalizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLocalizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLocalizarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLocalizarProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCadEntrada;
    private javax.swing.JButton btnCadSaida;
    private javax.swing.JButton btnNovoProdEstoq;
    private javax.swing.JTextField campoBuscProdNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtLocalizar;
    // End of variables declaration//GEN-END:variables
}
