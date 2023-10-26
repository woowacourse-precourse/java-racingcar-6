package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("자동차는 입력된 값이 4이상 9이하이면 전진할 수 있다.")
    void move(int number) {
        Car car = new Car("pobi");
        car.moveOrStop(number);

        assertThat(car).isEqualTo(new Car("pobi", 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("자동차는 입력된 값이 0이상 3이하라면 전진할 수 없다.")
    void stop(int number) {
        Car car = new Car("pobi");
        car.moveOrStop(number);

        assertThat(car).isEqualTo(new Car("pobi", 0));
    }
}