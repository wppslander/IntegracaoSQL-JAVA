package veterinario;

import java.sql.*;
import java.util.Scanner;



public final class Deletar implements SQL {
    
String sql;
Connection con = Conexao.getConnection();
Scanner sc = new Scanner( System.in );

Deletar(){
    int op = 0;
    while (op != 4){
    System.out.println("Qual tabela você deseja acessar");
    System.out.println("[1]:Animal\t[2]Cliente\t[4]Para Voltar");
    
    switch( op ){
        case (1) -> {
            this.Animal();
        }
        case (2) -> {
            this.Cliente();
        }
        
        //Não vou fazer a opção de deletar os pois não se pode deletar Nota Fiscal XD
    }
    
    

}
}

@Override
public void Animal()
{
    try{
        Statement smt = con.createStatement();
        System.out.println("Você esta na tabela dos PET's: ");
        System.out.println("Qual id do animal deseja excluir: ");
        int id = sc.nextInt();
        sql = "DELETE FROM animal WHERE animal.ID = " + id ;
        smt.executeQuery(sql);
        System.out.println("Animal de ID = " + id + " removido");
        smt.close();
    }catch (SQLException e) {
        System.out.println("O comando SQL não pode ser executado! " + e.getMessage());
    }
}

@Override
public void Cliente()
{
    try{
        Statement smt = con.createStatement();
        System.out.println("Você esta na tabela dos Clientes: ");
            System.out.println("Qual id do Cliente deseja excluir: ");
            int id = sc.nextInt();
            sql = "DELETE FROM dono WHERE dono.ID = " + id ;
            smt.executeQuery(sql);
    }catch (SQLException e) {
        System.out.println("O comando SQL não pode ser executado! " + e.getMessage());
    }
}

@Override
public void OS() {
    throw new UnsupportedOperationException("Não podemos deletar uma OS mesmo estando errada.");
}
    
    
@Override
public int OpcoesExterna() {
    Scanner opcao = new Scanner(System.in);
    System.out.println("\nEntre com a opção ([1]Listar [2]Inserir [3] Deletar [4] Alterar [5]Fim)? ");
    return opcao.nextInt();
}

    


}