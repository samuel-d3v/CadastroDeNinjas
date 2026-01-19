package br.com.samueloliveira.CadastroDeNinjas.missoes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {
    public final MissionService service;

    public MissionController(MissionService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public MissionResponseDTO createMission(@RequestBody RegisterMissionRequest missionRequest) {
        return service.createMission(missionRequest);
    }

    @GetMapping("/list")
    public List<MissionResponseDTO> listMission() {
        return service.listMission();
    }

    @GetMapping ("/list/{id}")
    public ResponseEntity<MissionResponseDTO> findMissionById(@PathVariable Long id){
         MissionResponseDTO mission = service.findMissionById(id);

        return ResponseEntity.ok(mission);
    }

    @PutMapping("/update/{id}")
    public MissionResponseDTO updateMission(@PathVariable Long id, @RequestBody RegisterMissionRequest missionRequest) {
        return service.updateMission(id, missionRequest);
    }

    @DeleteMapping("/delete/{id}")
    public List<MissionResponseDTO> deleteMission(@PathVariable Long id) {
        return service.deleteMission(id);
    }
}
