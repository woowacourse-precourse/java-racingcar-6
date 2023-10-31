package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.generator.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MaxControllerTest {
    MaxController maxController =new MaxController();
    CarLocationController carLocationController= new CarLocationController();

    @Test
    void testfindMax() {
        int max = maxController.findMax(5,10);
        assertEquals(10,max);
    }
    @Test
    void testforward() {
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);

        // Test case 1: random number is 5 (>= 4)
        int result1 = carLocationController.forward(0);
        assertEquals(1, result1);

        // Test case 2: random number is 3 (< 4)
        int result2 = carLocationController.forward(0);
        assertEquals(0, result2);
    }
}