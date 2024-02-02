package com.prigozhaeva.calculatorofoccurrencefrequencycharsinstring.service.impl;

import com.prigozhaeva.calculatorofoccurrencefrequencycharsinstring.service.OccurFreqService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OccurFreqServiceImpl implements OccurFreqService {
    @Override
    public Map<Character, Integer> calculateFrequency(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    @Override
    public Map<Character, Integer> sort(Map<Character, Integer> frequencyMap) {
        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
