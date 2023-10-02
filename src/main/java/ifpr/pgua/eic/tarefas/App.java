package ifpr.pgua.eic.tarefas;


import ifpr.pgua.eic.tarefas.controllers.Cadastro;
import ifpr.pgua.eic.tarefas.controllers.CadastroAgenda;
import ifpr.pgua.eic.tarefas.controllers.CadastroEmail;
import ifpr.pgua.eic.tarefas.controllers.CadastroTelefone;
import ifpr.pgua.eic.tarefas.controllers.Principal;
import ifpr.pgua.eic.tarefas.model.daos.AgendaDAO;
import ifpr.pgua.eic.tarefas.model.daos.EmailDAO;
import ifpr.pgua.eic.tarefas.model.daos.JDBCAgendaDAO;
import ifpr.pgua.eic.tarefas.model.daos.JDBCEmailDAO;
import ifpr.pgua.eic.tarefas.model.daos.TelefoneDAO;
import ifpr.pgua.eic.tarefas.model.daos.JDBCTelefoneDAO;
import ifpr.pgua.eic.tarefas.model.daos.FabricaConexoes;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioAgenda;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioEmail;
import ifpr.pgua.eic.tarefas.model.repositories.RepositorioTelefone;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private AgendaDAO agendaDAO =  new JDBCAgendaDAO(FabricaConexoes.getInstance());
    private RepositorioAgenda repositorioAgenda = new RepositorioAgenda(agendaDAO);

    private EmailDAO emailDAO =  new JDBCEmailDAO(FabricaConexoes.getInstance());
    private RepositorioEmail repositorioEmail = new RepositorioEmail(agendaDAO, emailDAO);

    private TelefoneDAO telefoneDAO =  new JDBCTelefoneDAO(FabricaConexoes.getInstance());
    private RepositorioTelefone repositorioTelefone = new RepositorioTelefone(agendaDAO, telefoneDAO);
    
    public static void main(String[] args) {
        launch();
    }

    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }


    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Coleção de Músicas";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "principal.fxml", o->new Principal()));

        registraTela("CADASTRO", new ScreenRegistryFXML(App.class, "cadastrar.fxml", o->new Cadastro()));

        registraTela("CADASTROAGENDA", new ScreenRegistryFXML(App.class, "cadastrar_agenda.fxml", o->new CadastroAgenda(repositorioAgenda)));

        registraTela("CADASTROEMAIL", new ScreenRegistryFXML(App.class, "cadastrar_email.fxml", o->new CadastroEmail(repositorioEmail, repositorioAgenda)));

        registraTela("CADASTROTELEFONE", new ScreenRegistryFXML(App.class, "cadastrar_telefone.fxml", o->new CadastroTelefone(repositorioTelefone, repositorioAgenda)));
    }

}