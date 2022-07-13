package veterinario;

import java.sql.*;
import java.util.*;

public final class Update implements SQL {
    
String sql;
Connection con = Conexao.getConnection();
Scanner sc = new Scanner( System.in );

    Update(){
    int op = 0;
    while(op != 4){
    System.out.println("Qual tabela você deseja Alterar");
    System.out.println("[1]:Animal\t[2]Cliente\t[3]Ordens de Servico\t[4]Para Voltar");
    op = sc.nextInt();
    
    switch( op ){
        
    case(1) -> {
        this.Animal();
    }
    case(3) -> {
        this.OS();
    }
    
    case(2) -> {
        this.Cliente();
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
        
        sc.nextLine();
        System.out.print( "\tID: " );
        int id = sc.nextInt();
        System.out.print( "\tID_Dono: " );
        int id_dono = sc.nextInt();
        System.out.print( "\tNome do Animal: " );
        String nome = sc.nextLine();
        System.out.print( "\tRaca: " );
        String raca = sc.nextLine();
        System.out.print( "\tEspecie: " );
        String especie = sc.nextLine();
        System.out.print( "\tGenero: " );
        String genero = sc.nextLine();
        System.out.println("Observação*caso não haja deixar em branco: ");
        String observacao = sc.nextLine();
        sc.nextLine();
    
    try{
        sql = "UPDATE animal set id_dono = ?, Nome = ?, Raca = ?, Especie = ?, genero = ?, Observacao = ? where animal.ID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(6, id);
        ps.setInt(0, id_dono);
        ps.setString(1, nome);
        ps.setString(2, raca);
        ps.setString(3, especie);
        ps.setString(4, genero);
        ps.setString(5, observacao);
        ps.execute();
        System.out.println( "Registo inserido com sucesso!" );
        ps.close();
     } catch (SQLException e) {
        System.out.println("O comando SQL não pode ser executado! " +e.getMessage());
     }
    }

    @Override
    public void Cliente() {
        sc.nextLine();
        System.out.print( "\tID: " );
        int id = sc.nextInt();            
        System.out.println("\tNome do cliente: ");
        String cliente = sc.nextLine();
        System.out.println("\tTelefone: ");
        String tel = sc.nextLine();
        System.out.println("\tEndereco: ");
        String ende = sc.nextLine();
        sc.nextLine();
    
    try{
        sql = "UPDATE dono set cliente = ?, tel = ?, ende = ? where dono.ID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(3, id);
        ps.setString(0, cliente);
        ps.setString(1, tel);
        ps.setString(2, ende);
        ps.execute();
        System.out.println( "Registo inserido com sucesso!" );
        ps.close();
     } catch (SQLException e) {
        System.out.println("O comando SQL não pode ser executado! " +e.getMessage());
     }
    }

    @Override
    public void OS() {
        sc.nextLine();
        System.out.print( "\tID: " );
        int id = sc.nextInt();
        System.out.println("\tId do PET: ");
        int idAnimal = sc.nextInt();
        System.out.println("\tData do serviço:(aaaa-mm-dd) ");
        String data = sc.nextLine();
        System.out.println("\tServico: ");
        String serv = sc.nextLine();
        System.out.println("\tPreco: ");
        double preco = sc.nextDouble();
        System.out.println("\tObservacão: \n\t*Caso não haja deixar em branco");
        String obs = sc.nextLine();
        sc.nextLine();
    
    try{
        sql = "UPDATE os set ID_Animal = ?, data = ?, servico = ?, preco = ?, observacao = ? where os.ID = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(5, id);
        ps.setInt(0, idAnimal);
        ps.setString(1, data);
        ps.setString(2, serv);
        ps.setDouble(3, preco);
        ps.setString(4, obs);
        ps.execute();
        System.out.println( "Registo inserido com sucesso!" );
        ps.close();
     } catch (SQLException e) {
        System.out.println("O comando SQL não pode ser executado! " +e.getMessage());
     }
    }
}
