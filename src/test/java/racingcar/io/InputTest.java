package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.io.ByteArrayInputStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InputTest {

    @Test
    @DisplayName("Cars 객체가 잘 생성되는지 확인하는 테스트")
    public void testReadCars() {
        Input input = new Input();
        String inputString = "A,B,C";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        Cars cars = input.readCars();
        Map<String, Integer> state = cars.getState();
        assertEquals(3, state.size());
        assertTrue(state.containsKey("A"));
        assertTrue(state.containsKey("B"));
        assertTrue(state.containsKey("C"));
    }
}