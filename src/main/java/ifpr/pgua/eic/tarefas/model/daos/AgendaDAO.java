package ifpr.pgua.eic.tarefas.model.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.Agenda;

public interface AgendaDAO {
    Resultado criar(Agenda agenda);
}
