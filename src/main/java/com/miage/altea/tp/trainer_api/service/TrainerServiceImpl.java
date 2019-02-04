package com.miage.altea.tp.trainer_api.service;

import com.miage.altea.tp.trainer_api.bo.Trainer;
import com.miage.altea.tp.trainer_api.repository.TrainerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService {

    private TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Iterable<Trainer> getAllTrainers() {
        return this.trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainer(String name) {
        return this.trainerRepository.findById(name).orElse(null);
    }

    @Override
    public Trainer createTrainer(Trainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    @Override
    public Trainer updateTrainer(String name, Trainer update) {
        Trainer origin = this.getTrainer(name);
        if (origin == null)
            return null;
        BeanUtils.copyProperties(update, origin, "name");

        return this.trainerRepository.save(origin);
    }

    @Override
    public void deleteTrainer(Trainer trainer) {
        this.trainerRepository.delete(trainer);
    }
}
