package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
//    @BeforeEach
//    void setUp(){
//        RacingCar car = new RacingCar(name);
//    }

    @Test
    void getLoc() {
    }

    @Test
    void getName() {
        String test_name = "test_name";
        RacingCar car = new RacingCar(test_name);
        String result = car.getName();
        assertThat(result).isEqualTo(test_name);
    }

    @Test
    void accel() {
    }
}