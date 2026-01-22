package br.com.samueloliveira.CadastroDeNinjas.ninjas;

import br.com.samueloliveira.CadastroDeNinjas.missoes.RegisterMissionRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {
    private final NinjaService service;
    private final NinjaMapper ninjaMapper;

    public NinjaControllerUi(NinjaService service, NinjaMapper ninjaMapper) {
        this.service = service;
        this.ninjaMapper = ninjaMapper;
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("ninja", new RegisterNinjaForm());
        return "adicionarNinja";
    }

    @PostMapping("/save")
    public String saveNinja(@ModelAttribute RegisterNinjaForm form, RedirectAttributes redirectAttributes) {
        service.createNinja(ninjaMapper.toRegisterDTO(form));
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado");

        return "redirect:/ninjas/ui/list";

    }

    /**
     *
     * Responds with ninjas list
     */
    @GetMapping("/list")
    public String listNinjas(Model model) {
        List<NinjaResponseDTO> ninjas = service.listNinjas();
        model.addAttribute("ninjas", ninjas);

        return "listNinjas";
    }

    /**
     * Responds with ninja or not found message
     */
    @GetMapping("/list/{id}")
    public String findNinjaById(@PathVariable Long id, Model model) {
        NinjaResponseDTO ninja = service.listNinjaById(id);

        if(ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesNinja";
        }

        model.addAttribute("mensagem", "Ninja não encontrado");
        return "listNinjas";
    }

    @GetMapping("/update/{id}")
    public String showNinjaUpdate(@PathVariable Long id, Model model) {
        service.listNinjaById(id);
        RegisterNinjaForm ninjaForm = new RegisterNinjaForm();
        ninjaForm.setId(id);

        model.addAttribute("ninja", ninjaForm);
        return "updateNinja";
    }

    /**
     * Updates ninja by ID; responds with ninja or not found
     */
    @PostMapping("/save/update/{id}")
    public String updateNinja(@ModelAttribute RegisterNinjaForm ninjaForm, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("ninja", ninjaForm);
        service.updateNinja(ninjaForm.getId(), ninjaMapper.toRegisterDTO(ninjaForm));

        return "redirect:/ninjas/ui/list";
    }

    /**
     * Deletes ninja by ID; returns success or not found
     */
    @GetMapping("/delete/{id}")
    public String deleteNinja(@PathVariable Long id) {
        service.deleteNinja(id);

        return "redirect:/ninjas/ui/list";
    }

}
