/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prova.dao;

import br.com.prova.jdbc.ConnectionFactory;
import br.com.prova.model.Clientes;
import br.com.prova.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class ClientesDAO {

    private Connection connection;

    public ClientesDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public String totalregistros() {
        String total = null;
        try {
            String sql = "Select count(nome) from tb_clientes";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            rs.next();
            total =rs.getString(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro em buscar a quantidade");
        }
        return total;
    }

    public void cadastrarCliente(Clientes objeto) {
        try {
            String sql = "insert tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado,data_cadastro,desconto)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, objeto.getNome());
            statement.setString(2, objeto.getRg());
            statement.setString(3, objeto.getCpf());
            statement.setString(4, objeto.getEmail());
            statement.setString(5, objeto.getTelefone());
            statement.setString(6, objeto.getCelular());
            statement.setString(7, objeto.getCep());
            statement.setString(8, objeto.getEndereco());
            statement.setInt(9, objeto.getNumero());
            statement.setString(10, objeto.getComplemento());
            statement.setString(11, objeto.getBairro());
            statement.setString(12, objeto.getCidade());
            statement.setString(13, objeto.getEstado());
            statement.setString(14, objeto.getData_cadastro());
            statement.setFloat(15, objeto.getDesconto());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }

    public List<Clientes> listarClientes() {
        try {
            List<Clientes> lista = new ArrayList();

            String sql = "select*from tb_clientes";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Clientes objeto = new Clientes();
                objeto.setId(result.getInt("id"));
                objeto.setNome(result.getString("nome"));
                objeto.setRg(result.getString("rg"));
                objeto.setCpf(result.getString("cpf"));
                objeto.setEmail(result.getString("email"));
                objeto.setTelefone(result.getString("telefone"));
                objeto.setCelular(result.getString("celular"));
                objeto.setCep(result.getString("cep"));
                objeto.setEndereco(result.getString("endereco"));
                objeto.setNumero(result.getInt("numero"));
                objeto.setComplemento(result.getString("complemento"));
                objeto.setBairro(result.getString("bairro"));
                objeto.setCidade(result.getString("cidade"));
                objeto.setEstado(result.getString("estado"));
                objeto.setData_cadastro(result.getString("data_cadastro"));
                objeto.setDesconto(result.getFloat("desconto"));

                lista.add(objeto);
            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }

    public void excluirCliente(Clientes objeto) {
        try {
            String sql = "delete from tb_clientes where id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, objeto.getId());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }

    public void editarCliente(Clientes objeto) {
        try {
            String sql = "update tb_clientes set  nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, "
                    + "endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=?, data_cadastro=?, desconto=?  where id =?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, objeto.getNome());
            statement.setString(2, objeto.getRg());
            statement.setString(3, objeto.getCpf());
            statement.setString(4, objeto.getEmail());
            statement.setString(5, objeto.getTelefone());
            statement.setString(6, objeto.getCelular());
            statement.setString(7, objeto.getCep());
            statement.setString(8, objeto.getEndereco());
            statement.setInt(9, objeto.getNumero());
            statement.setString(10, objeto.getComplemento());
            statement.setString(11, objeto.getBairro());
            statement.setString(12, objeto.getCidade());
            statement.setString(13, objeto.getEstado());
            statement.setString(14, objeto.getData_cadastro());
            statement.setFloat(15, objeto.getDesconto());
            statement.setInt(16, objeto.getId());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);

        }
    }

    public List<Clientes> buscaClientePorNome(String nome) {
        try {
            List<Clientes> lista = new ArrayList();

            String sql = "select*from tb_clientes where nome like?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Clientes objeto = new Clientes();
                objeto.setId(result.getInt("id"));
                objeto.setNome(result.getString("nome"));
                objeto.setRg(result.getString("rg"));
                objeto.setCpf(result.getString("cpf"));
                objeto.setEmail(result.getString("email"));
                objeto.setTelefone(result.getString("telefone"));
                objeto.setCelular(result.getString("celular"));
                objeto.setCep(result.getString("cep"));
                objeto.setEndereco(result.getString("endereco"));
                objeto.setNumero(result.getInt("numero"));
                objeto.setComplemento(result.getString("complemento"));
                objeto.setBairro(result.getString("bairro"));
                objeto.setCidade(result.getString("cidade"));
                objeto.setEstado(result.getString("estado"));
                objeto.setData_cadastro(result.getString("data_cadastro"));
                objeto.setDesconto(result.getFloat("desconto"));

                lista.add(objeto);
            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }

    public Clientes consultaPorNome(String nome) {
        try {
            String sql = "select*from tb_clientes where nome = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet result = statement.executeQuery();
            Clientes objeto = new Clientes();
            if (result.next()) {
                objeto.setId(result.getInt("id"));
                objeto.setNome(result.getString("nome"));
                objeto.setRg(result.getString("rg"));
                objeto.setCpf(result.getString("cpf"));
                objeto.setEmail(result.getString("email"));
                objeto.setTelefone(result.getString("telefone"));
                objeto.setCelular(result.getString("celular"));
                objeto.setCep(result.getString("cep"));
                objeto.setEndereco(result.getString("endereco"));
                objeto.setNumero(result.getInt("numero"));
                objeto.setComplemento(result.getString("complemento"));
                objeto.setBairro(result.getString("bairro"));
                objeto.setCidade(result.getString("cidade"));
                objeto.setEstado(result.getString("estado"));
                objeto.setEstado(result.getString("estado"));
                objeto.setEstado(result.getString("estado"));
                objeto.setData_cadastro(result.getString("data_cadastro"));
                objeto.setDesconto(result.getFloat("desconto"));
            }
            return objeto;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }

    public Clientes buscaCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setEstado(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }
    }

}
