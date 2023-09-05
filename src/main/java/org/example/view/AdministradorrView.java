package org.example.view;

import org.example.controller.AdminController;
import org.example.controller.LoanController;

import java.util.Scanner;

public class AdministradorrView {
    AdminController admnistratorController;
    LoanController loanController;
    Scanner scanner;
    public AdministradorrView() {
        admnistratorController = new AdminController();
        loanController = new LoanController();
        scanner = new Scanner(System.in);
    }

    public void logInAdmin() {
        System.out.println("Por favor, efetue seu login para ter acesso as opções: ");
        System.out.println();
        System.out.println("Informe seu token de acesso: ");
        int token = scanner.nextInt();
        menuAdministrator(admnistratorController.logIn(token));
    }

    public void menuAdministrator(boolean longinIsTrue) {
        int choice;
        do {
            System.out.println("Informe a opção desejada:" + "\n\t1- Cadastrar Autor" + "\n\t2- Cadastrar Livro" + "\n\t3- Deletar um cadastro " + "\n\t4- Efetuar um empréstimo" + "\n\t5- Associar Livro a um Autor" + "\n\t6- Associar Autor a um Livro" + "\n\t0-Sair do programa ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    registerAutor();
                    break;
                case 2:
                    registerBook();
                    break;
                case 3:
                    menuExcluded();
                    break;
                case 4:
                    efetuarEmprestimo();
                    break;
                case 5:
                    associarAutor();
                    break;
                case 6:
                    associarLivro();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        } while (choice != 0);
    }

    public void registerAutor() {
        System.out.println("Informe o nome do Autor: ");
        String name = scanner.next();
        System.out.println("Informe o CPF do Autor: ");
        String cpf = scanner.next();
        System.out.println("Informe o e-mail do Autor: ");
        String email = scanner.next();
        admnistratorController.registerAuthor(name, cpf, email);
    }

    public void registerBook() {
        System.out.println("Qual o título do livro?:");
        String titulo = scanner.next();
        System.out.println("Qual a descrição?: ");
        String descricao = scanner.next();
        scanner.nextLine();
        System.out.println("Qual o gênero?: ");
        String genero = scanner.next();
        admnistratorController.registerBook(titulo, descricao, genero);
    }

    public void menuExcluded() {
        int choice;
        do {
            System.out.println("Informe qual tipo de cadastro deseja excluir: " + "\n\t1-Excluir um livro" + "\n\t2-Excluir um autor" + "\n\t3-Excluir um usuário" + "\n\t0-Sair");
            choice = scanner.nextInt();
            System.out.println("Informe o id: ");
            int idASerDeletado = scanner.nextInt();
            switch (choice) {
                case 1:
                    admnistratorController.deleteBook(idASerDeletado);
                    break;
                case 2:
                    admnistratorController.deleteAuthor(idASerDeletado);
                    break;
                case 3:
                    admnistratorController.deleteUser(idASerDeletado);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
                    menuExcluded();
            }
        } while (choice != 0);
    }

    public void associarAutor() {
        System.out.println("Informe o id do Autor: ");
        int idAutor = scanner.nextInt();
        System.out.println("Informe o id do Livro: ");
        int idLivro = scanner.nextInt();
        admnistratorController.associateAuthorId(idAutor, idLivro);
    }

    public void associarLivro() {
        System.out.println("Informe o id do Livro: ");
        int idLivro = scanner.nextInt();
        System.out.println("Informe o id do Autor: ");
        int idAutor = scanner.nextInt();
        admnistratorController.associateBookId(idLivro, idAutor);
    }

    public void efetuarEmprestimo() {
        System.out.println("Digite o id do livro que deseja pegar emprestado:");
        int id_livro = scanner.nextInt();
        System.out.println("Digite o seu id:");
        int id_leitor = scanner.nextInt();
        loanController.makeLoan(id_livro, id_leitor);
    }
}