package br.com.samueloliveira.CadastroDeNinjas.ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    private NinjaMapper(){}

    /**
     * Maps ninja model to response DTO
     */
    public NinjaResponseDTO toDTO(NinjaModel ninjaModel) {
        return new NinjaResponseDTO(
                ninjaModel.getId(),
                ninjaModel.getNome(),
                ninjaModel.getIdade(),
                ninjaModel.getEmail(),
                ninjaModel.getLevel(),
                ninjaModel.getMissao()
        );
    }

    /**
     * Maps registration request to new ninja model
     */
    public NinjaModel toEntity(RegisterNinjaRequest request) {
        var ninjaModel = new NinjaModel();
        ninjaModel.setNome(request.nome());
        ninjaModel.setIdade(request.idade());
        ninjaModel.setEmail(request.email());
        ninjaModel.setLevel(request.level());
        ninjaModel.setMissao(request.missao());

        return ninjaModel;
    }
}
