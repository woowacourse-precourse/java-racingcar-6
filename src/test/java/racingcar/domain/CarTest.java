package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 이름을_올바르게_입력하는_경우() {
        Car car = new Car("seori");
        assertEquals(car.getName(), "seori");
        assertEquals(car.getMeter(), 0);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "leeseori, 이름은 공백 하여 최소 1자 이상 5자 이하만 가능합니다.",
            "'', 이름은 공백 하여 최소 1자 이상 5자 이하만 가능합니다.",
    })
    void 이름을_잘못_입력하는_경우(String input, String exceptionMessage) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new Car(input));
        assertEquals(e.getMessage(), exceptionMessage);
    }

    @Test
    void 전진_또는_이동() {
        Car seoriCar = new Car("seori");
        Car snowCar = new Car("snow");

        seoriCar.move(MOVING_FORWARD);
        snowCar.move(STOP);

        assertEquals(seoriCar.getMeter(), 1);
        assertEquals(snowCar.getMeter(), 0);
    }

}