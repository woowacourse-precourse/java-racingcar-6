package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    void inputTryCountTest_유효성체크_성공() {
        //given
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        Integer result = inputManager.inputTryCount();
        //then
        Integer expected = 5;
        assertEquals(expected, result);
    }

    @Test
    void inputTryCountTest_유효성체크_실패_숫자가_아닌_경우() {
        //given
        String input = "A";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        assertThatThrownBy(() -> inputManager.inputTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID tryCount : non-numeric characters");
    }

    @Test
    void inputTryCountTest_유효성체크_실패_1보다_작은_경우() {
        //given
        String input = "0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        assertThatThrownBy(() -> inputManager.inputTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("INVALID tryCount : number less than 1");
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