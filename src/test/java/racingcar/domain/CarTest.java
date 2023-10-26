package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("자동차는 입력된 값이 4이상 9이하이면 전진할 수 있다.")
    void move(int number) {
        car.moveOrStop(number);

        assertThat(car).isEqualTo(new Car("pobi", 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("자동차는 입력된 값이 0이상 3이하라면 전진할 수 없다.")
    void stop(int number) {
        car.moveOrStop(number);

        assertThat(car).isEqualTo(new Car("pobi", 0));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("입력된 값이 0보다 작거나 9보다 크다면 예외가 발생한다.")
    void invalidNumber(int number) {
        assertThatThrownBy(() -> car.moveOrStop(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력 값입니다.");
    }
}