package org.example.view;

import org.example.model.UsuarioModel;
import org.example.service.UsuarioService;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    //trazendo classes que vou usar
    private Scanner scanner;
    private UsuarioModel usuarioModel;
    private UsuarioService usuarioService;

    public  MenuView(){
        scanner = new Scanner(System.in);
        usuarioModel = new UsuarioModel();
        usuarioService = new UsuarioService();
    }
    public void iniciar(){
        int opcao;

        do {
            imprimirMenu();
            opcao = selecionaOpcao();

            switch (opcao){
                case 1:
                    usuarioService.concultaDados();
                    break;
                case 2:
                    System.out.println("Digite o nome que deseja inserir na tabela: ");
                    String nome = scanner.nextLine();
                    usuarioModel.setNome(nome);
                    usuarioService.inserirDados(usuarioModel.getNome());
                    break;
                case 0:
                    System.out.println("Encerrando o programa");
                    break;
                default:
                    System.out.println("Opçao invalida tente novamente");
                    break;
            }
        }while (opcao != 0);
    }
    public void imprimirMenu(){
        System.out.println("Digite uma das seguintes opçoes");
        System.out.println("1- Consultar todos os dados da tabela");
        System.out.println("2- Inserir dados na tabela");
        System.out.println("0- Sair...");
    }
    public int selecionaOpcao(){
        try{
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
            scanner.nextLine();
            return 1;
        }
    }
}
