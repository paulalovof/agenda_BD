package ifpr.pgua.eic.tarefas.model.entities;

public class Telefone {
    private int id;
    private int telefone;

    public Telefone(int id, int telefone){
        this.id = id;
        this.telefone = telefone;
    }

    public Telefone(int telefone){
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String toString(){
        return ""+telefone;
    }
}
