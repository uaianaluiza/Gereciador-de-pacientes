package br.com.zup.App.exceptions;

public class PacienteNaoEncontradoException extends RuntimeException{
    private int status = 400;
    private String campo = " CPF ";
    private String razao = "Pedido Incorreto";
    private String tipoErro = "Objeto Não Encontrado";

    public PacienteNaoEncontradoException(String mensagem) {
        super( mensagem);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getTipoErro() {
        return tipoErro;
    }

    public void setTipoErro(String tipoErro) {
        this.tipoErro = tipoErro;
    }
}
