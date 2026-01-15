package br.com.samueloliveira.CadastroDeNinjas.ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService service;

    public NinjaController(NinjaService service) {
        this.service = service;
    }

    @GetMapping("/teste")
    public String teste(){
        return "Teste ok";
    }

    @PostMapping("/create")
    public List<NinjaModel> createNinja(NinjaModel ninja) {
        return service.createNinja(ninja);
    }

    @GetMapping("/all")
    public List<NinjaModel> listNinjas() {
        return service.listNinjas();
    }

    @PutMapping("/update")
    public List<NinjaModel> updateNinja(NinjaModel ninja) {
        return service.updateNinja(ninja);
    }

    @DeleteMapping("{id}")
    public List<NinjaModel> deleteNinja(@PathVariable("id") Long id) {
        return service.deleteNinja(id);
    }
}
