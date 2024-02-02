package com.prigozhaeva.calculatorofoccurrencefrequencycharsinstring.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class OccurFreqServiceImplTest {
    @Test
    void testCalculateFrequency() {
        String inputString = "abccdddeee";
        OccurFreqServiceImpl occurFreqService = new OccurFreqServiceImpl();

        Map<Character, Integer> result = occurFreqService.calculateFrequency(inputString);

        assertEquals(1, result.get('a'));
        assertEquals(1, result.get('b'));
        assertEquals(2, result.get('c'));
        assertEquals(3, result.get('d'));
        assertEquals(3, result.get('e'));
    }

    @Test
    void testSort() {
        OccurFreqServiceImpl occurFreqService = new OccurFreqServiceImpl();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put('a', 1);
        frequencyMap.put('b', 3);
        frequencyMap.put('c', 2);

        Map<Character, Integer> result = occurFreqService.sort(frequencyMap);

        assertEquals(3, result.size());
        assertEquals('b', result.keySet().toArray()[0]);
        assertEquals('c', result.keySet().toArray()[1]);
        assertEquals('a', result.keySet().toArray()[2]);
    }
}