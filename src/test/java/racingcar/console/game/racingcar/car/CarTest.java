package racingcar.console.game.racingcar.car;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    public void setup() {
        car = Mockito.mock(Car.class);
    }

    @Test
    void operate_test() {
        // when
        car.operate();

        // then
        Mockito.verify(car).operate();

    }

    @Test
    void indicateLocation_test() {
        // when
        car.indicateLocation();

    }
}