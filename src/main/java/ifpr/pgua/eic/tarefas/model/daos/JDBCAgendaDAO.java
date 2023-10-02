package ifpr.pgua.eic.tarefas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.Agenda;
import ifpr.pgua.eic.tarefas.utils.DBUtils;

public class JDBCAgendaDAO implements AgendaDAO{

    private FabricaConexoes fabrica;

    public JDBCAgendaDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criar(Agenda agenda) {
        try (Connection con = fabrica.getConnection()){
            // Preparar o comando sql
            PreparedStatement pstm = con.prepareStatement("INSERT INTO agenda(nome) values ?", Statement.RETURN_GENERATED_KEYS);
            // Ajustar os parâmetros
            pstm.setString(1, agenda.getNome());
            // Executar o comando
            int ret = pstm.executeUpdate();

            if (ret == 1) {
                int id = DBUtils.getLastId(pstm);

                agenda.setId(id);

                return Resultado.sucesso("Nova Agenda cadastrada!", agenda);
            }
            return Resultado.erro("Erro não identificado!");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }
    
}
