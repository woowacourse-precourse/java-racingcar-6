package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CarMotionControllerTest {

    @Test
    void carMotionReturnsHyphenWhenRandomNumberIs4OrGreater() {
        for (int randomNumber = 4; randomNumber <= 9; randomNumber++) {
            String result = CarMotionController.carMotion(randomNumber);
            assertEquals("-", result);
        }
    }

    @Test
    void carMotionReturnsEmptyStringWhenRandomNumberIsLessThan4() {
        for (int randomNumber = 0; randomNumber < 4; randomNumber++) {
            String result = CarMotionController.carMotion(randomNumber);
            assertEquals("", result);
        }
    }

    @Test
    void findWinnersReturnsCorrectWinners() {
        Map<String, Integer> carHashMap = new HashMap<>();
        carHashMap.put("pobi", 3);
        carHashMap.put("woni", 4);
        carHashMap.put("jun", 3);

        List<String> winners = CarMotionController.findWinners(carHashMap);

        assertEquals(1, winners.size());
        assertEquals("woni", winners.get(0));
    }
}
