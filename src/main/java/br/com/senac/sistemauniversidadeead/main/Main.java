package br.com.senac.sistemauniversidadeead.main;

import java.util.Scanner;
import br.com.senac.sistemauniversidadeead.model.TipoUsuario;
import br.com.senac.sistemauniversidadeead.model.Usuario;
import br.com.senac.sistemauniversidadeead.view.TelaLogin;

public class Main {

    public static void main(String[] args) {
                            TelaLogin tela = new TelaLogin();
                                tela.setVisible(true);

      

  
       /*Usuario diretor = new Usuario(
                1,
                "Administrador",
                "diretor",
                "1234",
                TipoUsuario.DIRETOR
        );

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   SISTEMA UNIVERSIDADE EAD");
        System.out.println("=================================");

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (diretor.autenticar(login, senha)) {

            System.out.println("\nLogin realizado com sucesso!");
            System.out.println("Usuário: " + diretor.getNome());
            System.out.println("Tipo: " + diretor.getTipo());

        } else {

            System.out.println("\nLogin ou senha incorretos.");
        }

        scanner.close();*/
    }
}
