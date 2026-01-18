package br.com.samueloliveira.CadastroDeNinjas.ninjas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService service;

    public NinjaController(NinjaService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public NinjaResponseDTO createNinja(@RequestBody RegisterNinjaRequest request) {
        return service.createNinja(request);
    }

    @GetMapping("/list")
    public List<NinjaResponseDTO> listNinjas() {
        return service.listNinjas();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<NinjaResponseDTO> findNinjaById(@PathVariable Long id) {
        NinjaResponseDTO ninja = service.listNinjaById(id);

        return ResponseEntity.ok(ninja);
    }

    @PutMapping("/update/{id}")
    public NinjaResponseDTO updateNinja( @PathVariable Long id, @RequestBody RegisterNinjaRequest ninja) {
        return service.updateNinja(id, ninja);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<NinjaResponseDTO>> deleteNinja(@PathVariable Long id) {
        List<NinjaResponseDTO> ninja = service.deleteNinja(id);

        return ResponseEntity.ok(ninja);
    }
}
