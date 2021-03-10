package br.com.zup.App.services;

import br.com.zup.App.models.Historico;
import br.com.zup.App.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoService {

    @Autowired
    private PacienteService pacienteService;

    public Historico registrarHistorico(String cpf, Historico historico){
        Paciente paciente = pacienteService.pesquiserPacientePeloCPF(cpf);
        paciente.getHistorico().add(historico);

        return historico;

    }

    private void ordenaHistoricosDoPaciente(Paciente paciente) {
        paciente.getHistorico().sort((Historico historico1, Historico historico2) -> {
            return historico2.getDataDoRegistro().compareTo(historico1.getDataDoRegistro());
        });
    }
}
