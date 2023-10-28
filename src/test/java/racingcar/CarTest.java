package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤숫자가_4이상일떄_이동횟수_증가(int randomNumber) {
        car.move(randomNumber);
        assertThat(car.getMoveNum()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤숫자가_4미만일때_이동횟수_변화없음(int randomNumber) {
        car.move(randomNumber);
        assertThat(car.getMoveNum()).isEqualTo(0);
    }
}
