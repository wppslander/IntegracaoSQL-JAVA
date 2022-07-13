
package veterinario;

import java.sql.*;
import java.util.*;

public final class Select implements SQL {
    
String sql;
int id;
Connection con = Conexao.getConnection();
Scanner sc = new Scanner( System.in );
    
Select(){
    int op = 0;
    while (op != 4){
    System.out.println("Qual tabela você deseja visualizar");
    System.out.println("[1]:Animal\t[2]Cliente\t[3]Ordens de Servico\t[4]Para Voltar");
    op = sc.nextInt();
    
    switch( op ){
        
    case(1) -> {
    this.Animal();
    }
    case(2) -> {
    this.Cliente();
    }
    
    case(3) -> {
    this.OS();
    }
     
}
}
}

@Override
    public int OpcoesExterna() {
    Scanner opcao = new Scanner(System.in);
    System.out.println("\nEntre com a opção ([1]Listar [2]Inserir [3] Deletar [4] Alterar [5]Fim)? ");
    return opcao.nextInt();
    }

    @Override
    public void Animal() {
        try{
            Statement smt = con.createStatement();
        sql = "select a.id, a.nome, a.raca, a.Especie, a.genero, d.Nome as Dono, d.Telefone from animal a join dono d on a.ID_Dono = d.ID";


        ResultSet res = smt.executeQuery(sql);
        while( res.next() ){ 
            id = res.getInt("id");
            System.out.println("Código: " + id );
            System.out.println("Nome: " + res.getString("Nome"));
            System.out.println("Raça: " + res.getString("Raca"));
            System.out.println("Genero: " + res.getString("genero"));
            System.out.println("Dono: " + res.getString("Dono"));
            System.out.println("Telefone: " + res.getString("Telefone"));

            System.out.println();
        }
        smt.close();	
        }
        catch (SQLException e) {
            System.out.println("O comando SQL não pode ser executado! " + e.getMessage());
        }
    
    }

    @Override
    public void Cliente() {
        try{
	Statement smt = con.createStatement();
        sql = "select * from dono";
    
    
        ResultSet res = smt.executeQuery(sql);
        while( res.next() ){
            id = res.getInt("id");
            System.out.println("Código: " + id );
            System.out.println("Nome: " + res.getString("Nome"));
            System.out.println("Telefone: " + res.getString("Telefone"));
            System.out.println("Endereço: " + res.getString("Endereco"));
            System.out.println();
        }
        smt.close();	
        }
        catch (SQLException e) {
            System.out.println("O comando SQL não pode ser executado! " + e.getMessage());
        }
    }

    @Override
    public void OS() {
        try{
            Statement smt = con.createStatement();

            sql = "SELECT os.ID, d.Nome, a.Nome as PET, os.DATA, os.Servico, os.Preco, os.Observacao from os JOIN animal a on os.ID_Animal=a.ID JOIN dono d on a.ID_Dono=d.ID";


            ResultSet res = smt.executeQuery(sql);
            while( res.next() ){
                id = res.getInt("id");
                System.out.println("Código: " + id );
                System.out.println("Nome: " + res.getString("Nome"));
                System.out.println("PET: " + res.getString("PET"));
                System.out.println("Data na nota: " + res.getString("DATA"));
                System.out.println(res.getString("Servico"));
                System.out.println("Preco: " + res.getDouble("Preco") + "R$");
                System.out.println(res.getString("Observacao"));
                System.out.println();
            }
            smt.close();	
        }
        catch (SQLException e) {
            System.out.println("O comando SQL não pode ser executado! " + e.getMessage());
        }
    }
    
}
