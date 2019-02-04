package com.miage.altea.tp.trainer_api;

import com.miage.altea.tp.trainer_api.bo.Pokemon;
import com.miage.altea.tp.trainer_api.bo.Trainer;
import com.miage.altea.tp.trainer_api.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TrainerApi {

    public static void main(String... args){
        SpringApplication.run(TrainerApi.class, args);
    }

    @Bean
    @Autowired
    public CommandLineRunner demo(TrainerRepository repository) {
        return (args) -> {
            var ash = new Trainer("Ash");
            var pikachu = new Pokemon(25, 18);
            ash.setTeam(List.of(pikachu));

            var misty = new Trainer("Misty");
            var staryu = new Pokemon(120, 18);
            var starmie = new Pokemon(121, 21);
            misty.setTeam(List.of(staryu, starmie));

            // save a couple of trainers
            repository.save(ash);
            repository.save(misty);
        };
    }

}
