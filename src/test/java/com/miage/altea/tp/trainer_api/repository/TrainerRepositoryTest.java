package com.miage.altea.tp.trainer_api.repository;

import com.miage.altea.tp.trainer_api.TrainerApi;
import com.miage.altea.tp.trainer_api.bo.Pokemon;
import com.miage.altea.tp.trainer_api.bo.Trainer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrainerApi.class, loader = AnnotationConfigContextLoader.class)
public class TrainerRepositoryTest {

    @Autowired
    private TrainerRepository repository;

    @Test
    public void trainerRepository_shouldExtendsCrudRepository() throws NoSuchMethodException {
        assertTrue(CrudRepository.class.isAssignableFrom(TrainerRepository.class));
    }

    @Test
    public void trainerRepositoryShouldBeInstanciedBySpring() {
        assertNotNull(repository);
    }

    @Test
    public void testSave() {
        var ash = new Trainer("Ash");

        repository.save(ash);

        var saved = repository.findById(ash.getName()).orElse(null);

        assertEquals(ash.getName(), saved.getName());
    }

    @Test
    public void testSaveWithPokemons() {
        var misty = new Trainer("Misty");
        var staryu = new Pokemon(120, 18);
        var starmie = new Pokemon(121, 21);
        misty.setTeam(List.of(staryu, starmie));

        repository.save(misty);

        var saved = repository.findById(misty.getName()).orElse(null);

        assertEquals(misty.getName(), saved.getName());
        assertEquals(misty.getTeam().size(), saved.getTeam().size());
    }

}
