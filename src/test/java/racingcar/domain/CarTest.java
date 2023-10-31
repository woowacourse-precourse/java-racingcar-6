package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("taek");
    }

    @ParameterizedTest
    @CsvSource({"3,0", "4,1", "5,1"})
    void race_확인(int num, int expected) {
        car.race(num);
        assertThat(car.getMovement()).isEqualTo(expected);

    }

    @Test
    void 결과_확인() {
        for (int i = 0; i < 3; i++) {
            car.race(4);
        }
        assertThat(car.showMovement()).isEqualTo("---");

    }

    @Test
    void toString_확인() {
        car.race(4);
        assertThat(car.toString()).isEqualTo("taek : -");
    }


}