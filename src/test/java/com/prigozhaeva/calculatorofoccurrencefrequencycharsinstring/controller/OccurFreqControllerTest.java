package com.prigozhaeva.calculatorofoccurrencefrequencycharsinstring.controller;

import com.prigozhaeva.calculatorofoccurrencefrequencycharsinstring.service.OccurFreqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OccurFreqController.class)
class OccurFreqControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OccurFreqService occurFreqService;

    @Test
    void testCalcOccurrenceFrequencyCharsInString() throws Exception {
        String inputString = "abc";
        Map<Character, Integer> frequencyMap = createFrequencyMap();
        Map<Character, Integer> sortedFrequencyMap = createSortedFrequencyMap();

        when(occurFreqService.calculateFrequency(inputString)).thenReturn(frequencyMap);
        when(occurFreqService.sort(frequencyMap)).thenReturn(sortedFrequencyMap);

        mockMvc.perform(get("/api/calcFrequency/{str}", inputString))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.a").value(1))
                .andExpect(jsonPath("$.b").value(1))
                .andExpect(jsonPath("$.c").value(1));
    }

    @Test
    void testCalcOccurrenceFrequencyCharsInStringValidationException() throws Exception {
        String inputString = " ";

        mockMvc.perform(get("/api/calcFrequency/{str}", inputString))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").exists());
    }

    private  Map<Character, Integer> createFrequencyMap() {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put('a', 1);
        frequencyMap.put('b', 1);
        frequencyMap.put('c', 1);
        return frequencyMap;
    }

    private  Map<Character, Integer> createSortedFrequencyMap() {
        Map<Character, Integer> sortedFrequencyMap = new HashMap<>();
        sortedFrequencyMap.put('c', 1);
        sortedFrequencyMap.put('b', 1);
        sortedFrequencyMap.put('a', 1);
        return sortedFrequencyMap;
    }
}