package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class InputManagerTest {

    InputManager inputManager;
    InputStream originalSystemIn;

    @BeforeEach
    public void beforeEach() {
        inputManager = new InputManager();
        originalSystemIn = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    void inputTryCountTest_유효성체크_성공() {
        //given
        InputManager inputManager = new InputManager();
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
    void convertToCarMapTest() {
        //given
        String[] input = {"pobi", "woni", "jun"};
        //when
        assertDoesNotThrow(() -> {
            inputManager.convertToCarList(input);
        });
        List<Car> result = inputManager.convertToCarList(input);
        //then
        assertEquals(3, result.size());
        assertEquals(result.get(0).getCarName(),"pobi");
        assertEquals(result.get(1).getCarName(),"woni");
        assertEquals(result.get(2).getCarName(),"jun");

    }
}