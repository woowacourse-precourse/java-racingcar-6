package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"asdf", "pobi2", "Mr Jo"})
    @DisplayName("유효한 이름으로 자동차 인스턴스 생성")
    void constructor_유효한_이름(String input) {
        Car car = new Car(input);

        assertThat(car.getName()).isEqualTo(input);
        assertThat(car.getPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", " sad ", "pobipobi"})
    @DisplayName("유효하지 않은 이름으로 자동차 인스턴스 생성 시 예외 발생")
    void constructor_유효하지_않은_이름(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car(input);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4, 99})
    @DisplayName("n번 전진")
    void moveForward(int repeat) {
        Car car = new Car("pobi");
        for (int i = 0; i < repeat; i++) {
            car.moveForward();
        }

        assertThat(car.getPosition()).isEqualTo(repeat);
    }
}