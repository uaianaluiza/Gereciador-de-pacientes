package br.com.zup.App.services;

import br.com.zup.App.models.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {
    private static List<Paciente> pacientes = new ArrayList<>();

    public Paciente salvarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        paciente.setHistorico(new ArrayList<>());

        return paciente;
    }

    public Paciente pesquiserPacientePeloCPF(String cpf) {
        for (Paciente paciente : pacientes) {
            if ( paciente.getCpf().equals(cpf) ) {
                return paciente;
            }
        }
        throw new RuntimeException("Paciente não encontrado pelo CPF indicado");
    }

    public void verificarSeCPFEstaCadastrado(String cpf) throws Exception {
        for (Paciente paciente : pacientes) {
            if ( paciente.getCpf().equals(cpf) ) {
                throw new Exception("CPF já cadastrado");
            }
        }
    }
}