package com.prigozhaeva.calculatorofoccurrencefrequencycharsinstring.controller;

import com.prigozhaeva.calculatorofoccurrencefrequencycharsinstring.service.OccurFreqService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Validated
@RequestMapping("/api")
public class OccurFreqController {
    private OccurFreqService occurFreqService;

    public OccurFreqController(OccurFreqService occurFreqService) {
        this.occurFreqService = occurFreqService;
    }

    @GetMapping(value = "/calcFrequency/{str}")
    public Map<Character, Integer> calcOccurrenceFrequencyCharsInString(@PathVariable @NotBlank @Size(max = 10000) String str) {
        Map<Character, Integer> frequencyMap = occurFreqService.calculateFrequency(str);
        Map<Character, Integer> sortedFrequencyMap = occurFreqService.sort(frequencyMap);
        return sortedFrequencyMap;
    }
}
