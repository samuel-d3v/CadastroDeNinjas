package br.com.samueloliveira.CadastroDeNinjas.missoes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("missions/ui")
public class MissionControlerUi {
    MissionService missionService;
    MissionMapper missionMapper;

    public MissionControlerUi(MissionService missionService, MissionMapper missionMapper) {
        this.missionService = missionService;
        this.missionMapper = missionMapper;
    }

    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("mission", new RegisterMissionForm());

        return "addMission";
    }

    @PostMapping("/save")
    public String addMission(@RequestBody @ModelAttribute RegisterMissionForm missionForm, RedirectAttributes redirectAttributes) {
        missionService.createMission(missionMapper.toRegisterDTO(missionForm));
        redirectAttributes.addFlashAttribute("mensagem", "Missao cadastrada");

        return "redirect:/missions/ui/list";
    }

    @GetMapping("/list")
    public String listMission(Model model) {
        model.addAttribute("missions", missionService.listMission());

        return "listMissions";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable long id, Model model) {
        missionService.findMissionById(id);
        RegisterMissionForm missionForm = new RegisterMissionForm();
        missionForm.setId(id);
        model.addAttribute("mission", missionForm);

        return "updateMission";
    }

    @PostMapping("/save/update/{id}")
    public String updateMission(@ModelAttribute RegisterMissionForm missionForm, RedirectAttributes redirectAttributes) {
        missionService.updateMission(missionForm.getId(), missionMapper.toRegisterDTO(missionForm));
        redirectAttributes.addFlashAttribute("mission", missionForm);

        return "redirect:/missions/ui/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteMission(@PathVariable long id) {
        missionService.deleteMission(id);

        return "redirect:/missions/ui/list";
    }
}
