package ifpr.pgua.eic.tarefas.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.tarefas.model.entities.Email;
import ifpr.pgua.eic.tarefas.utils.DBUtils;

public class JDBCEmailDAO implements EmailDAO{
    private FabricaConexoes fabrica;

    public JDBCEmailDAO(FabricaConexoes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public Resultado criar(Email email) {
        try (Connection con = fabrica.getConnection()){
            // Preparar o comando sql
            PreparedStatement pstm = con.prepareStatement("INSERT INTO email(email) values ?", Statement.RETURN_GENERATED_KEYS);
            // Ajustar os parâmetros
            pstm.setString(1, email.getEmail());
            // Executar o comando
            int ret = pstm.executeUpdate();

            if (ret == 1) {
                int id = DBUtils.getLastId(pstm);

                email.setId(id);

                return Resultado.sucesso("Email cadastrado!", email);
            }
            return Resultado.erro("Erro não identificado!");
        } catch (SQLException e) {
            return Resultado.erro(e.getMessage());
        }
    }
}
