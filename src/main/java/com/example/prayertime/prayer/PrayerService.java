package com.example.prayertime.prayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrayerService {

    private final PrayerRepository prayerRepository;

    @Autowired
    public PrayerService(PrayerRepository prayerRepository) {
        this.prayerRepository = prayerRepository;
    }

    public List<Prayer> getAllPrayers() {
        return prayerRepository.findAll();
    }

    public Prayer getPrayerById(Long id) {
        return prayerRepository.findById(id).orElse(null);
    }

    public Prayer createPrayer(Prayer prayer) {
        return prayerRepository.save(prayer);
    }

    public Prayer updatePrayer(Long id, Prayer prayer) {
        if (prayerRepository.existsById(id)) {
            prayer.setId(id);
            return prayerRepository.save(prayer);
        }
        return null; // Handle not found case
    }

    public void deletePrayer(Long id) {
        prayerRepository.deleteById(id);
    }

    // Ajoutez d'autres méthodes pour les opérations métier si nécessaire
}
