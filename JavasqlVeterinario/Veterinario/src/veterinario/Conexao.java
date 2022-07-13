package veterinario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection cnn = null;
    private static String banco = "jdbc:mysql://localhost/trabalhop2m2";
    private static String usuario = "root";
    private static String senha = "";

   private static void setConexao() {
      try {
         cnn = DriverManager.getConnection(banco, usuario, senha);
      } catch (SQLException e) {
         throw new RuntimeException("Erro ao abrir conexão com bd. " + e.getMessage());
      }
   }
   
   public static Connection getConnection(){
      if (cnn == null) setConexao();
      return cnn;
   }
    
}
