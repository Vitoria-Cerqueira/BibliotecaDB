package org.example;

import org.example.repository.AdminRepository;
import org.example.view.AdministradorrView;
import org.example.view.UserView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdministradorrView bibliotecarioView = new AdministradorrView();
        UserView leitorView = new UserView();
        int escolha = 0;
        do {
            System.out.println("Bem-vindo a biblioteca");
            System.out.println("Você é: 1-Administrador | 2-Visitante | 0-Sair");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    bibliotecarioView.logInAdmin();
                    break;
                case 2:
                    leitorView.menuUser();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        } while (escolha != 0);
    }
}

