package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputManagerTest {

    InputManager inputManager;

    @BeforeEach
    public void beforeEach() {
        inputManager = new InputManager();
    }

    @Test
    void inputTryCountTest() {
        //given
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        String result = inputManager.inputTryCount();
        //then
        String expected = "5";
        assertEquals(expected, result);
    }

    @Test
    void inputCarNamesTest() {
        //given
        String input = "pobi,woni,jun";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        String[] result = inputManager.inputCarNames();
        //then
        String[] expected = {"pobi", "woni", "jun"};
        assertArrayEquals(expected, result);
    }

    @Test
    void convertToCarMapTest() {
        //given
        String[] input = {"pobi", "woni", "jun"};
        //when
        assertDoesNotThrow(() -> {
            inputManager.convertToCarMap(input);
        });
        Map<String, Integer> result = inputManager.convertToCarMap(input);
        //then
        assertEquals(3, result.size());
        for (String carName : input) {
            assertTrue(result.containsKey(carName));
            assertEquals(0, result.get(carName));
        }
    }
}