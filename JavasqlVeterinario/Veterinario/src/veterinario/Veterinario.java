package veterinario;

import java.util.Scanner;

public class Veterinario {

public static void main(String[] args) {
    int opcao=0;
    Scanner sc = new Scanner(System.in);
    SQL s; 


while(opcao != 5){
    System.out.println("\nEntre com a opção ([1]Listar [2]Inserir [3] Deletar [4] Alterar [5]Fim)? ");
    opcao = sc.nextInt();

    switch( opcao ){
        case 1: {//feito
            s = new Select();
            opcao = s.OpcoesExterna();
            
        }
        case 2:{//feito
            s = new Insert();
            opcao = s.OpcoesExterna();
        }
        case 3:{
            s = new Deletar();
            opcao = s.OpcoesExterna();
        }
        case 4:{
            s = new Update();
            opcao = s.OpcoesExterna();
        }
    }


}
}
    
}
