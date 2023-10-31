package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
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
}