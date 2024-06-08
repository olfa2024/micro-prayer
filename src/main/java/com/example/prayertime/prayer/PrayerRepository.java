package com.example.prayertime.prayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrayerRepository extends JpaRepository<Prayer, Long> {
    // Ajoutez des méthodes personnalisées pour accéder aux données de Prayer si nécessaire
}
