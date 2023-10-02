package ifpr.pgua.eic.tarefas.model.daos;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.Telefone;

public interface TelefoneDAO {
    Resultado criar(Telefone telefone);
}
