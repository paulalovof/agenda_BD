package ifpr.pgua.eic.tarefas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.Telefone;
import ifpr.pgua.eic.tarefas.utils.DBUtils;

public class JDBCTelefoneDAO implements TelefoneDAO{
    private FabricaConexoes fabrica;

    public JDBCTelefoneDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criar(Telefone telefone) {
        try (Connection con = fabrica.getConnection()){
            // Preparar o comando sql
            PreparedStatement pstm = con.prepareStatement("INSERT INTO agenda(nome) values ?", Statement.RETURN_GENERATED_KEYS);
            // Ajustar os parâmetros
            pstm.setInt(1, telefone.getTelefone());
            // Executar o comando
            int ret = pstm.executeUpdate();

            if (ret == 1) {
                int id = DBUtils.getLastId(pstm);

                telefone.setId(id);

                return Resultado.sucesso("Telefone cadastrada!", telefone);
            }
            return Resultado.erro("Erro não identificado!");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }
    
}
