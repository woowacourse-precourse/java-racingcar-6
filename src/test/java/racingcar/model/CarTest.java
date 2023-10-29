package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"4, 1", "1, 0"})
    void go_메서드는_입력값이_4보다_크면_position_을_1_증가시킨다(Integer goValue, Integer result) {
        Car car = new Car("자동차");
        car.go(goValue);
        assertThat(car.getPosition()).isEqualTo(result);
    }
}
