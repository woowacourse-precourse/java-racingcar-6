package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("자동차 객체 생성 - 입력값 정상")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "1", "!@#$%", " abc", "abc "})
    void createCarWithCorrectInput(String name) {
        Car newCar = new Car(name);
        assertThat(newCar.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 객체 생성 - 입력값 오류")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "abcdef"})
    void createCarWithWrongInput(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이동 - 전진X")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void notMoveForward(int randomNum) {
        Car car = new Car("pobi");
        car.move(randomNum);

        assertThat(car.getProgressCount()).isEqualTo(0);
    }

    @DisplayName("자동차 이동 - 전진")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveForward(int randomNum) {
        Car car = new Car("pobi");
        car.move(randomNum);

        assertThat(car.getProgressCount()).isEqualTo(1);
    }

    @DisplayName("자동차 전진 위치 비교")
    @Test
    void isSameProgress() {
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");

        carC.move(5);

        assertThat(carA.isSameProgress(carB)).isTrue();
        assertThat(carA.isSameProgress(carC)).isFalse();
    }
}