package br.com.zup.App.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ManipuladorDeExcecoes extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        List<ObjetoDeErro> objetosDeErros = getErros(ex);
        RespostaDeErro resErro = new RespostaDeErro("Validação", status.value(),
                status.getReasonPhrase(), objetosDeErros);
        return ResponseEntity.status(status).body(resErro);
    }

    private List<ObjetoDeErro> getErros(MethodArgumentNotValidException exception) {
        List<ObjetoDeErro> objetosDeErro = new ArrayList<>();
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();


        for (FieldError error : errors) {
            ObjetoDeErro objetoDeErro = new ObjetoDeErro(error.getDefaultMessage(), error.getField());
            objetosDeErro.add(objetoDeErro);
        }
            return objetosDeErro;
        }

        @ExceptionHandler({PacienteNaoEncontradoException.class})
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public RespostaDeErro manipularRuntimeException (PacienteNaoEncontradoException erro){
            ObjetoDeErro objetoDeErro = new ObjetoDeErro(erro.getMessage(), erro.getCampo());
            RespostaDeErro respostaDeErro = new RespostaDeErro(erro.getTipoErro(), erro.getStatus(), erro.getRazao(),
                    Arrays.asList(objetoDeErro));

            return respostaDeErro;
        }
    }


