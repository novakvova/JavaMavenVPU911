package program.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import program.dto.admin.authordto.AuthorAddDto;
import program.dto.admin.roledto.RoleAddDto;
import program.entities.Author;
import program.entities.Role;
import program.mapper.ApplicationMapper;
import program.repositories.AuthorRepository;
import program.repositories.RoleRepository;
import program.storage.StorageService;

import java.util.List;

@RestController
@RequestMapping("admin/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final StorageService storageService;
    private final AuthorRepository authorRepository;
    private final ApplicationMapper mapper;

    @PostMapping("")
    public String create(AuthorAddDto model) {
        Author author = mapper.AuthorByAddAuthorDto(model);
        String fileName=storageService.store(model.getImageBase64());
        author.setImage(fileName);
        authorRepository.save(author);
        return fileName;
    }
    @GetMapping("")
    public List<Author> list() {
        return authorRepository.findAll();
    }
}
