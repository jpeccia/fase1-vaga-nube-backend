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
@RequestMapping("/characters")
public class CharacterController {
    
    @Autowired
    private PersonagemRepository characterRepository;

    //Create
    @PostMapping("/")
    public Character createChar(@RequestBody Character character){
        return characterRepository.save(character);
    }

    //Read All
    @GetMapping
    public List<Character> getAllCharacters(){
        return characterRepository.findAll();
    }

    //Read by Id
    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id){
        return characterRepository.findById(id).orElse(null);
    }

    //Update
    @PutMapping("/{id}")
    public Character updateCharacter(@PathVariable Long id, @RequestBody Character characterDetails){
        Character character = characterRepository.findById(id).orElse(null);
        if(character != null){
            character.setName(characterDetails.getName());
            character.setCharacterClass(characterDetails.getCharacterClass());
            character.setLevel(characterDetails.getLevel());
            character.setExp(characterDetails.getExp());
            return characterRepository.save(character);
        }
        return null;
    }

    //Delete
    @DeleteMapping("/{id}")
    public void deletecharacter(@PathVariable Long id){
        characterRepository.deleteById(id);
    }
}
