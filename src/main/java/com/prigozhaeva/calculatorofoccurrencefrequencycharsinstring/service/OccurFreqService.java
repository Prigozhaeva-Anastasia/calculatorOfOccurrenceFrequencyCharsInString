package com.prigozhaeva.calculatorofoccurrencefrequencycharsinstring.service;

import java.util.Map;

public interface OccurFreqService {
    Map<Character, Integer> calculateFrequency(String str);
    Map<Character, Integer> sort(Map<Character, Integer> frequencyMap);
}
