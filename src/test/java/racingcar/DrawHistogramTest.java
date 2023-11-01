package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.controller.Car;
import racingcar.view.DrawHistogram;

public class DrawHistogramTest {

    @Test
    void 히스토그램_그리기() {
        // given
        Car car = new Car("TestCar", 5);

        // when
        String result = DrawHistogram.draw(car);

        // then
        assertEquals("-----", result);
    }
}
