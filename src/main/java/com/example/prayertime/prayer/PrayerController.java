package com.example.prayertime.prayer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/prayers")
public class PrayerController {

    private final PrayerService prayerService;

    @Autowired
    public PrayerController(PrayerService prayerService) {
        this.prayerService = prayerService;
    }

    @GetMapping
    public List<Prayer> getAllPrayers() {
        return prayerService.getAllPrayers();
    }

    @GetMapping("/{id}")
    public Prayer getPrayerById(@PathVariable Long id) {
        return prayerService.getPrayerById(id);
    }

    @PostMapping("addprayer")
    public Prayer createPrayer(@RequestBody Prayer prayer) {
        return prayerService.createPrayer(prayer);
    }

    @PutMapping("updateprayer/{id}")
    public Prayer updatePrayer(@PathVariable Long id, @RequestBody Prayer prayer) {
        return prayerService.updatePrayer(id, prayer);
    }

    @DeleteMapping("/{id}")
    public void deletePrayer(@PathVariable Long id) {
        prayerService.deletePrayer(id);
    }
}
