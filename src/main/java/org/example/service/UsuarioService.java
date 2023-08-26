package org.example.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.conecction.Conexao.fazerConexao;


public class UsuarioService {
    private Statement statement;



    //esse metodo faz a interaçao com o banco de dados
    public UsuarioService(){
        try {
            statement = fazerConexao().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //iniciando o CRUD
    // metodo incluir dados da tabela do banco de dados
    public void inserirDados(String nome){
        String sql = "INSERT INTO usuarios (nome) VALUES ('"+ nome +"')";
        try {
            statement.executeUpdate(sql);
            System.out.println("Usuario: " +nome + "foi adicionado com sucesso no banco de dados!");
        }catch (SQLException e){
            e.printStackTrace();

        }

    }
    //metodo que consulta todos os dados
    public void concultaDados(){
        String sql = "SELECT * FROM usuarios";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("ID:" + resultSet.getInt("id_usuario" + "| NOME: "
                        + resultSet.getString("nome")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
