package ifpr.pgua.eic.tarefas.model.repositories;

import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.daos.AgendaDAO;
import ifpr.pgua.eic.tarefas.model.daos.EmailDAO;
import ifpr.pgua.eic.tarefas.model.entities.Email;

public class RepositorioEmail {
    private EmailDAO dao;
    private AgendaDAO agendaDao;

    public RepositorioEmail(AgendaDAO agendaDao, EmailDAO dao){
        this.agendaDao = agendaDao;
        this.dao = dao;
    }

    public Resultado cadastrarEmail(String email){
        if(email.isEmpty() || email.isBlank()){
            return Resultado.erro("Nome inválido!");
        }

        //Categoria categoria = new Categoria(nome, descricao);
        Email emails = new Email(email);
        Resultado resultado = dao.criar(emails);
        return resultado;
    }

    public Resultado listarAgenda(){
       return null;
    }
}
