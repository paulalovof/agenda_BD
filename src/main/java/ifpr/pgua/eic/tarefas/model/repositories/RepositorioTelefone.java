package ifpr.pgua.eic.tarefas.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.daos.AgendaDAO;
import ifpr.pgua.eic.tarefas.model.daos.TelefoneDAO;
import ifpr.pgua.eic.tarefas.model.entities.Telefone;

public class RepositorioTelefone {
    private TelefoneDAO dao;
    private AgendaDAO agendaDao;

    public RepositorioTelefone(AgendaDAO agendaDao, TelefoneDAO dao){
        this.agendaDao = agendaDao;
        this.dao = dao;
    }

    public Resultado cadastrarTelefone(int telefone){
        if(telefone == 0){
            return Resultado.erro("Número inválido!");
        }

        //Categoria categoria = new Categoria(nome, descricao);
        Telefone telefones = new Telefone(telefone);
        Resultado resultado = dao.criar(telefones);
        return resultado;
    }

    public Resultado listarAgenda(){
       return null;
    }
}
