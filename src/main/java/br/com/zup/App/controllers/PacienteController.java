package br.com.zup.App.controllers;


import br.com.zup.App.DTOs.PacienteDTO;
import br.com.zup.App.models.Paciente;
import br.com.zup.App.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("pacientes/")

public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente cadastrarPaciente(@RequestBody @Valid PacienteDTO pacienteDTO){
        Paciente objetoPaciente = pacienteService.salvarPaciente(pacienteDTO.converterDTOparaPaciente());
        return objetoPaciente;
    }
    @GetMapping("{cpf}/")
    public Paciente pesquisarPaciente(@PathVariable String cpf){
        try {
            Paciente paciente = pacienteService.pesquiserPacientePeloCPF(cpf);
            return paciente;
        }catch (RuntimeException erro){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erro.getMessage());
        }
    }
}
