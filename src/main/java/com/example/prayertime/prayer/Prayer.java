package com.example.prayertime.prayer;

import com.example.prayertime.region.Region;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prayer")
public class Prayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_region", referencedColumnName = "id_region")
    private Region region;

    @Column(name = "يوم", length = 20)
    private String يوم;

    @Column(name = "الهجري", length = 10)
    private String الهجري;

    @Column(name = "الميلادي")
    private Date الميلادي;

    @Column(name = "الامساك", length = 10)
    private String الامساك;

    @Column(name = "الفجر", length = 10)
    private String الفجر;

    @Column(name = "الشروق", length = 10)
    private String الشروق;

    @Column(name = "الظهر", length = 10)
    private String الظهر;

    @Column(name = "العصر", length = 10)
    private String العصر;

    @Column(name = "المغرب", length = 10)
    private String المغرب;

    @Column(name = "العشاء", length = 10)
    private String العشاء;

    // Constructors
    public Prayer() {
    }

    public Prayer(Long id, Region region, String يوم, String الهجري, Date الميلادي, String الامساك, String الفجر, String الشروق, String الظهر, String العصر, String المغرب, String العشاء) {
        this.id = id;
        this.region = region;
        this.يوم = يوم;
        this.الهجري = الهجري;
        this.الميلادي = الميلادي;
        this.الامساك = الامساك;
        this.الفجر = الفجر;
        this.الشروق = الشروق;
        this.الظهر = الظهر;
        this.العصر = العصر;
        this.المغرب = المغرب;
        this.العشاء = العشاء;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getيوم() {
        return يوم;
    }

    public void setيوم(String يوم) {
        this.يوم = يوم;
    }

    public String getالهجري() {
        return الهجري;
    }

    public void setالهجري(String الهجري) {
        this.الهجري = الهجري;
    }

    public Date getالميلادي() {
        return الميلادي;
    }

    public void setالميلادي(Date الميلادي) {
        this.الميلادي = الميلادي;
    }

    public String getالامساك() {
        return الامساك;
    }

    public void setالامساك(String الامساك) {
        this.الامساك = الامساك;
    }

    public String getالفجر() {
        return الفجر;
    }

    public void setالفجر(String الفجر) {
        this.الفجر = الفجر;
    }

    public String getالشروق() {
        return الشروق;
    }

    public void setالشروق(String الشروق) {
        this.الشروق = الشروق;
    }

    public String getالظهر() {
        return الظهر;
    }

    public void setالظهر(String الظهر) {
        this.الظهر = الظهر;
    }

    public String getالعصر() {
        return العصر;
    }

    public void setالعصر(String العصر) {
        this.العصر = العصر;
    }

    public String getالمغرب() {
        return المغرب;
    }

    public void setالمغرب(String المغرب) {
        this.المغرب = المغرب;
    }

    public String getالعشاء() {
        return العشاء;
    }

    public void setالعشاء(String العشاء) {
        this.العشاء = العشاء;
    }
}
