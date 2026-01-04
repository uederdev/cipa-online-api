package br.com.ueder.cipa_online.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String message) {
        super("Registro não encontrado: " + message);
    }

    public ObjectNotFoundException() {
        super();
    }
}
