package ifpr.pgua.eic.tarefas.controllers;

import ifpr.pgua.eic.tarefas.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Cadastro {
    @FXML
    void cadastrarAgenda(ActionEvent event) {
        App.pushScreen("CADASTROAGENDA");
    }

    @FXML
    void cadastrarEmail(ActionEvent event) {
        App.pushScreen("CADASTROEMAIL");
    }

    @FXML
    void cadastrarTelefone(ActionEvent event) {
        App.pushScreen("CADASTROTELEFONE");
    }

    @FXML
    void voltar(ActionEvent event) {
        App.popScreen();
    }
}
