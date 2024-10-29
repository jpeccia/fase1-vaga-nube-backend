package primeirafase.vaga.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import primeirafase.vaga.controller.CharacterController;
import primeirafase.vaga.entity.Character;
import primeirafase.vaga.repository.CharacterRepository;

@SpringBootTest
public class CharacterControllerTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private CharacterController characterController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    public void testGetAllChars() {
        Character character1 = new Character(null, "Mage", "Feiticeiro", 5, 100);
        Character character2 = new Character(null, "Warrior", "Guerreiro", 10, 500);

        when(characterRepository.findAll()).thenReturn(Arrays.asList(character1, character2));

        List<Character> chars = characterController.getAllCharacters();
        assertEquals(2, chars.size());
        verify(characterRepository, times(1)).findAll();
    }

    @Test
    public void testGetCharById() {
        Character character = new Character(null, "Mage", "Feiticeiro", 5, 100);
        character.setId(1L);

        when(characterRepository.findById(1L)).thenReturn(Optional.of(character));

        Character result = characterController.getCharacterById(1L);
        assertEquals("Mage", result.getName());
        verify(characterRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateChar() {
        Character character = new Character(null, "Rogue", "Ladino", 3, 50);

        when(characterRepository.save(character)).thenReturn(character);

        Character result = characterController.createChar(character);
        assertEquals("Rogue", result.getName());
        verify(characterRepository, times(1)).save(character);
    }
}