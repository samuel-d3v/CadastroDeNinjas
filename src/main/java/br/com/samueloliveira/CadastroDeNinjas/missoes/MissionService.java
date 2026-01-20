package br.com.samueloliveira.CadastroDeNinjas.missoes;

import br.com.samueloliveira.CadastroDeNinjas.exeptions.MissionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {
    public final MissionRepository missionRepository;
    public final MissionMapper missionMapper;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    public MissionResponseDTO createMission(RegisterMissionRequest missionRequest) {
        MissionModel missionModel = missionRepository.save(
                missionMapper.toEntity(missionRequest)
        );

        return missionMapper.toDTO(missionModel);
    }

    public List<MissionResponseDTO> listMission() {
        return missionRepository.findAll()
                .stream()
                .map(missionMapper::toDTO)
                .toList();
    }

    public MissionResponseDTO findMissionById(Long id) {
        MissionModel missionModel = missionRepository.findById(id)
                .orElseThrow(
                    () -> new MissionNotFoundException("Nenhuma missão foi encontrada com o ID: " + id)
                );

        return missionMapper.toDTO(missionModel);
    }

    public MissionResponseDTO updateMission(Long id, RegisterMissionRequest request) {
        findMissionById(id);

        MissionModel missionModel = missionMapper.toEntity(request);
        missionModel.setId(id);
        MissionModel missionSave = missionRepository.save(missionModel);

        return missionMapper.toDTO(missionSave);
    }

    public List<MissionResponseDTO> deleteMission(Long id) {
        missionRepository.deleteById(id);

        return listMission();
    }
}
