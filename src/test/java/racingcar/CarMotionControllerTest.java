package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
}
