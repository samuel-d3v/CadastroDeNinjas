package br.com.samueloliveira.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    private MissionMapper(){}

    /**
    ** Maps registration request to new ninja model
    **/

    public MissionModel toEntity(RegisterMissionRequest request) {
        var missionModel = new MissionModel();
        missionModel.setNome(request.name());
        missionModel.setRank(request.rank());

        return missionModel;
    }

    /**
     * Maps mission model to response DTO
     */

    public MissionResponseDTO toDTO(MissionModel missionModel) {
        return new MissionResponseDTO(
                missionModel.getId(),
                missionModel.getNome(),
                missionModel.getRank());
    }
}
