
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    private Connection conexao;
    
    // Método de conexão com o banco de dados
    public void conectar() {
        try {
            //System.out.println("Iniciando conexão com o banco de dados...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11", "root", "Genecy15@");
            
            System.out.println("SUCESSO DE CONEXÃO!");
            
        } catch (SQLException e) {
            System.out.println("Falha: não conseguiu conectar");
        } catch (ClassNotFoundException e) {
            System.out.println("Falha: não encontrou a classe de conexão");
        }
    }
    
    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                //System.out.println("Desconectado com sucesso!");
            }
        } catch(SQLException e) {
            System.out.println("Erro ao desconectar");
        }
    }
    
    public Connection getConexao() {
        return conexao;
    }
}
