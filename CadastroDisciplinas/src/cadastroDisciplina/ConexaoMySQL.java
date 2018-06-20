//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M3LPBD

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Anne Livia da Fonseca Macedo

//******************************************************

// Está classe foi fornecida pelo curso e ela é responsavel por realizar a conexão com o banco de dados
package cadastroDisciplina;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexaoMySQL {

    private static ConexaoMySQL instance = null;
    private Connection connection = null;
    

    private ConexaoMySQL() {
        try {
            
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            
            String serverName = "127.0.0.1";    
            
        
            String dbName = "disciplinas" ;        
            String url = "jdbc:mysql://" + 
                    serverName + "/" + 
                    dbName;
            
           
            String username = "root";             
            String password = "root";      
            
            connection = DriverManager.getConnection(url,
                    username, password);
              
            if (connection != null) {
                System.out.println("STATUS--->Conectado "
                        + "com sucesso!");
            } else {
                System.err.println("STATUS--->Não foi "
                        + "possivel realizar conexão");
            }
            connection.setAutoCommit(true);
        } catch (ClassNotFoundException e) {  
            
            System.out.println("O driver expecificado"
                    + " nao foi encontrado.");
        } catch (SQLException e) {
            
            System.out.println("Nao foi possivel"
                    + " conectar ao Banco de Dados.");
            e.printStackTrace();
        }
        }

    public static ConexaoMySQL getInstance() {
        if (instance == null) {
            instance = new ConexaoMySQL();
        }
        return instance;
    }

    public java.sql.Connection getConnection() {
        return connection;
    }

    
}