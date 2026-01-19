package br.com.samueloliveira.CadastroDeNinjas.exeptions;

public class MissionNotFoundException extends RuntimeException {
    public MissionNotFoundException(String message) {
        super(message);
    }
}
