package com.example.prayertime;

import com.example.prayertime.prayer.Prayer;
import com.example.prayertime.prayer.PrayerController;
import com.example.prayertime.prayer.PrayerService;
import com.example.prayertime.region.Region;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PrayerController.class)
public class PrayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrayerService prayerService;

    @Autowired
    private ObjectMapper objectMapper;

    private Prayer prayer1;
    private Prayer prayer2;

    @BeforeEach
    public void setUp() {
        Region region1 = new Region(1L, "Region 1");
        prayer1 = new Prayer(1L, region1, "يوم1", "الهجري1", new Date(), "04:30", "05:00", "06:00", "12:30", "15:30", "18:00", "19:30");
        prayer2 = new Prayer(2L, region1, "يوم2", "الهجري2", new Date(), "04:31", "05:01", "06:01", "12:31", "15:31", "18:01", "19:31");
    }

    @Test
    public void testGetAllPrayers() throws Exception {
        List<Prayer> prayers = Arrays.asList(prayer1, prayer2);

        when(prayerService.getAllPrayers()).thenReturn(prayers);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/prayers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(prayers.size()))
                .andExpect(jsonPath("$[0].يوم").value(prayer1.getيوم()))
                .andExpect(jsonPath("$[1].يوم").value(prayer2.getيوم()));

        verify(prayerService, times(1)).getAllPrayers();
    }

    @Test
    public void testGetPrayerById() throws Exception {
        when(prayerService.getPrayerById(anyLong())).thenReturn(prayer1);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/prayers/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.يوم").value(prayer1.getيوم()));

        verify(prayerService, times(1)).getPrayerById(1L);
    }

    @Test
    public void testCreatePrayer() throws Exception {
        when(prayerService.createPrayer(any(Prayer.class))).thenReturn(prayer1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/prayers/addprayer")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(prayer1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.يوم").value(prayer1.getيوم()));

        verify(prayerService, times(1)).createPrayer(any(Prayer.class));
    }

    @Test
    public void testUpdatePrayer() throws Exception {
        when(prayerService.updatePrayer(anyLong(), any(Prayer.class))).thenReturn(prayer1);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/prayers/updateprayer/{id}", 1L)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(prayer1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.يوم").value(prayer1.getيوم()));

        verify(prayerService, times(1)).updatePrayer(anyLong(), any(Prayer.class));
    }

    @Test
    public void testDeletePrayer() throws Exception {
        doNothing().when(prayerService).deletePrayer(anyLong());

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/prayers/{id}", 1L))
                .andExpect(status().isOk());

        verify(prayerService, times(1)).deletePrayer(1L);
    }
}
