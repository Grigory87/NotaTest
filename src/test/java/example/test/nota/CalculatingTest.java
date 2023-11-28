package example.test.nota;

import example.test.nota.impl.service.Calculating;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CalculatingTest
 *
 * @author Grigory Dyakonov
 */

public class CalculatingTest {

    @Test
    void testGetLettersArray() throws Exception {
        String inputText = "Hello";
        char[] expectedArray = {'H', 'e', 'l', 'l', 'o'};

        Calculating calculating = new Calculating();

        Method privateMethod = Calculating.class.getDeclaredMethod("getLettersArray", String.class);
        privateMethod.setAccessible(true);

        char[] result = (char[]) privateMethod.invoke(calculating, inputText);

        assertArrayEquals(expectedArray, result);
    }

    @Test
    void testConvertToJson() throws Exception {
        Map<Character, Integer> inputMap = new HashMap<>();
        inputMap.put('a', 1);
        inputMap.put('b', 2);

        String expectedJson = "{\"a\":1,\"b\":2}";

        Calculating calculating = new Calculating();

        Method privateMethod = Calculating.class.getDeclaredMethod("convertToJson", Map.class);
        privateMethod.setAccessible(true);

        String result = (String) privateMethod.invoke(calculating, inputMap);

        assertEquals(expectedJson, result);
    }

    @Test
    void testGetSortedMap() throws Exception {
        Map<Character, Integer> inputMap = new HashMap<>();
        inputMap.put('a', 1);
        inputMap.put('b', 2);
        inputMap.put('c', 3);

        Calculating calculating = new Calculating();

        Method privateMethod = Calculating.class.getDeclaredMethod("getSortedMap", Map.class);
        privateMethod.setAccessible(true);

        Map<Character, Integer> resultMap = (Map<Character, Integer>) privateMethod.invoke(calculating, inputMap);
        assertEquals(3, resultMap.get('c'));
        assertEquals(2, resultMap.get('b'));
        assertEquals(1, resultMap.get('a'));

    }

    @Test
    void testCountingLetters() {
        String inputText = "VVabbccc";
        Calculating calculating = new Calculating();
        String result = calculating.countingLetters(inputText);
        assertEquals("{\"c\":3,\"b\":2,\"V\":2,\"a\":1}", result);
    }
}
