package ifpr.pgua.eic.tarefas.controllers;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAgenda;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioTelefone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CadastroTelefone {
    @FXML
    private TextField tfTelefone;

    @FXML
    private ComboBox cbAgenda;

    private RepositorioTelefone repositorio;
    
    private RepositorioAgenda repositorioAgenda;

    public CadastroTelefone(RepositorioTelefone repositorio, RepositorioAgenda repositorioAgenda){
        this.repositorio = repositorio;
        this.repositorioAgenda = repositorioAgenda;
    }

    @FXML
    void cadastrar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}
