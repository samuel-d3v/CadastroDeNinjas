package br.com.samueloliveira.CadastroDeNinjas.ninjas;

import org.springframework.http.HttpStatus;
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

    /**
     * Responds with ninja or error message
     */
    @PostMapping("/create")
    public ResponseEntity<String> createNinja(@RequestBody RegisterNinjaRequest request) {
        try {
            NinjaResponseDTO ninja = service.createNinja(request);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Ninja " + ninja.nome() + " criado com sucesso com ID: " + ninja.id());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Não foi possível cadastrar o ninja com os dados fornecidos");
        }
    }

    /**
     *
     * Responds with ninjas list
     */
    @GetMapping("/list")
    public ResponseEntity<List<NinjaResponseDTO>> listNinjas() {
        List<NinjaResponseDTO> ninjas = service.listNinjas();
        return ResponseEntity.ok(ninjas);
    }

    /**
     * Responds with ninja or not found message
     */
    @GetMapping("/list/{id}")
    public ResponseEntity<?> findNinjaById(@PathVariable Long id) {
        try {
            NinjaResponseDTO ninja = service.listNinjaById(id);
            return ResponseEntity
                    .ok(ninja);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    /**
     * Updates ninja by ID; responds with ninja or not found
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNinja( @PathVariable Long id, @RequestBody RegisterNinjaRequest ninja) {
        try {
            service.listNinjaById(id);

            service.updateNinja(id, ninja);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ninja);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    /**
     * Deletes ninja by ID; returns success or not found
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinja(@PathVariable Long id) {
        try {
            service.listNinjaById(id);

            service.deleteNinja(id);
            return ResponseEntity.ok("Ninja com ID " + id + " deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
