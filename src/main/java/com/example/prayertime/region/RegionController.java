package com.example.prayertime.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/regions")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable Long id) {
        return regionService.getRegionById(id);
    }

    @PostMapping
    public Region addRegion(@RequestBody Region region) {
        return regionService.addRegion(region);
    }

    @PutMapping("/{id}")
    public Region updateRegion(@PathVariable Long id, @RequestBody Region region) {
        return regionService.updateRegion(id, region);
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable Long id) {
        regionService.deleteRegion(id);
    }
}