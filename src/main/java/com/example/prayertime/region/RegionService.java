package com.example.prayertime.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Region getRegionById(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Region not found with id: " + id));
    }

    public Region addRegion(Region region) {
        return regionRepository.save(region);
    }

    public Region updateRegion(Long id, Region newRegion) {
        return regionRepository.findById(id)
                .map(region -> {
                    region.setNom(newRegion.getNom());
                    return regionRepository.save(region);
                })
                .orElseThrow(() -> new RuntimeException("Region not found with id: " + id));
    }

    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }
}