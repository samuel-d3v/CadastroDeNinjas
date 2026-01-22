package br.com.samueloliveira.CadastroDeNinjas.ninjas;

import br.com.samueloliveira.CadastroDeNinjas.exeptions.MissionNotFoundException;
import br.com.samueloliveira.CadastroDeNinjas.exeptions.NinjaNotFoundException;
import br.com.samueloliveira.CadastroDeNinjas.missoes.MissionModel;
import br.com.samueloliveira.CadastroDeNinjas.missoes.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository repository;
    private final NinjaMapper ninjaMapper;
    private final MissionRepository missionRepository;

    public NinjaService(NinjaRepository repository, NinjaMapper ninjaMapper, MissionRepository missionRepository) {
        this.repository = repository;
        this.ninjaMapper = ninjaMapper;
        this.missionRepository = missionRepository;
    }

    public NinjaResponseDTO createNinja(RegisterNinjaRequest request) {
        NinjaModel ninja = ninjaMapper.toEntity(request);

        MissionModel missao = missionRepository.findById(request.missaoId())
                .orElseThrow(
                        () -> new MissionNotFoundException("Missão não encontrada")
                );

        ninja.setMissao(missao);
        ninja = repository.save(ninja);

        return ninjaMapper.toDTO(ninja);
    }

    public List<NinjaResponseDTO> listNinjas(){
        List<NinjaModel> ninjas = repository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::toDTO)
                .toList();
    }

    public NinjaResponseDTO listNinjaById(Long id) {
         NinjaModel ninja = repository.findById(id)
                .orElseThrow(
                        () -> new NinjaNotFoundException("Nenhum ninja foi encontrado com o ID: " + id)
                );

        return ninjaMapper.toDTO(ninja);
    }

    public NinjaResponseDTO updateNinja(Long id, RegisterNinjaRequest request) {
        listNinjaById(id);

        MissionModel missao = missionRepository.findById(request.missaoId())
                .orElseThrow(
                        () -> new MissionNotFoundException("Missão não encontrada")
                );

        NinjaModel ninja = ninjaMapper.toEntity(request);
        ninja.setId(id);
        ninja.setMissao(missao);

        NinjaModel ninjaSave = repository.save(ninja);
        return ninjaMapper.toDTO(ninjaSave);
    }

    public List<NinjaResponseDTO> deleteNinja(Long id) {
        repository.deleteById(id);

        return listNinjas();
    }
}
