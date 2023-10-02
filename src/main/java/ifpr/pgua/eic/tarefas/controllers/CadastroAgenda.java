package ifpr.pgua.eic.tarefas.controllers;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.App;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAgenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroAgenda {
    
    @FXML
    private TextField tfNome;

    private RepositorioAgenda repositorio;

    public CadastroAgenda(RepositorioAgenda repositorio){
        this.repositorio = repositorio;
    }

    @FXML
    void cadastrar(ActionEvent event) {
        String nome = tfNome.getText();
        Resultado rs = repositorio.cadastrarAgenda(nome, null, null);

        Alert alert = new Alert(AlertType.INFORMATION,rs.getMsg());
        alert.showAndWait();
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}
