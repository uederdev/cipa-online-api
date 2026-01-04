package br.com.ueder.cipa_online.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ErroApi {

    public String mensagem;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    public LocalDateTime dataHora = LocalDateTime.now();

    public ErroApi(String mensagem) {
        this.mensagem = mensagem;
    }
}
