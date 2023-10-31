package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car("name");
    }

    @ParameterizedTest
    @CsvSource({"3,0", "4,1"})
    void 자동차_4_이상일_때_전진(int number, int moveCount) {
        car.moveForward(number);
        assertThat(car.getMoveForwardCount()).isEqualTo(moveCount);
    }
}