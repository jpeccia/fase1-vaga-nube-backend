package primeirafase.vaga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import primeirafase.vaga.entity.Character;
import primeirafase.vaga.repository.PersonagemRepository;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {
    
    @Autowired
    private PersonagemRepository personagemRepository;

    //Create
    @PostMapping("/")
    public Character createPersonagem(@RequestBody Character personagem){
        return personagemRepository.save(personagem);
    }

    //Read All
    @GetMapping
    public List<Character> getAllPersonagens(){
        return personagemRepository.findAll();
    }

    //Read by Id
    @GetMapping("/{id}")
    public Character getPersonagemById(@PathVariable Long id){
        return personagemRepository.findById(id).orElse(null);
    }

    //Update
    @PutMapping("/{id}")
    public Character updatePersonagem(@PathVariable Long id, @RequestBody Character personagemDetails){
        Character personagem = personagemRepository.findById(id).orElse(null);
        if(personagem != null){
            personagem.setNome(personagemDetails.getNome());
            personagem.setClasse(personagemDetails.getClasse());
            personagem.setNivel(personagemDetails.getNivel());
            personagem.setExp(personagemDetails.getExp());
            return personagemRepository.save(personagem);
        }
        return null;
    }

    //Delete
    @DeleteMapping("/{id}")
    public void deletePersonagem(@PathVariable Long id){
        personagemRepository.deleteById(id);
    }
}
