package br.com.zup.App.DTOs;

import br.com.zup.App.models.Paciente;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

public class PacienteDTO {

    private String nome;
    @Email(message = "E-mail inválido")
    private String email;
    @Min(value = 18, message = "Apenas maiores de 18 podem se cadastrar")
    private int idade;
    @CPF(message = "CPF inválido")
    private String cpf;

    public PacienteDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Paciente converterDTOparaPaciente(){
        Paciente paciente = new Paciente();
        paciente.setNome(this.nome);
        paciente.setCpf(this.cpf);
        paciente.setIdade(this.idade);

        return paciente;
    }
}
