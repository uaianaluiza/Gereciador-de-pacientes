package br.com.zup.App.controllers;

import br.com.zup.App.models.Historico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

public class HistoricoController {

    @Autowired
    private HistoricoController historicoService;

    @PostMapping("{cpf}/")
    public Historico registrarHistorico(@RequestBody Historico historico, @PathVariable String cpf){
        try {
            Historico objHistorico = historicoService.registrarHistorico(historico,cpf);
            return objHistorico;
        }catch (RuntimeException error){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error.getMessage());
        }
    }
}
