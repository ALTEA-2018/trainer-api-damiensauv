package com.miage.altea.tp.trainer_api.controller;

import com.miage.altea.tp.trainer_api.bo.Trainer;
import com.miage.altea.tp.trainer_api.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private final TrainerService trainerService;

    TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping
    Trainer createTrainer(Trainer trainer){
        return this.trainerService.createTrainer(trainer);
    }

    @PutMapping("/{name}")
    Trainer updateTrainer(@RequestBody Trainer trainer, @PathVariable String name){
        return this.trainerService.updateTrainer(name, trainer);
    }

    @DeleteMapping
    void deleteTrainer(Trainer trainer){
        this.trainerService.deleteTrainer(trainer);
    }

    @GetMapping("/")
    Iterable<Trainer> getAllTrainers() {
        return this.trainerService.getAllTrainers();
    }

    @GetMapping(value = "/{name}")
    Trainer getTrainer(@PathVariable String name) {
        return this.trainerService.getTrainer(name);
    }

}
