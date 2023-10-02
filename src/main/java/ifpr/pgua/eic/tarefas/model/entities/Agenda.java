package ifpr.pgua.eic.tarefas.model.entities;

import java.util.ArrayList;

public class Agenda {
    private int id;
    private String nome;
    private ArrayList<Email> email;
    private ArrayList<Telefone> telefone;

    public Agenda(int id, String nome, ArrayList<Email> email, ArrayList<Telefone> telefone){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Agenda(String nome, ArrayList<Email> email, ArrayList<Telefone> telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return nome+" ("+id+")";
    }

    public ArrayList<Email> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<Email> email) {
        this.email = email;
    }

    public ArrayList<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(ArrayList<Telefone> telefone) {
        this.telefone = telefone;
    }
}
