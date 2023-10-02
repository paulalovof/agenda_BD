package ifpr.pgua.eic.tarefas.model.repositories;

import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.daos.AgendaDAO;
import ifpr.pgua.eic.tarefas.model.entities.Agenda;
import ifpr.pgua.eic.tarefas.model.entities.Email;
import ifpr.pgua.eic.tarefas.model.entities.Telefone;

public class RepositorioAgenda {
    private AgendaDAO dao;

    public RepositorioAgenda(AgendaDAO dao){
        this.dao = dao;
    }

    public Resultado cadastrarAgenda(String nome, ArrayList<Email> email, ArrayList<Telefone> telefone){
        if(nome.isEmpty() || nome.isBlank()){
            return Resultado.erro("Nome inválido!");
        }

        //Categoria categoria = new Categoria(nome, descricao);
        Agenda agenda = new Agenda(nome, email, telefone);
        Resultado resultado = dao.criar(agenda);
        return resultado;
    }

    public Resultado listarAgenda(){
       return null;
    }
}
