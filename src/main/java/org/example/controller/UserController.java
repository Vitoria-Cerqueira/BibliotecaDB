package org.example.controller;

import org.example.model.UserModel;
import org.example.repository.UserRepository;

public class UserController {
    UserRepository userRepository = new UserRepository();
    UserModel userModel = new UserModel();

    public boolean register(String nome, String cpf, String email, String senha){
        userModel.setNameUser(nome);
        userModel.setCpfUser(cpf);
        userModel.setEmailUser(email);
        userModel.setSenhaUser(senha);
        return userRepository.register(userModel.getNameUser(), userModel.getCpfUser(), userModel.getEmailUser(), userModel.getSenhaUser());

    }
    public boolean logIn(String email, String password){
        userModel.setEmailUser(email);
        userModel.setSenhaUser(password);
        return userRepository.logIn(userModel.getEmailUser(), userModel.getSenhaUser());
    }

}
