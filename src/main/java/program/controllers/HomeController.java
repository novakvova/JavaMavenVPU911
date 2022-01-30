package program.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import program.repositories.RoleRepository;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final RoleRepository roleRepository;
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("roles", roleRepository.findAll());
        return "main/index";
    }
}
