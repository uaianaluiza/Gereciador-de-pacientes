package br.com.zup.App.models;

import java.util.List;

public class Paciente {
    private String nome;
    private int idade;
    private String cpf;
    private List<Historico> historico;

    public Paciente(){
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Historico> getHistorico() {
        return historico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setHistorico(List<Historico> historico) {
        this.historico = historico;
    }
}
