package br.com.samueloliveira.CadastroDeNinjas.ninjas;

public record RegisterNinjaRequest(String nome, int idade, String email, String level, Long missaoId, String imagemUrl){
}
