package primeirafase.vaga.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import primeirafase.vaga.controller.PersonagemController;
import primeirafase.vaga.entity.Personagem;
import primeirafase.vaga.repository.PersonagemRepository;

@SpringBootTest
public class PersonagemControllerTest {

    @Mock
    private PersonagemRepository personagemRepository;

    @InjectMocks
    private PersonagemController personagemController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    
    public void testGetAllPersonagens() {
        Personagem personagem1 = new Personagem(null, "Mage", "Feiticeiro", 5, 100);
        Personagem personagem2 = new Personagem(null, "Warrior", "Guerreiro", 10, 500);

        when(personagemRepository.findAll()).thenReturn(Arrays.asList(personagem1, personagem2));

        List<Personagem> personagens = personagemController.getAllPersonagens();
        assertEquals(2, personagens.size());
        verify(personagemRepository, times(1)).findAll();
    }

    @Test
    public void testGetPersonagemById() {
        Personagem personagem = new Personagem(null, "Mage", "Feiticeiro", 5, 100);
        personagem.setId(1L);

        when(personagemRepository.findById(1L)).thenReturn(Optional.of(personagem));

        Personagem result = personagemController.getPersonagemById(1L);
        assertEquals("Mage", result.getNome());
        verify(personagemRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreatePersonagem() {
        Personagem personagem = new Personagem(null, "Rogue", "Ladino", 3, 50);

        when(personagemRepository.save(personagem)).thenReturn(personagem);

        Personagem result = personagemController.createPersonagem(personagem);
        assertEquals("Rogue", result.getNome());
        verify(personagemRepository, times(1)).save(personagem);
    }
}