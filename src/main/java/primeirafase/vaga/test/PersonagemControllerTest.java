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

import primeirafase.vaga.controller.PersonagemController;
import primeirafase.vaga.entity.Character;
import primeirafase.vaga.repository.PersonagemRepository;

@SpringBootTest
public class PersonagemControllerTest {

    @Mock
    private PersonagemRepository personagemRepository;

    @InjectMocks
    private PersonagemController personagemController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    public void testGetAllPersonagens() {
        Character personagem1 = new Character(null, "Mage", "Feiticeiro", 5, 100);
        Character personagem2 = new Character(null, "Warrior", "Guerreiro", 10, 500);

        when(personagemRepository.findAll()).thenReturn(Arrays.asList(personagem1, personagem2));

        List<Character> personagens = personagemController.getAllPersonagens();
        assertEquals(2, personagens.size());
        verify(personagemRepository, times(1)).findAll();
    }

    @Test
    public void testGetPersonagemById() {
        Character personagem = new Character(null, "Mage", "Feiticeiro", 5, 100);
        personagem.setId(1L);

        when(personagemRepository.findById(1L)).thenReturn(Optional.of(personagem));

        Character result = personagemController.getPersonagemById(1L);
        assertEquals("Mage", result.getNome());
        verify(personagemRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreatePersonagem() {
        Character personagem = new Character(null, "Rogue", "Ladino", 3, 50);

        when(personagemRepository.save(personagem)).thenReturn(personagem);

        Character result = personagemController.createPersonagem(personagem);
        assertEquals("Rogue", result.getNome());
        verify(personagemRepository, times(1)).save(personagem);
    }
}