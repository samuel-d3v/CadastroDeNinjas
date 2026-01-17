package br.com.samueloliveira.CadastroDeNinjas.ninjas;

import br.com.samueloliveira.CadastroDeNinjas.missoes.MissionModel;

public record NinjaResponseDTO(Long id, String nome, int idade, String email, String level, MissionModel missao) {
}
