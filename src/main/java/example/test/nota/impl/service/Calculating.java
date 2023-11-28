package example.test.nota.impl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Calculating
 *
 * @author Grigory Dyakonov
 */

@Slf4j
@Service
public class Calculating {

    public String countingLetters(String text) {
        char[] letters = getLettersArray(text);
        Map<Character, Integer> resultMap = new HashMap<>();
        for (char letter : letters) {
            resultMap.merge(letter, 1, Integer::sum);
        }
        String result = convertToJson(getSortedMap(resultMap));
        log.info("Counting result: {}", result);
        return result;
    }

    private char[] getLettersArray(String text) {
        return text.toCharArray();
    }

    private Map<Character, Integer> getSortedMap(Map<Character, Integer> resultMap) {
        return resultMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }

    private String convertToJson(Map<Character, Integer> map) {
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            log.error("Error converting to json: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
