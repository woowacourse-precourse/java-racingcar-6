package study;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

public class CarTest {
    @DisplayName("실패 : 자동차의 이름의 글자수가 1~5글자를 벗어나는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", "여섯글자입력"})
    void test1(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"한", "다섯글자임"})
    void Car_객체의_이름은_1글자에서_5글자이다_성공(String name) {
        assertThatCode(() -> new Car(name));
    }

    @Test
    void Car_이동메서드_체크() {
        Integer moveCount = 5;
        Car car = new Car("name");
        for (int i = 0; i < moveCount; i++) {
            car.processTurn();
        }
    }
}
