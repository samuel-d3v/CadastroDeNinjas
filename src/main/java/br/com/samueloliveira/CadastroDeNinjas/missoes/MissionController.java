package br.com.samueloliveira.CadastroDeNinjas.missoes;

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
    public List<MissionModel> createMission(MissionModel mission) {
        return service.createMission(mission);
    }

    @GetMapping("/all")
    public List<MissionModel> listMission() {
        return service.listMission();
    }

    @PutMapping("/update")
    public List<MissionModel> updateMission(MissionModel mission) {
        return service.updateMission(mission);
    }

    @DeleteMapping("{id}")
    public List<MissionModel> deleteMission(@PathVariable("id") Long id) {
        return service.deleteMission(id);
    }
}
