package com.miage.altea.tp.trainer_api.service;

import com.miage.altea.tp.trainer_api.bo.Trainer;

public interface TrainerService {

    Iterable<Trainer> getAllTrainers();
    Trainer getTrainer(String name);
    Trainer createTrainer(Trainer trainer);
    Trainer updateTrainer(String name, Trainer trainer);
    void deleteTrainer(Trainer trainer);
}
