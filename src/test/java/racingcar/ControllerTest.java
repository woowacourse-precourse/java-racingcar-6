package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.CarLocationController;
import racingcar.controller.MaxController;
import racingcar.generator.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class ControllerTest {
    MaxController maxController =new MaxController();
    CarLocationController carLocationController= new CarLocationController();

    @Test
    void testfindMax() {
        int max = maxController.findMax(5,10);
        assertEquals(10,max);
    }
    @Test
    void testforward() {
    }
}