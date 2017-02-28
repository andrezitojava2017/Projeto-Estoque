/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcc.Produto;

import com.tcc.ConexaoBD.ConexaoDB;
import com.tcc.NovoProduto.FormNovoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class NovoProduto {

    // atributos da classe
    private int cod_produto, minEstoque, maxEstoque, quantidade;
    private String situacao, descricao, data, codigo_barra, vlr_unitario;

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    // atributos de conexao
    Connection conexao = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getVlr_unitario() {
        return vlr_unitario;
    }

    public void setVlr_unitario(String vlr_unitario) {
        this.vlr_unitario = vlr_unitario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public int getMinEstoque() {
        return minEstoque;
    }

    public void setMinEstoque(int minEstoque) {
        this.minEstoque = minEstoque;
    }

    public int getMaxEstoque() {
        return maxEstoque;
    }

    public void setMaxEstoque(int maxEstoque) {
        this.maxEstoque = maxEstoque;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Metodo responsavel em gerar a sequencia numerica do codigo do produto
     * sera lido do BD o ultimo valor utilizado, depois sera incrementado +1 e
     * sera atribuido no campoCodProd.
     *
     * @return inteiro novo
     */
    public int gerarCodigoNovoProd() {

//      atributo com sql de seleção
        String sql = "select codigo from baseEstoque.produtos";

//      atributo que ira armazenar o ULTIMO VALOR da sequencia de produto
        int ultimo = 0;

//      atriuto que ira armazenar o VALOR ATUAL da sequencia de produto
        int novo = 0;

        try {
            conexao = ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();

            // laço paa percorrer a tabela de produtos ate o ultimo elemento;
            while (rs.next()) {
//              capturando o valor da primeira coluna da tabela baseEstoque.produto e atribuindo ao atributo ultimo
                ultimo = rs.getInt(1);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler sequencia de codigo do produto\n" + ex);
        } finally {

//          fechando a conexao com o banco de dados
            ConexaoDB.fecharConexao(conexao, stm, rs);
        }

//      passando o atributo 'ultimo' como valor do atributo novo, logo enseguida incrementando-o
        novo = ultimo;
        novo++;

        return novo;
    }

    /**
     * metodo responsavel em gravar o novo produto na tabela produto.
     */
    public void gravarNovoProd(List<NovoProduto> prod) {
        //      botao que faz a gravação dos dados na tabela produto e estoque
        String sql = "insert into baseEstoque.produtos(codigo, descricao, codigoBarra, estoqueMinimo, estoqueMaximo) values(?,?,?,?,?)";
        int confirma = 0;
        try {
            conexao = ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);

            for (NovoProduto novoProduto : prod) {

                stm.setInt(1, novoProduto.getCod_produto());
                stm.setString(2, novoProduto.getDescricao());
                stm.setString(3, novoProduto.getCodigo_barra());
                stm.setInt(4, novoProduto.getMinEstoque());
                stm.setInt(5, novoProduto.getMaxEstoque());

                confirma = stm.executeUpdate();
            }

            //if(confirma == 1){
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            // }

        } catch (SQLException ex) {
            Logger.getLogger(FormNovoProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // fechando a conexao com o banco de dados
            ConexaoDB.fecharConexao(conexao, stm);
        }
    }

    /**
     * Metodo responsavel em ler a tabela PRODUTO.
     *
     * @return retorno
     */
    public List<NovoProduto> lerTabProduto() {

        List<NovoProduto> retorno = new ArrayList<>();

        try {
            String sql = "select * from baseEstoque.produtos";

            conexao = ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                NovoProduto prod = new NovoProduto();
                prod.setCod_produto(Integer.parseInt(rs.getString("codigo")));
                prod.setDescricao(rs.getString("descricao"));
                prod.setCodigo_barra(rs.getString("codigoBarra"));
                retorno.add(prod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NovoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

        // retornando a lista de produtos
        return retorno;
    }

    /**
     * Metodo responsaveu em gravar a entrada de produtos na tabela
     * EntradaProduto.
     */
    public void gravarEntrada(NovoProduto prod) {
        try {
            String sql = "insert into baseEstoque.entrada_produto(cod_produto, quantidade, valor_unitario, data_entrada) values(?,?,?,?)";

            conexao = ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);

            stm.setInt(1, prod.getCod_produto());
            stm.setInt(2, prod.getQuantidade());
            stm.setString(3, String.valueOf(prod.getVlr_unitario()));
            stm.setString(4, prod.getData());
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados na tabela Entrada produtos\n" + ex);
        }
    }

    /**
     * metodo que ira ler dados da coluna quantidade da tabela estoque
     * determinado produto
     * @param cod
     * @return
     */
    public String lerEstoque(int cod) {
        // recebe o valor recuperado da tabela estoque;
        String qtd = null;

        try {
            String sql = "select qtde from baseEstoque.estoque where cod_produto =?";

            conexao = ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);

            stm.setInt(1, cod);
            rs = stm.executeQuery();

            while (rs.next()) {
                qtd = rs.getString("qtde");
            }

        } catch (SQLException ex) {
            Logger.getLogger(NovoProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoDB.fecharConexao(conexao, stm, rs);
        }

        return qtd;
    }

    /**
     * Metodo que atualizada a tabela estoque, inserindo ou removendo os dados
     */
    public void InserirTabEstoque(NovoProduto adiciona, int valor) {
        try {
            String sql = "update baseEstoque.estoque set cod_produto=?, descricao=?, qtde=?, valor_unitario=? where cod_produto=?";

            conexao = ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);

            stm.setInt(1, adiciona.getCod_produto());
            stm.setString(2, adiciona.getDescricao());
            stm.setInt(3, valor);
            stm.setString(4, adiciona.getVlr_unitario());
            stm.setInt(5, adiciona.getCod_produto());

            stm.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na gravação de dados - tabela estoque!\n" + ex);
        } finally {
            ConexaoDB.fecharConexao(conexao, stm);
        }

    }

    /**
     * Metodo respnsavel em gravar informações na tabela saida_produto
     * rgistrando todas as saidas de determinados produtos, juntamente com datas
     * e quantidades retiradas.
     *
     * @param prod objeto com a referencia aos atributos
     */
    public void gravarSaidaEstoque(NovoProduto prod) {
        try {
            String sql = "insert into baseEstoque.saida_produto(cod_produto,cod_barras, descricao, qtde, data_saida) values(?,?,?,?,?)";

            conexao = ConexaoDB.getconection();
            stm = conexao.prepareStatement(sql);

            stm.setInt(1, prod.getCod_produto());
            stm.setString(2, prod.getCodigo_barra());
            stm.setString(3, prod.getDescricao());
            stm.setInt(4, prod.getQuantidade());
            stm.setString(5, prod.getData());
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados na tabela Entrada produtos\n" + ex);
        }
    }

    /**
     * Metodo responsavel em gravar um novo produto que nao esteja na tabela
     * estoque
     *
     * @param prod objeto com as referencias do produto.
     */
    public void gravarNovoProdutoEstoque(NovoProduto prod) {

        try {
            String sql = "insert into baseEstoque.estoque(cod_produto, descricao, qtde, valor_unitario) values(?,?,?,?)";
            
            conexao = ConexaoDB.getconection();
            stm = conexao.prepareCall(sql);
            
            stm.setString(1, String.valueOf(prod.getCod_produto()));
            stm.setString(2, prod.getDescricao());
            stm.setString(3, String.valueOf(prod.getQuantidade()));
            stm.setString(4, prod.getVlr_unitario());
            
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar Novo produto na tabela estoque\n" + ex);
        }

    }

}
